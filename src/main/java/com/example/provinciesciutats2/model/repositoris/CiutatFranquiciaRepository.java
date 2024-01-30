package com.example.provinciesciutats2.model.repositoris;

import com.example.provinciesciutats2.model.entintats.CiutatsFranquicies;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiutatFranquiciaRepository extends CrudRepository<CiutatsFranquicies,Long> {
}
