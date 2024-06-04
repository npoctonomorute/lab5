package lab_6.server.actions;

import lab_6.common.network.Request;
import lab_6.server.app.ServerAppContainer;
import lab_6.server.collection.PostgresCollectionManager;

public class ClearAction implements Action<Integer> {
    /**
     * @param request
     * @return
     */
    @Override
    public Integer execute(Request request) {
        PostgresCollectionManager collectionManager = ServerAppContainer.getCollectionManager();
        return collectionManager.clear();
    }
}
