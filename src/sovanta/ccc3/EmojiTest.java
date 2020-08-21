package sovanta.ccc3;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

import sovanta.ccc3.util.EmojiUtil;
import sovanta.ccc3.util.impl.RegExEmojiUtil;
import sovanta.ccc3.util.impl.StringBuilderEmojiUtil;


public class EmojiTest {

    public static void main(String... args) {
        var utils = new ArrayList<EmojiUtil>();
        utils.add(new RegExEmojiUtil());
        utils.add(new StringBuilderEmojiUtil());

        for (var util: utils) {
            System.out.println("-----------------------------------------------------");
            System.out.println("Using util " + util.getClass().getSimpleName());
            System.out.println("👩 + 💻 = " + util.addJoiner("👩💻"));
            System.out.println("👩‍💻 is a combination of: " + util.removeJoiner("👩‍💻"));
            System.out.println("-----------------------------------------------------");
            System.out.println();
        }
    }

    public static void debugPrint(String emoji) {
        System.out.println("--- Debug printing: " + emoji + " ---");
        System.out.println("Length: " + emoji.length());
        emoji.codePoints().forEach(c -> System.out.println(c));
        var utf8Bytes = emoji.getBytes(StandardCharsets.UTF_8);
        var utf16beBytes = emoji.getBytes(StandardCharsets.UTF_16BE);
        var utf16leBytes = emoji.getBytes(StandardCharsets.UTF_16LE);
        System.out.println("utf8Bytes: " + Arrays.toString(utf8Bytes));
        System.out.println("utf16beBytes: " + Arrays.toString(utf16beBytes));
        System.out.println("utf16leBytes: " + Arrays.toString(utf16leBytes));
        for (var i = 0; i < emoji.length(); i++) {
            System.out.println("Code Point " + i + ": " + emoji.codePointAt(i));
            System.out.println("CharAt Point " + i + ": " + emoji.charAt(i));
        }
        System.out.println("--- Done ---");
    }

}
