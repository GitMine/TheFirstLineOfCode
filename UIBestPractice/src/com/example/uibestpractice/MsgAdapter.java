package com.example.uibestpractice;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MsgAdapter extends ArrayAdapter<Msg> {
	private int resource;

	public MsgAdapter(Context context, int resource, List<Msg> objects) {
		super(context, resource, objects);
		this.resource = resource;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		Msg msg = getItem(position);
		ViewHolder holder;
		if (convertView == null) {
			convertView = LayoutInflater.from(getContext()).inflate(resource,
					parent, false);
			holder = new ViewHolder();
			holder.leftLayout = (LinearLayout) convertView
					.findViewById(R.id.left_layout);
			holder.rightLayout = (LinearLayout) convertView
					.findViewById(R.id.right_layout);
			holder.leftMsg = (TextView) convertView.findViewById(R.id.left_msg);
			holder.rightMsg = (TextView) convertView
					.findViewById(R.id.right_msg);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		if (msg.getType() == Msg.TYPE_RECEIVED) {
			holder.leftLayout.setVisibility(View.VISIBLE);
			holder.rightLayout.setVisibility(View.GONE);
			holder.leftMsg.setText(msg.getContent());
		} else if (msg.getType() == Msg.TYPE_SENT) {
			holder.leftLayout.setVisibility(View.GONE);
			holder.rightLayout.setVisibility(View.VISIBLE);
			holder.rightMsg.setText(msg.getContent());
		}

		return convertView;
	}

	class ViewHolder {
		LinearLayout leftLayout;
		LinearLayout rightLayout;
		TextView leftMsg;
		TextView rightMsg;
	}

}
