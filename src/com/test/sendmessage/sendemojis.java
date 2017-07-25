package com.test.sendmessage;

import java.util.ArrayList;

import com.robotium.solo.Solo;
import com.test.teststart.Filetool;
import com.test.teststart.parameter;

import android.graphics.drawable.Drawable;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class sendemojis extends ActivityInstrumentationTestCase2 {
	// package com.instanza.baba
	// activity com.instanza.baba.activity.CocoVoice
	// 1,创建一个自动化测试对象Ø
	private Solo solo;
	private static Class<?> launchActivityClass;
	static {
		try {
			launchActivityClass = Class.forName(parameter.mainActiviy);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public sendemojis() {
		super(parameter.packageName, launchActivityClass);
	}

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}

	@Override
	protected void tearDown() throws Exception {
		this.solo.finishOpenedActivities();

		super.tearDown();
	}

	public void test_sendOneGroupEmoji() {
		solo.unlockScreen();
		solo.sleep(2000);
		Filetool st = new Filetool();
		solo.clickOnText(st.ReadTxtFile("paramter.txt"));
		solo.sleep(1000);
		parameter.clickOnViewByid(solo, parameter.showEmojiBtn);
		solo.sleep(1000);
		test_sendemoji();
	}

	public void test_sendAllEmoji() {
		String emojinames[] = { parameter.emojis_tab_1_smile,
				parameter.emojis_tab_2_flower, parameter.emojis_tab_3_bell,
				parameter.emojis_tab_4_car, parameter.emojis_tab_5_symbols };
		for (int i = 0; i < emojinames.length; i++) {
			solo.unlockScreen();
			solo.sleep(2000);
			Filetool st = new Filetool();
			solo.clickOnText(st.ReadTxtFile("paramter.txt"));
			solo.sleep(1000);
			parameter.clickOnViewByid(solo, parameter.showEmojiBtn);
			solo.sleep(1000);
			parameter.clickOnViewByid(solo, emojinames[i]);
			solo.sleep(1000);
			test_sendemoji();
			solo.goBack();
			solo.goBack();
		}
	}

	public GridView getGridView() {
		GridView emojiview = null;
		int localtion[] = new int[2];
		for (int i = 0; i < 2; i++) {
			emojiview = (GridView) solo.getView("Emoji_GridView", i);
			emojiview.getChildAt(0).getLocationOnScreen(localtion);
			System.out.println("localqwq===" + localtion[0]);
			if (localtion[0] < 30 && localtion[0] >= 0) {
				break;
			}
		}
		return emojiview;
	}

	public void test_sendemoji() {
		GridView emojiview = null;
		int emojinuminline = 1;// 一行的表情个数
		int localtion[] = new int[2];
		int localtion2[] = new int[2];

		emojiview = getGridView();

		for (int i = 6;; i++) {
			emojiview.getChildAt(i).getLocationOnScreen(localtion);
			System.out.println("local===" + localtion[0]);
			if (localtion[0] < 30) {
				emojinuminline = i;
				break;
			}
		}
		FrameLayout oldfl = (FrameLayout) emojiview.getChildAt(0);
		FrameLayout newfl;
		String oldfl_con = ((TextView) oldfl.getChildAt(0)).getText()
				.toString();// textview中的unicode编码
		String newfl_con;
		emojiview.getChildAt(0).getLocationOnScreen(localtion);
		for (int j = 0; j < emojinuminline; j++) {
			solo.clickOnView(emojiview.getChildAt(j));
			solo.sleep(100);
		}
		parameter.clickOnViewByid(solo, parameter.sendTextBtn);
		solo.sleep(10);
		solo.scrollListToLine(emojiview, emojinuminline);
		solo.sleep(100);

		for (int i = emojinuminline;; i = i + emojinuminline) {
			emojiview = getGridView();
			solo.sleep(100);
			newfl = (FrameLayout) emojiview.getChildAt(0);
			newfl_con = ((TextView) newfl.getChildAt(0)).getText().toString();
			if (oldfl_con == newfl_con) {
				newfl.getLocationOnScreen(localtion2);
				if (localtion2[1] == localtion[1]) {
					for (int j = 0; j < emojiview.getChildCount(); j++) {
						solo.clickOnView(emojiview.getChildAt(j));
						solo.sleep(100);
					}
					parameter.clickOnViewByid(solo, parameter.sendTextBtn);
					solo.sleep(10);
				} else {
					for (int j = emojinuminline; j < emojiview.getChildCount(); j++) {
						solo.clickOnView(emojiview.getChildAt(j));
						solo.sleep(100);
					}
					parameter.clickOnViewByid(solo, parameter.sendTextBtn);
					solo.sleep(10);
				}
				break;
			} else {
				for (int j = 0; j < emojinuminline; j++) {
					solo.clickOnView(emojiview.getChildAt(j));
					solo.sleep(100);
				}
				parameter.clickOnViewByid(solo, parameter.sendTextBtn);
				solo.sleep(10);
				solo.scrollListToLine(emojiview, i + emojinuminline);
				solo.sleep(100);
			}
			oldfl_con = newfl_con;
		}
	}

	// int localtion[]=new int[2];
	// int localtion2[]=new int[2];
	// int emojinuminline = 1;//一行的表情个数
	// for(int i=6;;i++){
	// emojiview.getChildAt(i).getLocationOnScreen(localtion);
	// if(localtion[0]<30){
	// emojinuminline =i;
	// break;
	// }
	// }
	// emojiview.getChildAt(0).getLocationOnScreen(localtion);
	// emojiview.getChildAt(emojinuminline).getLocationOnScreen(localtion2);
	//
	// double hight_each2 = 1.4*(localtion2[1]-localtion[1]);
	// int hight_each = 113;//(int)hight_each2;
	// FrameLayout oldfl = (FrameLayout)emojiview.getChildAt(0);
	// FrameLayout newfl;
	// String oldfl_con
	// =((TextView)oldfl.getChildAt(0)).getText().toString();//textview中的unicode编码
	// String newfl_con;
	// int localtion3[]=new int[2];//临时用
	// for(int i=1;;i++){//为了判断出滑动距离，以100为基础
	// solo.drag(localtion2[0]+10, localtion2[0]+10, localtion2[1]+110,
	// localtion2[1]+10, 100);solo.sleep(1000);
	// emojiview = (GridView)getViewByid("Emoji_GridView");solo.sleep(1000);
	// emojiview.getChildAt(0).getLocationOnScreen(localtion3);
	// if(localtion[1]-localtion3[1]<100){
	// Log.e("error4er4", i+"   "+localtion[1]+"   "+localtion3[1]);
	// hight_each=100*i+localtion3[1]-localtion[1];
	// solo.drag(localtion2[0]+10, localtion2[0]+10, localtion2[1]+10,
	// localtion2[1]+10+100*i, 100);solo.sleep(1000);
	// break;
	// }
	// }
	//
	// for(int i=0;i<28;i++){
	// emojiview.getChildAt(i).getLocationOnScreen(localtion);
	// Log.e("erroreere",localtion[0]+"  "+localtion[1]);
	// }
	// for(int i=0;i<4;i++){
	// emojiview = (GridView)getViewByid("Emoji_GridView");solo.sleep(1000);
	// emojiview.getChildAt(0).getLocationOnScreen(localtion);
	// solo.drag(localtion2[0]+10, localtion2[0]+10, localtion2[1]+100+10,
	// localtion2[1]+10, 100);solo.sleep(1000);
	// Log.e("erroreere2",localtion[0]+"   "+localtion[1]);
	// }
	// for(int j=0 ;j<emojinuminline;j++){
	// solo.clickOnView(emojiview.getChildAt(j));solo.sleep(10);
	// clickOnViewByid("sendTextBtn");solo.sleep(10);
	// }
	// solo.drag(localtion2[0]+10, localtion2[0]+10,
	// localtion2[1]+hight_each+10, localtion2[1]+10, 100);solo.sleep(1000);
	//
	// for(int i=0;;i=i+emojinuminline){
	// emojiview = (GridView)getViewByid("Emoji_GridView");solo.sleep(1000);
	// newfl = (FrameLayout)emojiview.getChildAt(0);
	// newfl_con = ((TextView)newfl.getChildAt(0)).getText().toString();
	// if(oldfl_con == newfl_con){
	// newfl.getLocationOnScreen(localtion2);
	// if(localtion2[1]==localtion[1]){
	// for(int j=0 ;j<emojiview.getChildCount();j++){
	// solo.clickOnView(emojiview.getChildAt(j));solo.sleep(100);
	// clickOnViewByid("sendTextBtn");solo.sleep(10);
	// }
	// }else{
	// for(int j=emojinuminline ;j<emojiview.getChildCount();j++){
	// solo.clickOnView(emojiview.getChildAt(j));solo.sleep(100);
	// clickOnViewByid("sendTextBtn");solo.sleep(100);
	// }
	// }
	// break;
	// }else{
	// for(int j=0 ;j<emojinuminline;j++){
	// solo.clickOnView(emojiview.getChildAt(j));solo.sleep(100);
	// clickOnViewByid("sendTextBtn");solo.sleep(100);
	// }
	// solo.drag(localtion2[0]+10, localtion2[0]+10,
	// localtion2[1]+hight_each+10, localtion2[1]+10, 100);solo.sleep(100);
	// }
	// oldfl_con=newfl_con;
	// }

	// public void testClickEachTab(){
	// solo.sleep(2000);
	// solo.clickOnButton("Agree and Activate");
	// solo.sleep(5000);
	// clickOnViewByid("select_country_text");
	// solo.sleep(1000);
	// solo.clickOnText("Bermuda");
	// solo.sleep(1000);
	// solo.clearEditText(0);
	// solo.enterText(0, "2087406082");
	// solo.sleep(4000);
	// clickOnViewByid("next");
	// solo.waitForDialogToOpen();
	// solo.clickOnButton("Approve");
	// solo.sleep(1000);
	// solo.enterText(0, "1616");
	// solo.sleep(5000);
	// }

	public void testsendmsg() {
		// solo.clickOnText("soma灌水测试大家屏蔽");
		solo.clickOnText("4438");
		solo.sleep(1000);
		for (int i = 0; i < 5; i++) {
			solo.enterText(0, "count == " + i);
			solo.sleep(500);
			parameter.clickOnViewByid(solo, "sendTextBtn");
			solo.sleep(500);
		}
	}

	// public void testsetbackgroud(){
	// //点击右上more按钮
	// Toolbar toolbar2 = (Toolbar)getViewByid("tool_bar");
	// ImageView set_imageview =(ImageView)
	// ((ActionMenuView)toolbar2.getChildAt(1)).getChildAt(2);
	// solo.clickOnView(set_imageview);solo.sleep(1000);
	// clickOnViewByid(parameter.title);solo.sleep(1000);
	// clickOnViewByid(parameter.row_chat);solo.sleep(1000);
	// //System.out.println(getActivity().get);
	// clickOnViewByid(parameter.row_chat_background);solo.sleep(2000);
	// assertTrue("error", true);
	// }

}
