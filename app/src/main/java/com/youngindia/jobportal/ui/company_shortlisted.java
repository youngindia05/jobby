package com.youngindia.jobportal.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.youngindia.jobportal.R;
import com.youngindia.jobportal.adapter.ListAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link company_shortlisted.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link company_shortlisted#newInstance} factory method to
 * create an instance of this fragment.
 */
public class company_shortlisted extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
   Company_candidatelist employeer_homeActivity;
    public String[]job_name={"Fundraiser", "Game Industry", "Genealogist", "Government Jobs", "Hair Stylist", "Human Resources"};
    public String[]job_specification={"Android List View", "Adapter implementation", "Simple List View In Android", "Create List View Android","Android Example", "List View Source Code"};
    public String[]job_skills={"Job views","Job Recommended","New Jobs","Latest Jobs","New Jobs","Latest Jobs"};
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public company_shortlisted() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment company_shortlisted.
     */
    // TODO: Rename and change types and number of parameters
    public static company_shortlisted newInstance(String param1, String param2) {
        company_shortlisted fragment = new company_shortlisted();
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
        View rootView = inflater.inflate(R.layout.fragment_fragment_companybase, container, false);
        ListView listview=(ListView)rootView.findViewById(R.id.listView);
        ListAdapter listAdapter=new ListAdapter(getActivity(),job_name,job_specification,job_skills);
        listview.setAdapter(listAdapter);
        listview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Dialog dialog =new Dialog(getActivity());
                    dialog.setTitle("We are still working on this Apply part!!");
                    dialog.show();
            }
        });
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        employeer_homeActivity=(Company_candidatelist) activity;
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
