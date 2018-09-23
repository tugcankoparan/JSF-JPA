package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Employee;
import service.EmployeeService;
import service.EmployeeServiceImpl;

@ManagedBean
@SessionScoped
public class EmployeeController {

	private String name;
	private String surname;
	private int salary;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	private List<Employee> employees = new ArrayList<>();

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public void addEmployee() {
		
		EmployeeService employeeService = new EmployeeServiceImpl();
		Employee employee = new Employee(name,surname,salary);
		employeeService.save(employee);
		
		employees = employeeService.findAll();
	}

	public void deleteEmployee(int id) {
		EmployeeService employeeService = new EmployeeServiceImpl();
		employeeService.remove(id);
		employees = employeeService.findAll();
	}
}
