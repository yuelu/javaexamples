package org.luyue.examples.leetcode;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ValidParenthesesTest {

    @Test
    public void testIsValid() {
        assertThat(ValidParentheses.isValid(""), is(false));
        assertThat(ValidParentheses.isValid(null), is(false));
        assertThat(ValidParentheses.isValid("()"), is(true));
        assertThat(ValidParentheses.isValid("[]"), is(true));
        assertThat(ValidParentheses.isValid("{}"), is(true));
        assertThat(ValidParentheses.isValid("(())"), is(true));
        assertThat(ValidParentheses.isValid("([)"), is(false));
        assertThat(ValidParentheses.isValid("(({}))"), is(true));
        assertThat(ValidParentheses.isValid("("), is(false));
        assertThat(ValidParentheses.isValid("}"), is(false));
    }

}
