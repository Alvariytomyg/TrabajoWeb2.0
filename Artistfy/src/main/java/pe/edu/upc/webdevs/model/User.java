package pe.edu.upc.webdevs.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotNull(message = "Email cannot be null.")
	@NotEmpty(message = "Email cannot be blank")
	@Email(message = "Invalid email address")
	@Column(name = "email", nullable = false)
	private String email;
	
	@NotNull(message = "Password needs a value")
	@NotEmpty(message = "A value for password needs to be specified.")
	@Column(name = "password", nullable = false)
	private String password;
	
	
	
	@Column(name = "enabled")
	private int enabled;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_roles", 
		joinColumns = @JoinColumn(name = "user_id"), 
		inverseJoinColumns=@JoinColumn(name = "role_id"))
	private List<Role> roles;
}
