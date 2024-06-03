package lab_6.server.app;

import lab_6.common.network.ActionAlias;
import lab_6.common.network.Request;
import lab_6.common.network.Response;
import lab_6.server.actions.*;

import java.io.Serializable;
import java.util.Map;

public class Router {
    private final Map<ActionAlias, Action<?>> routeList = Map.of(
            ActionAlias.SHOW, new ShowAction(),
            ActionAlias.ADD, new CreateAction(),
            ActionAlias.UPDATE, new UpdateAction(),
            ActionAlias.REMOVE, new DeleteAction(),
            ActionAlias.REMOVE_LOWER, new RemoveLowerAction(),
            ActionAlias.INFO, new InfoAction(),
            ActionAlias.REMOVE_GREATER, new RemoveGreaterAction(),
            ActionAlias.FILTER_BY_PERSON, new FilterByPersonAction(),
            ActionAlias.CLEAR, new ClearAction()
    );

    public Response resolve(Request request) {
        ActionAlias alias = request.getActionAlias();
        if (routeList.containsKey(alias)) {
            Action<?> action = routeList.get(alias);
            Serializable result = action.execute(request);
            return new Response(result);
        } else {
            throw new RuntimeException("Команда не реализована - " + alias.name());
        }
    }

    public Map<ActionAlias, Action<?>> getRouteList() {
        return routeList;
    }
}
