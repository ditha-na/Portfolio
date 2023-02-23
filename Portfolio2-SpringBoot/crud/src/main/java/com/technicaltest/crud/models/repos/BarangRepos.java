package com.technicaltest.crud.models.repos;

import com.technicaltest.crud.models.entities.Barang;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarangRepos extends CrudRepository<Barang, Long> {
}
