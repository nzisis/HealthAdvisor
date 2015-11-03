package com.ngngteam.healthadvisor.Utils;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;

import com.ngngteam.healthadvisor.R;

import it.gmariotti.changelibs.library.view.ChangeLogRecyclerView;

/**
 * Created by Nick Zisis on 11/3/15.
 */
public class ChangeLogDialog extends DialogFragment {

    public ChangeLogDialog() {
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        ChangeLogRecyclerView chgList = (ChangeLogRecyclerView) layoutInflater.inflate(R.layout.change_log, null);

        return new AlertDialog.Builder(getActivity())
                .setTitle("Version")
                .setView(chgList)
                .setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                dialog.dismiss();
                            }
                        }
                )
                .create();

    }

}
