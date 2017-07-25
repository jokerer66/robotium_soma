package com.test.teststart;

import java.util.Random;

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;

import com.robotium.solo.Solo;
import com.test.teststart.parameter;

public class testlogin extends ActivityInstrumentationTestCase2 {
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

		public testlogin() {
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

	   public void testsendmsg() {
			solo.clickOnText("6082");
			solo.sleep(1000);
			for (int i = 0; i < 300; i++) {
				solo.enterText(0, "count == " + i);
				parameter.clickOnViewByid(solo, parameter.sendTextBtn);
			}
//		   solo.clickOnText("2164");
//			solo.sleep(1000);
//			String uninum[]= {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
//			String uniword = "";
//			Random rand = new Random();
//			
//			for(int j=0;j<200000;j++){
//				for(int k =0;k<2;k++){
//					uniword = "";
//					for(int i=0;i<4;i++){
//						int num = rand.nextInt(16);
//						uniword = uniword + uninum[num];
//					}
//					solo.enterText(0, decodeUnicode("\\u"+uniword));
//				}parameter.clickOnViewByid(solo, parameter.sendTextBtn);
//			}
		}
	   
}
