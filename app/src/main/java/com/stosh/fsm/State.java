package com.stosh.fsm;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;

public abstract class State {

    private final CheckBox statusAlarm;
    private final TextView statusDoor;
    private final LinearLayout status;
    private final HashMap<Integer, View> resources;

    public State(HashMap<Integer, View> resources) {
        this.resources = resources;
        this.statusAlarm = (CheckBox) resources.get(0);
        this.statusDoor = (TextView) resources.get(1);
        this.status = (LinearLayout) resources.get(2);
    }

    protected HashMap<Integer, View> getResources() {
        return resources;
    }

    protected CheckBox getStatusAlarm() {
        return statusAlarm;
    }

    protected TextView getStatusDoor() {
        return statusDoor;
    }

    protected LinearLayout getStatus() {
        return status;
    }

    abstract public void onLock(FSM fsm);

    abstract public void onLockX2(FSM fsm);

    abstract public void onUnlock(FSM fsm);

    abstract public void onUnlockX2(FSM fsm);
}
