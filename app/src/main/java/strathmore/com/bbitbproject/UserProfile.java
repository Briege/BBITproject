package strathmore.com.bbitbproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONObject;

/**
 * Created by Briege on 11/25/2017.
 */

public class UserProfile extends AppCompatActivity {
    JSONObject response, profile_pic_data, profile_pic_url;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userprofile);
        Intent intent = getIntent();
        String jsondata = intent.getStringExtra("userProfile");
        Log.w("Jsondata" , jsondata);
        TextView user_name = (TextView) findViewById(R.id.Username);
        ImageView user_picture = (ImageView) findViewById(R.id.profilePic);
        TextView user_email = (TextView) findViewById(R.id.email);
        try{
            response = new JSONObject(jsondata);
            user_email.setText(response.get("email").toString());
            user_name.setText(response.get("name").toString());
            profile_pic_data = new JSONObject(response.get("picture").toString());
            profile_pic_url = new JSONObject(profile_pic_data.getString("data"));
            Picasso.with(this).load(profile_pic_url.getString("url")).into(user_picture);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
