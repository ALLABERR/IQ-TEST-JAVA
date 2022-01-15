package com.allaber.iq.screens.age;

import static com.allaber.iq.utils.Utils.isBlankString;

import com.allaber.iq.utils.PreferenceManager;
import com.allaber.iq.utils.common.BasePresenter;

public class AgePresenter extends BasePresenter {

    private AgeView view;
    private PreferenceManager preferenceManager;

    public AgePresenter(AgeFragment view) {
        this.view = view;
        preferenceManager = new PreferenceManager(view.getContext());
    }

    public boolean checkAge(String text) {
        if (isBlankString(text)) return false;
        Integer age = Integer.parseInt(text);
        return age > 0;
    }

    public void saveUserAge() {
        int age = view.getUserAge();
        preferenceManager.saveUserAge(age);
    }


}
