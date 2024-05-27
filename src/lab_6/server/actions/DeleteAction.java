package lab_6.server.actions;

import lab_6.common.network.Request;
import lab_6.server.CollectionManager;
import lab_6.server.JSON.JsonWriter;

public class DeleteAction implements Action<Boolean> {
    /**
     * @param request
     * @return
     */
    @Override
    public Boolean execute(Request request) {
        Long key = (Long) request.getData();
        CollectionManager.removeKey(key);
        JsonWriter.save();
        return true;
    }
}
