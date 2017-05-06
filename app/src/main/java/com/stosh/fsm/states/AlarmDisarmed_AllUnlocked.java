package com.stosh.fsm.states;

import android.view.View;
import android.widget.CheckBox;

import com.stosh.fsm.State;

/**
 * Created by TarikW on 5/6/2017.
 */

public class AlarmDisarmed_AllUnlock extends State {
	
	public AlarmDisarmed_AllUnlock(View view) {
		super(view);
	}

	@Override
	public void onLock() {

	}

	@Override
	public void onLockX2() {

	}

	@Override
	public void onUnlock() {

	}

	@Override
	public void onUnlockX2() {

	}

	@Override
	public void invoke() {
		((CheckBox) getView().findViewById(2)).setChecked(true);
	}
}
