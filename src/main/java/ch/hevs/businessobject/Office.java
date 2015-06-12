package ch.hevs.businessobject;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Office")
public class Office {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="capacity")
	private int capacity;

	@ManyToOne
	@JoinColumn(name = "fk_department")
	private Department department;
	
	// relations
	@OneToMany(mappedBy = "office", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Employee> employees;
	
	// id
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	// name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// capacity
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	// employees
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	// department
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	// constructors
	public Office() {
	}
	public Office(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
	}
	
	@Override
	public String toString() {
		return id + "-" + name;
	}
}
