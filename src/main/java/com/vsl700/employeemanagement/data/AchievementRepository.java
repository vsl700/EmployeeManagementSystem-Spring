package com.vsl700.employeemanagement.data;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vsl700.employeemanagement.data.models.Achievement;

public interface AchievementRepository extends MongoRepository<Achievement, String> {
    Achievement findByName(String name);
}
