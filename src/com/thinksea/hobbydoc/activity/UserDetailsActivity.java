package com.thinksea.hobbydoc.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.thinksea.hobbydoc.model.GetAllDataResult;
import com.thinksea.listsandcharts.R;

public class UserDetailsActivity extends Activity {
	private GetAllDataResult detailsItem;
	private Gson gson = new Gson();
	private TextView id;
	private TextView name;
	private TextView age;
	private TextView address;
	private TextView title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.user_detail_view);
		initUI();
		setTitle();
		getDataFromIntent();
		if(detailsItem !=null){
			setDataToUI();
		}
		else{
			Toast.makeText(this, "Problem Retrieving Data. Try Again.", Toast.LENGTH_SHORT).show();
		}

		super.onCreate(savedInstanceState);
	}

	private void setTitle() {
		title.setText(R.string.details_title);
	}

	private void initUI() {
		title = (TextView) findViewById(R.id.generic_titlebar_text);
		id = (TextView) findViewById(R.id.user_id);
		name = (TextView) findViewById(R.id.name);
		age = (TextView) findViewById(R.id.age);
		address = (TextView) findViewById(R.id.address);
	}

	private void setDataToUI() {
		id.setText(detailsItem.Id);
		name.setText(detailsItem.Name);
		age.setText(detailsItem.Age);
		address.setText(detailsItem.Address);
	}

	private void getDataFromIntent() {
		Intent i = getIntent();
		String selectedItem = i.getStringExtra("GetAllDataResult");
		detailsItem = gson.fromJson(selectedItem, GetAllDataResult.class);
	}
}
