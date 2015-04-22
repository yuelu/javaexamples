package org.luyue.examples.leetcode;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * <pre>
 * Problem:
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is
 * valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * 
 * Solution:
 * 1. iterate the string character by character
 * 2. if the character is one of "(","{","[", push it to the stack
 * 3. if the character is one of ")","}","]", pop from stack and see if the left parentheses matches. if not, return false. if true, continue
 * 4. if the character is not #2 or #3, it's an invalid char and return false 
 * 5. check if stack is empty, if not means no right parentheses matches left, return false
 * </pre>
 * 
 * @author jlu
 * @see <a href="https://leetcode.com/problems/valid-parentheses/">https://leetcode.com/problems/valid-parentheses/</a>
 *
 */
public class ValidParentheses {

    public static boolean isValid(String s) {

        if (s == null || s.isEmpty())
            return false;

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> parenthesesMappings = new HashMap<>();
        parenthesesMappings.put('(', ')');
        parenthesesMappings.put('{', '}');
        parenthesesMappings.put('[', ']');

        Set<Character> lefts = parenthesesMappings.keySet();
        Collection<Character> rights = parenthesesMappings.values();

        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (lefts.contains(ch)) {
                stack.push(ch);
            } else if (rights.contains(ch)) {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char left = stack.pop();
                    if (ch != parenthesesMappings.get(left)) {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }

        if (!stack.isEmpty())
            return false;

        return true;
    }
}