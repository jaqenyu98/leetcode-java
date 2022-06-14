package multiPointers.string;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfString {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (l < s.length() && !isVowel(chars[l])) {
                l++;
            }
            while (r >= 0 && !isVowel(chars[r])) {
                r--;
            }
            if (l < r) {
                swap(chars, l, r);
                l++;
                r--;
            }
        }
        return new String(chars);
    }
    // 查找字符串是否包含用contains，查找char用indexOf
    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) >= 0;
    }
    private void swap(char[] chars, int index1, int index2) {
        char temp = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = temp;
    }
    /*---------------将indexOf替换成hashset查------------------*/
    public String reverseVowels2(String s) {
        char[] chars = {'a', 'e', 'i', 'o', 'u'};
        Set<Character> set = new HashSet<>();
        for (char c : chars) {
            set.add(c);
            set.add(Character.toUpperCase(c));
        }
        char[] cs = s.toCharArray();
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (l < s.length() && !set.contains(cs[l])) {
                l++;
            }
            while (r >= 0 && !set.contains(cs[r])) {
                r--;
            }
            if (l < r) {
                swap(cs, l, r);
                l++;
                r--;
            }
        }
        return new String(cs);
    }
}
