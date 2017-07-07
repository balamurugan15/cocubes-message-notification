package com.balamurugan.cocubesmessagenotification;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class WebViewActivity extends AppCompatActivity {

    private ProgressBar progress;
    String cookie;

    WebView webview;

    String loginUrl = "https://www.cocubes.com/authentication/loginpage.aspx";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
/*
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // toolbar.setNavigationIcon(R.drawable.ic_chevron_left_white_36dp);
       /*// getSupportActionBar().setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });*/


        setTitle("CoCubes Login");

        progress = (ProgressBar) findViewById(R.id.progressBar);
        progress.setMax(100);

        webview = (WebView) findViewById(R.id.webpage);
        webview.setWebChromeClient(new MyWebViewClient());
        webview.getSettings().setBuiltInZoomControls(true);

        try{
            webview.getSettings().setJavaScriptEnabled(true);
            webview.loadUrl(loginUrl);
            webview.setWebViewClient(new DisPlayWebPageActivityClient());

            WebViewActivity.this.progress.setProgress(0);
        }
        catch(Exception e){
           // setContentView(R.layout.no_internet);
        }

    }


    @Override
    public void onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack();
        }
        setResult(Activity.RESULT_CANCELED);
        finish();
    }

    private class DisPlayWebPageActivityClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            if(url.contains("cocubes.com/student/home.aspx")) {
                SharedPreferences pref3 = getSharedPreferences(Constants.PREFERENCE_NAME, 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref3.edit();
                cookie = CookieManager.getInstance().getCookie(url);
                editor.putString(Constants.PREFERENCE_TAG, CookieManager.getInstance().getCookie(url));
                editor.apply();
                setResult(Activity.RESULT_OK);
                finish();
            }

            return false;
        }


       /* @Override
        public void onPageFinished(WebView view, String url){
        }*/
    }

    private class MyWebViewClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            WebViewActivity.this.setValue(newProgress);
            super.onProgressChanged(view, newProgress);
        }

    }

    public void setValue(int progress) {
      //  this.progress.setProgress(progress);
        if(progress > 70)
            this.progress.setVisibility(View.GONE);
    }
}