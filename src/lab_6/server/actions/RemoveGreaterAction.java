package lab_6.server.actions;

import lab_6.common.Classes.dto.WorkerDTO;
import lab_6.common.network.Request;
import lab_6.server.CollectionManager;

public class RemoveGreaterAction implements Action<Integer> {
    /**
     * @param request
     * @return
     */
    @Override
    public Integer execute(Request request) {
        WorkerDTO workerDTO = (WorkerDTO) request.getData();
        return CollectionManager.removeGreater(workerDTO);
    }
}
