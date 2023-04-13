package by.valsid.gym.service;

import by.valsid.gym.exceptions.UserNotFoundException;
import by.valsid.gym.model.dto.GymUserDto;
import by.valsid.gym.model.entity.GymUser;
import by.valsid.gym.model.mapping.GymUserMapper;
import by.valsid.gym.repository.GymUserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class GymUserService implements UserDetails {

    GymUserRepository gymUserRepository;

    GymUserMapper gymUserMapper;
    public GymUserDto findByPhone(String phoneNumber){
        Optional<GymUser> gymUserOptional = gymUserRepository.findByPhone(phoneNumber);
        if (gymUserOptional.isEmpty()){
            throw new UserNotFoundException();
        }
        return gymUserMapper.toDto(gymUserOptional.get());
    }

    public Optional<GymUser> getById(final Long id){
        return gymUserRepository.findById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return gymUserRepository.findByLogin(username).orElseThrow(() -> new UsernameNotFoundException("Не верное имя пользователя или пароль"));
    }

}
