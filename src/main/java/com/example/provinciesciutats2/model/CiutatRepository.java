package com.example.provinciesciutats2.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiutatRepository extends CrudRepository<com.example.provinciesciutats2.model.Ciutats,Long> {
}
