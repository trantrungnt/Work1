package techkids.mad3.trungnt.sendmessage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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
            Bundle bundle = new Bundle();
            bundle.putString("KeyData", inputData);

            Intent intentData = new Intent(this, DisplayActivity.class);
            intentData.putExtras(bundle);

            startActivity(intentData);
        }
    }
}
