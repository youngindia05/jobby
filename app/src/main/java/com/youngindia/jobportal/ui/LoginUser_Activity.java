package com.youngindia.jobportal.ui;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.youngindia.jobportal.R;
import com.youngindia.jobportal.adapter.Dialog_Advertisement;
import com.youngindia.jobportal.database.SessionManager;
import com.youngindia.jobportal.database.SqliteHandler;
import com.youngindia.jobportal.model.DefaultDialog;
import com.youngindia.jobportal.ui.app.AppConfig;
import com.youngindia.jobportal.ui.app.AppController;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import info.hoang8f.android.segmented.SegmentedGroup;

public class LoginUser_Activity extends AppCompatActivity {
    private ProgressDialog pDialog;
    private SessionManager session;
    private SqliteHandler db;
    EditText edt_username,edt_password;
    Button btn_Login;
    String status="Iscandidat";
    AppController mInstance;
    SegmentedGroup segmented2;
    TextView txt_forgetpsw,txt_registration;
    int SPLASH_TIME_OUT=5000;
    private static final String TAG = LoginUser_Activity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user_);
        edt_username=(EditText)findViewById(R.id.edt_username);
        edt_password=(EditText)findViewById(R.id.edt_password);
        btn_Login=(Button) findViewById(R.id.btn_login);
        pDialog=new ProgressDialog(this);
        mInstance=new AppController();
        segmented2 = (SegmentedGroup)findViewById(R.id.segmented2);
        txt_forgetpsw=(TextView) findViewById(R.id.txt_forget_psw);
        txt_registration=(TextView) findViewById(R.id.txt_newuserregistraation);
        Dialog_Advertisement showAdvertisment=new Dialog_Advertisement();
        showAdvertisment.showDialog(this,"I am happy.",R.drawable.profile_pic);
        txt_forgetpsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DefaultDialog dialog =new DefaultDialog();
                dialog.showDialog(LoginUser_Activity.this,"Please Enter your mobile number here to get new credentials.");
            }
        });
        segmented2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.button21) {
                    status="Iscandidat";
                    edt_username.setText("");
                    edt_password.setText("");
                    txt_registration.setText("New User Registration Here!!!!");
                }else
                {
                    status="Iscompany";
                    edt_username.setText("");
                    edt_password.setText("");
                    txt_registration.setText("New Employer/Company Registration Here!!!!");
                }
                if (checkedId==R.id.button33)
                {
                    status="Isdailywager";
                    Intent intent = new Intent(LoginUser_Activity.this, DailyWagesRegstr.class);
                    startActivity(intent);

                }
                if (checkedId==R.id.button44)
                {
                    status="IsFranchis";
                    edt_username.setText("");
                    edt_password.setText("");
                    txt_registration.setText("");
                }
            }
        });

        // SQLite database handler
        db = new SqliteHandler(getApplicationContext());

        // Session manager
        session = new SessionManager(getApplicationContext());
        // Check if user is already logged in or not
        if (session.isLoggedIn()) {
            // User is already logged in. Take him to main activity
            Intent intent = new Intent(LoginUser_Activity.this, Employee_HomeActivity.class);
            startActivity(intent);
            finish();
        }


        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edt_username.getText().toString();
                String password = edt_password.getText().toString();

                // Check for empty data in the form
                if (!username.isEmpty() && !password.isEmpty()) {
                    if(isNetworkAvailable()==true){checkLogin(username,password,status);}
                    else {Toast.makeText(getApplicationContext(),
                            "Please check the Internet Connection!", Toast.LENGTH_LONG)
                            .show();}
                } else {
                    // Prompt user to enter credentials

                    Toast.makeText(getApplicationContext(),
                            "Please enter the credentials!", Toast.LENGTH_LONG)
                            .show();
                }


            }
        });
    }

    private void checkLogin(final String username, final String password,final String status) {
        // Tag used to cancel the request
        String tag_string_req = "req_login";

        pDialog.setMessage("Logging in ...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_LOGIN, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Login Response: " + response.toString());
                hideDialog();

                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");

                    // Check for error node in json
                    if (!error) {
//                         user successfully logged in
//                         Create login session
                       // session.setLogin(true);

//                        // Now store the user in SQLite
//                        String uid = jObj.optString("uid");
//
//                        JSONObject user = jObj.getJSONObject("user");
//                        String name = user.optString("name");
//                        String email = user.optString("email");
//                        String created_at = user
//                                .optString("created_at");
//
//                        // Inserting row in users table
//                        db.addUser(name, email,password, uid, created_at);

                         //Launch main activity
                        String value=jObj.getString("status");
                        if(status.equals("Iscandidat")) {
                            String username=jObj.getString("username");
                            session.storeuser(username);
                            Intent intent = new Intent(LoginUser_Activity.this,
                                    Employee_RegistrationActivity.class);
                            startActivity(intent);

                        }
                        else
                        {
                            Intent intent = new Intent(LoginUser_Activity.this,
                                    Company_Base.class);
                            startActivity(intent);

                        }
                        if(status.equals("IsFranchis"))
                        {
                            Intent intent = new Intent(LoginUser_Activity.this,
                                    Franchise_Activity.class);
                            startActivity(intent);
                            finish();
                        }
                    } else {
                        // Error in login. Get the error message
                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }

                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Json error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Login Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", username);
                params.put("password", password);
                params.put("status", status);
                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq,tag_string_req);

    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
        pDialog.dismiss();
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
