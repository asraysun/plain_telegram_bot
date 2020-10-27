package by.uniqo.telegrambot.service;

import by.uniqo.telegrambot.model.UserProfileData;
import by.uniqo.telegrambot.repository.UserProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileDataService {
    private final UserProfileRepository userProfileRepository;


    public UserProfileDataService(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    public UserProfileData findById(Long id) {
        return userProfileRepository.getOne(id);
    }

    public List<UserProfileData> findAll() {
        return userProfileRepository.findAll();
    }

    public UserProfileData saveUser(UserProfileData userProfileData) {
        return userProfileRepository.save(userProfileData);
    }

    public void deleteById(Long id) {
        userProfileRepository.deleteById(id);
    }
}
