package com.thinksea.hobbydoc.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.thinksea.listsandcharts.R;

public class LoginActivity extends Activity implements OnClickListener{
	private TextView userName;
	private TextView passWord;
	private Button loginButton;
	private TextView title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.login_screen);
		initUI();
		setTitle();
		loginButton.setOnClickListener(this);
		super.onCreate(savedInstanceState);
	}
	
	private void setTitle() {
		title.setText(R.string.login_title);
	}

	private void initUI() {
		title = (TextView) findViewById(R.id.generic_titlebar_text);
		userName = (TextView) findViewById(R.id.username_edittext);
		passWord = (TextView) findViewById(R.id.password_edittext);
		loginButton = (Button) findViewById(R.id.login_button);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.login_button){
			if(dataValid())
				startMainMenuActivity();
		}
	}

	private boolean dataValid() {
		String uName = userName.getText().toString();
		String pass = passWord.getText().toString();
		if(authenticatedUser(uName, pass)){
			return true;
		}
		else return false;
	}

	private boolean authenticatedUser(String uName, String pass) {
		//TODO: contactServerForAuthentication returning true for now
		return true;
	}

	private void startMainMenuActivity() {
		Intent i = new Intent(this, MainMenuActivity.class);
		startActivity(i);
	}
}
