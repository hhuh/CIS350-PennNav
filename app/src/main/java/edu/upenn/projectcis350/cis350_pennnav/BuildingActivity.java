package edu.upenn.projectcis350.cis350_pennnav;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class BuildingActivity extends ActionBarActivity {
    String buildingName;
    String description = "Altered in 1926 by Paul Cret, this building housed the first working multi-purpose Electronic Numerical Integrator And Computer (ENIAC) that was the first modern computer.";
    String[] facilities = {"classroom", "bathroom"};

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

        String facilityNames = "";
        for (String f : facilities) {
            facilityNames += (f + ", ");
        }
        TextView tv3 = (TextView) findViewById(R.id.facilityName);
        tv3.setText(facilityNames);
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
}
