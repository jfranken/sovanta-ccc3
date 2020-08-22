package sovanta.ccc3.util.impl;

import java.util.Objects;

import sovanta.ccc3.util.EmojiUtil;


/**
 * The {@link CharacterSurrogateEmojiUtil} is a concrete implementation of {@link EmojiUtil} that uses a
 * {@link Character#highSurrogate(int)} and {@link Character#lowSurrogate(int)} to fulfill the interface requirements.
 */
public class CharacterSurrogateEmojiUtil implements EmojiUtil {

    @Override
    public String addJoiner(String input) {
        Objects.requireNonNull(input);

        String partOne = input.substring(0, 2);
        String partTwo = input.substring(2);
        int partOneCodePoint = partOne.codePointAt(partOne.offsetByCodePoints(0, 0));
        int partTwoCodePoint = partTwo.codePointAt(partTwo.offsetByCodePoints(0, 0));
        partOne = String.valueOf(
                new char[] {Character.highSurrogate(partOneCodePoint), Character.lowSurrogate(partOneCodePoint)});
        partTwo = String.valueOf(
                new char[] {Character.highSurrogate(partOneCodePoint), Character.lowSurrogate(partTwoCodePoint)});
        return partOne + "\u200D" + partTwo;
    }

    @Override
    public String removeJoiner(String input) {
        Objects.requireNonNull(input);

        String partOne = input.substring(0, 2);
        String partTwo = input.substring(4);
        int partOneCodePoint = partOne.codePointAt(partOne.offsetByCodePoints(0, 0));
        int partTwoCodePoint = partTwo.codePointAt(partTwo.offsetByCodePoints(0, 0));
        partOne = String.valueOf(
                new char[] {Character.highSurrogate(partOneCodePoint), Character.lowSurrogate(partOneCodePoint)});
        partTwo = String.valueOf(
                new char[] {Character.highSurrogate(partOneCodePoint), Character.lowSurrogate(partTwoCodePoint)});
        return partOne + partTwo;
    }

}
