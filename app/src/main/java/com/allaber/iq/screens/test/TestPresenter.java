package com.allaber.iq.screens.test;

import android.widget.Button;
import android.widget.ImageView;

import com.allaber.iq.utils.common.BasePresenter;

public class TestPresenter extends BasePresenter {

    private TestView view;

    public TestPresenter(TestFragment view) {
        this.view = view;
    }

    public void selectedButton(ImageView imageView, int selectedNumber) {
    }

    public void setQuestion(Button buttonNext) {
    }
}
