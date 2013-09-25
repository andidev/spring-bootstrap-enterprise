package org.andidev.applicationname.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.andidev.applicationname.entity.Template;
import org.andidev.applicationname.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anders
 */
@Service
@Transactional
@NoArgsConstructor
@AllArgsConstructor
public class TemplateService {

    @Autowired
    private TemplateRepository templateRepository;

    public Boolean create(Template template) {
        // create entity
        Template saved = templateRepository.save(template);
        if (saved == null) {
            return false;
        }

        return true;
    }

    public Boolean update(Template template) {
        // find entity
        Template existingTemplate = templateRepository.findById(template.getId());
        if (existingTemplate == null) {
            return false;
        }

        // change entity
        existingTemplate.setField(template.getField());

        // save entity
        Template saved = templateRepository.save(existingTemplate);
        if (saved == null) {
            return false;
        }

        return true;
    }

    public Boolean delete(Template template) {
        // find entity
        Template existingTemplate = templateRepository.findById(template.getId());
        if (existingTemplate == null) {
            return false;
        }

        // delete entity
        templateRepository.delete(existingTemplate);
        Template deletedTemplate = templateRepository.findById(template.getId());
        if (deletedTemplate != null) {
            return false;
        }

        return true;
    }
}
