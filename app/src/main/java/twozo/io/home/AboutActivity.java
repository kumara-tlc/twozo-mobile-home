package twozo.io.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        final TextView termsCondition = findViewById(R.id.condition);
        final TextView privacyPolicy = findViewById(R.id.policy);
        final ImageButton backOption = findViewById(R.id.back);

        backOption.setOnClickListener(view -> finish());
        termsCondition.setOnClickListener(view -> navigateToWebView(getString(R.string.conditions_link)));
        privacyPolicy.setOnClickListener(view -> navigateToWebView(getString(R.string.policy_link)));
    }

    private void navigateToWebView(final String url) {
        final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

        startActivity(intent);
    }
}