package by.uniqo.telegrambot.utils;

import com.vdurmont.emoji.EmojiParser;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Emojis {

    CHECK(EmojiParser.parseToUnicode(":heavy_check_mark:"));

    private String emojiName;

    @Override
    public String toString() {
        return emojiName;
    }
}