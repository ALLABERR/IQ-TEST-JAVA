package com.allaber.iq.utils.common;

import android.view.View;

public interface BaseView extends View.OnClickListener {
    void initiationViewElements(View view);
    void setOnClickListener();
}
