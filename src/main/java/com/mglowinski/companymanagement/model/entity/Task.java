package com.mglowinski.companymanagement.model.entity;

import com.mglowinski.companymanagement.model.TaskLevel;
import com.mglowinski.companymanagement.model.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private TaskLevel taskLevel;
    private TaskStatus taskStatus;

    @OneToMany(mappedBy = "task")
    private List<TaskAdditionalInfo> taskAdditionalInfos;
}
