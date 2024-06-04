package lab_6.server.actions;

import lab_6.common.Classes.Worker;
import lab_6.common.network.Request;
import lab_6.server.app.ServerAppContainer;
import lab_6.server.collection.PostgresCollectionManager;

import java.util.Map;

public class ShowAction implements Action<Map<Long, Worker>> {
    /**
     * @param request
     * @return
     */
    @Override
    public Map<Long, Worker> execute(Request request) {
        PostgresCollectionManager collectionManager = ServerAppContainer.getCollectionManager();
        return collectionManager.getMap();
    }
}
