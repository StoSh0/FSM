package com.wilshanetskyi.myapplication;

import java.util.Map;

/**
 * Created by TarikW on 5/6/2017.
 */

public class FSM {
	
	private final Map<Integer, State> uStates;
	
	public FSM(Map<Integer, State> states) {
		uStates = states;
	}
	
	public void setState(int id) {
		uStates.get(id).invoke();
	}
}
