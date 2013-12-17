package org.andidev.applicationname.format.custom;

import java.text.ParseException;
import java.util.Locale;
import lombok.AllArgsConstructor;
import org.springframework.format.Parser;

@AllArgsConstructor
public class CustomParser implements Parser<Object> {

    @Override
    public Object parse(String text, Locale locale) throws ParseException {
        return null;
    }

}
