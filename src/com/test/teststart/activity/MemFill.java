package com.test.teststart.activity;

import com.test.sendmessage.sendtext;
import com.test.teststart.MemFillTool;
import com.test.teststart.R;
import com.test.teststart.parameter;
import com.test.teststart.R.id;
import com.test.teststart.R.layout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MemFill extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.memfill);

		final EditText memfillnum = (EditText) findViewById(R.id.memfillnum);
		final Button fillmembtn = (Button) findViewById(R.id.fillmembtn);
		fillmembtn.setText("填充内存");
		fillmembtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				int fillnum = Integer.valueOf(memfillnum.getText().toString());
				MemFillTool.getInstance().fillMem(fillnum);
			}
		});
		

		Button freemembtn = (Button) findViewById(R.id.freemembtn);
		freemembtn.setText("释放内存");
		freemembtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				MemFillTool.getInstance().freeMem();
			}
		});
		
	}
}
