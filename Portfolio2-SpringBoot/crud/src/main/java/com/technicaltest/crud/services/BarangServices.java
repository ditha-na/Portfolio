package com.technicaltest.crud.services;

import com.technicaltest.crud.models.entities.Barang;
import com.technicaltest.crud.models.repos.BarangRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.transaction.Transactional;

@Service
@Transactional
@ApplicationScope
public class BarangServices{

    @Autowired
    BarangRepos barangRepos;

    public Barang insert(Barang barang){
        return barangRepos.save(barang);
    }

    public Iterable<Barang> inquiry(){
        return barangRepos.findAll();
    }

    public Barang entity(Long id){
        return barangRepos.findById(id).get();
    }

    public void delete(Long id){
        barangRepos.deleteById(id);
    }


}
