package com.test.sendmessage;


import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;
import com.test.teststart.Filetool;
import com.test.teststart.parameter;

public class sendtext extends ActivityInstrumentationTestCase2 {
	//package      com.instanza.baba
	//activity     com.instanza.baba.activity.CocoVoice
	//1,创建一个自动化测试对象Ø
	   private Solo solo;
	   private static Class<?> launchActivityClass;
	   protected String  tagname  = "";  
	   
	   public String getTagname() {
		return tagname;
		}
		public void setTagname(String tagname) {
			this.tagname = tagname;
		}


	//对应re-sign.jar生成出来的信息框里的两个值
	   static {
		   
			try {
				launchActivityClass = Class.forName(parameter.mainActiviy);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}

		public sendtext() {
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
		   solo.unlockScreen();solo.sleep(2000);
		   Filetool st = new Filetool();
		   solo.clickOnText(st.ReadTxtFile("paramter.txt"));solo.sleep(1000);
			for (int i = 0; i < 400; i++) {
				solo.enterText(0, "count == " + i);
				parameter.clickOnViewByid(solo, parameter.sendTextBtn);
			}
		}
	   
	   public void testsendallmsg() {
		   solo.unlockScreen();solo.sleep(2000);
		   Filetool st = new Filetool();
		   solo.clickOnText(st.ReadTxtFile("paramter.txt"));solo.sleep(1000);
			String uninum[]= {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
			String uniword;
			int i=2;
			for(int j=15;j<16;j++){
				for(int k=15;k<16;k++){
					for(int l=0;l<uninum.length;l++){
						uniword = decodeUnicode("\\u"+uninum[i]+uninum[j]+uninum[k]+uninum[l]);
						solo.enterText(0, uniword);
						solo.sleep(10);
					}
					solo.enterText(0, " // "+uninum[i]+uninum[j]+uninum[k]);
					parameter.clickOnViewByid(solo, parameter.sendTextBtn);
					
					solo.sleep(100);
				}
			}
		}
	   
	   
	   public static String decodeUnicode(String theString) {
			char aChar;
			int len = theString.length();
			StringBuffer outBuffer = new StringBuffer(len);
			for (int x = 0; x < len;) {
				aChar = theString.charAt(x++);
				if (aChar == '\\') {
					aChar = theString.charAt(x++);
					if (aChar == 'u') {
						// Read the xxxx
						int value = 0;
						for (int i = 0; i < 4; i++) {
							aChar = theString.charAt(x++);
							switch (aChar) {
							case '0':
							case '1':
							case '2':
							case '3':
							case '4':
							case '5':
							case '6':
							case '7':
							case '8':
							case '9':
								value = (value << 4) + aChar - '0';
								break;
							case 'a':
							case 'b':
							case 'c':
							case 'd':
							case 'e':
							case 'f':
								value = (value << 4) + 10 + aChar - 'a';
								break;
							case 'A':
							case 'B':
							case 'C':
							case 'D':
							case 'E':
							case 'F':
								value = (value << 4) + 10 + aChar - 'A';
								break;
							default:
								throw new IllegalArgumentException(
										"Malformed   \\uxxxx   encoding.");
							}

						}
						outBuffer.append((char) value);
					} else {
						if (aChar == 't')
							aChar = '\t';
						else if (aChar == 'r')
							aChar = '\r';

						else if (aChar == 'n')

							aChar = '\n';

						else if (aChar == 'f')

							aChar = '\f';

						outBuffer.append(aChar);

					}

				} else

					outBuffer.append(aChar);

			}

			return outBuffer.toString();

		}
}
