package lab_6.server.actions;

import lab_6.common.Classes.Worker;
import lab_6.common.Classes.dto.WorkerDTO;
import lab_6.common.network.Request;
import lab_6.server.app.ServerAppContainer;
import lab_6.server.collection.PostgresCollectionManager;

public class UpdateAction implements Action<Worker> {
    public Worker execute(Request request) {
        WorkerDTO workerDTO = (WorkerDTO) request.getData();
        PostgresCollectionManager collectionManager = ServerAppContainer.getCollectionManager();
        Worker worker = collectionManager.getWorkerById(workerDTO.getId());
        if (worker == null) {
            return null;
        }
        if (!worker.getOwnerLogin().equals(request.getUser().getLogin())) {
            return worker;
        }
        return collectionManager.updateWorker(workerDTO.getId(), workerDTO);
    }
}
