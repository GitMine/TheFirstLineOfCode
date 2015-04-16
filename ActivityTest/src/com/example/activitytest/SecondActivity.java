package com.example.activitytest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SecondActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.second_layout);
		Log.d("SecondActivity", getTaskId() + "");

		Intent intent = getIntent();
		String data = intent.getStringExtra("extra_data");
		Log.d("SecondActiviy", data);

		Button button2 = (Button) findViewById(R.id.button_2);
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// Intent intent = new Intent();
				// intent.putExtra("data_return", "Hello FirstActivity");
				// setResult(RESULT_OK, intent);
				// finish();
//				Intent intent = new Intent(SecondActivity.this,
//						ThirdActivity.class);
//				startActivity(intent);
				ThirdActivity.actionStart(SecondActivity.this);
			}
		});
	}

	@Override
	public void onBackPressed() {
		Intent intent = new Intent();
		intent.putExtra("data_return", "Hello FirstActivity");
		setResult(RESULT_OK, intent);
		finish();
	}
}
