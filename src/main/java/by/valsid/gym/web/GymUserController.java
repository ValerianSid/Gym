package by.valsid.gym.web;

import by.valsid.gym.model.dto.GymUserDto;
import by.valsid.gym.service.GymUserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GymUserController {

    GymUserService gymUserService;
    @GetMapping("/findByPhone")
    public ResponseEntity<GymUserDto> findByPhone(String phoneNumber){
        return ResponseEntity.ok(gymUserService.findByPhone(phoneNumber));
    }
}
