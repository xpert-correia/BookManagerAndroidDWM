package pt.ipca.androidbookdwm.dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import pt.ipca.androidbookdwm.interfaces.DialogsResult;

public class Dialogs {

    public static void showAlertDialog(Context context, AlertConfig alertConfig, final DialogsResult dialogsResult)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(alertConfig.getTitle());
        alertDialog.setMessage(alertConfig.getMessage());
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, alertConfig.getOk(), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                if(dialogsResult != null){
                    dialogsResult.onResult(true);
                }
            }
        });
        alertDialog.show();
    }

    public static void showConfirmDialog(Context context, ConfirmConfig confirmConfig, final DialogsResult dialogsResult)
    {
        AlertDialog confirmDialog = new AlertDialog.Builder(context).create();
        confirmDialog.setTitle(confirmConfig.getTitle());
        confirmDialog.setMessage(confirmConfig.getMessage());
        confirmDialog.setButton(AlertDialog.BUTTON_POSITIVE, confirmConfig.getOk(), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                if(dialogsResult != null){
                    dialogsResult.onResult(true);
                }
            }
        });
        confirmDialog.setButton(AlertDialog.BUTTON_NEGATIVE, confirmConfig.getCancel(), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                if(dialogsResult != null){
                    dialogsResult.onResult(false);
                }
            }
        });
        confirmDialog.show();
    }
}
