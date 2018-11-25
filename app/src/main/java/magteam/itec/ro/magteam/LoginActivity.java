package magteam.itec.ro.magteam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText mUserEt;
    EditText mPassEt;
    Button mLoginBtn;
    View loginCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUserEt = (EditText) findViewById(R.id.emailEt);
        mPassEt = (EditText) findViewById(R.id.passEt);
        loginCardView = (View) findViewById(R.id.loginCardView);
        mLoginBtn = (Button) loginCardView.findViewById(R.id.loginBtn);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, MapsActivity.class);
                startActivity(i);
                finish();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

    }
}
