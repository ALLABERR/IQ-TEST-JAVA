package com.allaber.iq.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import androidx.fragment.app.DialogFragment;

import com.allaber.iq.R;

public class MainMenuDialog extends DialogFragment implements View.OnClickListener {

    @Override
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        window.setBackgroundDrawableResource(android.R.color.transparent);
    }

//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        LayoutInflater inflater = getActivity().getLayoutInflater();
//        View view = inflater.inflate(R.layout.dialog_main_menu, null);
//        initiationViewElements(view);
//        builder.setView(view);
//        return builder.create();
//    }
//
//    private void initiationViewElements(View view) {
//        view.findViewById(R.id.textViewCancel).setOnClickListener(this);
//        view.findViewById(R.id.textViewAdd).setOnClickListener(this);
//        textInputEditText = view.findViewById(R.id.textInputEditText);
//    }


    @Override
    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.textViewCancel:
//                getDialog().dismiss();
//                break;
//            case R.id.textViewAdd:
//                setQrCode();
//                break;
//        };
    }
}
