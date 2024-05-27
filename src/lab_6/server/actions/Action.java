package lab_6.server.actions;

import lab_6.common.network.Request;

import java.io.Serializable;

public interface Action<T extends Serializable> {
    T execute(Request request);
}
