package org.andidev.applicationname.format.custom;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.andidev.applicationname.format.annotation.CustomFormat;
import org.springframework.core.convert.ConversionService;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.expression.spel.support.StandardTypeConverter;
import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.Parser;
import org.springframework.format.Printer;
import org.springframework.util.Assert;

public class CustomFormatAnnotationFormatterFactory
        implements AnnotationFormatterFactory<CustomFormat> {

    private static final Set<Class<?>> FIELD_TYPES;
    private final EvaluationContext evaluationContext;

    public CustomFormatAnnotationFormatterFactory() {
        this.evaluationContext = new StandardEvaluationContext();
    }

    public CustomFormatAnnotationFormatterFactory(FormatterRegistry registry) {
        this((ConversionService) registry);
    }

    public CustomFormatAnnotationFormatterFactory(ConversionService conversionService) {
        Assert.notNull(conversionService, "ConversionService must not be null");
        StandardEvaluationContext standardEvaluationContext = new StandardEvaluationContext();
        standardEvaluationContext.setTypeConverter(new StandardTypeConverter(conversionService));
        this.evaluationContext = standardEvaluationContext;
    }

    static {
        Set<Class<?>> fieldTypes = new HashSet<>(7);
        fieldTypes.add(Object.class);
        fieldTypes.add(Map.class);
        fieldTypes.add(Collection.class);
        FIELD_TYPES = Collections.unmodifiableSet(fieldTypes);

    }

    @Override
    public final Set<Class<?>> getFieldTypes() {
        return FIELD_TYPES;
    }

    @Override
    public Printer<?> getPrinter(CustomFormat annotation, Class<?> fieldType) {
        return new CustomPrinter(annotation.value(), evaluationContext);
    }

    @Override
    public Parser<Object> getParser(CustomFormat annotation, Class<?> fieldType) {
        return new CustomParser();
    }
}