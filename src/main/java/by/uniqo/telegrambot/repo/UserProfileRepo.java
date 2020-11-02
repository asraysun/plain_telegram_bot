package by.uniqo.telegrambot.repo;

import by.uniqo.telegrambot.model.UserProfileData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepo extends CrudRepository<UserProfileData, Long> {

}
