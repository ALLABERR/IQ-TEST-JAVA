package com.allaber.iq.screens.result.result;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;

import androidx.fragment.app.FragmentActivity;

import com.allaber.iq.R;
import com.allaber.iq.database.QuestionDAO;
import com.allaber.iq.database.model.Question;
import com.allaber.iq.screens.common.BasePresenter;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class ResultPresenter extends BasePresenter {

    private ResultCalculator resultCalculator;
    private QuestionDAO questionDAO;
    private ResultView view;

    public ResultPresenter(ResultFragment view) {
        this.resultCalculator = new ResultCalculator(view.getContext());
        questionDAO = new QuestionDAO(view.getContext());
        this.view = view;
    }

    public void displayTheResult(){
        ArrayList<Question> allQuestion = getAllQuestion();
        int resultScore = resultCalculator.getResultScore(allQuestion);
        String resultText = resultCalculator.getResultText(resultScore);
        view.setResultScore("" + resultScore);
        view.setResultText(resultText);
    }


    public ArrayList<Question> getAllQuestion(){
        return questionDAO.getAllQuestion();
    }

    public void shareResult(FragmentActivity activity) {
        Bitmap b = BitmapFactory.decodeResource(activity.getResources(), R.drawable.empty_question);
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("*/*");
        share.putExtra(Intent.EXTRA_TEXT, "Hello");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        b.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(activity.getContentResolver(), b, "Title", null);
        Uri imageUri = Uri.parse(path);
        share.putExtra(Intent.EXTRA_STREAM, imageUri);
        activity.startActivity(Intent.createChooser(share, "Select"));
    }

}
