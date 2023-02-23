package com.technicaltest.crud.services;

import com.technicaltest.crud.models.entities.Penjualan;
import com.technicaltest.crud.models.repos.PenjualanRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.transaction.Transactional;

@Service
@Transactional
@ApplicationScope
public class PenjualanServices {

    @Autowired
    PenjualanRepos penjualanRepos;

    public Penjualan insert(Penjualan penjualan){
        return penjualanRepos.save(penjualan);
    }

    public Iterable<Penjualan> inquiry(){
        return penjualanRepos.findAll();
    }

    public Penjualan entity(Long id){
        return penjualanRepos.findById(id).get();
    }

    public void delete(Long id) {
        penjualanRepos.deleteById(id);
    }

}
