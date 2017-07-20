package example.com.mycontact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailContact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_contact);
        TextView nameText = (TextView) findViewById(R.id.name);
        TextView codeText = (TextView) findViewById(R.id.code);

        Intent recvIntent = getIntent();
        Bundle extras = recvIntent.getExtras();
        String name = extras.getString("name", "UNKNOWN");
        String code = extras.getString("code", "UNKNOWN");

        nameText.setText(name);
        codeText.setText(code);
    }
}
