package br.com.rmservicos.hoc.controllers;

import br.com.rmservicos.hoc.converters.JobCategoryMapper;
import br.com.rmservicos.hoc.dto.JobCategoryDto;
import br.com.rmservicos.hoc.dto.UserDto;
import br.com.rmservicos.hoc.entities.JobCategory;
import br.com.rmservicos.hoc.entities.User;
import br.com.rmservicos.hoc.services.JobCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/jobcategory")
public class JobCategoryController {

    @Autowired
    JobCategoryService jobCategoryService;

    @Autowired
    JobCategoryMapper jobCategoryMapper;

    @GetMapping()
    public ResponseEntity<List<JobCategoryDto>> listJobCategories() {

        List<JobCategory> jobCategoryList =
                jobCategoryService.findAll();

        List<JobCategoryDto> jobCategoryDtoList
                = new ArrayList<JobCategoryDto>();

        toListDto(jobCategoryList,jobCategoryDtoList);

        return ResponseEntity.ok(jobCategoryDtoList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<JobCategoryDto> getJobCategory(@PathVariable Integer id) {

        Optional<JobCategory> jobCategory =
                jobCategoryService.findById(id);

        return jobCategory
                .map(value -> ResponseEntity
                        .ok(jobCategoryMapper.entityToJobCategoryDto(value)))
                        .orElseGet(()-> ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<JobCategoryDto> saveJobCategory (@RequestBody JobCategoryDto jobCategoryDto) {

        if(!Objects.isNull(jobCategoryDto)
                && !Objects.isNull(jobCategoryDto.getName())) {

            JobCategory jobCategory =
                    jobCategoryMapper.dtoToJobCategory(jobCategoryDto);

            jobCategory = jobCategoryService
                    .save(jobCategory);

            return ResponseEntity
                    .ok(jobCategoryMapper.entityToJobCategoryDto(jobCategory));

        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    public ResponseEntity<JobCategoryDto> updateJobCategory(@RequestBody JobCategoryDto jobCategoryDto) {

        JobCategory jobCategory = jobCategoryMapper
                .dtoToJobCategory(jobCategoryDto);

        jobCategory = jobCategoryService
                .update(jobCategory);

        return ResponseEntity
                .ok(jobCategoryMapper.entityToJobCategoryDto(jobCategory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobCategory(@PathVariable Integer id) {

        jobCategoryService
                .delete(id);

        return ResponseEntity.ok().build();
    }

    private void toListDto(List<JobCategory> categoryDb, List<JobCategoryDto> categories) {

        if(!categoryDb.isEmpty()) {

            categoryDb.forEach((category ->
                                categories
                                        .add(jobCategoryMapper.entityToJobCategoryDto(category)
                                )));
        }
    }
}
