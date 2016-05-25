package com.youngindia.jobportal.ui;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.Handler;
import android.os.Message;
import com.youngindia.jobportal.R;
import com.youngindia.jobportal.adapter.ImageAdapter;
import com.youngindia.jobportal.database.SessionManager;

import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link fragment_base.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link fragment_base#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_base extends android.support.v4.app.Fragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Employee_HomeActivity employee_homeActivity;
    public Integer[] mThumbIds = {
            R.drawable.job_status, R.drawable.job_recommended,
            R.drawable.job_update, R.drawable.job_find,
    };
    public String[]jobtype={"Job search","Job Recommended","New Jobs","Latest Jobs"};
    private OnFragmentInteractionListener mListener;
    SessionManager session;
    ProgressBar pb;
    TextView tv;
    int prg = 0;
    public fragment_base() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_base.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_base newInstance(String param1, String param2) {
        fragment_base fragment = new fragment_base();
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
        final View rootView = inflater.inflate(R.layout.fragment_fragment_base, container, false);
        TextView user_name = (TextView)rootView.findViewById(R.id.user_name);
        TextView user_qualification=(TextView)rootView.findViewById(R.id.user_qualification);
        session = new SessionManager(getActivity().getApplicationContext());
        HashMap<String, String> user1=session.getUsername();
        String username = user1.get(SessionManager.KEY_NAME);
        user_name.setText(username);
        pb = (ProgressBar) rootView.findViewById(R.id.pbId);
      tv = (TextView)rootView.findViewById(R.id.tvId);
         new Thread(myThread).start();
        final GridView gridview = (GridView)rootView.findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(employee_homeActivity,jobtype,mThumbIds));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if(position==0)
                {
                    Intent intent=new Intent(getActivity(),Search_Activity.class);
                    startActivity(intent);
                }
                else {
                    Intent intent=new Intent(getActivity(),User_jobdetails.class);
                    startActivity(intent);
                }
            }
        });
        return rootView;

    }
    private Runnable myThread = new Runnable()
    {
        @Override
        public void run()
        {
            while (prg < 60)
            {
                try
                {
                    hnd.sendMessage(hnd.obtainMessage());
                    Thread.sleep(60);
                }
                catch(InterruptedException e)
                {
                    Log.e("ERROR", "Thread was Interrupted");
                }
            }

            runOnUiThread(new Runnable() {
                public void run() {
                    tv.setText("Finished");
                }
            });
        }

        Handler hnd = new Handler()
        {
            @Override
            public void handleMessage(Message msg)
            {
                prg++;
                pb.setProgress(prg);

                String perc = String.valueOf(prg).toString();
                tv.setText(perc+"% Profile completed");
            }
        };
    };

    private void runOnUiThread(Runnable finished) {
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        employee_homeActivity = (Employee_HomeActivity)context;
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }


    public void onAttach(Activity activity) {
        super.onAttach(activity);
        employee_homeActivity=(Employee_HomeActivity) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
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
