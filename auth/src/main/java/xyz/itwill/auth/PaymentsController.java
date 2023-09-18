package xyz.itwill.auth;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.itwill.dto.Payment;

@Controller
@RequestMapping("/payment")
public class PaymentsController {
	@RequestMapping(value="/pay", method = RequestMethod.GET)
	public String pay() {
		return "pay";	
	}
	
	@RequestMapping(value="/pay", method = RequestMethod.POST)
	@ResponseBody
	public String pay(@RequestBody Payment payment, HttpSession session) {
		//결제 관련 API를 이용하기 전에 결제 금액 검증을 위해 세션에 주문번호(이름)와 결제금액(값)을 저장
		session.setAttribute(payment.getMerchantUid(), payment.getAmount());
		return "ok";	
	}
}








