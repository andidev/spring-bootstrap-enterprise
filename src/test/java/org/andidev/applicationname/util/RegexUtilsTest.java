package org.andidev.applicationname.util;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

public class RegexUtilsTest {

    @Test
    public void find_String_Regex_ReturnsParsedString() {
        String url = "jdbc:mysql://localhost:3306/applicationname";
        String regex = "([^/]*$)";
        assertThat(RegexUtils.parse(url, regex), is("applicationname"));
    }

    @Test
    public void find_String_RegexWithoutGroup_ReturnsParsedString() {
        String url = "jdbc:mysql://localhost:3306/applicationname";
        String regex = "[^/]*$";
        assertThat(RegexUtils.parse(url, regex), is("applicationname"));
    }

    @Test
    public void find_String_MissingRegex_ReturnsEmptyString() {
        String url = "jdbc:mysql://localhost:3306/applicationname";
        String regex = "(abc)";
        assertThat(RegexUtils.parse(url, regex), is(""));
    }

    @Test
    public void find_String_MissingRegexWithoutGroup_ReturnsEmptyString() {
        String url = "jdbc:mysql://localhost:3306/applicationname";
        String regex = "abc";
        assertThat(RegexUtils.parse(url, regex), is(""));
    }
}
