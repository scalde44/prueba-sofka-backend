package co.com.sofka.application.handler;

public interface CommandResponseHandler<C, R> {
    R execute(C command);
}
