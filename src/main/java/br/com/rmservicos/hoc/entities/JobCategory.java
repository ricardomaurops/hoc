package br.com.rmservicos.hoc.entities;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Date;
@Data
@Entity
@Table(name = "job_category")
public class JobCategory {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private Date dtIncl;
    private Date dtAlter;
    private Date dtInat;
}
