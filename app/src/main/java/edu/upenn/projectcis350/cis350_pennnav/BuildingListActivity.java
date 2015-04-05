package edu.upenn.projectcis350.cis350_pennnav;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Brian on 3/21/2015.
 */
public class BuildingListActivity extends Activity {
    String[] buildings = {"Towne", "Moore", "Levine", "Skirkanich"};
    ArrayList<String> BuildingList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building_list);

        final Context context = getApplicationContext();

        ArrayList<String> JSONList = getIntent().getStringArrayListExtra("JSONList");

        for(int i = 0; i < JSONList.size(); i++){
            String name = Reader.getAttribute(JSONList.get(i), "building");
            if(!BuildingList.contains(name)){
                BuildingList.add(name);
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, BuildingList);

        ListView listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                Intent intent = new Intent(context, BuildingActivity.class);
                                                String name = BuildingList.get(position);
                                                //Toast.makeText(context, name, Toast.LENGTH_SHORT).show();
                                                intent.putExtra("Building name", name);
                                                startActivityForResult(intent, 1);
                                            }
                                        }
        );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_building_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onBackButtonClick(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
