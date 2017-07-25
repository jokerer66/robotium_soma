package com.test.teststart.activity;

import com.test.sendmessage.sendtext;
import com.test.teststart.Filetool;
import com.test.teststart.MemFillTool;
import com.test.teststart.R;
import com.test.teststart.parameter;
import com.test.teststart.R.id;
import com.test.teststart.R.layout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class sendmsg extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sendmsg);

		// 运行所有测试用例：
		// adb shell am instrument -w packagename/InstrumentationTestRunnername
		// run.exec(" am instrument --user 0 -w com.test.teststart/com.test.teststart.InstrumentationTestRunner");

		// 运行单个测试类或某个TestSuite
		// adb shell am instrument -e class packagename.testclassname -w
		// packagename/InstrumentationTestRunnername
		//
		// 运行某个测试类里面的某个测试方法
		// adb shell am instrument -e class package名.测试类名#方法名 -w
		// 工程名.package名/InstrumentationTestRunner class名
		// 发现在17及以上版本，命令中需要加入--user 0参数
		// run.exec(" am instrument --user 0 -e class com.test.teststart.testlogin#test_sendemoji -w com.test.teststart/com.test.teststart.InstrumentationTestRunner");
		final EditText tagtext = (EditText) findViewById(R.id.tagtext);
		tagtext.setHint("请输入要发送的目标名称");
		TextView emojitext = (TextView) findViewById(R.id.emojitext);
		emojitext
				.setText("前提确认：1.你已经登录的soma 2.chats列表中有名为‘soma灌水测试大家屏蔽’的群 3.点击确认后，大约会有十几秒的等待时间，请注意\n 请问是否已经确保前提条件准备完成");
		Button emojibutton = (Button) findViewById(R.id.emojibutton);
		emojibutton.setText("连发一组表情消息");
		emojibutton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder builder = new AlertDialog.Builder(
						sendmsg.this);
				final String tagname = tagtext.getText().toString();
				builder.setTitle("将会连发一组表情消息 目标为"+tagname);
				builder.setPositiveButton("确定",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								// 这里添加点击确定后的逻辑
								if(tagname == null ||tagname.equals("") || tagname.equals("请输入要发送的目标名称")){
									new AlertDialog.Builder(sendmsg.this).setTitle("系统提示")//设置对话框标题  
								     .setMessage("请输入要发送的目标名称")//设置显示的内容  
								     .setPositiveButton("确定",new DialogInterface.OnClickListener() {//添加确定按钮  
								         @Override  
								         public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件  
								             // TODO Auto-generated method stub  
								         }  
								     }).show();
								}
								else{
									Runtime run = Runtime.getRuntime();
									try {
										Filetool tess = new Filetool();
										tess.writeTxt(tagname);
									run.exec(" am instrument --user 0 -e class com.test.sendmessage.sendemojis#test_sendOneGroupEmoji -w com.test.teststart/com.test.teststart.InstrumentationTestRunner");
									} catch (Exception e) {
									}

								}
							}
						});
				builder.setNegativeButton("取消",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								// 这里添加点击确定后的逻辑
							}
						});
				builder.create().show();
			}
		});
		Button emojibutton2 = (Button) findViewById(R.id.emojibutton2);
		emojibutton2.setText("连发全部表情消息");
		emojibutton2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder builder = new AlertDialog.Builder(
						sendmsg.this);
				final String tagname = tagtext.getText().toString();
				builder.setTitle("将会连发全部表情消息 目标为"+tagname);
				builder.setPositiveButton("确定",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								// 这里添加点击确定后的逻辑
								if(tagname == null ||tagname.equals("") || tagname.equals("请输入要发送的目标名称")){
									new AlertDialog.Builder(sendmsg.this).setTitle("系统提示")//设置对话框标题  
								     .setMessage("请输入要发送的目标名称")//设置显示的内容  
								     .setPositiveButton("确定",new DialogInterface.OnClickListener() {//添加确定按钮  
								         @Override  
								         public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件  
								             // TODO Auto-generated method stub  
								         }  
								     }).show();
								}
								else{
									Runtime run = Runtime.getRuntime();
									try {
										Filetool tess = new Filetool();
										tess.writeTxt(tagname);
									run.exec(" am instrument --user 0 -e class com.test.sendmessage.sendemojis#test_sendAllEmoji -w com.test.teststart/com.test.teststart.InstrumentationTestRunner");
									} catch (Exception e) {
										
									}

								}
							}
						});
				builder.setNegativeButton("取消",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								// 这里添加点击确定后的逻辑
							}
						});
				builder.create().show();
			}
		});

		TextView phototext = (TextView) findViewById(R.id.phototext);
		phototext.setText("前提确认：1.你已经登录的soma 2.chats列表中有名为‘soma灌水测试大家屏蔽’的群 3.确保照片选择页面存在以下命名的照片文件夹：测试专用图－－相机拍摄,测试专用图－－iPhone拍摄完,测试专用图－－iPhone拍摄（,微博长图,android 图片测试 4.点击确认后，大约会有十几秒的等待时间，请注意\n 请问是否已经确保前提条件准备完成");

		Button photobutton2 = (Button) findViewById(R.id.photobutton2);
		photobutton2.setText("连发全部照片");
		photobutton2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder builder = new AlertDialog.Builder(
						sendmsg.this);
				final String tagname = tagtext.getText().toString();
				builder.setTitle("将会连发全部照片 目标为"+tagname);
				builder.setPositiveButton("确定",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								// 这里添加点击确定后的逻辑
								if(tagname == null ||tagname.equals("") || tagname.equals("请输入要发送的目标名称")){
									new AlertDialog.Builder(sendmsg.this).setTitle("系统提示")//设置对话框标题  
								     .setMessage("请输入要发送的目标名称")//设置显示的内容  
								     .setPositiveButton("确定",new DialogInterface.OnClickListener() {//添加确定按钮  
								         @Override  
								         public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件  
								             // TODO Auto-generated method stub  
								         }  
								     }).show();
								}
								else{
									Runtime run = Runtime.getRuntime();
									try {
										Filetool tess = new Filetool();
										tess.writeTxt(tagname);
									run.exec(" am instrument --user 0 -e class com.test.sendmessage.sendphoto#test_sendAllPhoto -w com.test.teststart/com.test.teststart.InstrumentationTestRunner");
									} catch (Exception e) {
	
									}
								}
							}
						});
				builder.setNegativeButton("取消",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								// 这里添加点击确定后的逻辑
							}
						});
				builder.create().show();
			}
		});
		TextView msgtext = (TextView) findViewById(R.id.msgtext);
		msgtext.setText("前提确认：1.你已经登录的soma 2.chats列表中有名为‘soma灌水测试大家屏蔽’的群  3.点击确认后，大约会有十几秒的等待时间，请注意\n 请问是否已经确保前提条件准备完成");
		Button msgbutton1 = (Button) findViewById(R.id.msgbutton1);
		msgbutton1.setText("发送文本消息（数字）");
		
		msgbutton1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder builder = new AlertDialog.Builder(
						sendmsg.this);
				final String tagname = tagtext.getText().toString();
				builder.setTitle("将会发送100条消息 目标为"+tagname);
				builder.setPositiveButton("确定",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								// 这里添加点击确定后的逻辑
								if(tagname == null ||tagname.equals("") || tagname.equals("请输入要发送的目标名称")){
									new AlertDialog.Builder(sendmsg.this).setTitle("系统提示")//设置对话框标题  
								     .setMessage("请输入要发送的目标名称")//设置显示的内容  
								     .setPositiveButton("确定",new DialogInterface.OnClickListener() {//添加确定按钮  
								         @Override  
								         public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件  
								             // TODO Auto-generated method stub  
								         }  
								     }).show();
								}
								else{
									Runtime run = Runtime.getRuntime();
									try {
										Filetool tess = new Filetool();
										tess.writeTxt(tagname);
										run.exec(" am instrument --user 0 -e class com.test.sendmessage.sendtext#testsendmsg  -w com.test.teststart/com.test.teststart.InstrumentationTestRunner");
									} catch (Exception e) {

									}
								}
								
							}
						});
				builder.setNegativeButton("取消",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								// 这里添加点击确定后的逻辑
							}
						});
				builder.create().show();
			}
		});
		Button msgbutton2 = (Button) findViewById(R.id.msgbutton2);
		msgbutton2.setText("发送全部unicode文字");
		msgbutton2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder builder = new AlertDialog.Builder(
						sendmsg.this);
				final String tagname = tagtext.getText().toString();
				builder.setTitle("将会发送全部unicode文字 目标为"+tagname);
				builder.setPositiveButton("确定",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								// 这里添加点击确定后的逻辑
								if(tagname == null ||tagname.equals("") || tagname.equals("请输入要发送的目标名称")){
									new AlertDialog.Builder(sendmsg.this).setTitle("系统提示")//设置对话框标题  
								     .setMessage("请输入要发送的目标名称")//设置显示的内容  
								     .setPositiveButton("确定",new DialogInterface.OnClickListener() {//添加确定按钮  
								         @Override  
								         public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件  
								             // TODO Auto-generated method stub  
								         }  
								     }).show();
								}
								else{
									Runtime run = Runtime.getRuntime();
									try {
										Filetool tess = new Filetool();
										tess.writeTxt(tagname);
									run.exec(" am instrument --user 0 -e class com.test.sendmessage.sendtext#testsendallmsg -w com.test.teststart/com.test.teststart.InstrumentationTestRunner");
									} catch (Exception e) {
										
									}
								}
							}
						});
				builder.setNegativeButton("取消",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								// 这里添加点击确定后的逻辑
							}
						});
				builder.create().show();
			}
		});
	}
}
