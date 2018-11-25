package magteam.itec.ro.magteam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.concurrent.TimeoutException;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread welcomeThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    sleep(3000);
                    findViewById(R.id.loadingPanel).setVisibility(View.GONE);
                } catch (Exception e) {

                } finally {

                    Intent i = new Intent(SplashActivity.this,
                            WelcomeActivity.class);
                    startActivity(i);
                    finish();
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                }
            }
        };
        welcomeThread.start();
    }
}
