package com.stosh.fsm;

import android.widget.Button;
import android.widget.CheckBox;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import static org.assertj.core.api.Java6Assertions.assertThat;


/**
 * Created by StoSh on 06-May-17.
 */

@RunWith(RobolectricTestRunner.class)
@Config(manifest = "app/src/main/AndroidManifest.xml")
public class WelcomeActivityTest {

    @Test
    public void clickingButton_shouldChangeResultsViewText() throws Exception {
        Main activity = Robolectric.setupActivity(Main.class);

        Button button = (Button) activity.findViewById(R.id.btnLockX2);
        CheckBox statusAlarm = (CheckBox) activity.findViewById(R.id.statusAlarm);

        button.performClick();
        assertThat(statusAlarm.isChecked());
    }
}
