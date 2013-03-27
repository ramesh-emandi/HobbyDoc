package com.thinksea.hobbydoc.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.thinksea.hobbydoc.model.GetAllDataResult;
import com.thinksea.listsandcharts.R;

public class TSAllDataListAdapter extends BaseAdapter {

	private List<GetAllDataResult> dataList;
	private LayoutInflater mInflater;
	
	public TSAllDataListAdapter(Context ctx, List<GetAllDataResult> dataList){
		this.dataList = dataList;
		mInflater = LayoutInflater.from(ctx);
	}
	@Override
	public int getCount() {
		return dataList.size();
	}

	@Override
	public Object getItem(int position) {
		return dataList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if(convertView == null)
		{convertView = mInflater.inflate(R.layout.all_data_listview_row, null);	
		holder = new ViewHolder();
		holder.name = (TextView) convertView.findViewById(R.id.name);
		holder.address = (TextView) convertView.findViewById(R.id.address);
		convertView.setTag(holder);
		}
		else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.name.setText(dataList.get(position).Name);
		holder.address.setText(dataList.get(position).Address);
		
		return convertView;
	}
	
	class ViewHolder{
		public TextView name;
		public TextView address;
	}

}
