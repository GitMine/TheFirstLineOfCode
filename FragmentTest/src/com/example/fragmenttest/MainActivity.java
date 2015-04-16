package com.example.fragmenttest;

import com.example.fragmenttest.fragment.AnotherRightFragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button button = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.button = (Button) findViewById(R.id.button);
		this.button.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button:
			Log.d("MainActivity", "=====================");
			AnotherRightFragment fragment = new AnotherRightFragment();
			FragmentManager fragmentManager = getFragmentManager();
			FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
			beginTransaction.replace(R.id.right_layout, fragment);
			beginTransaction.addToBackStack(null);
			beginTransaction.commit();
			break;

		default:
			break;
		}
	}

}
