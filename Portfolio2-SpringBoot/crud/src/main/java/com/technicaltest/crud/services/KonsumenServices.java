package com.technicaltest.crud.services;

import com.technicaltest.crud.models.entities.Konsumen;
import com.technicaltest.crud.models.repos.KonsumenRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.transaction.Transactional;

@Service
@Transactional
@ApplicationScope
public class KonsumenServices {

    @Autowired
    KonsumenRepos konsumenRepos;

    public Konsumen insert(Konsumen konsumen) {
        return konsumenRepos.save(konsumen);
    }

    public Iterable<Konsumen> inquiry() {
        return konsumenRepos.findAll();
    }

    public Konsumen entity(Long id) {
        return konsumenRepos.findById(id).get();
    }

    public void delete(Long id) {
        konsumenRepos.deleteById(id);
    }
}
