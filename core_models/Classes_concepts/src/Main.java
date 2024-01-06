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
        // System.out.println(isAnagram("mississippi", "sippia")); // ans - 0
        // System.out.println(repeatedSubstringPattern("abac"));
        System.out.println(repeatedSubstringPattern("ababab"));

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

    public static boolean isAnagram(String s, String t) {
        boolean ans = true;
        int[] mas1 = new int[26];
        int[] mas2 = new int[26];
        for(int i = 0; i < 26; i++){
            mas1[i] = 0;
            mas2[i] = 0;
        }
        int n = s.length();
        int m = t.length();
        if(n == m){
            for (int i = 0; i < n; i++){
                mas1[s.charAt(i) - 'a'] += 1;
                mas2[t.charAt(i) - 'a'] += 1;
            }
            for (int i = 0; i < 26; i++){
                if(mas1[i] != mas2[i]){
                    ans = false;
                    break;
                }
            }
        }else{
            ans = false;
        }
        return ans;
    }
    public static boolean repeatedSubstringPattern_for_sub(String s) {

        // str1.equals(str2) -> true/false
        /*
        String s = "14.015_AUDI";
        String firstPart = s.substring(0, s.indexOf("_"));
         */
        boolean res = false;
        int sub_str_ln = s.length();
        int num_of_sub_str = 1;
        while(sub_str_ln % 2 == 0){
            sub_str_ln /= 2;
            num_of_sub_str *= 2;
            String[] parts = new String[num_of_sub_str];
            for (int i = 0; i < num_of_sub_str; i++){
                // parts[i] = s.substring((i * sub_str_ln) ,((i+1) * sub_str_ln - 1));
                parts[i] = s.substring((i * sub_str_ln) ,((i+1) * sub_str_ln));
                // System.out.println(parts[i]);
                if(i != 0){
                    if(parts[i].equals(parts[i-1])){
                        if(i == num_of_sub_str - 1) {
                            res = true;
                            sub_str_ln = 1; // some kind of break
                        }
                    }else{
                        break;
                    }
                }
            }
        }

        return res;
    }


    public static boolean repeatedSubstringPattern(String s) {
        boolean res = false;
        for(int sub_str_ln = s.length()/2; sub_str_ln >= 1; sub_str_ln--) {
            if(s.length() % sub_str_ln != 0){
                continue;
            }
            int num_of_sub_str = s.length() / sub_str_ln;
            String[] parts = new String[num_of_sub_str];
            for (int i = 0; i < num_of_sub_str; i++) {
                // parts[i] = s.substring((i * sub_str_ln) ,((i+1) * sub_str_ln - 1));
                parts[i] = s.substring((i * sub_str_ln), ((i + 1) * sub_str_ln));
                // System.out.println(parts[i]);
                if (i != 0) {
                    if (parts[i].equals(parts[i - 1])) {
                        if (i == num_of_sub_str - 1) {
                            res = true;
                            sub_str_ln = 1; // some kind of break
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return res;
    }

    public void moveZeroes(int[] nums) {
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] == 0) {
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[j - 1] = nums[j];
                        nums[j] = 0;
                    }else{
                        break;
                    }
                }
            }
        }
    }

    public int[] plusOne(int[] digits) {

        // System.arraycopy(ans, 0, ansr, 0, ln); -> SLICE OF ARRAY

        int[] ans = new int[digits.length + 1];
        System.arraycopy(digits, 0, ans, 1, digits.length);
        int ln = digits.length;
        for (int i = digits.length - 1; i >= 0; i--){
            ans[i+1] = digits[i] + 1;
            if(ans[i + 1] == 10){
                ans[i + 1] = 0;
                if(i == 0){
                    ans[0] = 1;
                    ln += 1;
                }
            }else{
                break;
            }
        }

        int[] ansr = new int[ln];
        if(ans[0] != 1){
            System.arraycopy(ans, 1, ansr, 0, ln);
        }else{
            System.arraycopy(ans, 0, ansr, 0, ln);
        }
        return ansr;
    }

    public int arraySign(int[] nums) {
        int pos = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= -1){
                pos += 1;
            }else if(nums[i] == 0){
                pos = -1;
                break;
            }
        }
        if(pos == -1){
            pos = 0;
        }else if(pos % 2 == 0){
            pos = 1;
        }else{
            pos = -1;
        }
        return pos;
    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        boolean res = true;

        return res;
    }
}