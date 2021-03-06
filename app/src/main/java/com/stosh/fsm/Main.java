package com.stosh.fsm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.stosh.fsm.states.AlarmDisarmed_AllLocked;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by StoSh on 06-May-17.
 **/

public class Main extends AppCompatActivity {
	
	private Unbinder unbinder;
	public FSM fsm;
	public HashMap<Integer, View> resources = new HashMap<>();
	@BindView(R.id.statusAlarm)
	CheckBox statusAlarm;
	@BindView(R.id.statusDoor)
	TextView statusDoor;
	@BindView(R.id.status)
	LinearLayout status;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		unbinder = ButterKnife.bind(this);
		resources.put(0, statusAlarm);
		resources.put(1, statusDoor);
		resources.put(2, status);
		
		fsm = new FSM(resources);
		fsm.setState(new AlarmDisarmed_AllLocked(fsm));
	}
	
	@OnClick({R.id.btnLock, R.id.btnUnlock, R.id.btnLockX2, R.id.btnUnlockX2})
	public void onButtonClick(View view) {
		switch (view.getId()) {
			case R.id.btnLock:
				fsm.getState().onLock();
				break;
			case R.id.btnUnlock:
				fsm.getState().onUnlock();
				break;
			case R.id.btnLockX2:
				fsm.getState().onLockX2();
				break;
			case R.id.btnUnlockX2:
				fsm.getState().onUnlockX2();
				break;
		}
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		unbinder.unbind();
	}
}

