package com.allaber.iq.task;

import androidx.fragment.app.FragmentActivity;

import com.allaber.iq.screens.test.TestPresenter;

import java.util.TimerTask;

public class TestTimerTask extends TimerTask {

    FragmentActivity activity;
    TestPresenter testPresenter;

    public TestTimerTask(FragmentActivity activity, TestPresenter testPresenter) {
        this.activity = activity;
        this.testPresenter = testPresenter;
    }

    @Override
    public void run() {
        activity.runOnUiThread(() -> {

            Integer time = testPresenter.getTimerText();

            time = time - 1;
            if (time == 3) {
                testPresenter.changeTimerColor();
            }
            if (time == 0) {
                testPresenter.finishTestByTime();
            }
            testPresenter.setTimerText(time);
        });

    }
}