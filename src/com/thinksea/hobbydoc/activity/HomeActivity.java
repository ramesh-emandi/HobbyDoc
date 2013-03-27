package com.thinksea.hobbydoc.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.thinksea.hobbydoc.adapters.TSAllDataListAdapter;
import com.thinksea.hobbydoc.model.JSONResponse;
import com.thinksea.hobbydoc.services.HttpRetriever;
import com.thinksea.hobbydoc.util.ThinkSeaUrlBuilder;
import com.thinksea.listsandcharts.R;

public class HomeActivity extends Activity implements OnClickListener, OnItemClickListener{
	
	private TextView title;
	private Button getAllDataButton;
	private ListView allDataListView;
	private JSONResponse response;
	Gson gson = new Gson();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initUI();
        setTitle();
        setListeners();
        
    }
    
    private void setTitle() {
		title.setText(R.string.list_screen_title);
	}
    private void setListeners() {
		getAllDataButton.setOnClickListener(this);
		getAllDataButton.setVisibility(View.GONE);
		getAllData();
	}

	private void initUI() {
		title = (TextView) findViewById(R.id.generic_titlebar_text);
    	getAllDataButton = (Button) findViewById(R.id.get_all_data_button);
    	allDataListView = (ListView) findViewById(R.id.all_data_listview);
    	
	}
    
    public void longToast(CharSequence message) {
		Toast.makeText(this, message, Toast.LENGTH_LONG).show();
	}

	
	private void getAllData() {
		ThinkSeaUrlBuilder urls = new ThinkSeaUrlBuilder();
		HttpRetriever httpService = new HttpRetriever();
		getObjectsFromJSON(httpService.retrieve(urls.getAllDataURL()));
	}

	private void getObjectsFromJSON(String serverResponse) {
		if(serverResponse == null)
		{
			toastLong("Server Error.!");
			return;
		}
		response = gson.fromJson(serverResponse, JSONResponse.class);
		if(response!=null){
			allDataListView.setAdapter(new TSAllDataListAdapter(this, response.GetAllDataResult));
			allDataListView.setOnItemClickListener(this);
		}
	}

	private void toastLong(String toastString) {
		Toast.makeText(this, toastString, Toast.LENGTH_LONG).show();
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.get_all_data_button:
			getAllData();
			break;
		default:
			break;
		}
	}
	
	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
//		toastLong("Clicked");
		String selectedItem = gson.toJson(response.GetAllDataResult.get(position));
		goToUserDetailsActivity(selectedItem);
	}

	private void goToUserDetailsActivity(String selectedItem) {
		Intent intent = new Intent(this, UserDetailsActivity.class);
		intent.putExtra("GetAllDataResult", selectedItem);
		startActivity(intent);
	}
}
