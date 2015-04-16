package com.example.listviewtest;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FruitAdapter extends ArrayAdapter<Fruit> {
	private int resourceId;

	public FruitAdapter(Context context, int resourceId, List<Fruit> objects) {
		super(context, resourceId, objects);
		this.resourceId = resourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Fruit fruit = getItem(position);
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = LayoutInflater.from(getContext()).inflate(resourceId,
					parent, false);
			holder.fruitImage = (ImageView) convertView
					.findViewById(R.id.fruit_image);
			holder.fruitName = (TextView) convertView
					.findViewById(R.id.fruit_name);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.fruitImage.setImageResource(fruit.getImageId());
		holder.fruitName.setText(fruit.getName());
		return convertView;
	}

	class ViewHolder {
		ImageView fruitImage;
		TextView fruitName;
	}

}
