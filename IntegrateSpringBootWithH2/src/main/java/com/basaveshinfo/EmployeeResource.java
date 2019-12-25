package com.basaveshinfo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class EmployeeResource {

	@Autowired
	EmployeeRepo employeeRepo;
	
	@RequestMapping("/addemployees")
	public void addEmployee() {
		employeeRepo.save(new Employee("Basavesh",75000,28));
		employeeRepo.save(new Employee("Suresh",70000,35));
		employeeRepo.save(new Employee("Ramesh",65000,38));
		employeeRepo.save(new Employee("Arun",78000,30));
		employeeRepo.save(new Employee("Karthik",50000,25));
		employeeRepo.save(new Employee("Akash",25000,29));
		employeeRepo.save(new Employee("Pavan",15000,40));
		employeeRepo.save(new Employee("Varun",35000,34));
		
		
	}
	
	@RequestMapping("/employees")
	public List<Employee> getAll(){
		return employeeRepo.findAll();
	}
	
	@RequestMapping("/employees/{id}")
	public Optional<Employee> getEmployee(@PathVariable("id") int id) {
		return employeeRepo.findById(id);
	}
	
	/*
	 * @RequestMapping("/employees/highsalary") public Employee
	 * getHighestSalariedEmp() {
	 * 
	 * returnemployeeRepo.findByName("Basavesh"); }
	 */
	
	@RequestMapping("/employees/greaterthan/{salary}")
	public List<Employee> getempSalaryGreaterThan(@PathVariable("salary") int salary) {
		
		
		return employeeRepo.findBySalaryGreatherThan(salary);
	}
	
	
	
	
	
	
	
	
}
