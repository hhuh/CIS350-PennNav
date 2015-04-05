package edu.upenn.projectcis350.cis350_pennnav;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class BuildingActivity extends ActionBarActivity {
    String buildingName;
    String description = "Altered in 1926 by Paul Cret, this building housed the first working multi-purpose Electronic Numerical Integrator And Computer (ENIAC) that was the first modern computer.";
    String[] facilities = {"classroom", "water fountain", "male restroom", "female restroom"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            buildingName = getIntent().getExtras().getString("Building name");
        }
        TextView tv = (TextView) findViewById(R.id.buildingName);
        tv.setText(buildingName);

        TextView tv2 = (TextView) findViewById(R.id.description);
        tv2.setText(description);

        /* list of facilities */
        final Context context = getApplicationContext();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, facilities);

        ListView listView = (ListView) findViewById(R.id.listView2);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                Intent intent = new Intent(context, FacilityFloorActivity.class);
                                                String facilityName = facilities[position];
                                                //Toast.makeText(context, name, Toast.LENGTH_SHORT).show();
                                                intent.putExtra("Facility name", facilityName);
                                                intent.putExtra("Building name", buildingName);
                                                startActivityForResult(intent, 1);
                                            }
                                        }
        );

    }

    public void onFloorButtonClick(View v) {
        Intent i = new Intent(this, FloorActivity.class);
        i.putExtra("buildingName",buildingName);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_building, menu);
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

    public void OnBackButtonClick(View view) {
        Intent i = new Intent(this, BuildingListActivity.class);
        startActivity(i);
    }
}
