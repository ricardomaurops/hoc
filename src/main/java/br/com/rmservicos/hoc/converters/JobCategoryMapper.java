package br.com.rmservicos.hoc.converters;

import br.com.rmservicos.hoc.dto.JobCategoryDto;
import br.com.rmservicos.hoc.entities.JobCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobCategoryMapper {

    JobCategory dtoToJobCategory(JobCategoryDto jobCategoryDto);
    JobCategoryDto entityToJobCategoryDto(JobCategory jobCategory);
}
