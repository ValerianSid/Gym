package by.valsid.gym.service;

import by.valsid.gym.exceptions.UserNotFoundException;
import by.valsid.gym.model.dto.GymUserDto;
import by.valsid.gym.model.entity.GymUser;
import by.valsid.gym.model.mapping.GymUserMapper;
import by.valsid.gym.repository.GymUserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class GymUserService {

    GymUserRepository gymUserRepository;

    GymUserMapper gymUserMapper;
    public GymUserDto findByPhone(String phoneNumber){
        Optional<GymUser> gymUserOptional = gymUserRepository.findByPhone(phoneNumber);
        if (gymUserOptional.isEmpty()){
            throw new UserNotFoundException();
        }
        return gymUserMapper.toDto(gymUserOptional.get());
    }
}
