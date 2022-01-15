package com.allaber.iq.navigator;

import androidx.fragment.app.Fragment;

public interface NavigatorView {
    void setFragment(Fragment fragment);
    void setApplicationLanguage();
    void recreateActivity();
}
