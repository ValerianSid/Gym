package by.valsid.gym.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GymUser {

    private static final String SEQ_NAME = "gym_user_id";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    Long id;

    String name;

    UUID uuid;

    @Column(unique = true)
    String phone;

    String email;

    String role;

    String lastEntry;

    @OneToMany
    @JoinColumn(name = "gym_user_id")
    List<Individual_Training_Programm> individualTrainingProgrammList;

}
