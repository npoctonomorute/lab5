package lab_6.client.Commands;

import lab_6.client.App.ClientAppContainer;
import lab_6.client.Commands.Exceptions.ConsoleInputValidator;
import lab_6.common.Classes.User;
import lab_6.common.network.ActionAlias;
import lab_6.common.network.Request;
import lab_6.common.network.RequestSender;
import lab_6.common.network.Response;

public class Register implements Command {
    public void execute(String arg) {
        System.out.println("Введите логин");
        String login = ConsoleInputValidator.getNonEmptyInput();
        System.out.println("Введите пароль");
        String password = ConsoleInputValidator.getNonEmptyInput();
        User user = new User(login, password);
        Request request = new Request(ActionAlias.REGISTER, user);
        Response response = RequestSender.send(request);
        boolean registered = (Boolean) response.getData();
        if (registered) {
            ClientAppContainer.setUser(user);
            System.out.println("Успешная регистрация");
        } else {
            System.out.println("Похоже такой логин уже занят");
        }
    }

    public String description() {
        return "";
    }

    public boolean needToAuthorize() {
        return false;
    }
}
