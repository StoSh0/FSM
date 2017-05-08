package com.stosh.fsm.states;


import com.stosh.fsm.FSM;
import com.stosh.fsm.R;
import com.stosh.fsm.State;

/**
 * Created by StoSh on 06-May-17.
 **/

public class AlarmDisarmed_AllUnlocked extends State {
	
	
	public AlarmDisarmed_AllUnlocked(FSM fsm) {
		super(fsm);
		fsm.getStatusAlarm().setChecked(false);
		fsm.getStatus().setBackgroundResource(R.drawable.all_unlocked);
		fsm.getStatusDoor().setText(R.string.all_unlocked);
	}
	
	@Override
	public void onLock() {
		getFsm().setState(new AlarmDisarmed_AllLocked(getFsm()));
	}
	
	@Override
	public void onLockX2() {
		getFsm().setState(new AlarmArmed_AllLocked(getFsm()));
	}
	
	@Override
	public void onUnlock() {
	}
	
	@Override
	public void onUnlockX2() {
	}
	
	
}
