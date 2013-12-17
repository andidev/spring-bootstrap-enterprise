package org.andidev.applicationname.format.json;

import com.google.gson.Gson;
import java.util.Locale;
import org.springframework.format.Printer;

public class JsonPrinter implements Printer<Object> {

    @Override
    public String print(Object object, Locale locale) {
        return new Gson().toJson(object);
    }
}
