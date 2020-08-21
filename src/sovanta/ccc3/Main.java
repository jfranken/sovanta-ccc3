package sovanta.ccc3;

public class Main {

    public static void main(String[] args) {
        String macBookWoman = "👩‍💻";
        String woman = "👩";
        String macBook = "💻";

        System.out.print("Remove Joiner from " + macBookWoman + ": ");
        System.out.println(removeJoiner(macBookWoman));
        System.out.print("Add Joiner to " + woman + macBook + ": ");
        System.out.println(addJoiner(woman + macBook));
    }

    private static String removeJoiner(String input) {
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

    private static String addJoiner(String input) {
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
}
