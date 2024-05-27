package lab_6.common.network;

import java.io.Serializable;

public class Response implements Serializable {
    private Serializable data;

    public Response(Serializable data) {
        this.data = data;
    }

    public Serializable getData() {
        return data;
    }

    public void setData(Serializable data) {
        this.data = data;
    }
}
