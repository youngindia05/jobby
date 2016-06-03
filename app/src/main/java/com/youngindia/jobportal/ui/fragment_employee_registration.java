package com.youngindia.jobportal.ui;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.youngindia.jobportal.R;

import java.util.Calendar;

import static android.view.View.*;

public class fragment_employee_registration extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Employee_RegistrationActivity employee_registrationActivity;

    int mYear, mMonth, mDay;
    TextView tvDisplayDate;
    Calendar cal;
    EditText editText_Dob;
    DatePicker dpResult;
    Button btnChangeDate;
    Button nxtbtn;
    static final int DATE_DIALOG_ID = 999;

    fragment_qualification fragment_qualification;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private fragment_emp_regitin.OnFragmentInteractionListener mListener;

    public fragment_employee_registration() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_employee_registration.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_employee_registration newInstance(String param1, String param2) {
        fragment_employee_registration fragment = new fragment_employee_registration();
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
        View rootview = inflater.inflate(R.layout.fragment_employee_registration, container, false);

        nxtbtn= (Button) rootview.findViewById(R.id.nxtbtn);

        dpResult = (DatePicker) rootview.findViewById(R.id.dpResult);
        btnChangeDate = (Button) rootview.findViewById(R.id.btnChangeDate);

      nxtbtn.setOnClickListener(new View.OnClickListener(){


          @Override
          public void onClick(View v) {
              fragment_qualification=new fragment_qualification();
              FragmentTransaction fragmenttransaction = employee_registrationActivity.getSupportFragmentManager().beginTransaction();
              //   sScreen = getResources().getString(R.string.title_wall);
              fragmenttransaction.replace(R.id.frame_container1, fragment_qualification);
              fragmenttransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
              fragmenttransaction.addToBackStack( "tag1" ).commit();
          }
      });
        return rootview;
    }
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        employee_registrationActivity=(Employee_RegistrationActivity) activity;
    }


//

        // TODO: Rename method, update argument and hook met
//
//        editText_Dob = (EditText) rootview.findViewById(R.id.editText_dob);
//        setCurrentDateOnView();
//        addListenerOnButton();
//
//    }
//
//
//    public void setCurrentDateOnView() {
//        cal = Calendar.getInstance();
//        mDay = cal.get(Calendar.DAY_OF_MONTH);
//        mMonth = cal.get(Calendar.MONTH);
//        mYear = cal.get(Calendar.YEAR);
//
//
//        editText_Dob.setText(new StringBuilder()
//                // Month is 0 based, just add 1
//                .append(mMonth + 1).append("-").append(mDay).append("-")
//                .append(mYear).append(" "));
//
//        // set current date into datepicker
//        dpResult.init(mYear, mMonth, mDay, null);
//    }
//
//    public void addListenerOnButton() {
//
//
//
//        btnChangeDate.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//                showDialog(DATE_DIALOG_ID);
//
//            }
//
//        });
//
//    }
//
//    @Override
//    protected DatePickerDialog onCreateDialog(int id) {
//        switch (id) {
//            case DATE_DIALOG_ID:
//                // set date picker as current date
//                return new DatePickerDialog(this, datePickerListener, mYear, mMonth,
//                        mDay);
//        }
//        return null;
//    }
//
//    DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
//
//        @Override
//        public void onDateSet(DatePicker view, int selectedYear,
//                              int selectedMonth, int selectedDay) {
//            mYear = selectedYear;
//            mMonth = selectedMonth;
//            mDay = selectedDay;
//            // set selected date into textview
//            tvDisplayDate.setText(new StringBuilder().append(mMonth + 1)
//                    .append("-").append(mDay).append("-").append(mYear)
//                    .append(" "));
//
//            // set selected date into datepicker also
//            dpResult.init(mYear, mMonth, mDay, null);
//
//        }
//    };
//
//// Inflate the layout for this fragment
//return rootview;
//        }hod into UI event
//
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

    @Override



    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
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
