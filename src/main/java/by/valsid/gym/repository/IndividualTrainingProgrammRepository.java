package by.valsid.gym.repository;

import by.valsid.gym.model.entity.IndividualTrainingProgramm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualTrainingProgrammRepository extends JpaRepository<IndividualTrainingProgramm, Long> {
}
