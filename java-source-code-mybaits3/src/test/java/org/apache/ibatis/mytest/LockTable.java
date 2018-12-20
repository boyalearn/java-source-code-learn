package org.apache.ibatis.mytest;

public class LockTable{
	
	private String lockNum;
	
	private String lockTime;

	public String getLockNum() {
		return lockNum;
	}

	public void setLockNum(String lockNum) {
		this.lockNum = lockNum;
	}

	public String getLockTime() {
		return lockTime;
	}

	public void setLockTime(String lockTime) {
		this.lockTime = lockTime;
	}

	@Override
	public String toString() {
		return "LockTable [lockNum=" + lockNum + ", lockTime=" + lockTime + "]";
	}
	
	

}
