package com.allaber.iq.screens.test;

import android.widget.ImageButton;
import android.widget.ImageView;

import com.allaber.iq.database.model.Question;
import com.allaber.iq.utils.common.BaseView;

public interface TestView extends BaseView {
    Integer getTimerText();

    void changeTimerColor();

    void setTimerText(Integer time);

    void finishTestByTime();

    void finishTest();

    void setVisibilityButtons(boolean b);

    void setQuestion(Question question);

    void setImageResource(ImageView imageView, String imageName);

    void setQuestionCount(int questionPosition, int numberQuestions);

    void resetButtonsState();

    void setButtonState(ImageButton imageButton);

    void setEnabledButtonNext(boolean b);
}
