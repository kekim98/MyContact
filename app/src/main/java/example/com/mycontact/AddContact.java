package example.com.mycontact;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddContact extends AppCompatActivity {

    private static final String TAG = "AddContact";
    public static final String DEMO_PREFERENCE = "DEMO_PREFERENCE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        final EditText nameInput = (EditText) findViewById(R.id.editName);
        final EditText codeInput = (EditText) findViewById(R.id.editCode);
        Button saveButton = (Button) findViewById(R.id.saveButton);

       saveButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String name = nameInput.getText().toString();
               String code = codeInput.getText().toString();

               Log.d(TAG, "name:" + name + " code:" + code);

               SharedPreferences pref = getPref(AddContact.this);
               pref.edit().putString(name, code).apply();
               finish();
           }
       });


    }

    public static SharedPreferences getPref(Context context) {
        return context.getSharedPreferences(DEMO_PREFERENCE, MODE_PRIVATE);
    }
}
