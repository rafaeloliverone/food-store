package br.edu.ifpb.padroes.service.order;

import br.edu.ifpb.padroes.domain.Administrator;
import br.edu.ifpb.padroes.domain.Customer;
import br.edu.ifpb.padroes.domain.Order;
import br.edu.ifpb.padroes.service.log.LogHandler;
import br.edu.ifpb.padroes.service.log.LogService;
import br.edu.ifpb.padroes.service.mail.AdministratorNotification;
import br.edu.ifpb.padroes.service.mail.CustomerNotification;
import br.edu.ifpb.padroes.service.payment.PaymentCreditCard;
import br.edu.ifpb.padroes.service.payment.PaymentPayPal;
import br.edu.ifpb.padroes.service.payment.PaymentService;

public class OrderManager {

    public OrderManager(Order order) {
        this.order = order;
    }

    private Order order;

    private CustomerNotification customerNotification = new CustomerNotification();

    private AdministratorNotification administratorNotification = new AdministratorNotification();


    private PaymentService paymentService = new PaymentService(new PaymentPayPal());

    private LogService logService = new LogService(new LogHandler(LogHandler.LogHandlerType.FILE));

    public void payOrder() {
        order.setStatus(Order.OrderStatus.IN_PROGRESS);
        try {

            paymentService.doPayment();
            order.setStatus(Order.OrderStatus.PAYMENT_SUCCESS);
            customerNotification.sendMailNotification(String.format("Order %d completed successfully", order.getId()), new Customer("rafael@gmail.com"));
            logService.info("payment finished");
        } catch (Exception e) {
            logService.error("payment refused");
            order.setStatus(Order.OrderStatus.PAYMENT_REFUSED);
            customerNotification.sendMailNotification(String.format("Order %d refused", order.getId()), new Customer("rafael@gmail.com"));
        }
    }

    public void cancelOrder() {
        order.setStatus(Order.OrderStatus.CANCELED);
        customerNotification.sendMailNotification(String.format("Order %d canceled", order.getId()), new Customer("rafael@gmail.com"));
        administratorNotification.sendMailNotification(String.format("Order %d canceled", order.getId()), new Administrator("Admin", "admin@gmail.com"));

        logService.debug(String.format("order %d canceled", order.getId()));
    }

}
