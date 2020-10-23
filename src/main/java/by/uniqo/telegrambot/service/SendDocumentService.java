//package by.uniqo.telegrambot.service;
//
//import by.uniqo.telegrambot.bean.TelegramBot;
//import by.uniqo.telegrambot.cache.UserDataCache;
//import by.uniqo.telegrambot.model.UserProfileData;
//import lombok.SneakyThrows;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.util.ResourceUtils;
//import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
//import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//
//
//@Service
//public class SendDocumentService {
//    @Autowired
//    TelegramBot telegramBot;
//    @Autowired
//    UserDataCache userDataCache;
//
//    public void sendDocument(long chatId, String caption, File sendFile) {
//        SendDocument sendDocument = new SendDocument();
//        sendDocument.setChatId(chatId);
//        sendDocument.setCaption(caption);
//        sendDocument.setDocument(sendFile);
//        try {
//            telegramBot.execute(sendDocument);
//        }
//        catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
//    }
//    @SneakyThrows
//    public File getUsersProfile(int userId) {
//        UserProfileData userProfileData = userDataCache.getUserProfileData(userId);
//        File profileFile = ResourceUtils.getFile("classpath:static/docs/users_profile.txt");
//
//        try (FileWriter fw = new FileWriter(profileFile.getAbsoluteFile());
//             BufferedWriter bw = new BufferedWriter(fw)) {
//            bw.write(userProfileData.toString());
//        }
//
//
//        return profileFile;
//
//    }
//}
