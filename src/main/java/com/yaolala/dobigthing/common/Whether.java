package com.yaolala.dobigthing.common;

public enum Whether { //枚举类
	YES(1),
	NO(0);
    
	private int value;
	
	Whether(int value){
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
}
 