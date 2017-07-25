package com.test.sendmessage;

import java.io.IOException;
import java.util.Stack;

import junit.framework.Assert;
import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar;
import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;
import com.test.teststart.parameter;

public class testit extends ActivityInstrumentationTestCase2 {
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

		public testit() {
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
	   
	   
	   
		public void doSomething() {
			Stack s = new Stack();
			s.push(new Object());
			// other code
				solo.assertMemoryNotLow();
			s.pop();// 这里同样导致对象无法回收,内存泄露.
		}
	   public void testbitmap(){
			Bitmap[] bitmap = new Bitmap[19];
			try {
				// 实例化Bitmap
				System.out.println("fffffffff 2222 ");
				for (int i = 0; i < bitmap.length; i++) {
					bitmap[i] = BitmapFactory
							.decodeFile("/storage/emulated/0/Robotium-Screenshots/backgroud=.jpg");
					solo.assertMemoryNotLow();
					System.out.println("assertok  i= " + i + "    "
							+ bitmap[i].getHeight());
					
				}
			} catch (OutOfMemoryError e) {
				solo.assertMemoryNotLow();
				System.out.println("assertnotok ");
				
				
				
				e.printStackTrace();
			}
			solo.sleep(30000);
		} 
		    
	   
	   
}
