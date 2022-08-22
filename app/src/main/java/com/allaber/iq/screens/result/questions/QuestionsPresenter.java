package com.allaber.iq.screens.result.questions;

import android.content.Context;

import com.allaber.iq.database.QuestionDAO;
import com.allaber.iq.database.model.Question;
import com.allaber.iq.screens.common.BasePresenter;

import java.util.ArrayList;

public class QuestionsPresenter extends BasePresenter {

    private QuestionsView view;
    private QuestionDAO questionDAO;

    public QuestionsPresenter(QuestionsFragment view, Context context) {
        this.view = view;
        questionDAO = new QuestionDAO(context);
    }

    public ArrayList<Question> getAllQuestion(){
        return questionDAO.getAllQuestion();
    }
}
