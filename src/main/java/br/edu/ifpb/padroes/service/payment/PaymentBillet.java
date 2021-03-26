package br.edu.ifpb.padroes.service.payment;

public class PaymentBillet implements Payment {

    @Override
    public String doPayment() {
    	return "Do billet payment!";
    }
}
