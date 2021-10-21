package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient()); //without this line, it will load this web page in external browser
        webView.loadUrl("https://developer.android.com/studio");

        WebSettings webSettings = webView.getSettings();  //thay doi cai dat webview
        webSettings.setJavaScriptEnabled(true);  //cho phép WebView thực thi mã JavaScript trong trường hợp website sử dụng javascript
    }
    //when back button is pressed will exit the app
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {  //kiem tra trang web co the quay lai lich su hay khong
            webView.goBack();  //tro ve trang cuoi cung
        } else {
            super.onBackPressed();   //exit app
        }
    }

}