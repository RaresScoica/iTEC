package magteam.itec.ro.magteam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    EditText nameText = null;
    EditText emailText = null;
    EditText passwordText = null;
    EditText repeatedPasswordText = null;
    Button mLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        nameText = findViewById(R.id.nameET);
        emailText = findViewById(R.id.emailEt);
        passwordText = findViewById(R.id.passEt);
        repeatedPasswordText = findViewById(R.id.confirmpassET);

        mLoginBtn = findViewById(R.id.loginBtn);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignupActivity.this, MapsActivity.class);
                startActivity(i);
                finish();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }
    public void CreateUser(View view) {
        if (nameText.getText().toString().trim().equals("") ||
                emailText.getText().toString().trim().equals("") ||
                passwordText.getText().toString().trim().equals("") ||
                repeatedPasswordText.getText().toString().trim().equals("")) {
            Toast.makeText(SignupActivity.this, "All the fields are mandatory",
                    Toast.LENGTH_LONG).show();
            return;
        }
        if (passwordText.getText().toString().length() < 3) {
            Toast.makeText(SignupActivity.this,
                    "Password should be at least 3 characters long",
                    Toast.LENGTH_LONG).show();
            return;
        }

        if (!passwordText.getText().toString().equals(repeatedPasswordText.getText().toString())) {
            Toast.makeText(SignupActivity.this, "Passwords are not the same",
                    Toast.LENGTH_LONG).show();
            return;
        }
    }
}
