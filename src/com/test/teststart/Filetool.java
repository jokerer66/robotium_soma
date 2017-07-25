package com.test.teststart;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.util.EncodingUtils;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;


public class Filetool {
	static String  filePath = "/sdcard/robotium/";
	static String  fileName = "paramter.txt";
	static String  fileName2 = "activityinfo.txt";
	static String  fileName3 = "checkinfo.txt";
	static String  fileName4 = "log.txt";
	static String  fileName5 = "finishstatus.txt";
	public void log(String content) {
		SimpleDateFormat    sDateFormat    =   new    SimpleDateFormat("yyyy-MM-dd    hh:mm:ss");       
		String    date    =    sDateFormat.format(new    java.util.Date()); 
		addTxtToFile("time = "+date+"log="+content+"\n", filePath, fileName4);
	    Log.e("tempview ",content);
	}
	public void writeTxt(String content) {
	    writeTxtToFile("paramters="+content+"\n", filePath, fileName);
	}
	public void writeactiinfo(String fromactivity,String button,String toactivity) {
		Log.e("tempview ","fromactivity= "+fromactivity+" button = "+button+" toactivity = "+toactivity);
		addTxtToFile("fromactivity="+fromactivity+" button="+button+" activity="+toactivity+"\n", filePath, fileName2);
	}
	public void writecheckinfo(String activity,int id,int i,int allnumber) {
		addTxtToFile("fromactivity="+activity+" i="+i+"/"+allnumber+" id="+id+"\n", filePath, fileName3);
	}
	public void writefinishstatus(String activity,String status) {
		
		editTxtToFile(activity,status, filePath, fileName5);
	}
	
	public void getpageinfofrom_actiinfo(){
		
	}
	
