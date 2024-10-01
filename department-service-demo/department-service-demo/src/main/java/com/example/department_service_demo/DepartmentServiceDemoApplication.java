package com.example.department_service_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DepartmentServiceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceDemoApplication.class, args);
	}

}
