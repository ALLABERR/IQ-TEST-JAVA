package com.allaber.iq.screens.common;

import android.view.View;

public interface BaseView extends View.OnClickListener {
    void initiationViewElements(View view);
    void setOnClickListener();
}
