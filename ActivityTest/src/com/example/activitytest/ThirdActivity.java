package com.example.activitytest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ThirdActivity extends BaseActivity {

	private Button button3 = null;

	public static void actionStart(Context context) {
		Intent intent = new Intent(context, ThirdActivity.class);
		context.startActivity(intent);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.third_layout);

		this.button3 = (Button) findViewById(R.id.button_3);

		this.button3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				ActivityCollector.finishAll();
			}
		});
	}
}
