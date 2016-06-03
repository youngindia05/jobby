package com.youngindia.jobportal.ui;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
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
import android.widget.AdapterView;
import android.widget.Button;

import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.youngindia.jobportal.R;

import com.youngindia.jobportal.database.SessionManager;
import com.youngindia.jobportal.ui.app.AppConfig;
import com.youngindia.jobportal.ui.app.AppController;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link fragment_emp_regitin.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link fragment_emp_regitin#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_emp_regitin extends Fragment implements SeekBar.OnSeekBarChangeListener{    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Employee_RegistrationActivity employee_registrationActivity;
    private final String TAG = fragment_emp_regitin.class.getSimpleName();
    Button nxtbtn;
    Spinner spinner_industry;
    EditText edt_other;
    private EditText HighestEducation, Specialization, University;
    private Spinner Location, Industry, PassedYear;
    private ProgressDialog pDialog;
    AppController mInstance;
    AppConfig mappconfig;
    SessionManager session;
    private TextView tvDisplayDate;
    private DatePicker dpResult;
    private Button btnChangeDate;

    private int year;
    private int month;
    private int day;

    static final int DATE_DIALOG_ID = 999;

    SeekBar seekBar_experience, seekBar_expected_salry;
    TextView textViewProgress, textView_expectedSalry;
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
    public fragment_emp_regitin newInstance(String param1, String param2) {
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
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_fragment_emp_regitin, container, false);
        ////

        tvDisplayDate = (TextView)rootview.findViewById(R.id.tvDate);
       // dpResult = (DatePicker)rootview.findViewById(R.id.dpResult);

        tvDisplayDate = (TextView) rootview.findViewById(R.id.tvDate);
        dpResult = (DatePicker) rootview.findViewById(R.id.dpResult);


        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

//        // set current date into textview
        tvDisplayDate.setText(new StringBuilder()
                // Month is 0 based, just add 1
                .append(month + 1).append("-").append(day).append("-")
                .append(year).append(" "));
        btnChangeDate = (Button) rootview.findViewById(R.id.btnChangeDate);

        btnChangeDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                DatePickerDialog datepicker = new DatePickerDialog(getContext(), datePickerListener,
                        year, month, day);

                datepicker.show();
            }

        });
        // set current date into datepicker
//        dpResult.init(year, month, day, null);
        ////
//        HighestEducation = (EditText) rootview.findViewById(R.id.hightEducation_ED);
//        Specialization = (EditText) rootview.findViewById(R.id.specilization_ED);
//        University = (EditText) rootview.findViewById(R.id.university_ED);
//        PassedYear = (Spinner) rootview.findViewById(R.id.spinner_yearOFpassed);
        Location = (Spinner) rootview.findViewById(R.id.spinner_location);

        Industry = (Spinner) rootview.findViewById(R.id.spinner_Industry);

        pDialog = new ProgressDialog(getActivity());
        pDialog.setCancelable(false);
        mInstance = new AppController();
        mappconfig = new AppConfig();

        spinner_industry = (Spinner) rootview.findViewById(R.id.spinner_Industry);

        edt_other = (EditText) rootview.findViewById(R.id.edt_others);
        //  spinner_industry.setSelection(11);
        // spinner_industry.setSelection((ArrayAdapter)spinner_industry.getAdapter()("Category 2"));

        spinner_industry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                {
                    switch (position) {
                        case 11:
                            edt_other.setVisibility(View.VISIBLE);
                            //Toast.makeText(getActivity().getApplicationContext(),"hi",Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            edt_other.setVisibility(View.GONE);

                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
       /* if(spinner_industry.getSelectedItem().equals("Others"))
        {
            edt_other.setVisibility(View.VISIBLE);
        }*/

        seekBar_expected_salry = (SeekBar) rootview.findViewById(R.id.seekBar_ExpectedSalary);
        textView_expectedSalry = (TextView) rootview.findViewById(R.id.textProgressSalry);

        seekBar_experience = (SeekBar) rootview.findViewById(R.id.seekBar_Experience);
        seekBar_experience.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener) this);
        seekBar_expected_salry.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener) this);
        textViewProgress = (TextView) rootview.findViewById(R.id.textProgress);

        nxtbtn = (Button) rootview.findViewById(R.id.btn);
        nxtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String highEducation = HighestEducation.getText().toString().trim();
                String specialization = Specialization.getText().toString().trim();
                String university = University.getText().toString().trim();
                String passedYear = PassedYear.getSelectedItem().toString().trim();
                String location=Location.getSelectedItem().toString().trim();
                String industry=Industry.getSelectedItem().toString().trim();
                session = new SessionManager(getActivity().getApplicationContext());
                HashMap<String, String> user1=session.getUsername();
                String username = user1.get(SessionManager.KEY_NAME);
              /*  if (!highEducation.isEmpty() && !specialization.isEmpty() && !university.isEmpty() && !passedYear.isEmpty()
                        && !location.isEmpty() && !industry.isEmpty() && !username.isEmpty()) {

                    registerUser(highEducation, specialization, university, passedYear,location,industry,username);
                } else {
                    Toast.makeText(getActivity().getApplicationContext(),
                            "Please enter your details!", Toast.LENGTH_LONG)
                            .show();

                }*/

                fragmnet_emp_reg2 fragmnet_emp_reg2=new fragmnet_emp_reg2();
