package lab_6.server.actions;

import lab_6.common.network.Request;
import lab_6.server.app.ServerAppContainer;
import lab_6.server.collection.PostgresCollectionManager;

public class InfoAction implements Action<String> {
    /**
     * @param request
     * @return
     */
    @Override
    public String execute(Request request) {
        PostgresCollectionManager collectionManager = ServerAppContainer.getCollectionManager();
        return "Тип коллекции: " + collectionManager.getType()
                + ", размер коллекции: " + collectionManager.getSize();
    }
}
