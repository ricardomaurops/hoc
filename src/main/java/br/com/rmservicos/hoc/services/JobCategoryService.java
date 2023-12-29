package br.com.rmservicos.hoc.services;

import br.com.rmservicos.hoc.dto.JobCategoryDto;
import br.com.rmservicos.hoc.entities.JobCategory;
import br.com.rmservicos.hoc.repositories.JobCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class JobCategoryService {
    @Autowired
    JobCategoryRepository jobCategoryRepository;

    public List<JobCategory> findAll() {
        return jobCategoryRepository.findAll();
    }

    public JobCategory save(JobCategory jobCategory) {
        if(jobCategoryRepository.findByName(jobCategory.getName()) == null) {
            jobCategory.setDtIncl(new Date());
            return jobCategoryRepository.save(jobCategory);
        }
        return null;
    }

    public JobCategory update(JobCategory jobCategory) {
        jobCategory.setDtAlter(new Date());
        return jobCategoryRepository.save(jobCategory);
    }

    public void delete(Integer id) {
        Optional<JobCategory> jobCategory = jobCategoryRepository.findById(id);
        jobCategory.ifPresent(category -> jobCategoryRepository.delete(category));
    }

    public Optional<JobCategory> findById(Integer id) {
        return jobCategoryRepository.findById(id);
    }
}
