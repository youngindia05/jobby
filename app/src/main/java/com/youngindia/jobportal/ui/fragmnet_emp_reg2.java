package com.youngindia.jobportal.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.youngindia.jobportal.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link fragmnet_emp_reg2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link fragmnet_emp_reg2#newInstance} factory method to
 * create an instance of this fragment.
 */

public class fragmnet_emp_reg2 extends Fragment implements SeekBar.OnSeekBarChangeListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    SeekBar seekBar_experience, seekBar_expected_salry;
    TextView textViewProgress,textView_expectedSalry;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button btn_submit;
    private OnFragmentInteractionListener mListener;
    Employee_RegistrationActivity employee_registrationActivity;
    public fragmnet_emp_reg2() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static fragmnet_emp_reg2 newInstance(String param1, String param2) {
        fragmnet_emp_reg2 fragment = new fragmnet_emp_reg2();
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
        View rootview=inflater.inflate(R.layout.fragment_fragmnet_emp_reg2, container, false);
        btn_submit=(Button)rootview.findViewById(R.id.btn_submit);
        seekBar_experience= (SeekBar) rootview.findViewById(R.id.seekBar_Experience);
        textViewProgress = (TextView)rootview.findViewById(R.id.textProgress);

        seekBar_expected_salry= (SeekBar) rootview.findViewById(R.id.seekBar_ExpectedSalary);
        textView_expectedSalry= (TextView)rootview.findViewById(R.id.textProgressSalry);

        seekBar_experience.setOnSeekBarChangeListener(this);
        seekBar_expected_salry.setOnSeekBarChangeListener(this);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(employee_registrationActivity,Employee_HomeActivity.class);
                startActivity(intent);
            }
        });
        // Inflate the layout for this fragment
        return rootview;
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
        employee_registrationActivity=(Employee_RegistrationActivity) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(seekBar==seekBar_experience)
        {
            textViewProgress.setText("Your Experience is :  "+progress);
        }
        else
        {
            textView_expectedSalry.setText("Your Expected Salary is:"+progress);
        }


    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        seekBar.setSecondaryProgress(seekBar.getProgress());

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
    @Override
    public void onResume() {
        super.onResume();
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        ActionBar actionBar = activity.getSupportActionBar();
        employee_registrationActivity. toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStack();
              // Toast.makeText(getActivity().getApplicationContext(), "Back", Toast.LENGTH_SHORT).show();
            }
        });

        actionBar.setTitle("Educational Details");
    }
}
