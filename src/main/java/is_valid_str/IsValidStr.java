package is_valid_str;

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
不用stack 完成

有效字符串需满足：
    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

链接：https://leetcode-cn.com/problems/valid-parentheses
 */
public class IsValidStr {

    public static void main(String[] args) {
        String str="{([]{})(())}";
        System.out.println(isValidStr(str));

    }

    public static boolean isValidStr(String s){
        if (s.length()==0){ //recursive base case
            return true;
        }
        StringBuffer expression=new StringBuffer();
        int countLeft1= 0;  //左括号 ( 计数器
        int countLeft2= 0;  //左括号 { 计数器
        int countLeft3= 0;  //左括号 [ 计数器

        for (int i=0; i<s.length(); i++){
            expression.append(s.charAt(i)); //构造表达式
            switch (s.charAt(i)){
                case '(' :
                    countLeft1++;
                    break;
                case '{' :
                    countLeft2++;
                    break;
                case '[' :
                    countLeft3++;
                    break;
                case ')' : {
                    countLeft1--;
                    if (countLeft1 < 0)
                        return false;
                    //一旦闭合则取出闭合内部表达式，判断是否有效
                    String expressionSubStr= expression.substring(expression.lastIndexOf("(")+1, expression.length()-1); //边界问题调试
                    if (isValidStr(expressionSubStr)) { //递归调用自身
                        expression= expression.delete(expression.lastIndexOf("("), expression.length()+1); //有效则去除闭合表达式，继续判断
                        break;
                    }
                    else return false;
                }
                case '}' : {
                    countLeft2--;
                    if (countLeft2 < 0)
                        return false;
                    //一旦闭合则取出闭合内部表达式，判断是否有效
                    String expressionSubStr= expression.substring(expression.lastIndexOf("{")+1, expression.length()-1); //边界问题调试
                    if (isValidStr(expressionSubStr)) { //递归调用自身
                        expression= expression.delete(expression.lastIndexOf("{"), expression.length()+1); //有效则去除闭合表达式，继续判断
                        break;
                    }
                    else return false;
                }
                case ']' : {
                    countLeft3--;
                    if (countLeft3 < 0)
                        return false;
                    //一旦闭合则取出闭合内部表达式，判断是否有效
                    String expressionSubStr= expression.substring(expression.lastIndexOf("[")+1, expression.length()-1); //边界问题调试
                    if (isValidStr(expressionSubStr)) { //递归调用自身
                        expression= expression.delete(expression.lastIndexOf("["), expression.length()+1); //有效则去除闭合表达式，继续判断
                        break;
                    }
                    else return false;
                }
            }
        }
        if(countLeft1==0 && countLeft2==0 && countLeft3==0)
            return true;
        else return false;
    }
}
