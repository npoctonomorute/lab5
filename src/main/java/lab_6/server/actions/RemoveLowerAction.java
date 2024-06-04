package lab_6.server.actions;

import lab_6.common.Classes.dto.WorkerDTO;
import lab_6.common.network.Request;
import lab_6.server.app.ServerAppContainer;
import lab_6.server.collection.PostgresCollectionManager;

public class RemoveLowerAction implements Action<Integer> {
    /**
     * @param request
     * @return
     */
    @Override
    public Integer execute(Request request) {
        WorkerDTO workerDTO = (WorkerDTO) request.getData();
        PostgresCollectionManager collectionManager = ServerAppContainer.getCollectionManager();
        return collectionManager.removeLower(workerDTO, request.getUser());
    }
}
