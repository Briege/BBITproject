package strathmore.com.bbitbproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;


public class LoginActivity extends AppCompatActivity {
    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        callbackManager = CallbackManager.Factory.create();
        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("email");
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });

        Button BtnSignup = (Button) findViewById(R.id.signup);
        BtnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signupintent = new Intent(LoginActivity.this, ActivitySignup.class);
                startActivity(signupintent);
            }
        });

        Button BtnLogin = (Button) findViewById(R.id.login);
        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginintent = new Intent(LoginActivity.this, ActivityHome.class);
                startActivity(loginintent);
            }

            EditText Username = (EditText) findViewById(R.id.username);
            EditText Password = (EditText) findViewById(R.id.password);

        });
    }

        protected void onActivityResult(final int requestCode,final int resultCode, final Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }

        protected void getUserDetails(LoginResult loginResult){
            GraphRequest data_request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback(){
                public void onCompleted(JSONObject json_object, GraphResponse response){
                    Intent intent = new Intent(LoginActivity.this,UserProfile.class);
                    intent.putExtra("userProfile", json_object.toString());
                }
            });

            Bundle permission_param = new Bundle();
            permission_param.putString("fields", "id,name,emailpicture.width(120).height(120)");
            data_request.setParameters(permission_param);
            data_request.executeAsync();
        }

    }






