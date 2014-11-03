package homework4.paulreitz.com.myapplication;

/**
 * Created by Paul on 11/2/2014.
 */

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;


public class MyAlertDialog extends DialogFragment
{
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        DialogInterface.OnClickListener positiveClick = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity().getBaseContext(), "Adding Book", Toast.LENGTH_SHORT).show();
                /*getActivity().finish(); */       }   };


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Page not available yet");
        builder.setPositiveButton("Return", positiveClick);
        builder.setTitle("I'm Sorry!");
        Dialog dialog = builder.create();
        return dialog;  }
}


