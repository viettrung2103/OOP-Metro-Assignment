public class StringManipulator {

    /**
     * Concatenates two input strings and returns the result.
     *
     * @param str1
     * @param str2
     * @return
     */
    String concatenate(String str1, String str2) {
        return str1 + " " + str2;
    }

    /**
     * Returns the length of the input string
     *
     * @param str
     * @return
     */
    int findLength(String str) {
        return str.length();
    }

    /**
     * Converts the input string to uppercase and returns the result.
     *
     * @param str
     * @return
     */
    String convertToUpperCase(String str) {
        return str.toUpperCase();
    }

    /**
     * Converts the input string to lowercase and returns the result.
     *
     * @param str
     * @return
     */
    String convertToLowerCase(String str) {
        return str.toLowerCase();
    }

    /**
     * Checks if the input string contains the given substring and returns true if it does,
     * otherwise returns false.
     *
     * @param str
     * @param subStr
     * @return
     */
    boolean containsSubstring(String str, String subStr) {
        return str.contains(subStr);
    }
}

