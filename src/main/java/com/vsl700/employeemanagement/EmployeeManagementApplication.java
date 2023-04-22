package com.vsl700.employeemanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.vsl700.employeemanagement.data.AchievementRepository;
import com.vsl700.employeemanagement.data.EmployeeRepository;
import com.vsl700.employeemanagement.data.models.Achievement;
import com.vsl700.employeemanagement.data.models.Employee;

@SpringBootApplication
public class EmployeeManagementApplication {

	private EmployeeRepository employeeRepository;
	private AchievementRepository achievementRepository;

	public EmployeeManagementApplication(EmployeeRepository employeeRepository, AchievementRepository achievementRepository){
		this.employeeRepository = employeeRepository;
		this.achievementRepository = achievementRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

	@Bean
	CommandLineRunner loadDatabase(){
		return args -> {
			// employeeRepository.deleteAll();
			// achievementRepository.deleteAll();

			addNewAchievement("Work hard");
			addNewAchievement("Work hard = Play hard");
			addNewAchievement("You want it, you got it!");
			addNewAchievement("Laziness saves you!");

			addNewEmployee("Alice", "Smith");
			addNewEmployee("John", "Smith");
			addNewEmployee("Peter", "Jackson");

			System.out.println("\nfindAll:");
			for (Employee employee : employeeRepository.findAll()) {
				System.out.println(employee);
			}

			System.out.println("\nfindByLastName:");
			for (Employee employee : employeeRepository.findByLastName("Smith")) {
				System.out.println(employee);
			}

			System.out.println("\nfindByFirstNameAndLastName:");
			Employee employee = employeeRepository.findByFirstNameAndLastName("Peter", "Jackson");
			System.out.println(employee);

			// Achievement achievement = achievementRepository.findByName("Laziness saves you!");
			// achievement.employeeId = employee.id;
			// achievementRepository.save(achievement);
			// employee = employeeRepository.findByFirstNameAndLastName("Peter", "Jackson");
			// System.out.println("\nEmployee with achievement:");
			// System.out.println(employee);
			
			// ----PREVIOUS CODE-----------------------------------
			// employee.addAchievement(achievement);
			// employee = employeeRepository.save(employee);
			// System.out.println("Employee with achievement:");
			// System.out.println(employee);
			// System.out.println("Employee's achievement:");
			// System.out.println(achievement);
			
			// achievement = achievementRepository.findByName("Laziness saves you!");
			// System.out.println("Employee's achievement:");
			// System.out.println(achievement);
		};
	}

	private void addNewEmployee(String firstName, String lastName){
		if(employeeRepository.findByFirstNameAndLastName(firstName, lastName) == null){
			Employee employee = new Employee(firstName, lastName);
			employeeRepository.save(employee);
		}
	}

	private void addNewAchievement(String name){
		if(achievementRepository.findByName(name) == null){
			Achievement achievement = new Achievement(name);
			achievementRepository.save(achievement);
		}
	}

}
