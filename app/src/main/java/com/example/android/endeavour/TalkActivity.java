package com.example.android.endeavour;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

public class TalkActivity extends AppCompatActivity
{
    Toolbar myToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talk);

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        ActionBar ab = getSupportActionBar();
        // ab.setDisplayHomeAsUpEnabled(true);
        myToolbar.setNavigationIcon(R.drawable.backspace_white);
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        WebView webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl("http://google.com");
    }
}
