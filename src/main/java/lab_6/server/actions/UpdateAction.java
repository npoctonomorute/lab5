package lab_6.server.actions;

import lab_6.common.Classes.Worker;
import lab_6.common.Classes.dto.WorkerDTO;
import lab_6.common.network.Request;
import lab_6.server.collection.CollectionManager;

public class UpdateAction implements Action<Worker> {
    /**
     * @param request
     * @return
     */
    @Override
    public Worker execute(Request request) {
        WorkerDTO workerDTO = (WorkerDTO) request.getData();
        return CollectionManager.update(workerDTO.getId(), workerDTO);
    }
}
