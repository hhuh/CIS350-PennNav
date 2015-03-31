package edu.upenn.projectcis350.cis350_pennnav;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


/**
 * Created by Ankha on 3/21/2015.
 */
public class FloorActivity extends ActionBarActivity {
    String buildingName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            buildingName = getIntent().getExtras().getString("buildingName");
        }

        TextView text = (TextView) findViewById(R.id.textView2);
        text.setText(buildingName);
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
        Intent i = new Intent(this, FloorActivity.class);
        i.putExtra("buildingName",buildingName);
        startActivity(i);
    }
}
