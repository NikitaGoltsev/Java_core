import java.util.Scanner;
import java.util.Arrays;
import java.util.Objects;
// Junit / Mockito - testes
public class Main {
    public static void main(String[] args) {
        // System.out.println(mergeAlternately("sp", "bu"));
        // System.out.println(findTheDifference("tur", "tuyr"));
        // System.out.println(strStr("trytotiy", "to")); // ans - 3
        // System.out.println(strStr("sad", "sad")); // ans - 0
        //System.out.println(strStr("mississippi", "sippia")); // ans - 0


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

    public static char findTheDifference(String s, String t) {
        char diff = 'a';

        int[] mas1 = new int[26];
        int[] mas2 = new int[26];
        for(int i = 0; i < 26; i++){
            mas1[i] = 0;
            mas2[i] = 0;
        }
        for(int i = 0; i < s.length(); i++){
            mas1[s.charAt(i) - 'a'] += 1;
            mas2[t.charAt(i) - 'a'] += 1;
        }
        mas2[t.charAt(t.length() - 1) - 'a'] += 1;
        for(int i = 0; i < 26; i++){
            if(mas1[i] != mas2[i]){
                diff += i;
                break;
            }
        }

        return diff;
    }

    public static int strStr(String haystack, String needle) {
        int res = -1;
        int i = 0, j = 0;
        int n = haystack.length();
        int m = needle.length();
        if(n >= m) {
            for(int index = 0; index < n; index++){
                if(haystack.charAt(index) == needle.charAt(0)){
                    i = index + 1;
                    j = 1;
                    // check in cycle
                    while (true){
                        if(j == m){
                            res = index;
                            break;
                        }else{
                            if(haystack.charAt(i) == needle.charAt(j)){
                                j += 1;
                                i += 1;
                            }else{
                                break;
                            }
                        }
                    }
                    if(res != -1)break;
                }else {
                    if(n - index - 1 < m){ // check for out of index
                        break;
                    }
                }
            }
        }

        return res;
    }
}