package com.example.demo1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Demo1Application {

	
    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    @Bean
    CommandLineRunner loadData(DepartmentRepository departmentRepository) {

        return args -> {

            Department department = new Department("IT");

            Employee e1 = new Employee("John");
            Employee e2 = new Employee("David");
            Employee e3 = new Employee("Smith");
            
            

            department.addEmployee(e1);
            department.addEmployee(e2);
            department.addEmployee(e3);

            departmentRepository.save(department);

            System.out.println("Data saved successfully");
        };
    }
}