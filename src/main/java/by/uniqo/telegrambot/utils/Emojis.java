package by.uniqo.telegrambot.utils;

import com.vdurmont.emoji.EmojiParser;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Emojis {

    CHECK(EmojiParser.parseToUnicode(":heavy_check_mark:")),
    CART(EmojiParser.parseToUnicode(":shopping_trolley:")),
    MONEYBAG(EmojiParser.parseToUnicode(":moneybag:")),
    SHIELD(EmojiParser.parseToUnicode(":shield:")),
    PILL(EmojiParser.parseToUnicode(":pill:")),
    HOMES(EmojiParser.parseToUnicode(":house_buildings:")),
    BENTO(EmojiParser.parseToUnicode(":bento:")),
    DESKTOP(EmojiParser.parseToUnicode(":desktop_computer:")),
    RAILROAD_TRACK(EmojiParser.parseToUnicode(":railway_track:")),
    BAR_CHART(EmojiParser.parseToUnicode(":bar_chart:")),
    CALLING(EmojiParser.parseToUnicode(":calling:")),
    ENVELOPE_WITH_ARROW(EmojiParser.parseToUnicode(":envelope_with_arrow:")),
    DOLLAR(EmojiParser.parseToUnicode(":dollar:")),
    CREDIT_CARD(EmojiParser.parseToUnicode(":credit_card:")),
    MAG_RIGHT(EmojiParser.parseToUnicode(":mag_right:")),
    SHOPPING_BAGS(EmojiParser.parseToUnicode(":shopping_bags:")),
    GEAR(EmojiParser.parseToUnicode(":gear:")),
    BOOKS(EmojiParser.parseToUnicode(":books:")),
    GIFT(EmojiParser.parseToUnicode(":gift:")),
    ROBOTFACE(EmojiParser.parseToUnicode(":robot_face:")),
    TOOLS(EmojiParser.parseToUnicode(":hammer_and_wrench:"));

    private String emojiName;

    @Override
    public String toString() {
        return emojiName;
    }
}