package br.edu.ifpb.padroes.service.payment;

public class PaymentDebit implements Payment {

    @Override
    public String doPayment() {
        return "Do debit payment!";
    }
}
