package xyz.itwill.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	@Value("${id}")
	private String id;
	
	@GetMapping("/test")
	@ResponseBody
	public String test() {
		return id;
	}
}
