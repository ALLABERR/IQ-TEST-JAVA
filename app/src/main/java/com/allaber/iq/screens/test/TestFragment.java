package com.allaber.iq.screens.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.allaber.iq.R;

public class TestFragment extends Fragment implements TestView {

    private TestPresenter testPresenter;

    private ImageView imgHome;
    private ImageView imgTimer;
    private ImageView imgQuestion;
    private ImageView imgBtnAnswer1;
    private ImageView imgBtnAnswer2;
    private ImageView imgBtnAnswer3;
    private ImageView imgBtnAnswer4;
    private ImageView imgBtnAnswer5;
    private ImageView imgBtnAnswer6;
    private ImageView imgBtnAnswer7;
    private ImageView imgBtnAnswer8;
    private Button buttonNext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        initiationViewElements(view);
        setOnClickListener();
        return view;
    }

    @Override
    public void initiationViewElements(View view) {
        testPresenter = new TestPresenter(this);
        imgHome = view.findViewById(R.id.imgHome);
        imgTimer = view.findViewById(R.id.imgTimer);
        imgQuestion = view.findViewById(R.id.imgQuestion);
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
                testPresenter.setQuestion(buttonNext);
                break;
        }

    }

    public static TestFragment newInstance() {
        return new TestFragment();
    }
}
