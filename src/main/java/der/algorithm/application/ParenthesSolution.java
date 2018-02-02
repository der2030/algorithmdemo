package der.algorithm.application;

import java.util.Stack;

/**
* @FileName:ParenthesSolution
* @Description: Given a string containing just the characters '(', ')', '{', '}',
 * '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
* @Author: Derrick Ye
*/
public class ParenthesSolution {

    public boolean validParethes(String str){

        if(str.length() % 2 == 1) {

            return false;

        }

        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i < str.length(); i++) {

            if(str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {

                stack.push(str.charAt(i));

            }

            else if(str.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == ')') {

                stack.pop();

            }

            else if(str.charAt(i) == ']' && !stack.isEmpty() && stack.peek() == ']') {

                stack.pop();

            }

            else if(str.charAt(i) == '}' && !stack.isEmpty() && stack.peek() == '}') {

                stack.pop();

            }

            else {

                return false;

            }

        }

        return stack.isEmpty();
    }
}
