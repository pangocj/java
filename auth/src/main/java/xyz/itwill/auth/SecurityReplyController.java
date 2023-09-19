package xyz.itwill.auth;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import xyz.itwill.dto.SecurityReply;
import xyz.itwill.service.SecurityReplyService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reply")
public class SecurityReplyController {
	private final SecurityReplyService securityReplyService;
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/register")
	public String register(@RequestBody @Valid SecurityReply reply, BindingResult bindingResult) throws BindException {
		if(bindingResult.hasErrors()) {
			throw new BindException(bindingResult);
		}
		securityReplyService.addSecurityReply(reply);
		return "success";
	}
	 
	@GetMapping("/list/{boardIdx}")
	public List<SecurityReply> list(@PathVariable int boardIdx) {
		return securityReplyService.getSecurityReplyList(boardIdx);
	}
}









