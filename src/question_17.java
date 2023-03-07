import java.util.*;

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
//给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

//思路：想到了hashmap，没想到递归
public class question_17 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backtrack(list,map,digits,0,new StringBuffer());
        return list;
    }

    public static void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        //如果index和digits长度一致，说明数字都遍历完了
        if (index == digits.length()) {
            System.out.println(combination);
            combinations.add(combination.toString());
        } else {
            //第x个数字
            char digit = digits.charAt(index);
            //获取第x个数字对应的字母
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            //对字母进行遍历
            for (int i = 0; i < lettersCount; i++) {
                //先加入一个字母
                combination.append(letters.charAt(i));
                //递归加入第二字母
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                //当递归返回到这一步时，combination已经获得了一组字符串，并加入道combinaions中去了，所以空出来去装新的字符；
                combination.deleteCharAt(index);

            }
        }
    }
}