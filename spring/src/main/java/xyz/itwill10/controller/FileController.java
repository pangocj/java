package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/file")
public class FileController {
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String upload() {
		return "file/form_one";
	}
}
