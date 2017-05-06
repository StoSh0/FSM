package com.stosh.fsm.states;
import android.view.View;


import com.stosh.fsm.FSM;
import com.stosh.fsm.R;
import com.stosh.fsm.State;

import java.util.HashMap;

/**
 Created by StoSh on 06-May-17.
 **/

public class AlarmDisarmed_AllLocked extends State {

    public AlarmDisarmed_AllLocked(HashMap<Integer, View> resources) {
        super(resources);
    }

    @Override
    public void onLock(FSM fsm) {
    }

    @Override
    public void onLockX2(FSM fsm) {
        getStatusAlarm().setChecked(true);
        fsm.setState(new AlarmArmed_AllLocked(getResources()));
    }

    @Override
    public void onUnlock(FSM fsm) {
        getStatus().setBackgroundResource(R.drawable.driver_unlocked);
        getStatusDoor().setText(R.string.driver_unlocked);
        fsm.setState(new AlarmDisarmed_DriverUnlocked(getResources()));
    }

    @Override
    public void onUnlockX2(FSM fsm) {
        getStatus().setBackgroundResource(R.drawable.all_unlocked);
        getStatusDoor().setText(R.string.all_unlocked);
        fsm.setState(new AlarmDisarmed_AllUnlocked(getResources()));
    }
}
