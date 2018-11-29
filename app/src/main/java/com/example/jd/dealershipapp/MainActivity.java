package com.example.jd.dealershipapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        MainFragment.OnFragmentInteractionListener,
        ViewInvFragment.OnFragmentInteractionListener,
        BookAppointmentFragment.OnFragmentInteractionListener,
        MeetTheTeamFragment.OnFragmentInteractionListener,
        CreditsFragment.OnFragmentInteractionListener,
        VehicleFragment.OnFragmentInteractionListener,
        ImagesFragment.OnFragmentInteractionListener,
        VehicleInformationFragment.OnFragmentInteractionListener,
        IssueInformationFragment.OnFragmentInteractionListener {

    FragmentManager fm;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        //Set up the first time we run the application
        fm = getSupportFragmentManager();
        if(savedInstanceState == null) {
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.replace(R.id.content, new MainFragment(), "main");
            transaction.commit();
        }

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
        getMenuInflater().inflate(R.menu.main, menu);
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
            Intent i = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentTransaction transaction = fm.beginTransaction();
        //transaction.setCustomAnimations(Insert 2 or 4 animations here);

        if (id == R.id.nav_homepage) {
            Fragment selectedFragment = fm.findFragmentByTag("homepage");

            if(selectedFragment == null) {
                transaction.replace(R.id.content, new MainFragment(), "homepage");
                transaction.addToBackStack(null);
            } else if(!selectedFragment.isVisible()) {
                transaction.replace(R.id.content, selectedFragment);
                transaction.addToBackStack(null);
            }

        } else if (id == R.id.nav_viewInv) {
            Fragment selectedFragment = fm.findFragmentByTag("inv");

            if(selectedFragment == null) {
                transaction.replace(R.id.content, new ViewInvFragment(), "inv");
                transaction.addToBackStack(null);
            } else if(!selectedFragment.isVisible()) {
                transaction.replace(R.id.content, selectedFragment);
                transaction.addToBackStack(null);
            }

        } else if (id == R.id.nav_bookAppt) {
            Fragment selectedFragment = fm.findFragmentByTag("appt");

            if(selectedFragment == null) {
                transaction.replace(R.id.content, new BookAppointmentFragment(), "appt");
                transaction.addToBackStack(null);
            } else if(!selectedFragment.isVisible()) {
                transaction.replace(R.id.content, selectedFragment);
                transaction.addToBackStack(null);
            }
        } else if (id == R.id.nav_meetTheTeam) {
            Fragment selectedFragment = fm.findFragmentByTag("team");

            if(selectedFragment == null) {
                transaction.replace(R.id.content, new MeetTheTeamFragment(), "team");
                transaction.addToBackStack(null);
            } else if(!selectedFragment.isVisible()) {
                transaction.replace(R.id.content, selectedFragment);
                transaction.addToBackStack(null);
            }
        } else if (id == R.id.nav_credits) {
            Fragment selectedFragment = fm.findFragmentByTag("credit");

            if(selectedFragment == null) {
                transaction.replace(R.id.content, new CreditsFragment(), "credit");
                transaction.addToBackStack(null);
            } else if(!selectedFragment.isVisible()) {
                transaction.replace(R.id.content, selectedFragment);
                transaction.addToBackStack(null);
            }
        }

        transaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
