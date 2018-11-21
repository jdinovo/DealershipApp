package com.example.jd.dealershipapp;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.*;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BookAppointmentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BookAppointmentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookAppointmentFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    FragmentManager fm;

    EditText email;
    EditText phone;
    TextView emailTitle;
    TextView phoneTitle;
    Pattern emailPattern = Pattern.compile("^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
    Pattern phonePattern1 = Pattern.compile("\\(\\d{3}\\)\\d{3}-?\\d{4}");
    Pattern phonePattern2 = Pattern.compile("\\d{10}");

    private OnFragmentInteractionListener mListener;

    public BookAppointmentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BookAppointmentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BookAppointmentFragment newInstance(String param1, String param2) {
        BookAppointmentFragment fragment = new BookAppointmentFragment();
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
        View view = inflater.inflate(R.layout.fragment_book_appointment, container, false);
        fm = getActivity().getSupportFragmentManager();

        final EditText fName = view.findViewById(R.id.fName);
        final EditText lName = view.findViewById(R.id.lName);
        final TextView lNameTitle = view.findViewById(R.id.lNameTitle);
        final TextView fNameTitle = view.findViewById(R.id.fNameTitle);

        email = view.findViewById(R.id.email);
        phone = view.findViewById(R.id.phone);
        emailTitle = view.findViewById(R.id.emailTitle);
        phoneTitle = view.findViewById(R.id.phoneTitle);

        fName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                fNameTitle.setText(R.string.first_name);
                fNameTitle.setTextColor(Color.BLACK);
            }
        });

        lName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                lNameTitle.setText(R.string.last_name);
                lNameTitle.setTextColor(Color.BLACK);
            }
        });

        phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!phonePattern1.matcher(phone.getText()).find() && !phonePattern2.matcher(phone.getText()).find()) {
                    phone.setTextColor(Color.RED);
                    phoneTitle.setTextColor(Color.RED);
                    phoneTitle.setText(R.string.phone_warning);
                } else {
                    phone.setTextColor(Color.BLACK);
                    phoneTitle.setTextColor(Color.BLACK);
                    phoneTitle.setText(R.string.phone);
                }
            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!emailPattern.matcher(email.getText()).find()) {
                    email.setTextColor(Color.RED);
                    emailTitle.setTextColor(Color.RED);
                    emailTitle.setText(R.string.email_waring);
                } else {
                    email.setTextColor(Color.BLACK);
                    emailTitle.setTextColor(Color.BLACK);
                    emailTitle.setText(R.string.email);
                }
            }
        });

        Button nextButton = view.findViewById(R.id.nextButtonContact);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(fName.getText().toString().trim().isEmpty()) {
                    fNameTitle.setText(R.string.first_name_blank);
                    fNameTitle.setTextColor(Color.RED);
                }
                if(lName.getText().toString().trim().isEmpty()) {
                    lNameTitle.setText(R.string.last_name_blank);
                    lNameTitle.setTextColor(Color.RED);
                }
                if(email.getText().toString().trim().isEmpty()) {
                    emailTitle.setText(R.string.email_blank);
                    emailTitle.setTextColor(Color.RED);
                }
                if(phone.getText().toString().trim().isEmpty()) {
                    phoneTitle.setText(R.string.phone_blank);
                    phoneTitle.setTextColor(Color.RED);
                }


                if(!fName.getText().toString().trim().isEmpty() && !lName.getText().toString().trim().isEmpty() && !phone.getText().toString().trim().isEmpty() && !email.toString().trim().isEmpty()) {
                    FragmentTransaction transaction = fm.beginTransaction();
                    transaction.replace(R.id.content, new VehicleInformationFragment());
                    transaction.addToBackStack(null);
                    transaction.commit();
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

}
