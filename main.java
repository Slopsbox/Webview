package ;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.annotation.SuppressLint;
import android.app.Activity;

public class Main extends Activity {
	
	private static final String TAG="dalane";
	
	private WebView MainWebview;
	
	private ProgressBar progressBar;

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		progressBar = (ProgressBar) findViewById(R.id.progressBar);
		Log.i(TAG, "onCreate");
		MainWebview = (WebView) findViewById(R.id.webView);
		MainWebview.getSettings().setJavaScriptEnabled(true);
		MainWebview.getSettings().setBuiltInZoomControls(true);
		MainWebview.getSettings().setSupportZoom(true);
		MainWebview.getSettings().setSaveFormData(true);
		MainWebview.getSettings().setSavePassword(true);
		MainWebview.loadUrl("DIN-url");
		MainWebview.setWebViewClient(new WebViewerClient());
		
	}
	
	@Override
	public void onBackPressed() {
		if (MainWebview.canGoBack())
			MainWebview.goBack();
		else
			super.onBackPressed();
			}
	
	private class WebViewerClient extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView weWebView, String url) {
			weWebView.loadUrl(url);
			progressBar.setVisibility(View.VISIBLE);
			return true;
		}
		
		@Override
		public void onPageFinished(WebView view, String url) {
			super.onPageFinished(view, url);
			progressBar.setVisibility(View.GONE);
		}
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		Log.i(TAG, "onStart");
	}
	
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.i(TAG, "onRestart");
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		Log.i(TAG, "onPause");
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		Log.i(TAG, "onResume");
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i(TAG, "onDestroy");
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		Log.i(TAG, "onStop");
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		MainWebview.saveState(outState);
		Log.i(TAG,"onSaveInstanceState");
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle saveInstanceState) {
		super.onRestoreInstanceState(saveInstanceState);
		MainWebview.restoreState(saveInstanceState);
		Log.i(TAG, "onRestoreInstanceState");
	}


}
