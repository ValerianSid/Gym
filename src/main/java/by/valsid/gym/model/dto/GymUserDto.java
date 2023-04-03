package by.valsid.gym.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GymUserDto {
    @NotBlank
    String name;

    @NotBlank
    String phone;

    @NotBlank
    String email;
}
