package lab_6.server.actions;

import lab_6.common.network.Request;
import lab_6.server.CollectionManager;

public class InfoAction implements Action<String> {
    /**
     * @param request
     * @return
     */
    @Override
    public String execute(Request request) {
        return "Тип коллекции: " + CollectionManager.getType()
                + ", дата инициализации: " + CollectionManager.getInitializationDate()
                + ", размер коллекции: " + CollectionManager.getSize();
    }
}
