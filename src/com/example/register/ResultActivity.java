package com.example.register;

import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class ResultActivity extends Activity {
    private TextView tvName,tvPsd,tvGender,tvCity;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		
		TextView tvName=(TextView)findViewById(R.id.tvName);
		TextView tvGender=(TextView)findViewById(R.id.tvGender);
		TextView tvPsd=(TextView)findViewById(R.id.tvPsd);
		TextView tvCity=(TextView)findViewById(R.id.tvCity);
		
		Intent intent=getIntent();
		tvName.setText(intent.getStringExtra("name"));
		tvGender.setText(intent.getStringExtra("gender"));
		tvPsd.setText(intent.getStringExtra("Psd"));
		tvCity.setText(intent.getStringExtra("city"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result, menu);
		return true;
	}

}
