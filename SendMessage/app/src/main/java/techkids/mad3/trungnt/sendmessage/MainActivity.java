package techkids.mad3.trungnt.sendmessage;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSend = (Button) this.findViewById(R.id.btnSend);
        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        typeInput(v);
    }

    //phuong thuc nhap du lieu tu EditText
    private void typeInput(View v)
    {
        int id = v.getId();
        if(id == R.id.btnSend)
        {
            String inputData;
            inputData = ((EditText) findViewById(R.id.editInput)).getText().toString();
            if (inputData.isEmpty() || inputData == null)
            {
                Context context = this;
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                // set title
                alertDialogBuilder.setTitle("WARNING ...");

                // set dialog message
                alertDialogBuilder
                        .setMessage("You need to type your data!")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
            else {
                Bundle bundle = new Bundle();
                bundle.putString("KeyData", inputData);

                Intent intentData = new Intent(MainActivity.this, DisplayActivity.class);
                intentData.putExtras(bundle);

                startActivity(intentData);
            }
        }
    }
}
