package com.test.teststart;

public class MemFillTool {
	
	static{
		System.loadLibrary("autotest");
	}
	public MemFillTool() {
	}

	public static MemFillTool instance = null;

	public static MemFillTool getInstance() {
		if (instance == null) {
			instance = new MemFillTool();
		}
		return instance;
	}

	// 填充xxxMB内存
	public native int fillMem(int blockNum);
	
	// 释放刚才填充的内存
	public native int freeMem();
}