package com.interview.utils;

import java.util.Date;

public class Timer {

	private long start, stop;
	
	public void start(){
		this.start = new Date().getTime();
	}
	
	public void stop(){
		this.stop = new Date().getTime();
	}
	
	public long getTotalMilliSeconds(){
		return stop - start;
	}
	
	public long getTotalSeconds(){
		return (stop - start) / 1000;
	}
	
	public String toString(){
		long milliseconds = (stop - start) % 1000;
		long seconds = (stop - start) / 1000;
		long hours = seconds / 3600;
		seconds -= hours * 3600;
		long minutes = seconds / 60;
		seconds -= minutes * 60;
		return String.format("%s hours, %s minutes, %s seconds, %s milliseconds", 
				hours, minutes, seconds, milliseconds);
				
	}
}
