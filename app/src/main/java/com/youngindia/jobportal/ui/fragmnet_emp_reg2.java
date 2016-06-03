package com.youngindia.jobportal.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.youngindia.jobportal.R;

import java.io.File;

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
    EditText spinnervalue;
    PowerManager.WakeLock wakeLock;
    TextView tvFileName;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button btn_submit;
    Button btn_upload;
    private static final int PICK_FILE_REQUEST = 1;
    private static final String TAG = fragmnet_emp_reg2.class.getSimpleName();
    private String selectedFilePath;
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
        btn_upload=(Button)rootview.findViewById(R.id.btn_upload);
        tvFileName = (TextView) rootview.findViewById(R.id.tv_file_name);
        seekBar_experience= (SeekBar) rootview.findViewById(R.id.seekBar_Experience);
        textViewProgress = (TextView)rootview.findViewById(R.id.textProgress);
        spinnervalue=(EditText)rootview.findViewById(R.id.edit_experience);
        seekBar_expected_salry= (SeekBar) rootview.findViewById(R.id.seekBar_ExpectedSalary);
        textView_expectedSalry= (TextView)rootview.findViewById(R.id.textProgressSalry);
        String value = spinnervalue.getText().toString();
       // seekBar_experience.setOnSeekBarChangeListener(this);
btn_upload.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        showFileChooser();
    }
});
      /*  if(btn_upload.getText().toString().trim().equals("Resume Uploaded Sucessfully"))
        {
            btn_upload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openfile(selectedFilePath);
                }
            });

        }
        else if(btn_upload.getText().toString().trim().equals("Upload Resume"))
        {

            btn_upload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showFileChooser();
                }
            });
        }*/
        seekBar_experience.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                //---change the font size of the EditText---

                spinnervalue.setText(String.valueOf(progress));
            }
        });

        spinnervalue.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }



            @Override
            public void afterTextChanged(Editable s) {
                try {
                    //Update Seekbar value after entering a number
                    seekBar_experience.setProgress(Integer.parseInt(s.toString()));
                    spinnervalue.setSelection(spinnervalue.getText().length());

                } catch (Exception ex) {
                }
            }
        });
//        int progress = Integer.parseInt(value);

       // seekBar_expected_salry.setOnSeekBarChangeListener(this);

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
    private void showFileChooser() {


        Intent intent = new Intent();
        //sets the select file to all types of files
        intent.setType("*/*");
        //allows to select data and return it
        intent.setAction(Intent.ACTION_GET_CONTENT);
        //starts new activity to select file and return data
        startActivityForResult(Intent.createChooser(intent, "Choose File to Upload.."), PICK_FILE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == PICK_FILE_REQUEST) {
                if (data == null) {
                    //no data present
                    return;
                }

                PowerManager powerManager = (PowerManager) getActivity().getSystemService(getActivity().POWER_SERVICE);
                wakeLock = powerManager.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK, TAG);
                wakeLock.acquire();
                Uri selectedFileUri = data.getData();
                selectedFilePath = FilePath.getPath(getActivity(), selectedFileUri);
                Log.i(TAG, "Selected File Path:" + selectedFilePath);

                if (selectedFilePath != null && !selectedFilePath.equals("")) {
                    //tvFileName.setText(selectedFilePath);
                    btn_upload.setText("Resume Uploaded Sucessfully");
                    if(btn_upload.getText().toString().trim().equals("Resume Uploaded Sucessfully")) {
                        btn_upload.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                openfile(selectedFilePath);
                            }
                        });
                    }
                } else {
                    Toast.makeText(getActivity(), "Cannot upload file to server", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public  void openfile(final  String selectedFilePath)
    {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
        File file = new File(selectedFilePath);
        String extension = android.webkit.MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(file).toString());
        String mimetype = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
        if (extension.equalsIgnoreCase("") || mimetype == null) {
            // if there is no extension or there is no definite mimetype, still try to open the file
            intent.setDataAndType(Uri.fromFile(file), "text/*");
        } else {
            intent.setDataAndType(Uri.fromFile(file), mimetype);
        }
        // custom message for the intent
        //dialog.dismiss();
        startActivity(Intent.createChooser(intent, "Choose an Application:"));
    }
}
