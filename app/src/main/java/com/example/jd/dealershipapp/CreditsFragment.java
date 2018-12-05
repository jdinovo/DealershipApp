package com.example.jd.dealershipapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.jd.dealershipapp.JavaBean.Credits;
import me.relex.circleindicator.CircleIndicator;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CreditsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CreditsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreditsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView list;
    private ArrayList<Credits> credits;

    private OnFragmentInteractionListener mListener;

    public CreditsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CreditsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CreditsFragment newInstance(String param1, String param2) {
        CreditsFragment fragment = new CreditsFragment();
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
        View view = inflater.inflate(R.layout.fragment_credits, container, false);

        final ArrayList<Credits> creditList = new ArrayList<>();

        // Strings for the links
        String meetTheTeamPicOneLink = "https://pixabay.com/en/attractive-beautiful-girl-model-1869761/";
        String meetTheTeamPicTwoLink = "https://pixabay.com/en/beard-face-man-model-mustache-1845166/";
        String meetTheTeamPicThreeLink = "https://pixabay.com/en/beautiful-fashion-grass-model-1844724/";
        String meetTheTeamPicOneDesc = "Picture of a model";
        String meetTheTeamPicTwoDesc = "Picture of a bearded model";
        String meetTheTeamPicThreeDesc = "Picture of a model";

        String jeepPicOneLink = "https://pixabay.com/en/vehicle-car-wheel-jeep-luxury-suv-3196981/";
        String jeepPicTwoLink = "https://pixabay.com/en/tire-track-sand-tread-imprint-2211379/";
        String jeepPicThreeLink = "https://pixabay.com/en/vehicle-car-transportation-system-3206929/";
        String jeepPicOneDesc = "Picture of a black Jeep";
        String jeepPicTwoDesc = "Picture of a black Jeep";
        String jeepPicThreeDesc = "Picture of tire markings in the mud from a Jeep";

        String mustangPicOneLink = "https://pixabay.com/en/drive-car-red-ford-mustang-natural-1630501/";
        String mustangPicTwoLink = "https://pixabay.com/en/convertible-ford-mustang-1630448/";
        String mustangPicThreeLink = "https://pixabay.com/en/red-car-natural-stone-trees-1630523/";
        String mustandPicOneDesc = "Picture of the front of a red Mustang";
        String mustandPicTwoDesc = "Picture of the side of a red convertible Mustang with the top down and the doors open";
        String mustandPicThreeDesc = "Picture of a red Mustang at the edge of a cliff";

        String yukonPicOneLink = "https://pixabay.com/en/gmc-yukon-grill-headlamp-glass-2831792/";
        String yukonPicTwoLink = "https://pixabay.com/en/gmc-yukon-sports-utility-vehicle-suv-2831791/";
        String yukonPicThreeLink = "https://pixabay.com/en/gmc-yukon-truck-wheel-rim-tire-2831790/";
        String yukonPicOneDesc = "Picture of the side of a white Yukon";
        String yukonPicTwoDesc = "Picture of the front grille of a white Yukon";
        String yukonPicThreeDesc = "Picture of chrome rims on a white Yukon";

        String miniPicOneLink = "https://pixabay.com/en/auto-mini-sports-car-vehicle-895720/";
        String miniPicTwoLink = "https://pixabay.com/en/car-red-mini-cooper-vehicle-1348250/";
        String miniPicThreeLink = "https://pixabay.com/en/mini-cooper-car-vehicle-mini-3775582/";
        String miniPicOneDesc = "Picture of the front hood of a red Mini Cooper";
        String miniPicTwoDesc = "Picture of the side of a red Mini Cooper";
        String miniPicThreeDesc = "Picture of the steering wheel with a Mini Cooper logo in the middle";

        String fbLogoLink = "https://en.facebookbrand.com";
        String twitterLogoLink = "https://about.twitter.com/en_us/company/brand-resources.html";
        String fbLogoDesc = "Picture of the Facebook logo";
        String twitterLogoDesc = "Picture of the Twitter logo";

        String wdlogoLink = "https://commons.wikimedia.org/wiki/File:Wheeler_Dealers.svg";
        String wdlogoDesc = "Picture of a logo with the letters W and D";


        creditList.add(new Credits("Model One", meetTheTeamPicOneLink, meetTheTeamPicOneDesc));
        creditList.add(new Credits("Model Two", meetTheTeamPicTwoLink, meetTheTeamPicTwoDesc));
        creditList.add(new Credits("Model Three", meetTheTeamPicThreeLink, meetTheTeamPicThreeDesc));

        creditList.add(new Credits("Jeep Picture", jeepPicOneLink, jeepPicOneDesc));
        creditList.add(new Credits("Jeep Picture", jeepPicTwoLink, jeepPicTwoDesc));
        creditList.add(new Credits("Jeep Picture", jeepPicThreeLink, jeepPicThreeDesc));

        creditList.add(new Credits("Mustang Picture", mustangPicOneLink, mustandPicOneDesc));
        creditList.add(new Credits("Mustang Picture", mustangPicTwoLink, mustandPicTwoDesc));
        creditList.add(new Credits("Mustang Picture", mustangPicThreeLink, mustandPicThreeDesc));

        creditList.add(new Credits("Yukon Picture", yukonPicOneLink, yukonPicOneDesc));
        creditList.add(new Credits("Yukon Picture", yukonPicTwoLink, yukonPicTwoDesc));
        creditList.add(new Credits("Yukon Picture", yukonPicThreeLink, yukonPicThreeDesc));

        creditList.add(new Credits("Mini Cooper Picture", miniPicOneLink, miniPicOneDesc));
        creditList.add(new Credits("Mini Cooper Picture", miniPicTwoLink, miniPicTwoDesc));
        creditList.add(new Credits("Mini Cooper Picture", miniPicThreeLink, miniPicThreeDesc));

        creditList.add(new Credits("Facebook Logo Picture", fbLogoLink, fbLogoDesc));
        creditList.add(new Credits("Twitter Logo Picture", twitterLogoLink, twitterLogoDesc));

        creditList.add(new Credits("WD Logo Picture", wdlogoLink, wdlogoDesc));

        RecyclerView recyclerView = view.findViewById(R.id.recycle_view_credits);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        CreditsRecycleViewAdapter adapter = new CreditsRecycleViewAdapter(creditList);
        recyclerView.setAdapter(adapter);

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
