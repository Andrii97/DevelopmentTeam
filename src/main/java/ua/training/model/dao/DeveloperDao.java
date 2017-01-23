package ua.training.model.dao;

import ua.training.model.entity.Developer;
import ua.training.model.entity.Qualification;

import java.util.List;

/**
 * Created by andrii on 18.01.17.
 */
public interface DeveloperDao extends GenericDao<Developer> {
    List<Developer> findByQualification(Qualification qualification);
}

