package com.thinksea.hobbydoc.activity;

import com.thinksea.listsandcharts.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

public class SplashActivity extends Activity {

	private CountDownTimer timer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.splash_activity);
		initTimer();
		timer.start();
		super.onCreate(savedInstanceState);
	}
	private void initTimer() {
		timer = new CountDownTimer(3000, 1000) {
			@Override
			public void onTick(long millisUntilFinished) {
			}

			@Override
			public void onFinish() {
				startHomeActivity();
			}
		};
	}

	private void startHomeActivity() {
		Intent i = new Intent(this, LoginActivity.class);
		startActivity(i);
		finish();
	}
}
