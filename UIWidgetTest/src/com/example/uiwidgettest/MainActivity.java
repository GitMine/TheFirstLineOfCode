package com.example.uiwidgettest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private TextView textView = null;
	private Button button = null;
	private EditText editText = null;
	private ImageView imageView = null;
	private ProgressBar progressBar = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.textView = (TextView) findViewById(R.id.text_view);
		this.button = (Button) findViewById(R.id.button);
		this.editText = (EditText) findViewById(R.id.edit_text);
		this.imageView = (ImageView) findViewById(R.id.image_view);
		this.progressBar = (ProgressBar) findViewById(R.id.progress_bar);
		this.button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// 在此处添加逻辑
				String inputText = editText.getText().toString();
				Toast.makeText(MainActivity.this, inputText, Toast.LENGTH_SHORT)
						.show();
				imageView.setImageResource(R.drawable.qq);
//				if(progressBar.getVisibility() == View.GONE) {
//					progressBar.setVisibility(View.VISIBLE);
//				} else {
//					progressBar.setVisibility(View.GONE);
//				}
				int progress = progressBar.getProgress();
				progress += 10;
				progressBar.setProgress(progress);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
