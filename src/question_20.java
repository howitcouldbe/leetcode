import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//匹配括号
//思路：无脑栈走起
public class question_20 {
    public static void main(String[] args) {
        String s = "()]";
        System.out.println(isValid2(s));
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('||s.charAt(i)=='{'||s.charAt(i)=='[')
                stack.push(s.charAt(i));
            else if(!stack.empty()&&stack.peek().equals(map.get(s.charAt(i)))){
                stack.pop();
            }else return false;
        }
        return true;
    }

    public static boolean isValid2(String s) {
            if(s.length() <= 1){
                return false;
            }
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('||s.charAt(i)=='{'||s.charAt(i)=='[')
                stack.push(s.charAt(i));
            else if(!stack.empty() && ((stack.peek().equals('(') && s.charAt(i) == ')')||(stack.peek().equals('{') && s.charAt(i) == '}')||(stack.peek().equals('[') && s.charAt(i) == ']'))){
                stack.pop();
            }else return false;
        }
        return stack.empty();
    }
}
