package org.andidev.applicationname.controller;

import java.lang.reflect.InvocationTargetException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/inline/{className}/")
public class InlineEditController {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private ConversionService conversionService;

//    http://www.isostech.com/web/joel/blog/-/blogs/backing-x-editable-with-spring-mvc-part-1
//    Usage
//    <a class="moo" href="#" name="someAttribute" id="${someEntity.id}"
//       data-name="someAttribute" data-type="text" data-pk="${someEntity.id}"
//       data-url="/inline/${someEntity.class.name}/edit/id/${someEntity.id}"
//       data-original-title="Some Attribute">${someEntity.someAttribute}</a>

    @RequestMapping(value = "/edit/id/{id}", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public String postEntityEdit(@ModelAttribute XEditableForm form, @PathVariable("className") String className, @PathVariable("id") String id) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Class clazz = Class.forName(className);
        Object moo = em.find(clazz, id);
        Object convertedValue = conversionService.convert(form.getValue(), PropertyUtils.getPropertyType(moo, form.getName()));
        PropertyUtils.setSimpleProperty(moo, form.getName(), convertedValue);
        em.persist(moo);
        return "";
    }

    @Getter
    @Setter
    public class XEditableForm {

        private String name;
        private String pk;
        private String value;
    }
}
