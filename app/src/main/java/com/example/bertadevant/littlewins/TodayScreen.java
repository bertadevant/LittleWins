package com.example.bertadevant.littlewins;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.LinearLayout;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.CheckBox;
import java.util.List.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import android.content.res.Resources;
import org.json.*;
import java.util.ArrayList;

public class TodayScreen extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ArrayList<EntriesClass> stored_Entries;
    private ListView entryList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go to another activity to add a new entry
            }
        });
        //set up randomEncouragement
        randomEncouragment();
        if (isThereAnyEntries() == true) {
            entryList = (ListView) findViewById(R.id.entriesList);
            readJSON("entries");


            for (int i =0; i<stored_Entries.size(); i++)
            {
                //entryList.add
            }

        } else {

        }

//        entryList.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//
//            }
//        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.today_screen, menu);
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

    protected void createEntryObject()
    {
        /*
        TODO:
            - read JSON Entry file to check if the entry already exist
            - write entry object to JSON file
         */
        writetoJSON("entries.json");
    }

    protected void randomEncouragment()
    {
        TextView randomEncouragement = (TextView) findViewById(R.id.randomEncouragement);
        Random rgenerator = new Random();
        Resources res = getResources();
        String [] encouragementArray = res.getStringArray(R.array.randomEncouragement);

        if (isThereAnyEntries() == false)
        {
            randomEncouragement.setText("@noEntriesRecorded");
        } else {
            String rg = encouragementArray[rgenerator.nextInt(encouragementArray.length)];
            randomEncouragement.setText(rg);
        }

    }

    protected boolean isThereAnyEntries()
    {
        if (readJSON("entries.json").isEmpty())
        {
            return false;
        } else {
            return true;
        }
    }

    protected void writetoJSON(String fileName)
    {

    }

    protected ArrayList readJSON(String arrayToGet) {
        try {
            //create JSON object that calls method that will load the entries.json
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray jsonArray = obj.getJSONArray(arrayToGet);

            for (int i = 0; i < jsonArray.length(); i++) {
                EntriesClass new_Entry = new EntriesClass();

                int entry_ID = jsonArray.getJSONObject(i).getInt("entry_ID");
                if (entry_ID != 0)
                    new_Entry.setEntry_ID(entry_ID);

                int entry_level = jsonArray.getJSONObject(i).getInt("entry_level");
                if (entry_level >= 0)
                    new_Entry.setEntry_level(entry_level);

                String entry_String = jsonArray.getJSONObject(i).getString("entry_String");
                if (entry_String.length() > 0)
                    new_Entry.setEntry_String(entry_String);

                stored_Entries.add(new_Entry);
            }
            return stored_Entries;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }


    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("entries.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        return true;
    }

}
