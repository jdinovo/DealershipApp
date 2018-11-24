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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link VehicleInformationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link VehicleInformationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VehicleInformationFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    FragmentManager fm;
    ArrayAdapter<CharSequence> modelAdapter;

    private OnFragmentInteractionListener mListener;

    public VehicleInformationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VehicleInformationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VehicleInformationFragment newInstance(String param1, String param2) {
        VehicleInformationFragment fragment = new VehicleInformationFragment();
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
        View view = inflater.inflate(R.layout.fragment_vehicle_information, container, false);

        fm = getActivity().getSupportFragmentManager();

        final Spinner brandSpinner = view.findViewById(R.id.brandSpinner);
        final Spinner modelSpinner = view.findViewById(R.id.modelSpinner);
        final EditText vinNum = view.findViewById(R.id.vinInput);
        final TextView vinTitle = view.findViewById(R.id.vinNumTitle);
        final EditText km = view.findViewById(R.id.kmInput);
        final TextView kmTitle = view.findViewById(R.id.kmTitle);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> brandAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.brand_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        brandAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        brandSpinner.setAdapter(brandAdapter);

        modelAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.model_blank_array, android.R.layout.simple_spinner_item);

        modelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        modelSpinner.setAdapter(modelAdapter);

        brandSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(view != null) {
                    if(!brandSpinner.getSelectedItem().toString().equals("Brand")) {
                        brandSpinner.setBackgroundColor(Color.TRANSPARENT);
                    }
                    if (adapterView.getItemAtPosition(i).toString().equals("BMW")) {
                        modelAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.bmw_model_array, android.R.layout.simple_spinner_item);
                    } else if (adapterView.getItemAtPosition(i).toString().equals("Jeep")) {
                        modelAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.jeep_model_array, android.R.layout.simple_spinner_item);
                    } else if (adapterView.getItemAtPosition(i).toString().equals("Mercedes")) {
                        modelAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.mercedes_model_array, android.R.layout.simple_spinner_item);
                    } else if (adapterView.getItemAtPosition(i).toString().equals("Ford")) {
                        modelAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.ford_model_array, android.R.layout.simple_spinner_item);
                    } else if (adapterView.getItemAtPosition(i).toString().equals("GMC")) {
                        modelAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.gmc_model_array, android.R.layout.simple_spinner_item);
                    } else if (adapterView.getItemAtPosition(i).toString().equals("Chevrolet")) {
                        modelAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.chev_model_array, android.R.layout.simple_spinner_item);
                    } else if (adapterView.getItemAtPosition(i).toString().equals("RAM")) {
                        modelAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.ram_model_array, android.R.layout.simple_spinner_item);
                    } else if (adapterView.getItemAtPosition(i).toString().equals("Toyota")) {
                        modelAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.toyota_model_array, android.R.layout.simple_spinner_item);
                    } else {
                        modelAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.model_blank_array, android.R.layout.simple_spinner_item);
                    }

                    modelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    modelSpinner.setAdapter(modelAdapter);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        modelSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(!modelSpinner.getSelectedItem().toString().equals("Model")) {
                    modelSpinner.setBackgroundColor(Color.TRANSPARENT);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        vinNum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                vinTitle.setText(R.string.vinText);
                vinTitle.setTextColor(Color.BLACK);
            }
        });

        km.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                kmTitle.setText(R.string.kmText);
                kmTitle.setTextColor(Color.BLACK);
            }
        });

        Button backButton = view.findViewById(R.id.backButtonVehicle);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                getFragmentManager().popBackStackImmediate();
                FragmentTransaction transaction = fm.beginTransaction();

                transaction.replace(R.id.content, fm.findFragmentByTag("appt"));
                transaction.addToBackStack(null);

                transaction.commit();

            }
        });

        Button nextButton = view.findViewById(R.id.nextButtonVehicle);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(brandSpinner.getSelectedItem().toString().equals("Brand")) {
                    brandSpinner.setBackgroundColor(Color.RED);
                }
                if(modelSpinner.getSelectedItem().toString().equals("Model")) {
                    modelSpinner.setBackgroundColor(Color.RED);
                }
                if(vinNum.getText().toString().trim().isEmpty()) {
                    vinTitle.setTextColor(Color.RED);
                    vinTitle.setText(R.string.vin_blank);
                }
                if(km.getText().toString().trim().isEmpty()) {
                    kmTitle.setTextColor(Color.RED);
                    kmTitle.setText(R.string.km_blank);
                }


                if(!brandSpinner.getSelectedItem().toString().equals("Brand") && !modelSpinner.getSelectedItem().toString().equals("Model") && !vinNum.getText().toString().trim().isEmpty() && !km.getText().toString().trim().isEmpty()) {
                    FragmentTransaction transaction = fm.beginTransaction();

                    Fragment selectedFragment = fm.findFragmentByTag("issue");
                    if(selectedFragment == null) {
                        transaction.replace(R.id.content, new IssueInformationFragment(), "issue");
                        transaction.addToBackStack(null);
                    } else if(!selectedFragment.isVisible()) {
                        transaction.replace(R.id.content, selectedFragment);
                        transaction.addToBackStack(null);
                    }
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
