package by.valsid.gym.repository;

import by.valsid.gym.model.entity.IndividualExercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndividualExerciseRepository extends JpaRepository<IndividualExercise, Long> {

    @Query("select ie from IndividualExercise ie where ie.individualTrainingProgrammId = :indTrProgId")
    List<IndividualExercise> findByTrProg(Long indTrProgId);
}
