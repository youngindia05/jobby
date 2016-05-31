package com.youngindia.jobportal.ui;

import android.app.Activity;
import android.app.ProgressDialog;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
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
public class fragment_emp_regitin extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Employee_RegistrationActivity employee_registrationActivity;
    private static final String TAG = fragment_emp_regitin.class.getSimpleName();
    Button nxtbtn;
    Spinner spinner_industry;
    TextView edt_other;
    private EditText HighestEducation,Specialization,University,PassedYear;
    private Spinner Location,Industry;
    private ProgressDialog pDialog;
    AppController mInstance;
    AppConfig mappconfig;
    SessionManager session;


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
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.fragment_fragment_emp_regitin, container, false);

        HighestEducation = (EditText)rootview.findViewById(R.id.hightEducation_ED);
        Specialization= (EditText) rootview.findViewById(R.id.specilization_ED);
        University = (EditText) rootview.findViewById(R.id.university_ED);
        PassedYear = (EditText)rootview.findViewById(R.id.year_ED);
        Location=(Spinner)rootview.findViewById(R.id.spinner_location);

        Industry=(Spinner)rootview.findViewById(R.id.spinner_Industry);

        pDialog = new ProgressDialog(getActivity());
        pDialog.setCancelable(false);
        mInstance=new AppController();
        mappconfig=new AppConfig();

        spinner_industry=(Spinner)rootview.findViewById(R.id.spinner_Industry);

        edt_other=(TextView)rootview.findViewById(R.id.edt_others);
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
                        default:edt_other.setVisibility(View.GONE);

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


        nxtbtn=(Button)rootview.findViewById(R.id.btn);
        nxtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String highEducation = HighestEducation.getText().toString().trim();
                String specialization = Specialization.getText().toString().trim();
                String university = University.getText().toString().trim();
                String passedYear = PassedYear.getText().toString().trim();
                String location=Location.getSelectedItem().toString().trim();
                String industry=Industry.getSelectedItem().toString().trim();
                session = new SessionManager(getActivity().getApplicationContext());
                HashMap<String, String> user1=session.getUsername();
                String username = user1.get(SessionManager.KEY_NAME);
                if (!highEducation.isEmpty() && !specialization.isEmpty() && !university.isEmpty() && !passedYear.isEmpty()
                        && !location.isEmpty() && !industry.isEmpty() && !username.isEmpty()) {

                    registerUser(highEducation, specialization, university, passedYear,location,industry,username);
                } else {
                    Toast.makeText(getActivity().getApplicationContext(),
                            "Please enter your details!", Toast.LENGTH_LONG)
                            .show();
                }
              /*  fragmnet_emp_reg2 fragmnet_emp_reg2=new fragmnet_emp_reg2();

                FragmentTransaction fragmenttransaction = employee_registrationActivity.getSupportFragmentManager().beginTransaction();
                //   sScreen = getResources().getString(R.string.title_wall);
                fragmenttransaction.replace(R.id.frame_container1, fragmnet_emp_reg2);
                fragmenttransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fragmenttransaction.addToBackStack( "tag" ).commit();*/
            }
        });
        // Inflate the layout for this fragment
        return rootview;
    }
    private void registerUser(final String highEducation, final String specialization,
                              final String university,final String passedyear,final String location,final  String industry,final  String username) {
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
                        fragmenttransaction.addToBackStack( "tag" ).commit();
                        Toast.makeText(getActivity().getApplicationContext(), "User details successfully stored" , Toast.LENGTH_LONG).show();

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
                params.put("passedyear",passedyear);
                params.put("location",location);
                params.put("industry",industry);



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
               //
            }
        });
    }
}
