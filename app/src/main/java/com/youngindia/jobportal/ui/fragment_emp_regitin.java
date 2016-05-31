package com.youngindia.jobportal.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;

import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import android.widget.Toast;

import com.youngindia.jobportal.R;
import com.youngindia.jobportal.adapter.DateTimePicker;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link fragment_emp_regitin.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link fragment_emp_regitin#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_emp_regitin extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Employee_RegistrationActivity employee_registrationActivity;
    Button nxtbtn;
    Spinner spinner_industry;
    TextView edt_other;

    TextView dateResult, date2;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public fragment_emp_regitin() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_emp_regitin.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_emp_regitin newInstance(String param1, String param2) {
        fragment_emp_regitin fragment = new fragment_emp_regitin();
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
        View rootview=inflater.inflate(R.layout.fragment_fragment_emp_regitin, container, false);
        dateResult = (TextView)rootview.findViewById(R.id.textResult);
        date2 = (TextView)rootview.findViewById(R.id.textView1);


        spinner_industry=(Spinner)rootview.findViewById(R.id.spinner_Industry);
        edt_other=(TextView)rootview.findViewById(R.id.edt_others);
        if(spinner_industry.getSelectedItem().equals("Others"))
        {
            edt_other.setVisibility(View.VISIBLE);
        }


        nxtbtn=(Button)rootview.findViewById(R.id.btn);
        nxtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmnet_emp_reg2 fragmnet_emp_reg2=new fragmnet_emp_reg2();

                FragmentTransaction fragmenttransaction = employee_registrationActivity.getSupportFragmentManager().beginTransaction();
                //   sScreen = getResources().getString(R.string.title_wall);
                fragmenttransaction.replace(R.id.frame_container1, fragmnet_emp_reg2);
                fragmenttransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fragmenttransaction.addToBackStack( "tag" ).commit();
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

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        employee_registrationActivity=(Employee_RegistrationActivity) activity;
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


    public void customDatePicker_click(View v){
        // Create the dialog
        final Dialog mDateTimeDialog = new Dialog(getActivity());
        // Inflate the root layout
        final RelativeLayout mDateTimeDialogView = (RelativeLayout) getLayoutInflater().inflate(R.layout.date_time_dialog, null);
        // Grab widget instance
        final DateTimePicker mDateTimePicker = (DateTimePicker) mDateTimeDialogView.findViewById(R.id.DateTimePicker);
        mDateTimePicker.setDateChangedListener((DateTimePicker.DateWatcher) getActivity());
        mDateTimePicker.initData();
        //end
        Button setDateBtn = (Button)mDateTimeDialogView.findViewById(R.id.SetDateTime);
        // Update demo TextViews when the "OK" button is clicked
        setDateBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                mDateTimePicker.clearFocus();
	/*				String result_string = mDateTimePicker.getMonth() + "/" + String.valueOf(mDateTimePicker.getDay()) + "/" + String.valueOf(mDateTimePicker.getYear())
							+ "  " + String.valueOf(mDateTimePicker.getHour()) + ":" + String.valueOf(mDateTimePicker.getMinute());*/
                String result_string = mDateTimePicker.getMonth() + "/" + String.valueOf(mDateTimePicker.getDay()) + "/" + String.valueOf(mDateTimePicker.getYear());

//					if(mDateTimePicker.getHour() > 12) result_string = result_string + "PM";
//					else result_string = result_string + "AM";
                date2.setText(result_string);
                mDateTimeDialog.dismiss();
            }
        });

        Button cancelBtn = (Button)mDateTimeDialogView.findViewById(R.id.CancelDialog);
        // Cancel the dialog when the "Cancel" button is clicked
        cancelBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                mDateTimePicker.reset();
                mDateTimeDialog.cancel();
            }
        });

        // Reset Date and Time pickers when the "Reset" button is clicked

        Button resetBtn = (Button)mDateTimeDialogView.findViewById(R.id.ResetDateTime);
        resetBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                mDateTimePicker.reset();
            }
        });

        // Setup TimePicker
        // No title on the dialog window
        mDateTimeDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // Set the dialog content view
        mDateTimeDialog.setContentView(mDateTimeDialogView);
        // Display the dialog
        mDateTimeDialog.show();
    }

    public void onDateChanged(Calendar c) {
        Log.e("","" + c.get(Calendar.MONTH) + " " + c.get(Calendar.DAY_OF_MONTH)+ " " + c.get(Calendar.YEAR));
        String result_string =String.valueOf(c.get(Calendar.MONTH)+1)  + "/" + String.valueOf(c.get(Calendar.DAY_OF_MONTH)) + "/" + String.valueOf(c.get(Calendar.YEAR));
//			_tvUserDOB.setTypeface(CGlobalVariables.tfFoEnglish);
        dateResult.setText(result_string+" (mm/dd/yyyy)");
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    @Override
    public void onResume() {
        super.onResume();
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        ActionBar actionBar = activity.getSupportActionBar();
        actionBar.setTitle("Educational Details");
        employee_registrationActivity. toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               employee_registrationActivity.finish();
               // Toast.makeText(getActivity().getApplicationContext(), "Back clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
