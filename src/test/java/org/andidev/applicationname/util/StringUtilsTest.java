package org.andidev.applicationname.util;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class StringUtilsTest {
    
    @Test
    public void nullSafeToString_Null_ReturnsNull() {
        String result = StringUtils.nullSafeToString(null);
        assertThat(result, is(nullValue()));
    }
    
    @Test
    public void nullSafeToString_Object_ReturnsObjectToString() {
        String result = StringUtils.nullSafeToString(new Object(){
            @Override
            public String toString() {
                return "object as string";
            }
        });
        assertThat(result, is("object as string"));
    }
    
    @Test
    public void parenthesize_Null_ReturnsParenthesizedNullString() {
        String result = StringUtils.parenthesize(null);
        assertThat(result, is("(null)"));
    }

    @Test
    public void parenthesize_String_ReturnsParenthesizedString() {
        String result = StringUtils.parenthesize("any string");
        assertThat(result, is("(any string)"));
    }
}
