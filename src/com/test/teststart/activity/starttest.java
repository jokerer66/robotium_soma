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
import android.widget.TextView;

public class starttest extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TextView sendmsgtext = (TextView) findViewById(R.id.sendmsgtext);
		sendmsgtext.setText("111");
		Button sendmsgbtn = (Button) findViewById(R.id.sendmsgbtn);
		sendmsgbtn.setText("进入消息发送模块");
		sendmsgbtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(starttest.this, sendmsg.class);
				startActivity(intent);
			}
		});
		
		TextView memtext = (TextView) findViewById(R.id.memtext);
		memtext.setText("222");

		Button membtn = (Button) findViewById(R.id.membtn);
		membtn.setText("填充内存");
		membtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(starttest.this, MemFill.class);
				startActivity(intent);
			}
		});
		
	}
}
