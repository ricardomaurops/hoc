package br.com.rmservicos.hoc.dto;

import br.com.rmservicos.hoc.entities.JobCategory;
import br.com.rmservicos.hoc.enums.UserProfile;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserDto {

    private Integer id;
    private String name;
    private String email;
    private Date dtIncl;
    private Date dtAlter;
    private Date dtInat;
    private UserProfile userProfile;
    private List<JobCategory> jobCategoryList;


}
