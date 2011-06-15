package com.stackoverflow.thunderrabbit.layout.inflation;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainCountdown extends RelativeLayout {
	private final String TAG = this.getClass().getSimpleName();

	private Context mContext;
	private Main myParent;
	private View myView;
	private TextView mCountdownText;

	public MainCountdown(Context context) {
		super(context);
		mContext = context;
	}

	public MainCountdown(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
	}

	public MainCountdown(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		mContext = context;
	}

	public void inflateInto(ViewGroup _view_group)
	{
		myView = inflate(mContext, R.layout.main_countdown, _view_group);
		mCountdownText = (TextView) myView.findViewById(R.id.countdown);
	}

	public void vanish() {
		Log.d(TAG,"vanish");
		myView.setVisibility(View.GONE);
	}

	public void appear() {
		Log.d(TAG,"appear");
		myView.setVisibility(View.VISIBLE);
	}

	public void countdown()
	{
		startCountdown();
	}

	private void startCountdown() {
		new CountDownTimer(5 * 1000,1000) {

			@Override
			public void onFinish() {
				myParent.countdownFinished();
			}

			@Override
			public void onTick(long millisUntilFinished) {
				mCountdownText.setText(Long.toString(millisUntilFinished / 1000));
			}
			
		}.start();

	}

	public void whoIsMyDaddy(Main _daddy) {
		myParent = _daddy;
	}

}
