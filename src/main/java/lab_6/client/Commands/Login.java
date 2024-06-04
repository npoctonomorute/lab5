package lab_6.client.Commands;

import lab_6.client.App.ClientAppContainer;
import lab_6.client.App.RequestSender;
import lab_6.client.Commands.Exceptions.ConsoleInputValidator;
import lab_6.common.Classes.User;
import lab_6.common.network.ActionAlias;
import lab_6.common.network.Request;
import lab_6.common.network.Response;

public class Login implements Command {
    public void execute(String arg) {
        System.out.println("Введите логин");
        String login = ConsoleInputValidator.getNonEmptyInput();
        System.out.println("Введите пароль");
        String password = ConsoleInputValidator.getNonEmptyInput();
        User user = new User(login, password);
        Request request = new Request(ActionAlias.LOGIN, user);
        Response response = RequestSender.send(request);
        boolean isLoggedIn = (Boolean) response.getData();
        if (isLoggedIn) {
            ClientAppContainer.setUser(user);
            System.out.println("Успешный вход");
        } else {
            System.out.println("Неверный логин или пароль. Попробуйте ещё раз.");
        }
    }

    public String description() {
        return "login - войти в аккаунт";
    }

    public boolean needToAuthorize() {
        return false;
    }
}
