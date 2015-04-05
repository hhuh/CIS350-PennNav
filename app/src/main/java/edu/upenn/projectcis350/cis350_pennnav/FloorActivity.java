package edu.upenn.projectcis350.cis350_pennnav;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by Ankha on 3/21/2015.
 */
public class FloorActivity extends ActionBarActivity {
    String buildingName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floors);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            buildingName = getIntent().getExtras().getString("buildingName");
        }

        TextView text = (TextView) findViewById(R.id.textView2);
        text.setText(buildingName);

        final Context context = getApplicationContext();

        final TextView t1 = (TextView) findViewById(R.id.textView);
        final TextView t2 = (TextView) findViewById(R.id.textView7);
        final TextView t3 = (TextView) findViewById(R.id.textView12);

        ImageView i1 = (ImageView) findViewById(R.id.imageView);
        ImageView i2 = (ImageView) findViewById(R.id.imageView2);
        ImageView i3 = (ImageView) findViewById(R.id.imageView3);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FloorDepthActivity.class);
                final TextView classList = (TextView) findViewById(R.id.textView4);
                final TextView facilityList = (TextView) findViewById(R.id.textView6);
                String floorNum = "1";
                CharSequence classRooms = classList.getText();
                CharSequence facilities = facilityList.getText();
                intent.putExtra("Floor number", floorNum);
                intent.putExtra("Classes", classRooms);
                intent.putExtra("Facilities", facilities);
                //Toast.makeText(context, floorNum, Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FloorDepthActivity.class);
                final TextView classList = (TextView) findViewById(R.id.textView4);
                final TextView facilityList = (TextView) findViewById(R.id.textView6);
                String floorNum = "1";
                CharSequence classRooms = classList.getText();
                CharSequence facilities = facilityList.getText();
                intent.putExtra("Floor number", floorNum);
                intent.putExtra("Classes", classRooms);
                intent.putExtra("Facilities", facilities);
                //Toast.makeText(context, floorNum, Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FloorDepthActivity.class);
                final TextView classList = (TextView) findViewById(R.id.textView9);
                final TextView facilityList = (TextView) findViewById(R.id.textView11);
                String floorNum = "2";
                CharSequence classRooms = classList.getText();
                CharSequence facilities = facilityList.getText();
                intent.putExtra("Floor number", floorNum);
                intent.putExtra("Classes", classRooms);
                intent.putExtra("Facilities", facilities);
                //Toast.makeText(context, floorNum, Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FloorDepthActivity.class);
                final TextView classList = (TextView) findViewById(R.id.textView9);
                final TextView facilityList = (TextView) findViewById(R.id.textView11);
                String floorNum = "2";
                CharSequence classRooms = classList.getText();
                CharSequence facilities = facilityList.getText();
                intent.putExtra("Floor number", floorNum);
                intent.putExtra("Classes", classRooms);
                intent.putExtra("Facilities", facilities);
                //Toast.makeText(context, floorNum, Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FloorDepthActivity.class);
                final TextView classList = (TextView) findViewById(R.id.textView14);
                final TextView facilityList = (TextView) findViewById(R.id.textView16);
                String floorNum = "3";
                CharSequence classRooms = classList.getText();
                CharSequence facilities = facilityList.getText();
                intent.putExtra("Floor number", floorNum);
                intent.putExtra("Classes", classRooms);
                intent.putExtra("Facilities", facilities);
                //Toast.makeText(context, floorNum, Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FloorDepthActivity.class);
                final TextView classList = (TextView) findViewById(R.id.textView14);
                final TextView facilityList = (TextView) findViewById(R.id.textView16);
                String floorNum = "3";
                CharSequence classRooms = classList.getText();
                CharSequence facilities = facilityList.getText();
                intent.putExtra("Floor number", floorNum);
                intent.putExtra("Classes", classRooms);
                intent.putExtra("Facilities", facilities);
                //Toast.makeText(context, floorNum, Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
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

    public void onBackButtonClicked(View view) {
        Intent i = new Intent(this, BuildingActivity.class);
        i.putExtra("Building name",buildingName);
        startActivity(i);
    }
}
