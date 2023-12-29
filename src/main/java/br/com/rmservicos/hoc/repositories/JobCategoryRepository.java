package br.com.rmservicos.hoc.repositories;

import br.com.rmservicos.hoc.entities.JobCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobCategoryRepository extends JpaRepository<JobCategory, Integer> {
    JobCategory findByName(String name);
}
