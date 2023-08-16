package xyz.itwill10.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RestMember {
	private String id;
	private String name;
	private String email;
}
