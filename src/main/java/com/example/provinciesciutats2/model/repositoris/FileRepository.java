package com.example.provinciesciutats2.model.repositoris;

import com.example.provinciesciutats2.model.entintats.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FileRepository extends JpaRepository<File, UUID> {
}
