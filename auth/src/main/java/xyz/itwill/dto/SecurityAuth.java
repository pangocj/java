package xyz.itwill.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SecurityAuth {
	private String userid;
	private String auth;
}
