package by.valsid.gym.repository;

import by.valsid.gym.model.entity.GymUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymUserRepository extends JpaRepository<GymUser, Long> {
}
