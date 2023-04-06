package by.valsid.gym.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class IndividualTrainingProgramm {

    private static final String SEQ_NAME = "individual_training_programm_id_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    Long id;

    String name;

    String description;

    @ManyToOne
    GymUser gymUser;

    @OneToMany
    @JoinColumn(name = "individual_training_programm_id")
    List<IndividualExercise> individualExerciseList;

    @OneToMany
    @JoinColumn(name = "individual_training_programm_id")
    List<CompleteTraining> completeTrainingList;
}
