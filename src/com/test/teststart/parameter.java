package com.test.teststart;

import com.robotium.solo.Solo;

import android.view.View;

public class parameter {
	//获取目标id的view
	public static View getViewByid(Solo solo,String id){
		   int temp =solo.getCurrentActivity().getResources().getIdentifier(id, "id", packageName);
		   View tagview = solo.getView(temp);
		   return tagview;
	   }
	   //点击目标id的view
	   public static void clickOnViewByid(Solo solo,String id){
		   solo.clickOnView(getViewByid(solo, id));
	   }
	
	 //对应re-sign.jar生成出来的信息框里的两个值
	   public static String mainActiviy = "com.instanza.baba.activity.CocoVoice";
	   public static String packageName = "com.instanza.baba";
	
	//目标发送用户或者群
	   //发送照片时，右上角会有不同，需要修改
	//public static String taguser ="soma灌水测试请屏蔽";
	public static String taguser ="606";
	//文本发送按钮
	public static String sendTextBtn ="sendTextBtn";
	//上方工具条
	public static String tool_bar ="tool_bar";
	//右上setting按钮
	public static String title ="title";
	//setting-chat
	public static String row_chat ="row_chat";
	//setting-chat-背景图
	public static String row_chat_background ="row_chat_background";
	//chatting中左下角表情按钮
	public static String showEmojiBtn ="showEmojiBtn";
	//chatting中表情 微笑标记
	public static String emojis_tab_1_smile ="emojis_tab_1_smile";
	//chatting中表情 花朵标记
	public static String emojis_tab_2_flower ="emojis_tab_2_flower";
	//chatting中表情 闹铃标记
	public static String emojis_tab_3_bell ="emojis_tab_3_bell";
	//chatting中表情 汽车标记
	public static String emojis_tab_4_car ="emojis_tab_4_car";
	//chatting中表情 符号标记
	public static String emojis_tab_5_symbols ="emojis_tab_5_symbols";
	//chatting中表情 最近标记
	public static String emojis_tab_0_recents ="emojis_tab_0_recents";
	//右下角附件按钮
	public static String chat_camera_btn ="chat_camera_btn";
	//照片选择页面，GridView
	public static String grid_view ="grid_view";
	//照片选择页面，的发送按钮
	public static String send_text ="send_text";
	
}
