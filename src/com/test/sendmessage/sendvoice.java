package com.test.sendmessage;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;
import com.test.teststart.Filetool;
import com.test.teststart.parameter;

public class sendvoice extends ActivityInstrumentationTestCase2 {
	private Solo solo;
	private static Class<?> launchActivityClass;
	static {
		try {
			launchActivityClass = Class.forName(parameter.mainActiviy);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public sendvoice() {
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
	
	public void testsendvoice(){
		solo.unlockScreen();solo.sleep(2000);
//		   Filetool st = new Filetool();
//		   solo.clickOnText(st.ReadTxtFile());solo.sleep(1000);
			solo.clickOnText("新灌水群");solo.sleep(1000);
		for(int i=1;i<5000;i++){
			solo.clickLongOnView(parameter.getViewByid(solo, "chat_voice_btn"), 5*1000);
			solo.sleep(2000);
		}
	}

}
