package xyz.itwill10.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Employee {
	@NotNull
	private String id;
	@NotNull
	private String passwd;
	@NotNull
	private String name;
	@NotNull
	private String email;
	@NotNull
	private String gender;
}
