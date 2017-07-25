package com.test.sendmessage;

import com.robotium.solo.Solo;
import com.test.teststart.Filetool;
import com.test.teststart.parameter;

import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class sendvideo extends ActivityInstrumentationTestCase2 {
	private Solo solo;
	private static Class<?> launchActivityClass;
	static {
		try {
			launchActivityClass = Class.forName(parameter.mainActiviy);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public sendvideo() {
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

	public static int photoNumberInLine = 4;// 一行的照片个数

	public void test_sendAllPhoto2222() {
		solo.unlockScreen();solo.sleep(2000);
//		   Filetool st = new Filetool();
//		   solo.clickOnText(st.ReadTxtFile());solo.sleep(1000);
			solo.clickOnText("新灌水群");solo.sleep(1000);
		  
			for(int i=0;;i++){
				Toolbar toolbar2 = (Toolbar) parameter.getViewByid(solo,
					parameter.tool_bar);
				solo.sleep(2000);
				parameter.clickOnViewByid(solo,parameter.chat_camera_btn);
				solo.clickOnText("Gallery");solo.sleep(1500);
				solo.clickOnText("Video");solo.sleep(1500);
				solo.clickOnText("All Videos");solo.sleep(1000);
	//			ImageView image0 = (ImageView) parameter.getViewByid(solo, "grid_avatar");
				parameter.clickOnViewByid(solo, "grid_avatar");solo.sleep(2000);
				parameter.clickOnViewByid(solo, "video_send");solo.sleep(2000);
			}
	}

	// 进入到图片选择页面
	//由于用户与群的区别，发送照片时，右上角会有不同，需要修改 taguser
	public void ToPhotoSelectPage(String filename) {
		// 点击右上附件按钮
		Toolbar toolbar2 = (Toolbar) parameter.getViewByid(solo,
				parameter.tool_bar);
		solo.sleep(2000);
////		群聊
////		ActionMenuItemView link_imageview = (ActionMenuItemView) (((ActionMenuView) toolbar2
////				.getChildAt(1)).getChildAt(0));
////		单聊
//		ActionMenuItemView link_imageview = (ActionMenuItemView) (((ActionMenuView) toolbar2
//				.getChildAt(1)).getChildAt(1));
//		solo.sleep(1000);
		parameter.clickOnViewByid(solo,parameter.chat_camera_btn);
		solo.clickOnText("Gallery");solo.sleep(1500);
		solo.clickOnText(filename);
	}

	// 选择并发送
	public void SelectAndSend(RelativeLayout tempfl, String filename) {
		solo.clickOnView(((ImageView) tempfl.getChildAt(1)));
		solo.sleep(100);
		parameter.clickOnViewByid(solo, parameter.send_text);
		solo.sleep(2000);
		ToPhotoSelectPage(filename);
	}

	// 发送一行四张图片、
	/**
	 * 
	 * @param photonum
	 *            计数用，一行第几张照片 1~4循环
	 * @param i
	 *            计数用，全部第几张照片
	 * @param filename
	 *            打开的照片文件夹名
	 */
	public void SendARowPhoto(int photonum, int i, String filename) {
		GridView grid_view = (GridView) parameter.getViewByid(solo,
				parameter.grid_view);
		RelativeLayout tempfl = (RelativeLayout) grid_view.getChildAt(photonum);
		SelectAndSend(tempfl, filename);
		grid_view = (GridView) parameter.getViewByid(solo, parameter.grid_view);
		solo.scrollListToLine(grid_view, i + photoNumberInLine);
		solo.sleep(500);
	}

	public void test_sendphone(String filename) {
		int photonum = 0;// 计数用，第几张照片 1~4循环
		ToPhotoSelectPage(filename);
		GridView grid_view = (GridView) parameter.getViewByid(solo,
				parameter.grid_view);
		RelativeLayout tempfl;
					for(int j = 0;j<9;j++){
						tempfl = (RelativeLayout) grid_view.getChildAt(j+photonum);
						solo.clickOnView(((ImageView) tempfl.getChildAt(1)));
						solo.sleep(100);
					}
					parameter.clickOnViewByid(solo, parameter.send_text);
					solo.sleep(500);
	}
	
	
	public void test_sendphone2(String filename) {
		int photonum = 0;// 计数用，第几张照片 1~4循环
		ToPhotoSelectPage(filename);
		GridView grid_view = (GridView) parameter.getViewByid(solo,
				parameter.grid_view);
		RelativeLayout oldfl, newfl;
		RelativeLayout tempfl;
		String oldfl_con, newfl_con;

		for (int i = 0;; i = i + photoNumberInLine) {
			grid_view = (GridView) parameter.getViewByid(solo,
					parameter.grid_view);
			solo.scrollListToLine(grid_view, 0 + i);
			solo.sleep(500);
			// 取第一张图片，向下滑动一层，
			grid_view = (GridView) parameter.getViewByid(solo,
					parameter.grid_view);
			oldfl = (RelativeLayout) grid_view.getChildAt(0);
			oldfl_con = ((ImageView) oldfl.getChildAt(0)).getDrawable()
					.getConstantState().toString();// 图片的唯一值
			solo.scrollListToLine(grid_view, photoNumberInLine + i);
			solo.sleep(500);
			// 取第一张图片，再向上滑动一层，滑会原处
			grid_view = (GridView) parameter.getViewByid(solo,
					parameter.grid_view);
			newfl = (RelativeLayout) grid_view.getChildAt(0);
			newfl_con = ((ImageView) newfl.getChildAt(0)).getDrawable()
					.getConstantState().toString();// 图片的唯一值
			solo.scrollListToLine(grid_view, 0 + i);
			solo.sleep(500);

			grid_view = (GridView) parameter.getViewByid(solo,
					parameter.grid_view);
			System.out.println("old==" + oldfl_con + "   new==" + newfl_con);
			// 若两张图片相同则判断，已经拉倒底部
			if (newfl_con.equals(oldfl_con)) {
				for (photonum = 0; photonum < grid_view.getChildCount(); photonum=photonum +4) {
					System.out.println("ph===" + photonum);
					grid_view = (GridView) parameter.getViewByid(solo,
							parameter.grid_view);
					int send_num = photoNumberInLine;
					if(grid_view.getChildCount()-photonum<4)
						send_num = grid_view.getChildCount()-photonum;
					
					for(int j = 0;j<send_num;j++){
						tempfl = (RelativeLayout) grid_view.getChildAt(j+photonum);
						solo.clickOnView(((ImageView) tempfl.getChildAt(1)));
						solo.sleep(100);
					}
					parameter.clickOnViewByid(solo, parameter.send_text);
					solo.sleep(500);
					ToPhotoSelectPage(filename);solo.sleep(500);
					grid_view = (GridView) parameter.getViewByid(solo,
							parameter.grid_view);
					solo.scrollListToLine(grid_view, i + photoNumberInLine);
					solo.sleep(500);
				}
				break;
			} else {
					grid_view = (GridView) parameter.getViewByid(solo,
							parameter.grid_view);
					for(int j = 0;j<photoNumberInLine;j++){
						tempfl = (RelativeLayout) grid_view.getChildAt(j);
						solo.clickOnView(((ImageView) tempfl.getChildAt(1)));
						solo.sleep(100);
					}
					parameter.clickOnViewByid(solo, parameter.send_text);
					solo.sleep(500);
					ToPhotoSelectPage(filename);solo.sleep(500);
//					grid_view = (GridView) parameter.getViewByid(solo,
//							parameter.grid_view);
//					solo.scrollListToLine(grid_view, 0 + i);
//					solo.sleep(500);
			}
			oldfl_con = newfl_con;
		}
	}
}
