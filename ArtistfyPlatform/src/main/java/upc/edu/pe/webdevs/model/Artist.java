package upc.edu.pe.webdevs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "artist")
public class Artist  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer artistId;
	
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

	@NotNull(message = "Skills needs a value")
	@Column(name="skill",nullable=false)
	private String skill;
	
	@NotNull(message = "Genre needs a value")
	@Column(name="genre",nullable=false)
	private String genre;

	@NotNull(message = "Website url needs a value")
	@Column(name="website_url",nullable=false)
	private String websiteUrl;

	public Integer getArtistId() {
		return artistId;
	}

	public void setArtistId(Integer artistId) {
		this.artistId = artistId;
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

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skills) {
		this.skill = skills;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getWebsiteUrl() {
		return websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}
	
	
}
