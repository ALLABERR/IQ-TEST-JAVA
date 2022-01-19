package com.allaber.iq.screens.result.result;

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
import com.allaber.iq.screens.result.questions.QuestionsFragment;

public class ResultFragment extends Fragment implements ResultView {

    private ResultPresenter resultPresenter;

    private ImageView imgHome;
    private Button btnResults;
    private Button btnShare;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        resultPresenter = new ResultPresenter(this);
        initiationViewElements(view);
        setOnClickListener();
        return view;
    }

    @Override
    public void initiationViewElements(View view) {
        imgHome = view.findViewById(R.id.imgHome);
        btnResults = view.findViewById(R.id.btnResults);
        btnShare = view.findViewById(R.id.btnShare);
    }

    @Override
    public void setOnClickListener() {
        imgHome.setOnClickListener(this);
        btnResults.setOnClickListener(this);
        btnShare.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgHome:
                resultPresenter.showMainMenuDialog();
                break;
            case R.id.btnResults:
                resultPresenter.setFragment(getContext(), QuestionsFragment.newInstance());
                break;
            case R.id.btnShare:
                resultPresenter.shareResult(getActivity());
                break;
        }
    }

    public static ResultFragment newInstance() {
        return new ResultFragment();
    }
}
