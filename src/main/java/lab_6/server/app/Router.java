package lab_6.server.app;

import lab_6.common.network.ActionAlias;
import lab_6.common.network.Request;
import lab_6.common.network.Response;
import lab_6.server.actions.*;

import java.io.Serializable;
import java.util.Map;

public class Router {
    private final Map<ActionAlias, Action<?>> routeList = Map.ofEntries(
            Map.entry(ActionAlias.SHOW, new ShowAction()),
            Map.entry(ActionAlias.ADD, new CreateAction()),
            Map.entry(ActionAlias.UPDATE, new UpdateAction()),
            Map.entry(ActionAlias.REMOVE, new DeleteAction()),
            Map.entry(ActionAlias.REMOVE_LOWER, new RemoveLowerAction()),
            Map.entry(ActionAlias.INFO, new InfoAction()),
            Map.entry(ActionAlias.REMOVE_GREATER, new RemoveGreaterAction()),
            Map.entry(ActionAlias.FILTER_BY_PERSON, new FilterByPersonAction()),
            Map.entry(ActionAlias.CLEAR, new ClearAction()),
            Map.entry(ActionAlias.LOGIN, new LoginAction()),
            Map.entry(ActionAlias.REGISTER, new RegisterAction())
    );

    public Response resolve(Request request) {
        ActionAlias alias = request.getActionAlias();
        if (routeList.containsKey(alias)) {
            Action<?> action = routeList.get(alias);
            Serializable result = (Serializable) action.execute(request);
            return new Response(result);
        } else {
            throw new RuntimeException("Команда не реализована - " + alias.name());
        }
    }

    public Map<ActionAlias, Action<?>> getRouteList() {
        return routeList;
    }
}
