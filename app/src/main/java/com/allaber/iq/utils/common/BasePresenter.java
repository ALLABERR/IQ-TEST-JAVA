package com.allaber.iq.utils.common;

import android.content.Context;

import androidx.fragment.app.Fragment;

import com.allaber.iq.navigator.NavigatorView;

public class BasePresenter {

    private NavigatorView navigatorView;

    public void showExitDialog() {

    }

    public void showRateAppDialog() {

    }

    public void showMainMenuDialog() {

    }

    public void setFragment(Context context, Fragment fragment) {
        if (context instanceof NavigatorView) {
            navigatorView = (NavigatorView) context;
            navigatorView.setFragment(fragment);
        }
    }

}
