package com.example.contu_francesca_quiz;

import android.app.Dialog;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDialogFragment;


public class Dialog1 extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        MainActivity mainActivity= new MainActivity();
        builder.setTitle("Hai completato il quiz!");
        builder.setMessage("Il tuo punteggio comparirà in basso");
        builder.setPositiveButton(("Ho capito") , new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {

            }
        });

        return builder.create();
    }



























}
