package com.allaber.iq.screens.test;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.allaber.iq.R;
import com.allaber.iq.database.model.Question;
import com.allaber.iq.screens.result.result.ResultFragment;

public class TestFragment extends Fragment implements TestView {

    private TestPresenter testPresenter;

    private ImageView imgHome;

    private ImageView imgTimer;
    private ImageView imgQuestion;

    private TextView txtTimer;
    private TextView txtQuestionCount;

    private ScrollView scrollViewTest;
    private LinearLayout linearLayoutTimeIsOver;
    private LinearLayout linearLayoutButtons;

    private ImageButton imgBtnAnswer1;
    private ImageButton imgBtnAnswer2;
    private ImageButton imgBtnAnswer3;
    private ImageButton imgBtnAnswer4;
    private ImageButton imgBtnAnswer5;
    private ImageButton imgBtnAnswer6;
    private ImageButton imgBtnAnswer7;
    private ImageButton imgBtnAnswer8;
    private Button buttonNext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        initiationViewElements(view);
        setOnClickListener();
        testPresenter.startTimer(getActivity());
        testPresenter.setQuestion();
        return view;
    }

    @Override
    public void initiationViewElements(View view) {
        testPresenter = new TestPresenter(this);
        imgHome = view.findViewById(R.id.imgHome);
        imgTimer = view.findViewById(R.id.imgTimer);
        scrollViewTest = view.findViewById(R.id.scrollViewTest);
        linearLayoutTimeIsOver = view.findViewById(R.id.linearLayoutTimeIsOver);
        linearLayoutButtons = view.findViewById(R.id.linearLayoutButtons);
        imgQuestion = view.findViewById(R.id.imgQuestion);
        txtTimer = view.findViewById(R.id.txtTimer);
        txtQuestionCount = view.findViewById(R.id.txtQuestionCount);
        imgBtnAnswer1 = view.findViewById(R.id.imgBtnAnswer1);
        imgBtnAnswer2 = view.findViewById(R.id.imgBtnAnswer2);
        imgBtnAnswer3 = view.findViewById(R.id.imgBtnAnswer3);
        imgBtnAnswer4 = view.findViewById(R.id.imgBtnAnswer4);
        imgBtnAnswer5 = view.findViewById(R.id.imgBtnAnswer5);
        imgBtnAnswer6 = view.findViewById(R.id.imgBtnAnswer6);
        imgBtnAnswer7 = view.findViewById(R.id.imgBtnAnswer7);
        imgBtnAnswer8 = view.findViewById(R.id.imgBtnAnswer8);
        buttonNext = view.findViewById(R.id.buttonNext);
    }

    @Override
    public void setOnClickListener() {
        imgHome.setOnClickListener(this);
        imgBtnAnswer1.setOnClickListener(this);
        imgBtnAnswer2.setOnClickListener(this);
        imgBtnAnswer3.setOnClickListener(this);
        imgBtnAnswer4.setOnClickListener(this);
        imgBtnAnswer5.setOnClickListener(this);
        imgBtnAnswer6.setOnClickListener(this);
        imgBtnAnswer7.setOnClickListener(this);
        imgBtnAnswer8.setOnClickListener(this);
        buttonNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgHome:
                testPresenter.showMainMenuDialog();
                break;
            case R.id.imgBtnAnswer1:
                testPresenter.selectedButton(imgBtnAnswer1, 1);
                break;
            case R.id.imgBtnAnswer2:
                testPresenter.selectedButton(imgBtnAnswer2, 2);
                break;
            case R.id.imgBtnAnswer3:
                testPresenter.selectedButton(imgBtnAnswer3, 3);
                break;
            case R.id.imgBtnAnswer4:
                testPresenter.selectedButton(imgBtnAnswer4, 4);
                break;
            case R.id.imgBtnAnswer5:
                testPresenter.selectedButton(imgBtnAnswer5, 5);
                break;
            case R.id.imgBtnAnswer6:
                testPresenter.selectedButton(imgBtnAnswer6, 6);
                break;
            case R.id.imgBtnAnswer7:
                testPresenter.selectedButton(imgBtnAnswer7, 7);
                break;
            case R.id.imgBtnAnswer8:
                testPresenter.selectedButton(imgBtnAnswer8, 8);
                break;
            case R.id.buttonNext:
                testPresenter.setQuestion(buttonNext, getContext());
                break;
        }

    }

    public static TestFragment newInstance() {
        return new TestFragment();
    }

    @Override
    public Integer getTimerText() {
        return Integer.parseInt(txtTimer.getText().toString());
    }

    @Override
    public void changeTimerColor() {
        imgTimer.setImageDrawable(getResources().getDrawable(R.drawable.ic_timer_low));
        txtTimer.setTextColor(getResources().getColor(R.color.color_timer_low));
    }

    @Override
    public void setTimerText(Integer time) {
        txtTimer.setText(String.valueOf(time));
    }

    @Override
    public void finishTestByTime() {
        testPresenter.timerCancel();
        scrollViewTest.setVisibility(View.GONE);
        linearLayoutTimeIsOver.setVisibility(View.VISIBLE);
        buttonNext.setEnabled(true);
        buttonNext.setText(getActivity().getResources().getString(R.string.string_start_over));
    }

    @Override
    public void finishTest() {
        testPresenter.timerCancel();
        testPresenter.setFragment(getContext(), ResultFragment.newInstance());
    }

    @Override
    public void setVisibilityButtons(boolean visibility) {
        if (visibility) {
            linearLayoutButtons.setVisibility(View.VISIBLE);
        } else {
            linearLayoutButtons.setVisibility(View.GONE);
        }
    }

    @Override
    public void setQuestion(Question question) {
        setImageResource(imgQuestion, (question.getQuestion()));
        setImageResource(imgBtnAnswer1, (question.getAnswers1()));
        setImageResource(imgBtnAnswer2, (question.getAnswers2()));
        setImageResource(imgBtnAnswer3, (question.getAnswers3()));
        setImageResource(imgBtnAnswer4, (question.getAnswers4()));
        setImageResource(imgBtnAnswer5, (question.getAnswers5()));
        setImageResource(imgBtnAnswer6, (question.getAnswers6()));
        setImageResource(imgBtnAnswer7, (question.getAnswers7()));
        setImageResource(imgBtnAnswer8, (question.getAnswers8()));
    }

    @Override
    public void setImageResource(ImageView imageView, String imageName) {
        Resources resources = getActivity().getResources();
        String packageName = getActivity().getPackageName();
        int drawable = resources.getIdentifier(imageName, "drawable", packageName);
        imageView.setImageResource(drawable);
    }

    @Override
    public void setQuestionCount(int position, int number) {
        txtQuestionCount.setText(position + "/" + number);
    }

    @Override
    public void resetButtonsState() {
        imgBtnAnswer1.setEnabled(true);
        imgBtnAnswer2.setEnabled(true);
        imgBtnAnswer3.setEnabled(true);
        imgBtnAnswer4.setEnabled(true);
        imgBtnAnswer5.setEnabled(true);
        imgBtnAnswer6.setEnabled(true);
        imgBtnAnswer7.setEnabled(true);
        imgBtnAnswer8.setEnabled(true);
    }

    @Override
    public void setButtonState(ImageButton imageButton) {
        imageButton.setEnabled(false);
    }

    @Override
    public void setEnabledButtonNext(boolean enabled) {
        if (enabled) buttonNext.setEnabled(true);
        else buttonNext.setEnabled(false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        testPresenter.timerCancel();
    }
}
