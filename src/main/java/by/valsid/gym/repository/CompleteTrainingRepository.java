package by.valsid.gym.repository;

import by.valsid.gym.model.entity.CompleteTraining;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompleteTrainingRepository extends JpaRepository<CompleteTraining, Long> {
}
