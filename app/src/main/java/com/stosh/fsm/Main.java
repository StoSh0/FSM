package com.stosh.fsm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.stosh.fsm.states.AlarmDisarmed_AllLocked;

import java.util.HashMap;

/**
 * Created by StoSh on 06-May-17.
 **/

public class Main extends AppCompatActivity implements View.OnClickListener {

    private FSM fsm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListenerForButton();
        HashMap<Integer, View> resources = new HashMap<>();
        resources.put(0, findViewById(R.id.statusAlarm));
        resources.put(1, findViewById(R.id.statusDoor));
        resources.put(2, findViewById(R.id.status));
        fsm = new FSM(new AlarmDisarmed_AllLocked(resources));
    }

    private void setListenerForButton(){
        findViewById(R.id.btnUnlock).setOnClickListener(this);
        findViewById(R.id.btnUnlockX2).setOnClickListener(this);
        findViewById(R.id.btnLock).setOnClickListener(this);
        findViewById(R.id.btnLockX2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLock:
                fsm.getState().onLock(fsm);
                break;
            case R.id.btnUnlock:
                fsm.getState().onUnlock(fsm);
                break;
            case R.id.btnLockX2:
                fsm.getState().onLockX2(fsm);
                break;
            case R.id.btnUnlockX2:
                fsm.getState().onUnlockX2(fsm);
                break;
        }
    }
}
