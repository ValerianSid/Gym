package by.valsid.gym.repository;

import by.valsid.gym.model.entity.TrainingProgramm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingProgrammRepository extends JpaRepository<TrainingProgramm, Long> {
}
