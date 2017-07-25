package com.test.teststart;

import java.util.Stack;

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
import android.widget.TextView;

public class testit2 extends Activity {
//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
//		// 运行所有测试用例：
//		// adb shell am instrument -w packagename/InstrumentationTestRunnername
//		// run.exec(" am instrument --user 0 -w com.test.teststart/com.test.teststart.InstrumentationTestRunner");
//		// 运行单个测试类或某个TestSuite
//		// adb shell am instrument -e class packagename.testclassname -w
//		// packagename/InstrumentationTestRunnername
//		// 运行某个测试类里面的某个测试方法
//		// adb shell am instrument -e class package名.测试类名#方法名 -w
//		// 工程名.package名/InstrumentationTestRunner class名
//		// 发现在17及以上版本，命令中需要加入--user 0参数
//		// run.exec(" am instrument --user 0 -e class com.test.teststart.testlogin#test_sendemoji -w com.test.teststart/com.test.teststart.InstrumentationTestRunner");
//		TextView emojitext = (TextView) findViewById(R.id.emojitext);
//		emojitext.setText("前提确认：1.你已经登录的soma 2.chats列表中有名为‘soma灌水测试大家屏蔽’的群 3.点击确认后，大约会有十几秒的等待时间，请注意\n 请问是否已经确保前提条件准备完成");
//		Button emojibutton = (Button) findViewById(R.id.emojibutton);
//		emojibutton.setText("连发一组表情消息");
//		Button emojibutton2 = (Button) findViewById(R.id.emojibutton2);
//		emojibutton2.setText("连发全部表情消息");
//		TextView phototext = (TextView) findViewById(R.id.phototext);
//		phototext.setText("前提确认：1.你已经登录的soma 2.chats列表中有名为‘soma灌水测试大家屏蔽’的群 3.确保照片选择页面存在以下命名的照片文件夹：测试专用图－－相机拍摄,测试专用图－－iPhone拍摄完,测试专用图－－iPhone拍摄（,微博长图,android 图片测试 4.点击确认后，大约会有十几秒的等待时间，请注意\n 请问是否已经确保前提条件准备完成");
//		Button photobutton2 = (Button) findViewById(R.id.photobutton2);
//		photobutton2.setText("连发全部照片");
//		TextView msgtext = (TextView) findViewById(R.id.msgtext);
//		msgtext.setText("前提确认：1.你已经登录的soma 2.chats列表中有名为‘soma灌水测试大家屏蔽’的群  3.点击确认后，大约会有十几秒的等待时间，请注意\n 请问是否已经确保前提条件准备完成");
//		Button msgbutton1 = (Button) findViewById(R.id.msgbutton1);
//		msgbutton1.setText("发送文本消息（数字）");
//		Button msgbutton2 = (Button) findViewById(R.id.msgbutton2);
//		msgbutton2.setText("发送全部unicode文字");
//		msgbutton2.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				Bitmap[] bitmap = new Bitmap[8000];
//				try {
//				    // 实例化Bitmap
//					for(int i=0;;i++){
//						bitmap[i] = BitmapFactory.decodeFile("/storage/emulated/0/Robotium-Screenshots/backgroud=.jpg");
//					    System.out.println("fffffffff  i= "+i+"    "+bitmap[i].getHeight());
//					}
//				} catch (OutOfMemoryError e) {
//				    e.printStackTrace();
//				}
//			}
//		});
//	}
}
