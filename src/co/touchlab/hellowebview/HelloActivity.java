package co.touchlab.hellowebview;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;

public class HelloActivity extends Activity
{
    private WebView webView;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        webView = (WebView)findViewById(R.id.webView);
        webView.setBackgroundColor(Color.WHITE);
        webView.clearCache(true);
        // The URL below has the following meta tag, which disables WebView scaling:
        // <meta name="viewport" content="target-densitydpi=device-dpi" />
        webView.loadUrl("http://codinghero.ws/public/webview.html");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();

        if (webView != null)
        {
            ViewParent parent = webView.getParent();
            if (parent != null)
            {
                ViewGroup parentView = (ViewGroup)parent;
                parentView.removeView(webView);
            }
        }
    }
}
