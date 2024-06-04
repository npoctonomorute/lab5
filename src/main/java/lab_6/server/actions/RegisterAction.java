package lab_6.server.actions;

import lab_6.common.Classes.User;
import lab_6.common.network.Request;
import lab_6.server.app.ServerAppContainer;
import lab_6.server.user.UserManager;

public class RegisterAction implements Action<Boolean> {
    public Boolean execute(Request request) {
        User user = (User) request.getData();
        UserManager userManager = ServerAppContainer.getUserManager();
        return userManager.register(user);
    }
}
