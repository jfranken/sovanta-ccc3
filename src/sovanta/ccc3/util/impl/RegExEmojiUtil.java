package sovanta.ccc3.util.impl;

import java.util.Objects;

import sovanta.ccc3.util.EmojiUtil;


/**
 * The {@link RegExEmojiUtil} is a concrete implementation of {@link EmojiUtil} that uses a
 * {@code regular expressions} to fulfill the interface requirements.
 */
public class RegExEmojiUtil implements EmojiUtil {

    @Override
    public String addJoiner(String emojis) {
        Objects.requireNonNull(emojis);

        return emojis.replaceAll("(.)", "$1"+ ZWJ).replaceFirst(".$","");
    }

    @Override
    public String removeJoiner(String emojis) {
        Objects.requireNonNull(emojis);

        return emojis.replaceAll(ZWJ, "");
    }

}
