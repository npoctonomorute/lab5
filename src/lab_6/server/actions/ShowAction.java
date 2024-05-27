package lab_6.server.actions;

import lab_6.common.Classes.Worker;
import lab_6.common.network.Request;
import lab_6.server.CollectionManager;

import java.util.HashMap;

public class ShowAction implements Action<HashMap<Long, Worker>> {
    /**
     * @param request
     * @return
     */
    @Override
    public HashMap<Long, Worker> execute(Request request) {
        return CollectionManager.getMap();
    }
}
