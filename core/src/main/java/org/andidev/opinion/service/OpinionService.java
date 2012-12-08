package org.andidev.opinion.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.bull.javamelody.MonitoredWithSpring;
import org.andidev.opinion.domain.Opinion;
import org.andidev.opinion.repository.OpinionRepository;
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
@MonitoredWithSpring
public class OpinionService {

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