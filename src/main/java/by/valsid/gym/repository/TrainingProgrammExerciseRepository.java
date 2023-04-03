package by.valsid.gym.repository;

import by.valsid.gym.model.entity.TrainingProgrammExercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingProgrammExerciseRepository extends JpaRepository<TrainingProgrammExercise, Long> {
}
