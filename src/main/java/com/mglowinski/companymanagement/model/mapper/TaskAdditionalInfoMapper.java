package com.mglowinski.companymanagement.model.mapper;

import com.mglowinski.companymanagement.model.dto.TaskAdditionalInfoDTO;
import com.mglowinski.companymanagement.model.entity.TaskAdditionalInfo;
import org.springframework.stereotype.Component;

@Component
public class TaskAdditionalInfoMapper implements Mapper<TaskAdditionalInfo, TaskAdditionalInfoDTO> {

    @Override
    public TaskAdditionalInfoDTO map(TaskAdditionalInfo from) {
        if (from != null) {
            return TaskAdditionalInfoDTO.builder()
                    .id(from.getId())
                    .description(from.getDescription())
                    .attachment(from.getAttachment())
                    .build();
        }
        return null;
    }

}
