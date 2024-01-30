package com.example.provinciesciutats2.model.repositoris;

import com.example.provinciesciutats2.model.entintats.Franquicies;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranquiciaRepository extends CrudRepository<Franquicies,Long> {
}
