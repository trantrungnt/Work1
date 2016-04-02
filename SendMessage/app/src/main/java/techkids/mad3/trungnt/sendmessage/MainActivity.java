package techkids.mad3.trungnt.sendmessage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        typeInput();
    }

    //phuong thuc nhap du lieu tu EditText
    private void typeInput()
    {
        //String inputData;
        //inputData = this.findViewById(R.id.editInput).toString();

        Intent intentData = new Intent(this, DisplayActivity.class);
        startActivity(intentData);
    }
}
