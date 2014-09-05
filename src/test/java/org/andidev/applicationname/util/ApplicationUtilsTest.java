package org.andidev.applicationname.util;

import com.google.common.collect.Lists;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Collection;
import lombok.extern.slf4j.Slf4j;
import org.andidev.applicationname.service.JsonService;
import org.junit.Test;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.expression.spel.support.StandardTypeConverter;


@Slf4j
public class ApplicationUtilsTest {

    @Test
    public void test() throws ParseException {
//        String spel = "[0]";
//        Collection<JsonService.Option> object = Lists.newArrayList(new JsonService.Option("1", "ADMIN"), new JsonService.Option("2", "USER"));
//        ExpressionParser parser = new SpelExpressionParser();
//        StandardEvaluationContext sevaluationContext = new StandardEvaluationContext(object);
//        ConversionService conversionService = new DefaultConversionService();
//        sevaluationContext.setTypeConverter(new StandardTypeConverter(conversionService));
//        Object test = parser.parseExpression(spel).getValue(sevaluationContext);
////        Object object = parser.parseExpression("[1]").getValue(roles);
//
//
//        if (test instanceof String) {
//            log.info("Object is string = " + (String) test);
//        } else {
//            log.info("Object is not string = " + test.toString());
//        }
    }


}