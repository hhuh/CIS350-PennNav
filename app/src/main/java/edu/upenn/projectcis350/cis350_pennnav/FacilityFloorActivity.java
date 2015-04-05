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


public class FacilityFloorActivity extends ActionBarActivity {
    String[] floors = {"basement","1","2","3","4"};
    String facilityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facility_floor);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            facilityName = getIntent().getExtras().getString("Facility name");
        }
        TextView tv = (TextView) findViewById(R.id.textView7);
        tv.setText(facilityName + "s are located on these floors:");


        /* list of floors */
        final Context context = getApplicationContext();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, floors);

        ListView listView = (ListView) findViewById(R.id.listView3);
        listView.setAdapter(adapter);
        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                Intent intent = new Intent(context, FloorDepth.class);
                                                String floorNum = floors[position];
                                                //Toast.makeText(context, name, Toast.LENGTH_SHORT).show();
                                                intent.putExtra("Floor", floorNum);
                                                startActivityForResult(intent, 1);
                                            }
                                        }
        );*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_facility_floor, menu);
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
