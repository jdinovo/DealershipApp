package com.example.jd.dealershipapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.NonNull;
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
import android.widget.Toast;

import java.util.Calendar;

import static com.example.jd.dealershipapp.IssueInformationFragment.dateDay;
import static com.example.jd.dealershipapp.IssueInformationFragment.dateMonth;
import static com.example.jd.dealershipapp.IssueInformationFragment.dateYear;
import static com.example.jd.dealershipapp.IssueInformationFragment.hour;
import static com.example.jd.dealershipapp.IssueInformationFragment.min;


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

    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Set up the first time we run the application
        fm = getSupportFragmentManager();
        if(savedInstanceState == null) {
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.replace(R.id.content, new MainFragment(), "homepage");
            transaction.commit();
        }

        drawer = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
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
        transaction.setCustomAnimations(R.anim.fade_wipe_in, R.anim.fade_wipe_out, R.anim.fade_wipe_back_in, R.anim.fade_wipe_back_out);

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

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        switch(requestCode){
            case IssueInformationFragment.PERMISSION_WRITE_CALENDAR:
                if(grantResults.length > 0 &&
                        (grantResults[0] == PackageManager.PERMISSION_GRANTED)){
                    System.out.println("saved to calendar");
                    //if we have permission
                    Calendar beginTime = Calendar.getInstance();
                    beginTime.set(dateYear, dateMonth, dateDay, hour, min);
                    Intent i = new Intent(Intent.ACTION_INSERT)
                            .setData(CalendarContract.Events.CONTENT_URI)
                            .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis())
                            .putExtra(CalendarContract.Events.TITLE, "Vehicle service")
                            .putExtra(CalendarContract.Events.DESCRIPTION, "Vehicle service appointment")
                            .putExtra(CalendarContract.Events.EVENT_LOCATION, "Wheeler Dealer Service Center")
                            .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY);

                    if(i.resolveActivity(this.getPackageManager()) != null) {
                        startActivity(i);
                    } else {
                        Toast.makeText(this, "You do not have the correct software", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    //Permission was not granted, we should disable the button
                }
                break;

        }

    }

}
