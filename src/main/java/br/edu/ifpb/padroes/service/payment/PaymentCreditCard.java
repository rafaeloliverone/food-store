package br.edu.ifpb.padroes.service.payment;

public class PaymentCreditCard implements Payment {

    @Override
    public String doPayment() {
        return "Do credit card payment!";
    }
}
