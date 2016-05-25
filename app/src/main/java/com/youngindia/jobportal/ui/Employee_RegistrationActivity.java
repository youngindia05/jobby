package com.youngindia.jobportal.ui;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.youngindia.jobportal.R;

public class Employee_RegistrationActivity extends AppCompatActivity {
Button btn_save;
    fragment_emp_regitin fragment_emp_regitin1;
    fragmnet_emp_reg2 fragmnet_emp_reg2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee__registration);
//        btn_save=(Button)findViewById(R.id.btn_save);
//        btn_save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =new Intent(Employee_RegistrationActivity.this,Employee_HomeActivity.class);
//                startActivity(intent);
//            }
//        });
        fragmnet_emp_reg2=new fragmnet_emp_reg2();
        fragment_emp_regitin1=new fragment_emp_regitin();;
        FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
        //   sScreen = getResources().getString(R.string.title_wall);
        fragmenttransaction.replace(R.id.frame_container1, fragment_emp_regitin1);
        fragmenttransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmenttransaction.commit();
    }
}
