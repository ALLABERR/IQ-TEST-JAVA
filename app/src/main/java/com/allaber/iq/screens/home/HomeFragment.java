package com.allaber.iq.screens.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.allaber.iq.R;
import com.allaber.iq.screens.age.AgeFragment;

public class HomeFragment extends Fragment implements HomeView{

    private HomePresenter homePresenter;

    private Button btnExit;
    private TextView txtStartTest;
    private TextView txtRateApp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initiationViewElements(view);
        setOnClickListener();
        return view;
    }

    @Override
    public void initiationViewElements(View view) {
        homePresenter = new HomePresenter(this);
        btnExit = view.findViewById(R.id.btnExit);
        txtStartTest = view.findViewById(R.id.txtStartTest);
        txtRateApp = view.findViewById(R.id.txtRateApp);
    }

    @Override
    public void setOnClickListener() {
        btnExit.setOnClickListener(this);
        txtStartTest.setOnClickListener(this);
        txtRateApp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnExit:
                homePresenter.showExitDialog();
                break;
            case R.id.txtStartTest:
                homePresenter.setFragment(getActivity(), AgeFragment.newInstance());
                break;
            case R.id.txtRateApp:
                homePresenter.showRateAppDialog();
                break;
        }
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }
}
