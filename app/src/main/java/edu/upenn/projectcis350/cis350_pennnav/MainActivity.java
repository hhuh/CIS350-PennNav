package edu.upenn.projectcis350.cis350_pennnav;

import android.content.Context;
import android.content.Intent;
import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;


public class MainActivity extends Activity {

    //global variable here
    ArrayList<String> JSONList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context context = getApplicationContext();

        if(JSONList.size() == 0){
            try {
                Reader reader = new Reader(getAssets().open("class.json"));
                JSONList = reader.readAll();

                //System.out.println(JSONList.size() + "--------------------!!!!");

            } catch (IOException e) {
                e.printStackTrace();
                //System.out.println("ERRORERRORERRORERRORERRORERRORERRORERRORERRORERROR");
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void onBuildingButtonClick(View v){
        // Change the GameActivity to the building
        Intent i = new Intent(this, BuildingListActivity.class);
        i.putStringArrayListExtra("JSONList", JSONList);
        startActivity(i);
    }

    public void onFacilityButtonClick(View v) {
        //Change the GameActivity to the facility list
        Intent i = new Intent(this, FacilityListActivity.class);
        i.putStringArrayListExtra("JSONList", JSONList);
        startActivity(i);
    }
}
