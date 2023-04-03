package by.valsid.gym.repository;

import by.valsid.gym.model.entity.IndividualExercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualExerciseRepository extends JpaRepository<IndividualExercise, Long> {
}
