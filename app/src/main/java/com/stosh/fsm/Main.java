package com.stosh.fsm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;

public class Main extends AppCompatActivity implements View.OnClickListener {

    private boolean alarmArmed, allUnlocked, allLocked, driverUnlocked;

    @BindView(R.id.statusAlarm)
    CheckBox checkBoxAlarmArmed;
    @BindView(R.id.statusDoor)
    TextView doorStatus;
    @BindView(R.id.allLocked)
    LinearLayout linearLayoutAllLocked;
    @BindView(R.id.allUnlocked)
    LinearLayout linearLayoutAllUnlocked;
    @BindView(R.id.driverUnlocked)
    LinearLayout linearLayoutDriverUnlocked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayoutAllLocked.setSelected(true);

        alarmArmed = checkBoxAlarmArmed.isChecked();
        allUnlocked = linearLayoutAllUnlocked.isSelected();
        allLocked = linearLayoutAllLocked.isSelected();
        driverUnlocked = linearLayoutDriverUnlocked.isSelected();

    }

    @OnClick({R.id.btnLock, R.id.btnUnlock, R.id.btnLockX2, R.id.btnUnlockX2})
    public void OnButtonClick(Button button) {
        switch (button.getId()) {
            case R.id.btnLock:
                if (!alarmArmed && allUnlocked) {
                    allUnlocked(false);
                    allLocked(true);
                }
                if (!alarmArmed && driverUnlocked) {
                    driverUnlocked(false);
                    allLocked(true);
                }
                break;
            case R.id.btnUnlock:
                if (!alarmArmed && allUnlocked) break;
                if (!alarmArmed && driverUnlocked) break;
                if (!alarmArmed && allLocked) {
                    allLocked(false);
                    driverUnlocked(true);
                }
                if (alarmArmed && allLocked) {
                    alarmArmed(false);
                    allLocked(false);
                    driverUnlocked(true);
                }
                break;
            case R.id.btnLockX2:
                if (!alarmArmed && allUnlocked) {
                    alarmArmed(true);
                    allUnlocked(false);
                    allLocked(true);
                }
                if (!alarmArmed && driverUnlocked) {
                    alarmArmed(true);
                    driverUnlocked(false);
                    allLocked(true);
                }
                if (!alarmArmed && allLocked) {
                    alarmArmed(true);
                }
                if (alarmArmed && allLocked) {
                    break;
                }
                break;
            case R.id.btnUnlockX2:
                if (!alarmArmed && allUnlocked) {
                    break;
                }
                if (!alarmArmed && driverUnlocked) {
                    break;
                }
                if (!alarmArmed && allLocked) {
                    allLocked(false);
                    allUnlocked(true);
                }
                if (alarmArmed && allLocked) {
                    alarmArmed(false);
                    allLocked(false);
                    allUnlocked(true);
                }
                break;
        }
    }

    @Override
    public void onClick(View v) {


    }

    private void alarmArmed(boolean value) {
        checkBoxAlarmArmed.setChecked(value);
        alarmArmed = value;
    }

    private void allLocked(boolean value) {
        linearLayoutAllLocked.setSelected(value);
        doorStatus.setText("All Locked");
        allLocked = value;
    }

    private void allUnlocked(boolean value) {
        linearLayoutAllUnlocked.setSelected(value);
        doorStatus.setText("All Unlocked");
        allUnlocked = value;
    }

    private void driverUnlocked(boolean value) {
        linearLayoutDriverUnlocked.setSelected(value);
        doorStatus.setText("Driver Unlocked");
        driverUnlocked = value;
    }
}
