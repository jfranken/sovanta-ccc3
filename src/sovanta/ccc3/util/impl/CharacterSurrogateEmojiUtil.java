package sovanta.ccc3.util.impl;

import java.util.stream.Collectors;

import sovanta.ccc3.util.EmojiUtil;


/**
 * The {@link CharacterSurrogateEmojiUtil} is a concrete implementation of {@link EmojiUtil} that uses a
 * {@link Character#highSurrogate(int)} and {@link Character#lowSurrogate(int)} to fulfill the interface requirements.
 */
public class CharacterSurrogateEmojiUtil implements EmojiUtil {

    @Override
    public String removeJoiner(String input) {
        return input.replace(ZWJ, "");
    }

    @Override
    public String addJoiner(String input) {
        return input.codePoints().boxed()
                .map(c -> String.valueOf(new char[] {Character.highSurrogate(c), Character.lowSurrogate(c)}))
                .collect(Collectors.joining(ZWJ));
    }
}
