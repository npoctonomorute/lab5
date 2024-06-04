package lab_6.common.network;

import lab_6.common.Classes.User;

import java.io.Serializable;

public class Request implements Serializable {
    private Serializable data;
    private ActionAlias actionAlias;
    private User user;

    public Request(ActionAlias actionAlias) {
        this.actionAlias = actionAlias;
    }

    public Request(ActionAlias actionAlias, Serializable data) {
        this.data = data;
        this.actionAlias = actionAlias;
    }

    public Serializable getData() {
        return data;
    }

    public void setData(Serializable data) {
        this.data = data;
    }

    public ActionAlias getActionAlias() {
        return actionAlias;
    }

    public void setActionAlias(ActionAlias actionAlias) {
        this.actionAlias = actionAlias;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
