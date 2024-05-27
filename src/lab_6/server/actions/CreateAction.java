package lab_6.server.actions;

import lab_6.common.Classes.Worker;
import lab_6.common.Classes.dto.WorkerDTO;
import lab_6.common.network.Request;
import lab_6.server.CollectionManager;
import lab_6.server.JSON.JsonWriter;

public class CreateAction implements Action<Worker> {
    /**
     * @param request
     * @return
     */
    @Override
    public Worker execute(Request request) {
        WorkerDTO workerDTO = (WorkerDTO) request.getData();
        Worker worker = CollectionManager.create(workerDTO);
        JsonWriter.save();
        return worker;
    }
}
