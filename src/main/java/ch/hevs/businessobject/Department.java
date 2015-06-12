package ch.hevs.businessobject;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(name="name")
	private String name;

	// relations
	@OneToMany(mappedBy = "department", orphanRemoval=true, cascade = CascadeType.ALL)
	private List<Office> offices;
	
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
	
	// offices
	public List<Office> getOffices() {
		return offices;
	}
	public void setOffices(List<Office> offices) {
		this.offices = offices;
	}
	
	// constructors
	public Department() {
	}
	public Department(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return id + "-" + name;
	}
}
