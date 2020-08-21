package sovanta.ccc3.util;

/**
 * The {@link EmojiUtil} offers methods to manipulate emojis.
 */
public interface EmojiUtil {

    /**
     * The zero width joiner character (as {@code codePoint}).
     */
    int ZWJ_CODE_POINT = 0x200D;

    /**
     * The zero width joiner character (as {@link String}).
     */
    String ZWJ = Character.toString(0x200D);


    /**
     * Returns a new {@link String} with a {@link #ZWJ} added between each code point.
     *
     * @param string the {@link String} to be enriched by {@link #ZWJ ZWJs} (must not be {@code null})
     * @return the enriched {@link String}
     */
    String addJoiner(String string);

    /**
     * Returns a new {@link String} with any {@link #ZWJ} removed.
     *
     * @param string the {@link String} to be cleaned from {@link #ZWJ ZWJs} (must not be {@code null})
     * @return the enriched {@link String}
     */
    String removeJoiner(String string);

}