	// 将字符串写入到文本文件中
	public void writeTxtToFile(String strcontent, String filePath, String fileName) {
	    //生成文件夹之后，再生成文件，不然会出错
	    makeFilePath(filePath, fileName);
	    String strFilePath = filePath+fileName;
	    try{   
	        FileOutputStream fout = new FileOutputStream(strFilePath);   
	        byte [] bytes = strcontent.getBytes();   
	        fout.write(bytes);   
	        fout.close();   
	      }  
	       catch(Exception e){   
	         e.printStackTrace();   
	        }   
	}
	// 将字符串写入到文本文件中
	public void addTxtToFile(String strcontent, String filePath, String fileName) {
	    //生成文件夹之后，再生成文件，不然会出错
	    makeFilePath(filePath, fileName);
	    String strFilePath = filePath+fileName;
	    try{   
	        FileOutputStream fout = new FileOutputStream(strFilePath,true);   
	        byte [] bytes = strcontent.getBytes();   
	        fout.write(bytes);   
	        fout.close();   
	      }  
	       catch(Exception e){   
	         e.printStackTrace();   
	        }   
	}
	// 修改
		public void editTxtToFile(String activity,String status, String filePath, String fileName) {
		    //生成文件夹之后，再生成文件，不然会出错
			makeFilePath(filePath, fileName);
		    String strFilePath = filePath+fileName;
		    File file = new File(strFilePath);
		    String filePath_bak = strFilePath+".bak";
			File file1 = new File(filePath_bak);
		    String content = ""; //文件内容字符串
            //如果path是传递过来的参数，可以做一个非目录的判断
            //if (file.isDirectory()){Log.d("TestFile", "The File doesn't not exist.");}
           
                try {
                	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
        			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file1,false),"UTF-8"));
        			
        			String str = null;
        			int d=0;
        			while((str=br.readLine())!=null){
						if (str.contains(activity) ) {
								bw.write("activity= "+activity+" status="+status);
								bw.write("\r\n");
							d++;
						} else {
							bw.write(str);
							bw.write("\r\n");
						}
						
        			}
        			if(d==0){
						addTxtToFile("activity= "+activity+" status=false"+"\n", filePath, fileName);
					}
        			bw.flush();
        			log(" "+filePath+"...替换成功."+"d="+d);
        			br.close();
        			bw.close();
                }
                catch (java.io.FileNotFoundException e) 
                {} 
                catch (IOException e) 
                {}
                //file.delete();
        		//file1.renameTo(file);
		}	
		//读取文本文件中的内容
	    public static ArrayList<String> ReadListFile(String fromfilename,String tagname)
	    {
	    	ArrayList<String> liststr = new ArrayList<String>() ;
	    	int listnumber = 0;
	        String path = filePath+fromfilename;
	        String content = ""; //文件内容字符串
	            //打开文件
	            File fileName = new File(path);
	            //如果path是传递过来的参数，可以做一个非目录的判断
	            if (fileName.isDirectory()){Log.d("TestFile", "The File doesn't not exist.");}
	            else
	            {
	            	try {
	                	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
	        			
	        			String str = null;
	        			while((str=br.readLine())!=null){
	        				Log.e("tempview"," str = "+str);
							if (str.contains("fromactivity="+tagname) && str.contains("button")) {
								int startnum = str.indexOf("button=");
								String tempstr = str.substring(startnum+7,startnum+7+8);
								if(tempstr.contains(" "))tempstr = str.substring(startnum+7,startnum+7+1);
								Log.e("tempview"," tempstr = "+tempstr);
								liststr.add( tempstr.trim());
								}
							} 
	        			br.close();
	                }
	                catch (java.io.FileNotFoundException e) 
	                {} 
	                catch (IOException e) 
	                {}
	            }
	            return liststr;
	    }
		//读取文本文件中的内容
    public static String ReadTxtFile(String fromfilename)
    {
        String path = filePath+fromfilename;
        String content = ""; //文件内容字符串
            //打开文件
            File fileName = new File(path);
            //如果path是传递过来的参数，可以做一个非目录的判断
            if (fileName.isDirectory()){Log.d("TestFile", "The File doesn't not exist.");}
            else
            {
                try {
                	FileInputStream fin = new FileInputStream(fileName);   
	                int length = fin.available();   
	                byte [] buffer = new byte[length];   
	                fin.read(buffer);       
	                content = EncodingUtils.getString(buffer, "UTF-8");   
	                fin.close();       
                }
                catch (java.io.FileNotFoundException e) 
                {Log.d("TestFile", "The File doesn't not exist.");} 
                catch (IOException e) 
                {Log.d("TestFile", e.getMessage());}
            }
            String[] listaa =content.split("=");
			for(int i=0;i<listaa.length;i++){
				Log.i("listaa",listaa[i]);
			}
            return listaa[1];
    }
	
	
	
	// 生成文件
	public File makeFilePath(String filePath, String fileName) {
	    File file = null;
	    makeRootDirectory(filePath);
	    try {
	        file = new File(filePath + fileName);
	        if (!file.exists()) {
	            file.createNewFile();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return file;
	}
	 
	// 生成文件夹
	public static void makeRootDirectory(String filePath) {
	    File file = null;
	    try {
	        file = new File(filePath);
	        if (!file.exists()) {
	            file.mkdir();
	        }
	    } catch (Exception e) {
	        Log.i("error:", e+"");
	    }
	}
	
	
	//读取文本文件中的内容
    public static String getStringidByIntid(String fromfilename,String tagname)
	    {
	        String path = filePath+fromfilename;
	        String tempstr = "";
	            //打开文件
	            File fileName = new File(path);
	            //如果path是传递过来的参数，可以做一个非目录的判断
	            if (fileName.isDirectory()){Log.d("TestFile", "The File doesn't not exist.");}
	            else
	            {
	            	try {
	                	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
	        			
	        			String str = null;
	        			while((str=br.readLine())!=null){
							if (str.contains("0x"+tagname) && str.contains("int")) {
								int startnum = str.indexOf("public static final int ");
								int endnum = str.indexOf("=0x");
								tempstr = str.substring(startnum+24,endnum);
								Log.e("tempview"," tempstr = "+tempstr);
								}
							} 
	        			br.close();
	                }
	                catch (java.io.FileNotFoundException e) 
	                {} 
	                catch (IOException e) 
	                {}
	            }
	            return tempstr;
	    }
}
