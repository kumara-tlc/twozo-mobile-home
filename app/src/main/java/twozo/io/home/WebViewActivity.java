package twozo.io.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view);
        final String url = getIntent().getStringExtra(getString(R.string.url));

        setupWebView(url);
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void setupWebView(final String url) {
        final WebView webView = findViewById(R.id.web_view);
        final WebSettings webSettings = webView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webView.loadUrl(url);
    }
}