package com.allaber.iq.screens.age;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.allaber.iq.R;
import com.allaber.iq.screens.home.HomeFragment;
import com.allaber.iq.screens.home.HomePresenter;
import com.allaber.iq.screens.home.HomeView;
import com.allaber.iq.screens.test.TestFragment;
import com.allaber.iq.screens.test.TestPresenter;
import com.allaber.iq.utils.TextValidator;

public class AgeFragment extends Fragment implements AgeView {

    private AgePresenter agePresenter;
    private EditText editText;
    private Button btnNext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_age, container, false);
        initiationViewElements(view);
        setOnClickListener();
        return view;
    }

    @Override
    public void initiationViewElements(View view) {
        agePresenter = new AgePresenter(this);
        editText = view.findViewById(R.id.edtEnterAge);
        btnNext = view.findViewById(R.id.btnNext);

        editText.addTextChangedListener(new TextValidator(editText) {
            @Override
            public void validate(TextView textView, String text) {
                view.findViewById(R.id.btnNext).setEnabled(agePresenter.checkAge(text));
            }
        });
    }

    @Override
    public void setOnClickListener() {
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnNext:
                agePresenter.saveUserAge();
                agePresenter.setFragment(getActivity(), TestFragment.newInstance());
                break;
        }
    }

    public static AgeFragment newInstance() {
        return new AgeFragment();
    }

    @Override
    public int getUserAge() {
        String text = editText.getText().toString();
        int age = Integer.parseInt(text);
        return age;
    }
}
