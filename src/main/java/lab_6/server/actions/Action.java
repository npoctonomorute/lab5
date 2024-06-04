package lab_6.server.actions;

import lab_6.common.network.Request;

public interface Action<T> {
    T execute(Request request);
}
