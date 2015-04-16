package com.example.activitytest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.first_layout);
		Log.d("FirstActivity", this.toString() + "," + getTaskId());

		Button button1 = (Button) findViewById(R.id.button_1);
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// Toast.makeText(FirstActivity.this, "You clicked Button 1",
				// Toast.LENGTH_SHORT).show();
				String data = "Hello SecondActivity";

				// œ‘ ΩIntent
				Intent intent = new Intent(FirstActivity.this,
						SecondActivity.class);
				intent.putExtra("extra_data", data);
				// “˛ ΩIntent
				// Intent intent = new Intent(
				// "com.example.activitytest.ACTION_START");
				// intent.addCategory("com.example.activitytest.MY_CATEGORY");
				// Intent intent = new Intent(Intent.ACTION_VIEW);
				// intent.setData(Uri.parse("http://www.baidu.com"));
				// Intent intent = new Intent(Intent.ACTION_DIAL);
				// intent.setData(Uri.parse("tel:1008611"));
				 startActivity(intent);
//				startActivityForResult(intent, 1);
				// startActivity(new Intent(FirstActivity.this,
				// FirstActivity.class));
				// finish();
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case 1:
			if (resultCode == RESULT_OK) {
				String returnedData = data.getStringExtra("data_return");
				Log.d("FirstActivity", returnedData);
			}
			break;

		default:
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {

		switch (item.getItemId()) {
		case R.id.add_item:
			Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
			break;
		case R.id.remove_item:
			Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT)
					.show();
			break;

		default:
			break;
		}
		return true;
	}
}
