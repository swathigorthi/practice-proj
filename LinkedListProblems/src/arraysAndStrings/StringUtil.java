package arraysAndStrings;

public class StringUtil {
    public static boolean hasAllUniqueChar(String newString) {
        boolean[] booleanVaue = new boolean[256];
        for (int i = 0; i < newString.length(); i++) {
            int value = newString.charAt(i);
            if (booleanVaue[value]) {
                return false;
            }
            else {
                booleanVaue[value] = true;
            }
        }
        return true;
    }

    public static String reverseCString(String str) {
        String cString = str + '\n';
        int length = cString.length();
        char[] charArray = new char[length];
        charArray[length - 1] = '\n';
        for (int i = 0; i < length - 1; i++) {
            charArray[length - 1 - i] = cString.charAt(i);
        }
        return new String(charArray);
    }
}
