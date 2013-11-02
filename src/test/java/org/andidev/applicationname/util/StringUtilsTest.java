package org.andidev.applicationname.util;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StringUtilsTest {
    
    @Test
    public void testParenthesizeNull() {
        String result = StringUtils.parenthesize(null);
        assertThat(result, is("(null)"));
    }

    @Test
    public void testParenthesizeText() {
        String result = StringUtils.parenthesize("some text");
        assertThat(result, is("(some text)"));
    }
    
}
