package com.stosh.fsm.states;

import android.view.View;

import com.stosh.fsm.FSM;
import com.stosh.fsm.R;
import com.stosh.fsm.State;

import java.util.HashMap;

/**
 * Created by StoSh on 06-May-17.
 **/

public class AlarmDisarmed_AllUnlocked extends State {

    public AlarmDisarmed_AllUnlocked(HashMap<Integer, View> resources) {
        super(resources);
    }

    @Override
    public void onLock(FSM fsm) {
        getStatus().setBackgroundResource(R.drawable.all_locked);
        getStatusDoor().setText(R.string.all_locked);
        fsm.setState(new AlarmDisarmed_AllLocked(getResources()));
    }

    @Override
    public void onLockX2(FSM fsm) {
        getStatusAlarm().setChecked(true);
        getStatus().setBackgroundResource(R.drawable.all_locked);
        getStatusDoor().setText(R.string.all_locked);
        fsm.setState(new AlarmArmed_AllLocked(getResources()));
    }

    @Override
    public void onUnlock(FSM fsm) {
    }

    @Override
    public void onUnlockX2(FSM fsm) {
    }


}
