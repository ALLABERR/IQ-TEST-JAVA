package com.allaber.iq.screens.result.question;

import com.allaber.iq.database.model.Question;
import com.allaber.iq.screens.common.BaseView;

public interface QuestionView extends BaseView {
    void setVisibilityButtons(boolean b);

    void toggleButtonNext(boolean b);

    void toggleButtonPrevious(boolean b);

    void showHints(int selectedAnswer, int correct);

    void setQuestion(Question question);
}
