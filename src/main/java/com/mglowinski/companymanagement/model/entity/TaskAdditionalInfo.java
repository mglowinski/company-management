package com.mglowinski.companymanagement.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.File;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TaskAdditionalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private File attachment;

    @ManyToOne
    @JoinColumn
    private Task task;
}
