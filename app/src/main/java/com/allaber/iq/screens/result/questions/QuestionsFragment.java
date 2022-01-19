package com.allaber.iq.screens.result.questions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.allaber.iq.R;
import com.allaber.iq.database.model.Question;
import com.allaber.iq.screens.result.result.ResultFragment;

import java.util.ArrayList;

public class QuestionsFragment extends Fragment implements QuestionsView {

    private QuestionsPresenter questionsPresenter;

    private ImageView imgHome;
    private ImageView imgBack;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_questions, container, false);
        questionsPresenter = new QuestionsPresenter(this, getContext());
        initiationViewElements(view);
        setOnClickListener();
        return view;
    }

    @Override
    public void initiationViewElements(View view) {
        imgHome = view.findViewById(R.id.imgHome);
        imgBack = view.findViewById(R.id.imgBack);
        recyclerView = view.findViewById(R.id.recyclerView);
        initRecyclerView();
    }

    private void initRecyclerView(){
        ArrayList<Question> allQuestion = questionsPresenter.getAllQuestion();
        QuestionAdapter questionAdapter = new QuestionAdapter(getActivity(), allQuestion);
        recyclerView.setAdapter(questionAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void setOnClickListener() {
        imgHome.setOnClickListener(this);
        imgBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgHome:
                questionsPresenter.showMainMenuDialog();
                break;
            case R.id.imgBack:
                questionsPresenter.setFragment(getContext(), ResultFragment.newInstance());
                break;
        }
    }

    public static QuestionsFragment newInstance() {
        return new QuestionsFragment();
    }
}
