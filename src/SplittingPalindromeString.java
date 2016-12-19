import java.util.ArrayList;

/**
 * Created by rajat on 18/12/16.
 */
public class SplittingPalindromeString {

    public static void main(String[] args) {

        String str = "ababbbabbababa";
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> partition = new ArrayList<String>();//track each possible partition


        SplittingPalindromeString splittingPalindromeString = new SplittingPalindromeString();

        if (splittingPalindromeString.isPalindrome(str)) {
            System.out.println(0);
        } else {
            splittingPalindromeString.addPalindrome(str, 0, partition, result);
            int max_size = Integer.MAX_VALUE;
            for (ArrayList<String> list : result) {
                if (list.size() < max_size) {
                    max_size = list.size();
                }

            }

            System.out.println(max_size - 1);
        }


    }


    void addPalindrome(String string, int start, ArrayList<String> partition, ArrayList<ArrayList<String>> result) {

        if (start == string.length()) {
            ArrayList<String> temp = new ArrayList<>(partition);
            result.add(temp);
            return;
        }

        for (int index = start + 1; index <= string.length(); index++) {
            String str = string.substring(start, index);
            if (isPalindrome(str)) {
                partition.add(str);
                addPalindrome(string, index, partition, result);
                partition.remove(partition.size() - 1);
            }
        }
    }

    Boolean isPalindrome(String str) {
        int start = 0;
        int last = str.length() - 1;

        while (start < last) {
            if (str.charAt(start) != str.charAt(last)) {
                return false;
            }
            start++;
            last--;
        }
        return true;
    }


}
