package example.com.mycontact;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ArrayAdapter<String> mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView nameList = (ListView) findViewById(R.id.nameList);
        mListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        nameList.setAdapter(mListAdapter);
        nameList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = (String) adapterView.getAdapter().getItem(i);
                SharedPreferences pref = AddContact.getPref(MainActivity.this);
                String code = pref.getString(name,"UNKNOWN");

                Log.d(TAG, "list item:" + name);
                Log.d(TAG, "code:" + code);

                Intent intent = new Intent(MainActivity.this, DetailContact.class);
                intent.putExtra("name", name);
                intent.putExtra("code", code);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume occured!!!");
        refresh();
    }

    private void refresh() {
        Log.d(TAG, "refresh occured!!!");
        SharedPreferences pref = AddContact.getPref(this);

        mListAdapter.clear();
        Map<String, ?> values = pref.getAll();
        for(String key : values.keySet()){
            Log.d(TAG, "shared key:" + key);
            mListAdapter.add(key);
        }
        mListAdapter.notifyDataSetChanged();
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
