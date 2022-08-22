package com.allaber.iq.screens.result.result;

import android.content.Context;

import com.allaber.iq.database.model.Question;
import com.allaber.iq.utils.PreferenceManager;

import java.util.ArrayList;

public class ResultCalculator {
    private final Context context;

    public ResultCalculator(Context context) {
        this.context = context;
    }

    public int getResultScore(ArrayList<Question> questions) {
        double score = 0;

        for (Question question : questions) {
            score = score + getScoreOnQuestion(question);
        }

        double iq = (score * getUserAgeCoefficient()) / 100;
        return Math.toIntExact(Math.round(iq));
    }


    private double getScoreOnQuestion(Question question){
        int correct = question.getCorrect();
        int selectedAnswer = question.getSelectedAnswer();
        if(correct != selectedAnswer) return 0;

        String questionGroup = question.getQuestionGroup();
        switch (questionGroup) {
            case "A" : return 1.5;
            case "B" : return 1.9;
            case "C" : return 2.3;
            case "D" : return 2.8;
            case "E" : return 3.2;
            default: return 1;
        }
    }

    private int getUserAgeCoefficient(){
        PreferenceManager preferenceManager = new PreferenceManager(context);
        int userAge = preferenceManager.getUserAge();
        if(userAge >= 0 && userAge <= 30) return 100;

        if(userAge >= 31 && userAge <= 35) return 97;

        if(userAge >= 36 && userAge <= 40) return 93;

        if(userAge >= 41 && userAge <= 45) return 88;

        if(userAge >= 46 && userAge <= 50) return 82;

        if(userAge >= 51 && userAge <= 55) return 76;

        if(userAge > 56) return 70;

        return 100;
    }

    public String getResultText(int score) {
        if(score >= 0 && score <= 20) return "Тяжёлая степень слабоумия";

        if(score >= 21 && score <= 50) return "Средняя степень слабоумия";

        if(score >= 51 && score <= 70) return "Лёгкая степень слабоумия";

        if(score >= 71 && score <= 80) return "Низкий уровень интеллекта";

        if(score >= 81 && score <= 90) return "Интеллект ниже среднего";

        if(score >= 91 && score <= 110) return "Средний уровень интеллекта ";

        if(score >= 111 && score <= 120) return "Интеллект выше среднего ";

        if(score >= 121 && score <= 140) return "Высокий уровень интеллекта";

        if(score > 140) return "Незаурядный, выдающийся интеллект";

        return "Error";
    }


}













