package com.example.nav;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import java.util.Arrays;



    public class RegisterDialog extends AppCompatDialogFragment {
        public static String[] cowslist = new String[1];
        EditText deviceId;
        public static int buttonCount = 1;

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

            LayoutInflater inflater = getActivity().getLayoutInflater();
            View view = inflater.inflate(R.layout.layout_register_dialog, null);

            builder.setView(view)
                    .setTitle("Register device")
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            cowslist = Arrays.copyOf(cowslist, cowslist.length+1);
                            cowslist[buttonCount] = deviceId.getText().toString();
                            buttonCount ++;
                            System.out.println(cowslist.toString());
                            System.out.println(buttonCount);

                        }
                    });

            deviceId = view.findViewById(R.id.edit_username);

            return builder.create();
        }
}
