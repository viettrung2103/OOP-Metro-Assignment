public class PalindromeChecker {

    public PalindromeChecker(){}

    public boolean isPalindrome(String string){
        // replace all space and comma with ""
        // split newString to list of Char
        String[] charList = string.replaceAll("[,\\s]","").toLowerCase().split("");
        boolean sameChar = true;
        int limit = (int) Math.ceil((charList.length-1)/2); // len = 5, limit = 2
        for (int i = 0; i <= limit; i ++){
            int oppositeIdx = charList.length-1-i;
            if (!charList[i].equals(charList[oppositeIdx])){
                sameChar = false;
                break;
            }
        }
        return sameChar;
    }

    public static void main(String[] agrs){
      PalindromeChecker checker = new PalindromeChecker();
        System.out.println(checker.isPalindrome("A man, a plan, a canal, Panama"));
    }
}
