package by.valsid.gym.repository;

import by.valsid.gym.model.entity.BasicExercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicExerciseRepository extends JpaRepository<BasicExercise, Long> {
}
