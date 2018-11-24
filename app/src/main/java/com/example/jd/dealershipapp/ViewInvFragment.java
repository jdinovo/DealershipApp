package com.example.jd.dealershipapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jd.dealershipapp.JavaBean.Vehicle;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ViewInvFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ViewInvFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewInvFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private boolean mTwoPane;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView list;

    private OnFragmentInteractionListener mListener;

    public ViewInvFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ViewInvFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ViewInvFragment newInstance(String param1, String param2) {
        ViewInvFragment fragment = new ViewInvFragment();
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
        View view = inflater.inflate(R.layout.fragment_view_inv, container, false);

        //creating list
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        ArrayList<Integer> images = new ArrayList<>();
        Uri jeep1 = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.jeep1);
        images.add(R.raw.jeep1);
        images.add(R.raw.jeep2);
        images.add(R.raw.jeep3);
        vehicleList.add(new Vehicle(getResources().getString(R.string.brand1), getResources().getString(R.string.model1), getResources().getString(R.string.year1), getResources().getString(R.string.price1), getResources().getString(R.string.description1), R.raw.jeep1, images));
        images = new ArrayList<>();
        images.add(R.raw.wheeler_dealer);
        images.add(R.raw.wheeler_dealer);
        images.add(R.raw.wheeler_dealer);
        vehicleList.add(new Vehicle(getResources().getString(R.string.brand2), getResources().getString(R.string.model2), getResources().getString(R.string.year2), getResources().getString(R.string.price2), getResources().getString(R.string.description2), R.raw.wheeler_dealer, images));
        vehicleList.add(new Vehicle(getResources().getString(R.string.brand3), getResources().getString(R.string.model3), getResources().getString(R.string.year3), getResources().getString(R.string.price3), getResources().getString(R.string.description3), R.raw.wheeler_dealer, images));
        vehicleList.add(new Vehicle(getResources().getString(R.string.brand4), getResources().getString(R.string.model4), getResources().getString(R.string.year4), getResources().getString(R.string.price4), getResources().getString(R.string.description4), R.raw.wheeler_dealer, images));


        RecyclerView rec = view.findViewById(R.id.recycle);
        rec.setLayoutManager(new LinearLayoutManager(getContext()));

        CustomCardViewAdapter adapter = new CustomCardViewAdapter(vehicleList);
        rec.setAdapter(adapter);

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
