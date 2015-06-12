package ch.hevs.businessobject;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(name="firstname")
	@NotBlank
	private String firstname;
	
	@Column(name="lastname")
	@NotBlank
	private String lastname;

	// relations
	@ManyToOne
	@JoinColumn(name = "fk_office")
	private Office office;
	
	// id
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	// firstname
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	// lastname
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	// office
	public Office getOffice() {
		return office;
	}
	public void setOffice(Office office) {
		this.office = office;
	}
	
	// constructors
	public Employee() {
	}
	public Employee(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	@Override
	public String toString() {
		return id + "-" + firstname + "-" + lastname;
	}
}
