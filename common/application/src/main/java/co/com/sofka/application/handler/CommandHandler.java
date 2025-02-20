package co.com.sofka.application.handler;

public interface CommandHandler<C> {
    void execute(C command);
}
