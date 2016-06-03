package com.youngindia.jobportal.ui;

import android.app.Fragment;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import com.youngindia.jobportal.R;

public class Employee_RegistrationActivity extends AppCompatActivity {
    Button btn_save;
    fragment_emp_regitin fragment_emp_regitin1;
    fragmnet_emp_reg2 fragmnet_emp_reg2;
    fragment_employee_registration fragment_employee_registration;
    Toolbar toolbar;
    private final static String FRAGMENT_TAG = "FRAGMENTB_TAG";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee__registration);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.toolbar_backbtn);

        setSupportActionBar(toolbar);

       /* toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext()  , "Back clicked!",     Toast.LENGTH_SHORT).show();
            }
        });*/

//        btn_save=(Button)findViewById(R.id.btn_save);
//        btn_save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =new Intent(Employee_RegistrationActivity.this,Employee_HomeActivity.class);
//                startActivity(intent);
//            }
//        });
        fragmnet_emp_reg2 = new fragmnet_emp_reg2();
        fragment_emp_regitin1 = new fragment_emp_regitin();

        fragment_employee_registration=new fragment_employee_registration();


        FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
        //   sScreen = getResources().getString(R.string.title_wall);
        fragmenttransaction.replace(R.id.frame_container1,fragment_employee_registration, FRAGMENT_TAG);
     /*   MyFragment myFragment = (MyFragment)getFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        if (myFragment != null && myFragment.isVisible()) {
            // add your code here
        }*/
        fragmenttransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmenttransaction.addToBackStack(null);

        //Fragment currentFragment = getActivity().getFragmentManager().findFragmentById(R.id.fragment_container);
        // fragmenttransaction.addToBackStack(FRAGMENT_TAG);
        /*android.support.v4.app.FragmentManager fm = Employee_RegistrationActivity.this.getSupportFragmentManager();
String currentFragmentTag = fm.getBackStackEntryAt(fm.getBackStackEntryCount() - 1).getName();
        getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG);*/
        //   android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        //      String currentFragmentTag = fm.getBackStackEntryAt(fm.getBackStackEntryCount() - 1).getName();*/
        //  Toast.makeText(getApplicationContext(),"currentFragment" +S1,Toast.LENGTH_SHORT).show();
        //List Fragments = getSupportFragmentManager().getFragments();
        // mCurrentFragment = Fragments.get(Fragments.size() - 1);
//        if()
//        {
//            toolbar.setNavigationOnClickListener(new View.OnClickListener(){
//                @Override
//                public void onClick(View view) {
//                    Toast.makeText(getApplicationContext()  , "Back clicked!",     Toast.LENGTH_SHORT).show();
//                }
//            });
//        }
        fragmenttransaction.commit();

       /*android.support.v4.app.Fragment S1 =getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        getSupportFragmentManager().findFragmentByTag("firstfragment");
        Fragment currentFragment = getFragmentManager().findFragmentById(R.id.frame_container1);*/
      /*  getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.Fragment currentFragment = fragmentManager.findFragmentById(R.id.frame_container1);*/
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

    }





}
