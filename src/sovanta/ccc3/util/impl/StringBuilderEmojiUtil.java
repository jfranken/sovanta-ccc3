package sovanta.ccc3.util.impl;

import java.util.Objects;

import sovanta.ccc3.util.EmojiUtil;


/**
 * The {@link StringBuilderEmojiUtil} is a concrete implementation of {@link EmojiUtil} that uses a
 * {@link StringBuilder} to fulfill the interface requirements.
 */
public class StringBuilderEmojiUtil implements EmojiUtil {

    @Override
    public String addJoiner(String emojis) {
        Objects.requireNonNull(emojis);

        var builder = new StringBuilder();

        var codePoints = emojis.codePoints().toArray();
        for (var i = 0; i < codePoints.length; i++) {
            builder.appendCodePoint(codePoints[i]);
            if (i < codePoints.length - 1) {
                builder.appendCodePoint(ZWJ_CODE_POINT);
            }
        }

        return builder.toString();
    }

    @Override
    public String removeJoiner(String emojis) {
        Objects.requireNonNull(emojis);

        var builder = new StringBuilder();

        var codePoints = emojis.codePoints().toArray();
        for (var codePoint : codePoints) {
            if (!ZWJ.equalsIgnoreCase(Character.toString(codePoint))) {
                builder.append(Character.toChars(codePoint));
            }
        }

        return builder.toString();
    }

}
