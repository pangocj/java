package xyz.itwill.service;

import xyz.itwill.dto.Payment;

public interface PaymentService {
	void addPayment(Payment payment);
	void modifyPayment(Payment payment);

	String getAccessToken(Payment payment);
	Payment getPayment(String accessToken, String impUid);
	String canclePayment(String accessToken, Payment payment);
}