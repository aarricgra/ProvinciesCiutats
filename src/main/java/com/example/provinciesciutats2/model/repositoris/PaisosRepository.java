package com.example.provinciesciutats2.model.repositoris;

import com.example.provinciesciutats2.model.entintats.Paisos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisosRepository extends CrudRepository<Paisos,Long> {
}
