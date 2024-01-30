package com.example.provinciesciutats2.model.repositoris;

import com.example.provinciesciutats2.model.entintats.Provincies;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinciesRepository extends CrudRepository<Provincies,Long> {
}
