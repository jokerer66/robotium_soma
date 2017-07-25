package com.test.sendmessage;

import java.net.NetPermission;
import java.util.ArrayList;

import com.robotium.solo.Solo;
import com.test.teststart.Filetool;
import com.test.teststart.parameter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Instrumentation.ActivityMonitor;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.support.v7.internal.widget.FitWindowsLinearLayout;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class loopclick extends ActivityInstrumentationTestCase2 {
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

	public loopclick() {
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
	
	public void test_loopall(){
		solo.unlockScreen();
		View toolbar = solo.getView("tool_bar");
		int[] location = new int[2];
		toolbar.getLocationOnScreen(location);
		//solo.clickOnScreen(0+10, 252+10);
		//solo.clickOnScreen(location[0]+10, location[1]+10);
		//solo.clickOnText("Account");
		solo.sleep(2000);
		
//		solo.clickOnText("Privacy");
//		solo.clickOnText("Last seen");solo.sleep(500);
//		ListView select_dialog_listview =(ListView)solo.getView("select_dialog_listview");
//		08-29 10:37:54.104: E/tempview(11445): com.instanza.baba.activity.CocoVoice\

		//solo.get
        //Log.e("tempview",solo.getCurrentActivity().getClass().getName());
		test_loopclick();
		solo.sleep(2000);
	}
	
	public void test_loopclick(){
		Filetool filetool = new Filetool();
		int oldpagenumber=0,newpagenumber=0;
		solo.sleep(1000);
		int[] location = new int[2];
		ArrayList<View> allviewlist = solo.getCurrentViews();
		ArrayList<TextView> oldtextlist,newtextlist;
		Activity oldactivity,newactivity;
		String oldpagename ="",newpagename = "";
		int available_id = -1,tempid;
		filetool.log("allviewlist.size() = "+allviewlist.size());
		WindowManager wm = getActivity().getWindowManager();
		int width = wm.getDefaultDisplay().getWidth();
		int height = wm.getDefaultDisplay().getHeight();
		filetool.log(" width = "+width+" height = "+height);
		for(int i=0 ;i<allviewlist.size();i++){
			View tempview = allviewlist.get(i);
			tempview.getLocationOnScreen(location);
			oldactivity = solo.getCurrentActivity();

			
			// view可以点击，且可见，且xy坐标不为（0，0），且均大于等于0，id不等于-1,且坐标位于屏幕内，与返回键idhesetting按钮id
			// view若为listview时，且可点击时，对其子item进行点击遍历
			if(tempview.getClass().toString().contains("ObservableListView") && 
					tempview.isClickable() && tempview.getVisibility()== View.VISIBLE && tempview.isShown() && 
					(location[0]!=0 || location[1]!=0) && (location[0]>=0 && location[1]>=0) &&(location[0]<=width && location[1]<=height) && 
					tempview.getId()>=0 && tempview.getId() != 2131690351 ){
				filetool.log("in all view i= "+i+"   x= "+location[0]+"   y= "+location[1] +" tempview.isClickable() ="+tempview.isClickable()+" class = "+tempview.getClass() +"  id = "+tempview.getId());
				
				ListView listview =(ListView) tempview;
				filetool.log("ObservableListView.getChildCount = "+listview.getChildCount());
				
				available_id=tempview.getId();
				for(int k=0;k<0;k++){
					oldactivity = solo.getCurrentActivity();
					
					oldtextlist = solo.getCurrentViews(TextView.class);
					for(int zz= 0;zz<oldtextlist.size();zz++){
						if(oldtextlist.get(zz).getText().toString().length()>=4){
							oldpagename = oldtextlist.get(zz).getText().toString();
							break;
						}
							
					}
					View list_itemview = listview.getChildAt(k);
					tempid = list_itemview.getId();
					if(tempid > -1)available_id = tempid;
					list_itemview.getLocationOnScreen(location);
					solo.clickOnView(list_itemview);
					filetool.log("in the list k = "+k+"   x= "+location[0]+"   y= "+location[1] +" class = "+list_itemview.getClass() +"  id = "+list_itemview.getId());
					
					solo.sleep(1000);
					newtextlist = solo.getCurrentViews(TextView.class);
					for(int zz= 2;zz<newtextlist.size();zz++){
						if(newtextlist.get(zz).getText().toString().length()>=4){
							newpagename = newtextlist.get(zz).getText().toString();//获取当前页面的存在的textview的text
							break;
						}
					}
					if(search_choosedialog(tempview)){
						if(oldpagename.equals(newpagename))
							filetool.writeactiinfo("page"+oldpagename, Integer.toHexString(list_itemview.getId()), "page"+newpagename+" find a choosedialog");
						else
							filetool.writeactiinfo("page"+oldpagename, Integer.toHexString(list_itemview.getId()), "page"+newpagename);
						solo.goBack();
					}else{
						
						newactivity = solo.getCurrentActivity();
						flag_newactivity( oldactivity, newactivity, list_itemview,i,available_id,oldpagename,newpagename);
					}
					
				}
				
				
			}else{
				// view可以点击，且可见，且xy坐标不为（0，0），且均大于等于0，id不等于-1,且坐标位于屏幕内，与返回键id
				if(tempview.isClickable() && tempview.getVisibility()== View.VISIBLE && tempview.isShown() && 
						(location[0]!=0 || location[1]!=0) && (location[0]>=0 && location[1]>=0) &&(location[0]<=width && location[1]<=height) && 
						tempview.getId()>=0 && tempview.getId() != 2131690351 ){
					oldactivity = solo.getCurrentActivity();
					filetool.log("in all view i= "+i+"   x= "+location[0]+"   y= "+location[1] +" tempview.isClickable() ="+tempview.isClickable()+" class = "+tempview.getClass() +"  id = "+Integer.toHexString(tempview.getId()));
					solo.sleep(2000);
					
					tempid = tempview.getId();
					if(tempid > -1)available_id = tempid;
					solo.clickOnView(tempview);solo.sleep(1000);
					newtextlist = solo.getCurrentViews(TextView.class);
					for(int zz= 2;zz<newtextlist.size();zz++){
						if(newtextlist.get(zz).getText().toString().length()>=4){
							newpagename = newtextlist.get(zz).getText().toString();
							break;
						}
					}
					
					if(search_choosedialog(tempview)){
						if(oldpagename.equals(newpagename))
							filetool.writeactiinfo("page"+oldpagename, Integer.toHexString(tempview.getId()), "page"+newpagename+" find a choosedialog");
						else
							filetool.writeactiinfo("page"+oldpagename, Integer.toHexString(tempview.getId()), "page"+newpagename);
						solo.goBack();
					}else{
						
						newactivity = solo.getCurrentActivity();
						flag_newactivity( oldactivity, newactivity, tempview,i,available_id,oldpagename,newpagename);
					}
						//select_dialog_listviewd的viewid，判断弹出选择框
						//search_choosedialog(tempview);
					
//					//filetool.writefinishstatus(newactivity.getLocalClassName(), "false");
//						newactivity = solo.getCurrentActivity();
//						flag_newactivity( oldactivity, newactivity, tempview,i);
				}
			}
			oldactivity = solo.getCurrentActivity();
			//filetool.writecheckinfo(oldactivity.getLocalClassName(), tempview.getId(), i, allviewlist.size());
			if(i==allviewlist.size()-1){
				filetool.writefinishstatus(oldactivity.getLocalClassName(), "true");
			}
		}
	}
	//select_dialog_listviewd的viewid，判断弹出选择框
	public boolean search_choosedialog(View tempview){
		Filetool filetool = new Filetool();
		if(solo.waitForView(2131689611,1,200)){
			filetool.log("find select_dialog_listview ");
//			ListView select_dialog_listview =(ListView)solo.getView("select_dialog_listview");
//			int listcount =select_dialog_listview.getChildCount();
//			solo.clickOnView(select_dialog_listview.getChildAt(0));solo.sleep(1000);
//			for(int j=1;j<listcount;j++){
//				solo.clickOnView(tempview);solo.sleep(500);
//				solo.clickOnView(((ListView)solo.getView("select_dialog_listview")).getChildAt(j));
//				solo.sleep(1000);
//			}
			return true;
		}else{
			return false;
		}
	}
	public void flag_newactivity(Activity oldactivity,Activity newactivity,View tempview,int i,int available_id,String oldpagename,String newpagename){
		WindowManager wm = getActivity().getWindowManager();
		int width = wm.getDefaultDisplay().getWidth();
		int height = wm.getDefaultDisplay().getHeight();
		Filetool filetool = new Filetool();
		if(oldactivity.equals(newactivity)){
			ArrayList<View> allviewlist2 = solo.getCurrentViews();
			boolean flag_newpage = true;
			int[] location2 = new int[2];
			for(int j=0;j<allviewlist2.size();j++){
				allviewlist2.get(j).getLocationOnScreen(location2);
				
				if(allviewlist2.get(j).getId() == available_id && allviewlist2.get(j).getVisibility()== View.VISIBLE && allviewlist2.get(j).isShown() && (location2[0]!=0 || location2[1]!=0) && (location2[0]>=0 && location2[1]>=0) &&(location2[0]<=width || location2[1]<=height) && allviewlist2.get(j).getId()>=0 ){
					filetool.log("not newpage i= "+i+"   x= "+location2[0]+"   y= "+location2[1] +" class = "+tempview.getClass());
					flag_newpage=false;
					break;
				}
			}
			//newactivity = solo.getCurrentActivity();
			//filetool.writefinishstatus("Page "+newpagenumber, "false");
			//filetool.log("flag_newpage = "+flag_newpage);
			if(!flag_newpage){
				filetool.log("not newactivity and not newpage");
			}else{
				filetool.log("not newactivity and newpage");
				//filetool.writeactiinfo("Page "+oldpagenumber, tempview.getId()+"   x= "+location[0]+"   y= "+location[1], "Page "+newpagenumber);
				solo.hideSoftKeyboard();solo.sleep(500);
				filetool.writeactiinfo("page"+oldpagename, Integer.toHexString(tempview.getId()), "page"+newpagename);
				solo.goBack();solo.sleep(200);
			}
			
		}else{
			filetool.log("newactivity "+oldactivity.getLocalClassName()+ " =  "+newactivity.getLocalClassName());
			filetool.writeactiinfo("page"+oldpagename, Integer.toHexString(tempview.getId()), "page"+newpagename);
			//filetool.writeactiinfo(oldactivity.getLocalClassName(), tempview.getId()+"   x= "+location[0]+"   y= "+location[1], newactivity.getLocalClassName());
			//test_loopclick();
			solo.hideSoftKeyboard();solo.sleep(500);
			solo.goBack();solo.sleep(200);
		}
	}
	
	public void test_readactiinfo(){
		Filetool filetool = new Filetool();
		ArrayList<String> list_id = filetool.ReadListFile("activityinfo.txt", "pageApp of the day");
		for(int i=0;i<list_id.size();i++){
			filetool.log("listnum = "+i+" id = "+list_id.get(i));
			//solo.clickOnView(solo.getView(list_id.get(i)));
			
			parameter.clickOnViewByid(solo, filetool.getStringidByIntid("R.java", list_id.get(i)));
			solo.hideSoftKeyboard();solo.sleep(500);
			solo.goBack();
		}
	}

}
