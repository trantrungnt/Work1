package techkids.mad3.trungnt.sendmessage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by TrungNT on 4/2/2016.
 */
public class DisplayActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intentDisplay = getIntent();
        Bundle b = intentDisplay.getExtras();
        String strTemp = b.getString("KeyData");
        TextView txtDisplay = (TextView) this.findViewById(R.id.txtDisplay);
        txtDisplay.setText(strTemp);
    }
}
