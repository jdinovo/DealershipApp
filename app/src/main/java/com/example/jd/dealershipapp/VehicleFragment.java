package com.example.jd.dealershipapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link VehicleFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link VehicleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VehicleFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private CustomAdapter adapter;
    private ArrayList<Integer> images;

    private OnFragmentInteractionListener mListener;

    public VehicleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VehicleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VehicleFragment newInstance(String param1, String param2) {
        VehicleFragment fragment = new VehicleFragment();
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
        View view = inflater.inflate(R.layout.fragment_vehicle, container, false);

        Bundle args = getArguments();
        String brand = args.getString("brand");
        String model = args.getString("model");
        String year = args.getString("year");
        String price = args.getString("price");
        String desc = args.getString("desc");
        images = args.getIntegerArrayList("images");

        TextView brandView = view.findViewById(R.id.vehicleBrand);
        TextView modelView = view.findViewById(R.id.vehicleModel);
        TextView yearView = view.findViewById(R.id.vehicleYear);
        TextView priceView = view.findViewById(R.id.vehiclePrice);
        TextView descriptionView = view.findViewById(R.id.vehicleDesc);

        brandView.setText(brand);
        modelView.setText(model);
        yearView.setText(year);
        priceView.setText(price);
        descriptionView.setText(desc);

        adapter = new CustomAdapter(getChildFragmentManager());
        ViewPager viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);


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

    public class CustomAdapter extends FragmentPagerAdapter {
        public CustomAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return ImagesFragment.newInstance(images.get(0));
                case 1:
                    return ImagesFragment.newInstance(images.get(1));
                case 2:
                    return ImagesFragment.newInstance(images.get(2));

                default:
                    return ImagesFragment.newInstance(0);

            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
