package com.stackoverflow.thunderrabbit.layout.inflation;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class StepOne {
	private final String TAG = this.getClass().getSimpleName();

	private Context mContext;
	private Main myParent;
	private StepOneLayout myView;
	private View myButton;

	private class StepOneLayout extends RelativeLayout {
		public StepOneLayout(Context context) {
			super(context);
			mContext = context;
		}
	
		public StepOneLayout(Context context, AttributeSet attrs) {
			super(context, attrs);
			mContext = context;
		}
	
		public StepOneLayout(Context context, AttributeSet attrs, int defStyle) {
			super(context, attrs, defStyle);
			mContext = context;
		}
	}

	public void init(Context _context)
	{
		myView = new StepOneLayout(_context);
	}

	public void inflateInto(ViewGroup _view_group)
	{
		myView.inflate(mContext, R.layout.main_start, _view_group);
		vanish();
		myButton = myView.findViewById(R.id.startcountdown);
		myButton.setOnClickListener(startCountdownButtonListener);
	}

	private View.OnClickListener startCountdownButtonListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			myParent.startCountdown();
		}
	};

	public void vanish() {
		Log.d(TAG,"vanish");
		myView.setVisibility(View.GONE);
	}

	public void appear() {
		Log.d(TAG,"appear");
		myView.setVisibility(View.VISIBLE);
	}

	public void whoIsMyDaddy(Main _daddy) {
		myParent = _daddy;
	}
}
