package com.afternoonified.afternoonified;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:" + "ahauntedswan@gmail.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Afternoonified email");
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        WebView myWebView = findViewById(R.id.webview);
        myWebView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setSupportMultipleWindows(true);
       // myWebView.requestFocus(View.FOCUS_DOWN);
        //myWebView.setWebViewClient(new WebViewClient(){
        //    @Override
        //    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        //        return super.shouldOverrideUrlLoading(view, request);
        //    }
        //});

        if (id == R.id.instagram_url) {
            myWebView.loadUrl("https://www.instagram.com/shopafternoonified/");
            return true;
        }
        else if (id == R.id.etsy) {
            myWebView.loadUrl("https://m.etsy.com/shop/shopafternoonified");
            return true;
        }
        else if (id == R.id.instagram_url2) {
            myWebView.loadUrl("https://www.instagram.com/ahauntedswan");
            return true;
        }
        else if (id == R.id.twitter) {
            myWebView.loadUrl("https://mobile.twitter.com/ahauntedswan");
            return true;
        }
        else if (id == R.id.kc) {
            myWebView.loadUrl("https://www.katecatalina.com");
            return true;
        }
        else if (id == R.id.exit) {
            android.os.Process.killProcess(android.os.Process.myPid());
        }

        return super.onOptionsItemSelected(item);
    }
}