package by.valsid.gym.repository;

import by.valsid.gym.model.entity.BasicExercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasicExerciseRepository extends JpaRepository<BasicExercise, Long> {

    @Query("select be from BasicExercise be where be.muscleGroup = :muscle")
    List<BasicExercise> findByMuscleGroup(String muscle);
}
