package com.thinksea.hobbydoc.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.thinksea.listsandcharts.R;

public class MainMenuActivity extends Activity {
	private Button nextButton;
	private TextView title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main_menu_screen);
		initUI();
		setTitle();
	}

	private void setTitle() {
		title.setText(R.string.main_menu_title);
	}

	private void initUI() {
		nextButton = (Button) findViewById(R.id.next_button);
		title = (TextView) findViewById(R.id.generic_titlebar_text);
		nextButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startHomeActivity();

			}
		});
	}

	private void startHomeActivity() {
		Intent i = new Intent(this, HomeActivity.class);
		startActivity(i);

	}
}
