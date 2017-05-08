package com.stosh.fsm;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by StoSh on 06-May-17.
 **/

public class FSM {
	
	private State state;
	private final CheckBox statusAlarm;
	private final TextView statusDoor;
	private final LinearLayout status;
	
	
	FSM(HashMap<Integer, View> resources) {
		this.statusAlarm = (CheckBox) resources.get(0);
		this.statusDoor = (TextView) resources.get(1);
		this.status = (LinearLayout) resources.get(2);
	}
	
	
	public CheckBox getStatusAlarm() {
		return statusAlarm;
	}
	
	public TextView getStatusDoor() {
		return statusDoor;
	}
	
	public LinearLayout getStatus() {
		return status;
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	State getState() {
		return state;
	}
}
