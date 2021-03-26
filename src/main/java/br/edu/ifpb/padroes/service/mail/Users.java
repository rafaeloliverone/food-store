package br.edu.ifpb.padroes.service.mail;

public interface Users<T> {
    public void sendMailNotification(String message, T user);
}
