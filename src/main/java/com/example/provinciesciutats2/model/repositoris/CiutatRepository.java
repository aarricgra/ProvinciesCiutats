package com.example.provinciesciutats2.model.repositoris;

import com.example.provinciesciutats2.model.entintats.Ciutats;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiutatRepository extends CrudRepository<Ciutats,Long> {
}