=======
//                String highEducation = HighestEducation.getText().toString().trim();
//                String specialization = Specialization.getText().toString().trim();
//                String university = University.getText().toString().trim();
//                String passedYear = PassedYear.getSelectedItem().toString().trim();
//                String location = Location.getSelectedItem().toString().trim();
//                String industry = Industry.getSelectedItem().toString().trim();
//                session = new SessionManager(getActivity().getApplicationContext());
//                HashMap<String, String> user1 = session.getUsername();
//                String username = user1.get(SessionManager.KEY_NAME);
//                if (!highEducation.isEmpty() && !specialization.isEmpty() && !university.isEmpty() && !passedYear.isEmpty()
//                        && !location.isEmpty() && !industry.isEmpty() && !username.isEmpty()) {
//
//                    registerUser(highEducation, specialization, university, passedYear, location, industry, username);
//                } else {
//                    Toast.makeText(getActivity().getApplicationContext(),
//                            "Please enter your details!", Toast.LENGTH_LONG)
//                            .show();
//                }
                fragmnet_emp_reg2 fragmnet_emp_reg2 = new fragmnet_emp_reg2();


                FragmentTransaction fragmenttransaction = employee_registrationActivity.getSupportFragmentManager().beginTransaction();
                //   sScreen = getResources().getString(R.string.title_wall);
                fragmenttransaction.replace(R.id.frame_container1, fragmnet_emp_reg2);
                fragmenttransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fragmenttransaction.addToBackStack("tag0").commit();
            }
        });
        // Inflate the layout for this fragment
        return rootview;

}

    }


    private void registerUser(final String highEducation, final String specialization,
                              final String university, final String passedyear, final String location, final String industry, final String username) {
        // Tag used to cancel the request
        String tag_string_req = "req_register";

        pDialog.setMessage("Registering ...");

        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_USERDETAIL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Register Response: " + response.toString());

                try {
                    JSONObject jObj = null;
                    try {
                        jObj = new JSONObject(response);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    boolean error = jObj.getBoolean("error");
                    if (!error) {

                        fragmnet_emp_reg2 fragmnet_emp_reg2 = new fragmnet_emp_reg2();

                        FragmentTransaction fragmenttransaction = employee_registrationActivity.getSupportFragmentManager().beginTransaction();
                        //   sScreen = getResources().getString(R.string.title_wall);
                        fragmenttransaction.replace(R.id.frame_container1, fragmnet_emp_reg2);
                        fragmenttransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        fragmenttransaction.addToBackStack("tag").commit();
                        Toast.makeText(getActivity().getApplicationContext(), "User details successfully stored", Toast.LENGTH_LONG).show();

                    } else {

                        // Error occurred in registration. Get the error
                        // message
                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getActivity().getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Registration Error: " + error.getMessage());
                Toast.makeText(getActivity().getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                // hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", username);
                params.put("highEducation", highEducation);
                params.put("specialization", specialization);
                params.put("university", university);
                params.put("passedyear", passedyear);
                params.put("location", location);
                params.put("industry", industry);


                return params;
            }

        };

        // Adding request to request queue
        mInstance.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        employee_registrationActivity = (Employee_RegistrationActivity) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (seekBar == seekBar_experience) {
            textViewProgress.setText("Your Experience is :  " + progress);
        } else {
            textView_expectedSalry.setText("Your Expected Salary is:" + progress);
        }

    }

    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        seekBar.setSecondaryProgress(seekBar.getProgress());

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    // display current date
    public void setCurrentDateOnView() {


    }


    private DatePickerDialog.OnDateSetListener datePickerListener
            = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            year = selectedYear;
            month = selectedMonth;
            day = selectedDay;

            // set selected date into textview
            tvDisplayDate.setText(new StringBuilder().append(month + 1)
                    .append("-").append(day).append("-").append(year)
                    .append(" "));

        }
    };

    @Override
    public void onResume() {
        super.onResume();
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        ActionBar actionBar = activity.getSupportActionBar();
        actionBar.setTitle("Educational Details");
        employee_registrationActivity.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                employee_registrationActivity.finish();
                //
            }
        });
    }
}
