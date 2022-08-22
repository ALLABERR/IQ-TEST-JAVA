package com.allaber.iq.screens.test;

import android.content.Context;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.fragment.app.FragmentActivity;

import com.allaber.iq.R;
import com.allaber.iq.database.QuestionDAO;
import com.allaber.iq.database.model.Question;
import com.allaber.iq.screens.age.AgeFragment;
import com.allaber.iq.task.TestTimerTask;
import com.allaber.iq.screens.common.BasePresenter;

import java.util.Timer;

public class TestPresenter extends BasePresenter {

    private TestView view;

    private Timer timer;
    private TestTimerTask testTimerTask;
    private QuestionDAO questionDAO;

    private int questionPosition = 1;

    public TestPresenter(TestFragment view) {
        this.view = view;
        questionDAO = new QuestionDAO(view.getContext());
    }

    public void selectedButton(ImageButton imageButton, int selectedAnswer) {
        int positionInDb = questionPosition - 1;
        questionDAO.setSelectedAnswer(positionInDb, selectedAnswer);
        view.resetButtonsState();
        view.setButtonState(imageButton);
        view.setEnabledButtonNext(true);
    }

    public void setQuestion(Button buttonNext, Context context) {
        String text = buttonNext.getText().toString();
        if(text == context.getResources().getString(R.string.string_start_over)){
            setFragment(context, AgeFragment.newInstance());
        } else {
            nextQuestion();
        }
    }

    public void nextQuestion() {
        view.setEnabledButtonNext(false);
        questionPosition = questionPosition + 1;
        setQuestion();
        view.resetButtonsState();
    }

    public void startTimer(FragmentActivity fragmentActivity) {
        timer = new Timer();
        testTimerTask = new TestTimerTask(fragmentActivity, this);
        timer.schedule(testTimerTask, 60000, 1000);
    }

    public Integer getTimerText() {
        return view.getTimerText();
    }

    public void changeTimerColor() {
        view.changeTimerColor();
    }

    public void finishTestByTime() {
        view.finishTestByTime();
    }

    public void setTimerText(Integer time) {
        view.setTimerText(time);
    }

    public void timerCancel() {
        timer.cancel();
    }

    public void setQuestion() {
        Question question = questionDAO.getQuestionToPosition(questionPosition);
        if (isLastQuestion(question)) return;
        setVisibilityButtons(question.getNumberAnswers());
        view.setQuestion(question);
        setQuestionCount();
    }

    private boolean isLastQuestion(Question question) {
        if (question == null) {
            view.finishTest();
            return true;
        }
        return false;
    }

    private void setVisibilityButtons(int number) {
        if (number > 6) {
            view.setVisibilityButtons(true);
        } else {
            view.setVisibilityButtons(false);
        }
    }

    private void setQuestionCount() {
        view.setQuestionCount(questionPosition, getNumberQuestions());
    }

    public int getNumberQuestions() {
        return questionDAO.getQuestionCount();
    }
}
