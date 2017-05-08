package com.stosh.fsm.states;


import com.stosh.fsm.FSM;
import com.stosh.fsm.R;
import com.stosh.fsm.State;

/**
 * Created by StoSh on 06-May-17.
 **/

public class AlarmArmed_AllLocked extends State {
	
	
	public AlarmArmed_AllLocked(FSM fsm) {
		super(fsm);
		fsm.getStatusAlarm().setChecked(true);
		fsm.getStatus().setBackgroundResource(R.drawable.all_locked);
		fsm.getStatusDoor().setText(R.string.all_locked);
	}
	
	@Override
	public void onLock() {
	}
	
	@Override
	public void onLockX2() {
	}
	
	@Override
	public void onUnlock() {
		getFsm().setState(new AlarmDisarmed_DriverUnlocked(getFsm()));
	}
	
	@Override
	public void onUnlockX2() {
		getFsm().setState(new AlarmDisarmed_AllUnlocked(getFsm()));
	}
}
