package com.yiibai.crawler2;

public enum TaskLevel {
	 LOW("低级", 1), MIDDLE("中级", 2), HIGH("高级", 3);
	 // 成员变量  
    private String level;  
    private int index;  
    // 构造方法  
    private TaskLevel(String level, int index) {  
        this.level = level;  
        this.index = index;  
    }
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	} 
    
    
}
