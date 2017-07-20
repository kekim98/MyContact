package example.com.mycontact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView nameList = (ListView) findViewById(R.id.nameList);
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        nameList.setAdapter(listAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume occured!!!");
        refresh();
    }

    private void refresh() {
        Log.d(TAG, "refresh occured!!!");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.addmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.addButton:
                Log.d(TAG, "addButton selected!!!!");
                Intent i = new Intent(this, AddContact.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
