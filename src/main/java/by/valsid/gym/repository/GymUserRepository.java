package by.valsid.gym.repository;

import by.valsid.gym.model.entity.GymUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GymUserRepository extends JpaRepository<GymUser, Long> {

    @Query("select gu from GymUser gu where gu.phone = :phoneNumber")
    Optional<GymUser> findByPhone(String phoneNumber);
}
