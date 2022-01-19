package com.allaber.iq.screens.result.question;

import android.content.Context;

import com.allaber.iq.database.QuestionDAO;
import com.allaber.iq.database.model.Question;
import com.allaber.iq.utils.common.BasePresenter;

public class QuestionPresenter extends BasePresenter {

    private QuestionView view;
    private QuestionDAO questionDAO;
    int position;

    public QuestionPresenter(QuestionFragment view, Context context) {
        this.view = view;
        questionDAO = new QuestionDAO(context);
    }

    public void setQuestion(int position) {
        this.position = position;
        Question question = questionDAO.getQuestionToPosition(position);
        setVisibilityButtons(question.numberAnswers);
        setEnableNavigationButtons(position);
        view.showHints(question.getSelectedAnswer(), question.getCorrect());
        view.setQuestion(question);
    }

    private void setVisibilityButtons(int number) {
        if (number > 6) {
            view.setVisibilityButtons(true);
        } else {
            view.setVisibilityButtons(false);
        }
    }

    private void setEnableNavigationButtons(int validatePosition) {
        if(validatePosition == getNumberQuestions()) view.toggleButtonNext(false);
        else view.toggleButtonNext(true);

        if(validatePosition == 1) view.toggleButtonPrevious(false);
        else view.toggleButtonPrevious(true);
    }

    public int getPosition() {
        return position;
    }

    public int getNumberQuestions() {
        return questionDAO.getQuestionCount();
    }

    public void setNextQuestion() {
        int positionNext = position + 1;
        if(validatePosition(positionNext)) return;
        setQuestion(positionNext);
    }

    public void setPreviousQuestion() {
        int positionPrevious = position - 1;
        if(validatePosition(positionPrevious)) return;
        setQuestion(positionPrevious);
    }

    private boolean validatePosition(int validatePosition){
        if(validatePosition == 0) return true;
        if(validatePosition == getNumberQuestions() + 1) return true;
        return false;
    }
}
