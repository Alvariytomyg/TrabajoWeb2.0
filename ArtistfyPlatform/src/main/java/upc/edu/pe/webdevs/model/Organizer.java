package upc.edu.pe.webdevs.model;

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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "organizer")
public class Organizer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer organizerId;
	
	@NotNull(message = "First Name must have a value.")
	@NotEmpty(message = "Enter your firstname")
	@Column(name="first_name",nullable=false)
	private String firstName;
	
	@NotNull(message = "Last Name must have a value.")
	@NotEmpty(message = "Enter your lastname")
	@Column(name="last_name",nullable=false)
	private String lastName;
	
	@NotNull(message = "Dni needs a value")
	@Column(name="dni",nullable=false)
	private Long dni;
	
	@NotNull(message = "Email cannot be null.")
	@NotEmpty(message = "Email cannot be blank")
	@Column(name="email",nullable=false)
	private String email;
	
	@NotNull(message = "Phone needs a value")
	@Column(name="phone",nullable=false)
	private Long phone;
	
	@OneToMany(mappedBy = "organizer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Event> events;
	

	public Integer getOrganizerId() {
		return organizerId;
	}

	public void setOrganizerId(Integer organizerId) {
		this.organizerId = organizerId;
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

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	
}
