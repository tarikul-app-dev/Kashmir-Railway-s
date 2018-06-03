package limited.it.planet.traintimingapp.activity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.TableLayout;
import android.webkit.WebViewClient;
import java.util.ArrayList;
import android.webkit.WebChromeClient;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import limited.it.planet.traintimingapp.R;
import limited.it.planet.traintimingapp.model.RailwayStation;
import limited.it.planet.traintimingapp.utill.FontCustomization;

import android.content.DialogInterface;

public class OnlineBookingActivity extends AppCompatActivity {
    Toolbar toolbar;
     String onlineURL = "https://kashmirrailways.in/";
     WebView webView;
    AlertDialog alertDialog;
    private ProgressDialog progressBar;
    TextView txvHead;
    FontCustomization fontCustomization;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_booking);
        toolbar = (Toolbar)findViewById(R.id.toolbar_online_booking);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        initViews();

    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void initViews(){
        txvHead = (TextView)findViewById(R.id.txv_head);
        webView = (WebView)findViewById(R.id.webview);
        progressBar = ProgressDialog.show(OnlineBookingActivity.this,
                getString(R.string.progress_please_wait), getString(R.string.progress_loading));
        progressBar.setCancelable(true);
        fontCustomization = new FontCustomization(OnlineBookingActivity.this);
        txvHead.setTypeface(fontCustomization.getTexgyreHerosBold());
        loadOnlineBooking();

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void loadOnlineBooking(){
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setAllowFileAccessFromFileURLs(true);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webView.clearCache(true);
        webView.clearHistory();
        webView.getSettings().setAllowContentAccess(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true); // enable javascript
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);

        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);

        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.setScrollbarFadingEnabled(false);
        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // Log.i(TAG, "Processing webview url click...");
                view.loadUrl(url);
                return true;
            }

            public void onPageFinished(WebView view, String url) {

                if (progressBar.isShowing()) {
                    progressBar.dismiss();

                }
            }
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                //  progressBar.isShowing();

            }
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                // Log.e(TAG, "Error: " + description);
                Toast.makeText(getApplicationContext(), "Oh no! " + description, Toast.LENGTH_SHORT).show();
                alertDialog.setTitle("Error");
                alertDialog.setMessage(description);
                alertDialog.setButton(DialogInterface.BUTTON_POSITIVE,
                        "OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                return;
                            }
                        });

                alertDialog.show();
            }
        });
        if(onlineURL.length()>0){
            webView.loadUrl(onlineURL);
        }
    }
}
