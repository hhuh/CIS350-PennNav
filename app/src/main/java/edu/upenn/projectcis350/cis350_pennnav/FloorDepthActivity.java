package edu.upenn.projectcis350.cis350_pennnav;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Ankha on 4/5/2015.
 */
public class FloorDepthActivity extends ActionBarActivity {

    String buildingName;
    String topText = "Floor Number: ";
    String rooms = "The following classrooms/auditoriums are on this floor: ";
    String facilities = "This floor has the following: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor_depth);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            topText = topText + getIntent().getExtras().getString("Floor number");
            rooms = rooms + getIntent().getExtras().getString("Classes");
            facilities = facilities + getIntent().getExtras().getString("Facilities");
            buildingName = getIntent().getExtras().getString("buildingName");
        }

        TextView top = (TextView) findViewById(R.id.textView17);
        top.setText(topText);

        TextView roomList = (TextView) findViewById(R.id.textView18);
        roomList.setText(rooms);

        TextView facilityList = (TextView) findViewById(R.id.textView19);
        facilityList.setText(facilities);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_floor_depth, menu);
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

    public void onBackButtonClicked(View view) {
        Intent i = new Intent(this, FloorActivity.class);
        i.putExtra("buildingName", buildingName);
        startActivity(i);
    }
}