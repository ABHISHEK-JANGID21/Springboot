package com.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
//@Data is combo of @Getters @setters @Code @ RequiredArgsConstructor @ToString @EqualsAndHashCode
@Data 
@ApiModel(description = "Employee details")
@Entity
public class Employee {
	@Id
	@ApiModelProperty(value = "The unique Id of an emplyee")
	 @Column(name = "Emp_Id")
	private int id;
	@ApiModelProperty(value="Name of an employee")
	@Column(name = "Emp_Name", length = 50)
	private String name;
	@ApiModelProperty(value ="Address of an emplyee")
	@Column(name = "Home_Town", length = 100)
	private String address;
	@ApiModelProperty(value = "Number of years of experience")
	@Column(name = "Years_Of_Experience")
	private int experience;

}
