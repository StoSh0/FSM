package com.stosh.fsm;

/**
 * Created by StoSh on 06-May-17.
 **/

public class FSM {

    private State state;

    FSM(State state) {
        this.state = state;
    }

    public void setState(State state) {
        this.state = state;
    }

    State getState() {
        return state;
    }
}
