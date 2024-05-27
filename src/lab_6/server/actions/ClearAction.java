package lab_6.server.actions;

import lab_6.common.network.Request;
import lab_6.server.CollectionManager;
import lab_6.server.JSON.JsonWriter;

public class ClearAction implements Action<Integer> {
    /**
     * @param request
     * @return
     */
    @Override
    public Integer execute(Request request) {
        Integer size = CollectionManager.getSize();
        CollectionManager.clear();
        JsonWriter.save();
        return size;
    }
}
