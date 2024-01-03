import java.util.Scanner;
import java.util.Arrays;
import java.util.Objects;
// Junit / Mockito - testes
public class Main {
    public static void main(String[] args) {
        // System.out.println(mergeAlternately("sp", "bu"));
    }

    public static String mergeAlternately(String word1, String word2) {
        // Work with strings
        /*
            1) word.length() - get len
            2) Add char in str
                str = str.concat(Character.toString('!'));
            3) get on char from str
                String text = "foo";
                char charAtZero = text.charAt(0);
         */
        String res = "";
        int n = word1.length();
        int m = word2.length();
        int i = 0, j= 0, fl = 0;
        char chr;
        while (true){
            if(fl % 2 == 0){
                chr = word1.charAt(i);
                res = res.concat(Character.toString(chr));
                i += 1;
                if(j < m){
                    fl = 1;
                }else{
                    if(i >= n){
                        break;
                    }
                }
            }else{
                chr = word2.charAt(j);
                res = res.concat(Character.toString(chr));
                j += 1;
                if(i < n){
                    fl = 0;
                }else {
                    if (j >= m){
                        break;
                    }
                }
            }
        }
        return res;
    }

    public char findTheDifference(String s, String t) {
        char diff;
        int[] mas1 = new int[26];
        int[] mas2 = new int[26];

        for(){

        }
    }
}