package pe.edu.upc.webdevs.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="events")
public class Event implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "Name must have a value.")
	@NotEmpty(message = "You need to specify a name.")
	@Column(name="name",nullable=false)
	private String name;
	
	@NotNull(message = "Description must have a value.")
	@NotEmpty(message = "You need to specify a description.")
	@Column(name="description",nullable=false)
	private String description;
	
	@NotNull(message = "Requeriments must have a value.")
	@NotEmpty(message = "You need to specify a requeriments.")
	@Column(name="requeriments",nullable=false)
	private String requeriments;
	
	@NotNull(message = "OfferedSalary must have a value.")
	@DecimalMin("1.00")
	@Column(name="offered_salary",nullable=false, columnDefinition = "Decimal(8,2)")
	private Double offeredSalary;
	
	@NotNull(message = "An expiration date needs to be specified.")
	@Future(message = "The expiration date must be in the future.")
	@Column(name="schedule_at",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date scheduleAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRequeriments() {
		return requeriments;
	}

	public void setRequeriments(String requeriments) {
		this.requeriments = requeriments;
	}

	public Double getOfferedSalary() {
		return offeredSalary;
	}

	public void setOfferedSalary(Double offeredSalary) {
		this.offeredSalary = offeredSalary;
	}

	public Date getScheduleAt() {
		return scheduleAt;
	}

	public void setScheduleAt(Date scheduleAt) {
		this.scheduleAt = scheduleAt;
	}
	
	
	
}
