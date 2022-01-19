package com.allaber.iq.screens.result.question;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.allaber.iq.R;
import com.allaber.iq.database.model.Question;
import com.allaber.iq.screens.result.questions.QuestionsFragment;

public class QuestionFragment extends Fragment implements QuestionView {

    private QuestionPresenter questionPresenter;

    private TextView txtQuestionCount;

    private ImageView imgBtnHome;
    private ImageView imgBtnNext;
    private ImageView imgBtnPrevious;

    private ImageView imgQuestion;

    private ImageButton imgBtnAnswer1;
    private ImageButton imgBtnAnswer2;
    private ImageButton imgBtnAnswer3;
    private ImageButton imgBtnAnswer4;
    private ImageButton imgBtnAnswer5;
    private ImageButton imgBtnAnswer6;
    private ImageButton imgBtnAnswer7;
    private ImageButton imgBtnAnswer8;

    private ImageView imgAnswer1;
    private ImageView imgAnswer2;
    private ImageView imgAnswer3;
    private ImageView imgAnswer4;
    private ImageView imgAnswer5;
    private ImageView imgAnswer6;
    private ImageView imgAnswer7;
    private ImageView imgAnswer8;

    private LinearLayout linearLayoutButtons;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question, container, false);
        initiationViewElements(view);
        setOnClickListener();
        return view;
    }

    public static QuestionFragment newInstance() {
        return new QuestionFragment();
    }

    @Override
    public void initiationViewElements(View view) {
        questionPresenter = new QuestionPresenter(this, getContext());

        Bundle bundle = this.getArguments();
        int position = bundle.getInt("position", 0);

        txtQuestionCount = view.findViewById(R.id.txtQuestionCount);

        imgBtnHome = view.findViewById(R.id.imgBtnHome);
        imgBtnNext = view.findViewById(R.id.imgBtnNext);
        imgBtnPrevious = view.findViewById(R.id.imgBtnPrevious);

        imgQuestion = view.findViewById(R.id.imgQuestion);

        imgBtnAnswer1 = view.findViewById(R.id.imgBtnAnswer1);
        imgBtnAnswer2 = view.findViewById(R.id.imgBtnAnswer2);
        imgBtnAnswer3 = view.findViewById(R.id.imgBtnAnswer3);
        imgBtnAnswer4 = view.findViewById(R.id.imgBtnAnswer4);
        imgBtnAnswer5 = view.findViewById(R.id.imgBtnAnswer5);
        imgBtnAnswer6 = view.findViewById(R.id.imgBtnAnswer6);
        imgBtnAnswer7 = view.findViewById(R.id.imgBtnAnswer7);
        imgBtnAnswer8 = view.findViewById(R.id.imgBtnAnswer8);

        imgAnswer1 = view.findViewById(R.id.imgAnswer1);
        imgAnswer2 = view.findViewById(R.id.imgAnswer2);
        imgAnswer3 = view.findViewById(R.id.imgAnswer3);
        imgAnswer4 = view.findViewById(R.id.imgAnswer4);
        imgAnswer5 = view.findViewById(R.id.imgAnswer5);
        imgAnswer6 = view.findViewById(R.id.imgAnswer6);
        imgAnswer7 = view.findViewById(R.id.imgAnswer7);
        imgAnswer8 = view.findViewById(R.id.imgAnswer8);

        linearLayoutButtons = view.findViewById(R.id.linearLayoutButtons);

        questionPresenter.setQuestion(position);
    }

    @Override
    public void setOnClickListener() {
        imgBtnHome.setOnClickListener(this);
        imgBtnNext.setOnClickListener(this);
        imgBtnPrevious.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgBtnHome:
                questionPresenter.setFragment(getContext(), QuestionsFragment.newInstance());
                break;
            case R.id.imgBtnNext:
                questionPresenter.setNextQuestion();
                break;
            case R.id.imgBtnPrevious:
                questionPresenter.setPreviousQuestion();
                break;
        }
    }

    @Override
    public void setQuestion(Question question) {
        txtQuestionCount.setText(questionPresenter.getPosition() + "/" + questionPresenter.getNumberQuestions());
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

    public void setImageResource(ImageView imageView, String image) {
        Resources resources = getActivity().getResources();
        String packageName = getContext().getPackageName();
        int imageId = resources.getIdentifier(image, "drawable", packageName);
        imageView.setImageResource(imageId);
    }

    @Override
    public void setVisibilityButtons(boolean visibility) {
        if(visibility)
            linearLayoutButtons.setVisibility(View.VISIBLE);
        else
            linearLayoutButtons.setVisibility(View.GONE);
    }

    @Override
    public void toggleButtonNext(boolean enabled) {
        imgBtnNext.setEnabled(enabled);
    }

    @Override
    public void toggleButtonPrevious(boolean enabled) {
        imgBtnPrevious.setEnabled(enabled);
    }

    @Override
    public void showHints(int selected, int correct) {
        clearHints();
        setHintsDrawing(selected, "wrong_answer");
        setHintsDrawing(correct, "correct_answer");
    }

    private void clearHints() {
        setVisibleImage(imgAnswer1);
        setVisibleImage(imgAnswer2);
        setVisibleImage(imgAnswer3);
        setVisibleImage(imgAnswer4);
        setVisibleImage(imgAnswer5);
        setVisibleImage(imgAnswer6);
        setVisibleImage(imgAnswer7);
        setVisibleImage(imgAnswer8);
    }

    private void setVisibleImage(ImageView imageView) {
        imageView.setVisibility(View.GONE);
    }

    private void setHintsDrawing(int position, String imageName) {
        switch (position) {
            case 1:
                setImageAndVisibility(imgAnswer1, imageName);
                break;
            case 2:
                setImageAndVisibility(imgAnswer2, imageName);
                break;
            case 3:
                setImageAndVisibility(imgAnswer3, imageName);
                break;
            case 4:
                setImageAndVisibility(imgAnswer4, imageName);
                break;
            case 5:
                setImageAndVisibility(imgAnswer5, imageName);
                break;
            case 6:
                setImageAndVisibility(imgAnswer6, imageName);
                break;
            case 7:
                setImageAndVisibility(imgAnswer7, imageName);
                break;
            case 8:
                setImageAndVisibility(imgAnswer8, imageName);
                break;
        }
    }

    private void setImageAndVisibility(ImageView imageView, String imageName) {
        setImageResource(imageView, imageName);
        imageView.setVisibility(View.VISIBLE);
    }
}
