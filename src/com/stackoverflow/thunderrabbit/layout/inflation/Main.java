package com.stackoverflow.thunderrabbit.layout.inflation;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class Main extends Activity {
	private final String TAG = this.getClass().getSimpleName();

	private Context mContext;
	private MainStart mMainStart;
	private RelativeLayout mMainTop;
	private MainCountdown mMainCountdown;
	private MainLast mMainLast;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		mContext = getBaseContext();

		// Create three custom classes that will have their own layouts
		// and need to call this parent class when they've finished their work.
		mMainStart = new MainStart(mContext);
		mMainStart.whoIsMyDaddy(this);

		mMainCountdown = new MainCountdown(mContext);
		mMainCountdown.whoIsMyDaddy(this);

		mMainLast = new MainLast(mContext);
		mMainLast.whoIsMyDaddy(this);

		mMainTop = (RelativeLayout) findViewById(R.id.root_main);
		addViews(mMainTop);
	}

	private void addViews(ViewGroup _add_views_to)
	{
		mMainStart.inflateInto(_add_views_to);
		mMainCountdown.inflateInto(_add_views_to);
		mMainLast.inflateInto(_add_views_to);
		go();
	}

	// display the first class, a text field button
	private void go()
	{
		Log.d(TAG,"go()");
		mMainStart.appear();
	}

	// when the first class button is clicked, hide it and display the second class, a countdown
	public void startCountdown()
	{
		Log.d(TAG,"startCountdown()");
		mMainStart.vanish();
		mMainCountdown.appear();
		mMainCountdown.countdown();
	}

	// when the countdown is finished, hide it and display the "again?" button
	public void countdownFinished()
	{
		Log.d(TAG,"countdownFinished()");
		mMainCountdown.vanish();
		mMainLast.appear();
	}

	// when user clicks "again?" do it all again
	public void startOver() {
		Log.d(TAG,"startOver()");
		mMainLast.vanish();
		go();
	}
}