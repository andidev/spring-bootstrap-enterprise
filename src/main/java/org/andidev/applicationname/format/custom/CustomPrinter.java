package org.andidev.applicationname.format.custom;

import java.util.Locale;
import org.andidev.applicationname.format.annotation.CustomFormat;
import org.apache.commons.lang3.StringUtils;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParseException;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.format.Printer;

public class CustomPrinter implements Printer<Object> {

    private final String spelExpression;
    private final EvaluationContext evaluationContext;

    public CustomPrinter(String spelExpression, EvaluationContext evaluationContext) {
        this.spelExpression = StringUtils.defaultIfBlank(spelExpression, null);
        this.evaluationContext = evaluationContext;
    }

    @Override
    public String print(Object object, Locale locale) {
        if (spelExpression == null) {
            return null;
        }
        ExpressionParser parser = new SpelExpressionParser();
        try {
            Object result = parser.parseExpression(spelExpression).getValue(evaluationContext, object);
            return result.toString();
        } catch (SpelParseException e) {
            throw new CustomFormatException("Could not parse spel expression = \"" + spelExpression + "\" in " + CustomFormat.class.getSimpleName() + " annotation: " + e.getMessage());
        }
    }
}
