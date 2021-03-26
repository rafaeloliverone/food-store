package br.edu.ifpb.padroes.service.mail;

import br.edu.ifpb.padroes.domain.Customer;

public class CustomerNotification implements Users<Customer> {

	@Override
	public void sendMailNotification(String message, Customer customer) {
		System.out.println("send mail notification to " + customer.getEmail());
		
	}
    
}
