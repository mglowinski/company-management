package com.mglowinski.companymanagement.config.converter;

import com.mglowinski.companymanagement.model.TaskStatus;
import org.springframework.core.convert.converter.Converter;

public class StringToEnumConverter implements Converter<String, TaskStatus> {

    @Override
    public TaskStatus convert(String source) {
        return TaskStatus.valueOf(source.toUpperCase());
    }

}
