package com.technicaltest.crud.models.repos;

import com.technicaltest.crud.models.entities.Konsumen;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KonsumenRepos extends CrudRepository<Konsumen, Long> {
}
