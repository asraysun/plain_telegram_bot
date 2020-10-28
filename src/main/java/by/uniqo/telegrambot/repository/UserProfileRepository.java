package by.uniqo.telegrambot.repository;


import by.uniqo.telegrambot.model.UserProfileData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfileData, Long> {
}
