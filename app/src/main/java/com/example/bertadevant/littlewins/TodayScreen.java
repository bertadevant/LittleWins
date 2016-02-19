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
import android.widget.ScrollView;
import android.widget.LinearLayout;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.CheckBox;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import android.content.res.Resources;

import java.util.ArrayList;

public class TodayScreen extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ArrayList<EntriesClass> stored_Entries;

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

            }
        });
        //set up randomEncouragement
        randomEncouragment();
        if (isThereAnyEntries() == true)
        {

        } else {

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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

    protected ArrayList readJSON(String fileName)
    {
        ArrayList<EntriesClass> stored_Entries;
        String json = null;
        try {
            InputStream in = getAssets().open(fileName);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;

            for (int i = 0; i < scheduleData.Count; i++) {
                JsonData game = scheduleData [i];

                ScheduledGames arenaGame = new ScheduledGames();

                string arenaStr = game ["arena"].ToString();
                if (arenaStr.Length > 0)
                    arenaGame.arena = arenaStr;

                string iconURL_Str = game ["iconURL"].ToString();
                if (iconURL_Str.Length > 0)
                    arenaGame.iconURL = iconURL_Str;

                string teamPC_Str = game ["teamColor"].ToString();
                if (teamPC_Str.Length > 0)
                    arenaGame.teamColor = teamPC_Str;

                JsonData individualGameTimes = game["games"];
                if (individualGameTimes.Count <= 0) {
                    //Check back soon for more opportunities\n to play Turbo live at the Amway Center\n this NBA season.
                    arenaGame.games.Add("No upcoming games.\nCheck back soon for more opportunities\n to play Turbo live this NBA season.");
                } else {
                    for (int j = 0; j < maxGames; j++) {
                        arenaGame.games.Add(individualGameTimes [j].ToString());
                    }
                }

                gameList.Add(arenaGame);
            }

        }

        return stored_Entries;
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /*
    //TO DO
    Method where I read a JSON file and check if it is empty, if it is empty I load the Button; if it is not I load the List with the entries
    Method for loading the Entries



    */
}
