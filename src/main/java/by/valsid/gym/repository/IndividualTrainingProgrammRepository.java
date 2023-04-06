package by.valsid.gym.repository;

import by.valsid.gym.model.entity.IndividualTrainingProgramm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IndividualTrainingProgrammRepository extends JpaRepository<IndividualTrainingProgramm, Long> {

    @Query("select itp from IndividualTrainingProgramm itp where itp.name = :name")
    Optional<IndividualTrainingProgramm> findByName(String name);
}
