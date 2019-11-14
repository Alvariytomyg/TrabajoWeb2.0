package pe.edu.upc.webdevs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")

public class User implements Serializable  {
private static final long serialVersionUID=1L;
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;

@Column(name="username",nullable=false)
private String username;
@Column(name="password",nullable=false)
private String password;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}
public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
	
}
public String getPassword() {
	return username;
}

public void setPassword(String password) {
	this.password = password;
	
}
}
