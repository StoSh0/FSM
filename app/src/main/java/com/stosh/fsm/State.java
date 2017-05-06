package com.wilshanetskyi.myapplication;

import android.view.View;

/**
 * Created by TarikW on 5/6/2017.
 */

public abstract class State {
	
	private final View uRoot;
	
	public State(View view) {
		uRoot = view;
	}
	
	protected final View getView() {
		return uRoot;
	}
	
	abstract public void invoke();
	
}
