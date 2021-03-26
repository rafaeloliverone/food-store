package br.edu.ifpb.padroes.service.payment;

public class PaymentService {

    private Payment paymentGeneric;

    public PaymentService(Payment aa) {
        this.paymentGeneric = aa;
    }
//
//    public enum PaymentType {
//        CREDIT_CARD, DEBIT, BILLET, PAYPAL
//    }


    public void doPayment() {
        System.out.println(paymentGeneric.doPayment());
    }

}
