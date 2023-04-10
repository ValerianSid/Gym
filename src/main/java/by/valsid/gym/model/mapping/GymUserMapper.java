package by.valsid.gym.model.mapping;

import by.valsid.gym.model.dto.GymUserDto;
import by.valsid.gym.model.entity.GymUser;
import by.valsid.gym.service.GymUserService;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GymUserMapper {

    GymUser toEntity(GymUserDto gymUserDto);

    GymUserDto toDto(GymUser gymUser);

}
