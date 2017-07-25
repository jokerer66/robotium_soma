package com.test.sendmessage;

import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar;
import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;
import com.test.teststart.parameter;

public class takephoto extends ActivityInstrumentationTestCase2 {
	//package      com.instanza.baba
	//activity     com.instanza.baba.activity.CocoVoice
	//1,创建一个自动化测试对象Ø
	   private Solo solo;
	   private static Class<?> launchActivityClass;
	   //对应re-sign.jar生成出来的信息框里的两个值
	   static {
			try {
				launchActivityClass = Class.forName(parameter.mainActiviy);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}

		public takephoto() {
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
	   
//	   public void testtakephoto(){
//		   solo.clickOnText(parameter.taguser);solo.sleep(1000);
//		   parameter.clickOnViewByid(solo,parameter.chat_camera_btn);
//		   solo.clickOnText("Camera");
//		   
//		   CrossProcessUtil cp = new CrossProcessUtil();
//		   solo.sleep(2000);
//		   cp.CameraUtil();
//		   solo.sleep(3400);
//	   }
	   
	   
}
