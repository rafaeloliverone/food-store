package br.edu.ifpb.padroes.service.payment;

public class PaymentPayPal implements Payment {

    @Override
    public String doPayment() {
    	return "Do paypal payment!";
    }
}
