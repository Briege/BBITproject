package strathmore.com.bbitbproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivitySignup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        Button btnSignup = (Button) findViewById(R.id.button_createaccount);

        final EditText Firstname = (EditText) findViewById(R.id.firstname);
        final EditText Lastname = (EditText) findViewById(R.id.lastname);
        final EditText Username = (EditText) findViewById(R.id.username);
        final EditText EmailAddress = (EditText) findViewById(R.id.email);
        final EditText PhoneNumber = (EditText) findViewById(R.id.phone);
        final EditText Password = (EditText) findViewById(R.id.password);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homepageintent = new Intent(ActivitySignup.this,  ActivityHome.class);

                homepageintent.putExtra("Firstname", Firstname.getText().toString());
                homepageintent.putExtra("Lastname", Lastname.getText().toString());
                homepageintent.putExtra("Username", Username.getText().toString());
                homepageintent.putExtra("EmailAddress", EmailAddress.getText().toString());
                homepageintent.putExtra("Phone", PhoneNumber.getText().toString());
                homepageintent.putExtra("Password", Password.getText().toString());
                startActivity(homepageintent);

            }

        });

    }

}
