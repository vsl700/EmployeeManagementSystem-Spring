package com.vsl700.employeemanagement.data.models;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document
public class Employee {
    
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Date employmentDate;
    @ReadOnlyProperty
    @DocumentReference(lookup = "{'employeeId':?#{#self._id} }")
    private List<Achievement> achievements;

    public Employee() {
        employmentDate = Date.from(Instant.now());
    }

    public Employee(String firstName, String lastName){
        this();
        
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addAchievement(Achievement achievement){
        achievements.add(achievement);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public List<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<Achievement> achievements) {
        this.achievements = achievements;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", %d achievements".formatted(achievements.size()) + "]";
    }
}
