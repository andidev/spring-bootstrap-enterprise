package org.andidev.opinion.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.bull.javamelody.MonitoredWithSpring;
import org.andidev.opinion.domain.Opinion;
import org.andidev.opinion.repository.OpinionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;
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
@MonitoredWithSpring
@ManagedResource
public class OpinionService {

    String age;

    @ManagedAttribute(description = "The Age Attribute", currencyTimeLimit = 15)
    public String getAge() {
        return age;
    }

    @ManagedAttribute(description = "The Age Attribute", currencyTimeLimit = 15)
    public void setAge(String age) {
        this.age = age;
    }

    @ManagedOperation(description = "Add two numbers")
    @ManagedOperationParameters({
        @ManagedOperationParameter(name = "x", description = "The first number"),
        @ManagedOperationParameter(name = "y", description = "The second number")})
    public int add(int x, int y) {
        return x + y;
    }
    @Autowired
    private OpinionRepository opinionRepository;

    public Boolean create(Opinion opinion) {
        // create entity
        Opinion saved = opinionRepository.save(opinion);
        if (saved == null) {
            return false;
        }

        return true;
    }

    public Boolean update(Opinion opinion) {
        // find entity
        Opinion existingOpinion = opinionRepository.findById(opinion.getId());
        if (existingOpinion == null) {
            return false;
        }

        // change entity
        existingOpinion.setHeader(opinion.getHeader());
        existingOpinion.setText(opinion.getText());
        //existingOpinion.setOpinionTags(opinion.getOpinionTags());

        // save entity
        Opinion saved = opinionRepository.save(existingOpinion);
        if (saved == null) {
            return false;
        }

        return true;
    }

    public Boolean delete(Opinion opinion) {
        // find entity
        Opinion existingOpinion = opinionRepository.findById(opinion.getId());
        if (existingOpinion == null) {
            return false;
        }

        // delete entity
        opinionRepository.delete(existingOpinion);
        Opinion deletedOpinion = opinionRepository.findById(opinion.getId());
        if (deletedOpinion != null) {
            return false;
        }

        return true;
    }
}