//给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标

import java.util.Stack;

//思路:字符串匹配，第一个想到kmp算法，但都什么时代了，还在用传统匹配算法？Sunday算法前来觐见！
public class question_28 {
    public static void main(String[] args) {
        System.out.println(strStr("aabaaabaaac", "aabaaac"));

    }

    //但这不是正规的Sunday，只是自己实现的，效率很差
    public static int strStr(String haystack, String needle) {
        int[] next = new int[256];
        GetNext(needle, needle.length(), next);
        int i=0;
        int j=0;
        int k;
        boolean is_find = false;
        while (i <= haystack.length() - needle.length())
        {
            j = i;
            k = 0;
            while (j < haystack.length() && k < needle.length() && haystack.charAt(j) == needle.charAt(k)) {
                j++;k++;
            }

            if (k == needle.length())
            {
                return i;
            }

            if (i + needle.length() < haystack.length())
                i += (needle.length() - next[haystack.charAt(i + needle.length())]);
            else
                break;
        }

        if (!is_find)
            return -1;
        else return i;
    }
    public static void GetNext(String needle, int  length, int[] next)
    {
        for (int i = 0; i < 256; i++)
            next[i] = -1;
        for (int i = 0; i < length; i++)
            next[needle.charAt(i)] = i;
    }
}
