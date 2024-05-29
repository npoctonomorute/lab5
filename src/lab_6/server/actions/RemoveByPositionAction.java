package lab_6.server.actions;

import lab_6.common.Classes.Position;
import lab_6.common.network.Request;
import lab_6.server.CollectionManager;

public class RemoveByPositionAction implements Action<Integer> {
    /**
     * @param request
     * @return
     */
    @Override
    public Integer execute(Request request) {
        Position position = (Position) request.getData();
        return CollectionManager.removeByPosition(position);
    }
}
