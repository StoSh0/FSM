package com.stosh.fsm;


import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.stosh.fsm.states.AlarmArmed_AllLocked;
import com.stosh.fsm.states.AlarmDisarmed_AllLocked;
import com.stosh.fsm.states.AlarmDisarmed_AllUnlocked;
import com.stosh.fsm.states.AlarmDisarmed_DriverUnlocked;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MyActivityTest {
	
	private Main activity;
	private Button button;
	private CheckBox statusAlarm;
	private TextView statusDoor;
	
	@Before
	public void setup() {
		activity = Robolectric.buildActivity(Main.class)
				.create().get();
		assertNotNull(activity);
		statusAlarm = (CheckBox) activity.findViewById(R.id.statusAlarm);
		statusDoor = (TextView) activity.findViewById(R.id.statusDoor);
	}
	
	
	@Test
	public void clickingUnlock_before_AlarmArmed_AllLocked() throws Exception {
		FSM fsm = mock(FSM.class);
		when(fsm.getState()).thenReturn(new AlarmArmed_AllLocked(activity.fsm));
		button = (Button) activity.findViewById(R.id.btnUnlock);
		button.performClick();
		assertEquals(statusAlarm.isChecked(), false);
		assertEquals(statusDoor.getText(), activity.getString(R.string.driver_unlocked));
	}
	
	@Test
	public void clickingUnlockX2_before_AlarmArmed_AllLocked() throws Exception {
		FSM fsm = mock(FSM.class);
		when(fsm.getState()).thenReturn(new AlarmArmed_AllLocked(activity.fsm));
		button = (Button) activity.findViewById(R.id.btnUnlockX2);
		button.performClick();
		assertEquals(statusAlarm.isChecked(), false);
		assertEquals(statusDoor.getText(), activity.getString(R.string.all_unlocked));
	}
	
	
	@Test
	public void clickingLockX2_before_AlarmDisarmed_AllLocked() throws Exception {
		FSM fsm = mock(FSM.class);
		when(fsm.getState()).thenReturn(new AlarmArmed_AllLocked(activity.fsm));
		button = (Button) activity.findViewById(R.id.btnLockX2);
		button.performClick();
		assertEquals(statusAlarm.isChecked(), true);
		assertEquals(statusDoor.getText(), activity.getString(R.string.all_locked));
	}
	
	@Test
	public void clickingUnlock_before_AlarmDisarmed_AllLocked() throws Exception {
		FSM fsm = mock(FSM.class);
		when(fsm.getState()).thenReturn(new AlarmDisarmed_DriverUnlocked(activity.fsm));
		button = (Button) activity.findViewById(R.id.btnUnlock);
		button.performClick();
		assertEquals(statusAlarm.isChecked(), false);
		assertEquals(statusDoor.getText(), activity.getString(R.string.driver_unlocked));
	}
	
	@Test
	public void clickingUnlockX2_before_AlarmDisarmed_AllLocked() throws Exception {
		FSM fsm = mock(FSM.class);
		when(fsm.getState()).thenReturn(new AlarmDisarmed_AllUnlocked(activity.fsm));
		button = (Button) activity.findViewById(R.id.btnUnlockX2);
		button.performClick();
		assertEquals(statusAlarm.isChecked(), false);
		assertEquals(statusDoor.getText(), activity.getString(R.string.all_unlocked));
	}
	
	@Test
	public void clickingLock_before_AlarmDisarmed_AllUnlocked() throws Exception {
		FSM fsm = mock(FSM.class);
		when(fsm.getState()).thenReturn(new AlarmDisarmed_AllLocked(activity.fsm));
		button = (Button) activity.findViewById(R.id.btnLock);
		button.performClick();
		assertEquals(statusAlarm.isChecked(), false);
		assertEquals(statusDoor.getText(), activity.getString(R.string.all_locked));
	}
	
	@Test
	public void clickingLockX2_before_AlarmDisarmed_AllUnlocked() throws Exception {
		FSM fsm = mock(FSM.class);
		when(fsm.getState()).thenReturn(new AlarmArmed_AllLocked(activity.fsm));
		button = (Button) activity.findViewById(R.id.btnLockX2);
		button.performClick();
		assertEquals(statusAlarm.isChecked(), true);
		assertEquals(statusDoor.getText(), activity.getString(R.string.all_locked));
	}
	
	@Test
	public void clickingLock_before_AlarmDisarmed_DriverUnlocked() throws Exception {
		FSM fsm = mock(FSM.class);
		when(fsm.getState()).thenReturn(new AlarmDisarmed_AllLocked(activity.fsm));
		button = (Button) activity.findViewById(R.id.btnLock);
		button.performClick();
		assertEquals(statusAlarm.isChecked(), false);
		assertEquals(statusDoor.getText(), activity.getString(R.string.all_locked));
	}
	
	@Test
	public void clickingLockX2_before_AlarmDisarmed_DriverUnlocked() throws Exception {
		FSM fsm = mock(FSM.class);
		when(fsm.getState()).thenReturn(new AlarmArmed_AllLocked(activity.fsm));
		button = (Button) activity.findViewById(R.id.btnLockX2);
		button.performClick();
		assertEquals(statusAlarm.isChecked(), true);
		assertEquals(statusDoor.getText(), activity.getString(R.string.all_locked));
	}
}

