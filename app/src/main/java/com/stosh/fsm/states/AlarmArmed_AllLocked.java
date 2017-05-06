package com.stosh.fsm.states;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.stosh.fsm.FSM;
import com.stosh.fsm.R;
import com.stosh.fsm.State;

/**
 * Created by StoSh on 06-May-17.
 */

public class AlarmArmed_AllUnlocked extends State {

    public AlarmArmed_AllUnlocked(View view) {
        super(view);
    }

    @Override
    public void onLock(FSM fsm) {
        ((LinearLayout) getView().findViewById(R.id.allUnlocked)).setSelected(false);
        ((LinearLayout) getView().findViewById(R.id.allLocked)).setSelected(true);
        ((TextView) getView().findViewById(R.id.statusDoor)).setText(R.string.all_locked);

    }

    @Override
    public void onLockX2(FSM fsm) {
        ((LinearLayout) getView().findViewById(R.id.allUnlocked)).setSelected(false);
        ((LinearLayout) getView().findViewById(R.id.allLocked)).setSelected(true);
        ((TextView) getView().findViewById(R.id.statusDoor)).setText(R.string.all_locked);

    }

    @Override
    public void onUnlock(FSM fsm) {
        ((LinearLayout) getView().findViewById(R.id.allUnlocked)).setSelected(false);
        ((LinearLayout) getView().findViewById(R.id.allLocked)).setSelected(true);
        ((TextView) getView().findViewById(R.id.statusDoor)).setText(R.string.all_locked);

    }

    @Override
    public void onUnlockX2(FSM fsm) {
        ((LinearLayout) getView().findViewById(R.id.allUnlocked)).setSelected(false);
        ((LinearLayout) getView().findViewById(R.id.allLocked)).setSelected(true);
        ((TextView) getView().findViewById(R.id.statusDoor)).setText(R.string.all_locked);

    }
}
