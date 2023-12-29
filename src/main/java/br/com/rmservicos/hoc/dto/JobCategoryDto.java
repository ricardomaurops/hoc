package br.com.rmservicos.hoc.dto;

import lombok.Data;

import java.util.Date;

@Data
public class JobCategoryDto {
    private Integer id;
    private String name;
    private Date dtIncl;
    private Date dtAlter;
    private Date dtInat;
}
