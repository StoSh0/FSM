package com.stosh.fsm;

public abstract class State {
	private final FSM fsm;
	
	public State(FSM fsm) {
		this.fsm = fsm;
	}
	
	public FSM getFsm() {
		return fsm;
	}
	
	abstract public void onLock();
	
	abstract public void onLockX2();
	
	abstract public void onUnlock();
	
	abstract public void onUnlockX2();
}
