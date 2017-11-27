package strathmore.com.bbitbproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        TextView Firstname = (TextView) findViewById(R.id.textView);
        TextView Lastname = (TextView) findViewById(R.id.textView2);
        TextView Username = (TextView) findViewById(R.id.textView3);
        TextView EmailAddress = (TextView) findViewById(R.id.textView4);
        TextView PhoneNumber = (TextView) findViewById(R.id.textView5);
        TextView Password = (TextView) findViewById(R.id.textView6);

        Intent intent = getIntent();
        String TextView_Firstname = intent.getStringExtra("Firstname");
        String TextView_Lastname = intent.getStringExtra("Lastname");
        String TextView_Username = intent.getStringExtra("Username");
        String TextView_EmailAddress = intent.getStringExtra("EmailAddress");
        String TextView_PhoneNumber = intent.getStringExtra("Phone");
        String TextView_Password = intent.getStringExtra("Password");
        

        Firstname.setText(TextView_Firstname);
        Lastname.setText(TextView_Lastname);
        Username.setText(TextView_Username);
        EmailAddress.setText(TextView_EmailAddress);
        PhoneNumber.setText(TextView_PhoneNumber);
        Password.setText(TextView_Password);



        Button BtnViewmap = (Button) findViewById(R.id.map);
        BtnViewmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signupintent = new Intent(ActivityHome.this, MapsActivity.class);
                startActivity(signupintent);
            }
        });



        }

}


