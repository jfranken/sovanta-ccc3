package sovanta.ccc3;

import java.util.ArrayList;
import java.util.List;

import sovanta.ccc3.util.EmojiUtil;
import sovanta.ccc3.util.impl.CharacterSurrogateEmojiUtil;
import sovanta.ccc3.util.impl.RegExEmojiUtil;
import sovanta.ccc3.util.impl.StringBuilderEmojiUtil;


public class Main {

    public static void main(String[] args) {
        List<EmojiUtil> utils = new ArrayList<>();
        utils.add(new RegExEmojiUtil());
        utils.add(new StringBuilderEmojiUtil());
        utils.add(new CharacterSurrogateEmojiUtil());

        String macBookWoman = "👩‍💻";
        String woman = "👩";
        String macBook = "💻";

        for (EmojiUtil util : utils) {
            System.out.println("Testing Util: " + util.getClass().getSimpleName());
            System.out.print("Remove Joiner from " + macBookWoman + ": ");
            System.out.println(util.removeJoiner(macBookWoman));
            System.out.print("Add Joiner to " + woman + macBook + ": ");
            System.out.println(util.addJoiner(woman + macBook));
            System.out.println();
        }
    }

}
