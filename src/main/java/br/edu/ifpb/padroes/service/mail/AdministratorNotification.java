package br.edu.ifpb.padroes.service.mail;

import br.edu.ifpb.padroes.domain.Administrator;

public class AdministratorNotification implements Users<Administrator>{

    @Override
    public void sendMailNotification(String message, Administrator administrator) {
        System.out.println("send mail notification to admin=" + administrator.getEmail());
    }
}
