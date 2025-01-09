package twozo.io.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView logo = findViewById(R.id.logo);
        final TextView message = findViewById(R.id.message);
        final RelativeLayout twozoButton = findViewById(R.id.twozo_button);
        final TextView aboutView = findViewById(R.id.about);
        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.spin);

        setMessageContent(message);
        logo.startAnimation(animation);
        twozoButton.setOnClickListener(view -> navigateToWebView());
        aboutView.setOnClickListener(view -> startActivity(new Intent(this, AboutActivity.class)));
    }

    private void setMessageContent(final TextView message) {
        final String content = "The Only CRM You’ll Need to Manage Sales, Customers & More At the Lowest Price";
        final String targetContent = "Only CRM You’ll Need";
        final SpannableString spannableString = new SpannableString(content);
        final int startIndex = content.indexOf(targetContent);
        final int endIndex = startIndex + targetContent.length();

        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.theme_light_primary)),
                startIndex,
                endIndex,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );
        message.setText(spannableString);
    }

    private void navigateToWebView() {
        final String webUrl = getString(R.string.web_link);

        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(webUrl)));
    }
}