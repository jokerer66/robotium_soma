package com.test.sendmessage;

import java.util.ArrayList;

//import xuxu.autotest.AdbDevice;
//import xuxu.autotest.element.Element;
//import xuxu.autotest.element.Position;

public class CrossProcessUtil {
//	
//	private AdbDevice adbDevice;
//	private Position position;
//	
//	public CrossProcessUtil(){
//		adbDevice = new AdbDevice();
//		position = new Position();
//	}
//	
//	public void CameraUtil(){
//		Element  element;  
//			adbDevice.tap(1140,360);
//			try {
//				Thread.sleep(3000);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//			element= position.findElementByText("Save");
//			adbDevice.tap(element);
//			try {
//				Thread.sleep(1000);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//	}
//	
//	public boolean CallUtil(String callNumber){
//		Element  element;  
//        boolean  result;  
//        //验证是否拨打了正确的号码  
////        if(callNumber.length() == 11){//正常号码需要转变为 x xxx-xxx-xxxx的格式  
////                String formatCallNumber = callNumber.substring(0, 1) + " " +callNumber.substring(1, 4) + "-" + callNumber.substring(4,7) +"-" + callNumber.substring(7, callNumber.length());  
////                element= position.findElementByText(formatCallNumber);  
////                try{  
////                        Thread.sleep(5000);  //线程休眠5秒  
////                }catch (InterruptedException e) {  
////                        e.printStackTrace();  
////                }  
////        }else{  
////                element= position.findElementByText(callNumber);//除正常号码外，其他格式的号码不进行格式转换  
////        }  
//        element= position.findElementByText(callNumber);
//        if(element != null){  
//                result= true;  
//        }else{  
//                result= false;  
//        }  
//        element= position.findElementByText("结束通话");   //挂断电话  
//        if(element != null) adbDevice.tap(element);  
//        return  result;  
//	}
}
