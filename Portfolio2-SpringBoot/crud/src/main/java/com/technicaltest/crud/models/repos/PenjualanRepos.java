package com.technicaltest.crud.models.repos;

import com.technicaltest.crud.models.entities.Penjualan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenjualanRepos extends CrudRepository<Penjualan, Long> {
}
