package com.example.jd.dealershipapp;

import android.Manifest;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.CalendarContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.jd.dealershipapp.JavaBean.Customer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link IssueInformationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link IssueInformationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IssueInformationFragment extends Fragment implements android.app.DatePickerDialog.OnDateSetListener {
    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public static final int PERMISSION_WRITE_CALENDAR = 1;

    FragmentManager fm;

    String[] email = {"service@wheelerdealer.ca"};

    EditText dateText;
    EditText timeText;
    DatePickerDialog date;
    TimePickerDialog time;
    TimePickerDialog.OnTimeSetListener timeSetListener;

    TextView dateView;
    TextView timeView;
    TextView issueView;
    EditText issueText;

    int hour, min, dateDay, dateMonth, dateYear;

    public IssueInformationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment IssueInformationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static IssueInformationFragment newInstance(String param1, String param2) {
        IssueInformationFragment fragment = new IssueInformationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_issue_information, container, false);

        fm = getActivity().getSupportFragmentManager();

        issueText = view.findViewById(R.id.issue);
        issueView = view.findViewById(R.id.issueText);

        dateView = view.findViewById(R.id.dateTitle);
        timeView = view.findViewById(R.id.timeTitle);

        Calendar current = Calendar.getInstance();
        hour = current.get(Calendar.HOUR_OF_DAY);
        min = current.get(Calendar.MINUTE);
        timeText = view.findViewById(R.id.time);

        date = new DatePickerDialog(getActivity());
        dateText = view.findViewById(R.id.date);
        date.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                dateYear = year;
                dateDay = day;
                dateMonth = month;
                dateText.setText(day + " / " + (month + 1) + " / " + year);
            }
        });
        dateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                date.show();
                dateView.setTextColor(Color.BLACK);
                dateView.setText(R.string.date_title);
            }
        });


        timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                hour = i;
                min = i1;
                String hourString;
                String minString;
                String amPm;
                if (hour > 12) {
                    hourString = hour - 12 + "";
                    amPm = "PM";
                } else if(hour == 12) {
                    hourString = "12";
                    amPm = "PM";
                } else if(hour == 0) {
                    hourString = "12";
                    amPm = "AM";
                } else {
                    hourString = hour + "";
                    amPm = "AM";
                }

                if(min < 10) {
                    minString = "0" + min;
                } else {
                    minString = min + "";
                }

                timeText.setText(hourString + ":" + minString + " " + amPm);

            }
        };

        time = new TimePickerDialog(getActivity(), timeSetListener, hour, min, false);

        timeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                time.show();
                timeView.setTextColor(Color.BLACK);
                timeView.setText(R.string.time_title);
            }
        });

        issueText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                issueView.setTextColor(Color.BLACK);
                issueView.setText(R.string.issue_title);
            }
        });

        Button backButton = view.findViewById(R.id.backButtonIssue);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.setCustomAnimations(R.anim.slide_back_in, R.anim.slide_back_out);
                transaction.replace(R.id.content, new VehicleInformationFragment());
                transaction.addToBackStack(null);

                transaction.commit();
            }
        });

        Button submitButton = view.findViewById(R.id.submitButtonIssue);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dateText.getText().toString().trim().isEmpty()) {
                    dateView.setTextColor(Color.RED);
                    dateView.setText(R.string.date_empty);
                }
                if(timeText.getText().toString().trim().isEmpty()) {
                    timeView.setTextColor(Color.RED);
                    timeView.setText(R.string.time_empty);
                }
                if(issueText.getText().toString().trim().isEmpty()) {
                    issueView.setTextColor(Color.RED);
                    issueView.setText(R.string.issue_empty);
                }



                if(!dateText.getText().toString().trim().isEmpty() && !timeText.getText().toString().trim().isEmpty() && !issueText.getText().toString().trim().isEmpty()) {

                    //add appointment to calendar
                    if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_CALENDAR) != PackageManager.PERMISSION_GRANTED) {
                        //if we dont have the permission
                        //Have we already asked them for permission? if so should we show rationale?
                        if(ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.WRITE_CALENDAR)) {
                            //i should so you a reason as to why i want the permission
                            final AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                            alertDialog.setTitle("Calendar Permission");
                            alertDialog.setMessage("We need access to your calendar to add the appointment.");
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    alertDialog.dismiss();
                                    //request permission again
                                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_CALENDAR}, PERMISSION_WRITE_CALENDAR);

                                }
                            });
                            alertDialog.show();
                        } else {
                            //if this is the first time asking for permission
                            //then ask for permission
                            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_CALENDAR}, PERMISSION_WRITE_CALENDAR);
                        }

                    } else {
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

                        if(i.resolveActivity(getActivity().getPackageManager()) != null) {
                            startActivity(i);
                        } else {
                            Toast.makeText(getContext(), "You do not have the correct software", Toast.LENGTH_SHORT).show();
                        }
                    }

                    Customer.setDate(dateText.getText().toString().trim());
                    Customer.setTime(timeText.getText().toString().trim());
                    Customer.setIssue(issueText.getText().toString().trim());

                    Intent i = new Intent(Intent.ACTION_SENDTO);
                    i.setData(Uri.parse("mailto:"));
                    i.putExtra(Intent.EXTRA_EMAIL, email);
                    i.putExtra(Intent.EXTRA_SUBJECT, "SERVICE APPOINTMENT REQUEST");
                    i.putExtra(Intent.EXTRA_TEXT, "- CUSTOMER INFO -\nName: " + Customer.getFirstName() + " " + Customer.getLastName() + "\nEmail: " + Customer.getEmail() + "\nPhone: " + Customer.getPhone() + "\n\n" +
                                                        "- VEHICLE INFO -\nBrand: " + Customer.getBrand() + "\nModel: " + Customer.getModel() + "\nVIN: " + Customer.getVin() + "\nKM: " + Customer.getKm() + "\n\n" +
                                                        "- APPOINTMENT INFO -\nDate: " + Customer.getDate() + "\nTime: " + Customer.getTime() + "\nIssue: " + Customer.getIssue());

                    AppCompatActivity activity = (AppCompatActivity) view.getContext();

                    if (i.resolveActivity(activity.getPackageManager()) != null) {
                        activity.startActivity(i);
                    } else {
                        Toast.makeText(activity.getApplicationContext(), "You do not have the correct software", Toast.LENGTH_SHORT).show();
                    }

                    dateText.setText("");
                    timeText.setText("");
                    issueText.setText("");

                    fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

                    Toast.makeText(getActivity(), "Appointment set, see you soon!", Toast.LENGTH_LONG).show();

                }

            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }
}
