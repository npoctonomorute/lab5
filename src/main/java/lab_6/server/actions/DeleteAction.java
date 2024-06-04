package lab_6.server.actions;

import lab_6.common.network.Request;
import lab_6.server.app.ServerAppContainer;
import lab_6.server.collection.PostgresCollectionManager;

public class DeleteAction implements Action<Boolean> {
    /**
     * @param request
     * @return
     */
    @Override
    public Boolean execute(Request request) {
        Long key = (Long) request.getData();
        PostgresCollectionManager collectionManager = ServerAppContainer.getCollectionManager();
        return collectionManager.removeKey(key);
    }
}
