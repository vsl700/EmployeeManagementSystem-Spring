package com.vsl700.employeemanagement.data.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Achievement {
    
    @Id
    public String id;
    public String name;

    public String employeeId;

    public Achievement() {}

    public Achievement(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Achievement [id=" + id + ", name=" + name + ", employeeId=" + employeeId + "]";
    }
}
