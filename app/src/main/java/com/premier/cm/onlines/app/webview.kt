package com.premier.cm.onlines.app

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.core.view.isVisible

class webview : AppCompatActivity() {
    lateinit var webview:WebView
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
         webview=findViewById(R.id.web)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#17B169")))
        val progress:ProgressBar=findViewById(R.id.bar1)

        webview.loadUrl("http://www.erdad.XYZ")
        webview.settings.javaScriptEnabled=true
         var counter:Int
        webview.webViewClient=object:WebViewClient(){

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                counter=1
                view?.isVisible=false
                progress.isVisible=true

                Thread(Runnable {

                    while(counter<=100){
                    counter=counter+12
                        runOnUiThread{
                            progress.setProgress(counter)
                        }
                        Thread.sleep(1000)
                    }
                }).start()
                super.onPageStarted(view, url, favicon)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                counter=0
                view?.isVisible=true
                progress.isVisible=false
                super.onPageFinished(view, url)
            }
        }

    }

    override fun onBackPressed() {

        if(webview.canGoBack()){
            webview.goBack()
        }
        else{
            super.onBackPressed()
        }

    }
}