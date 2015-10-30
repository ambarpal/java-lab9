package com.Pizza.utils;

public class UIDGenerator {
	public static int init = 0;
	public static int genUID(){
		init += 1;
		return init;
	}
}
