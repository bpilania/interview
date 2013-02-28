package com.interview.lectures.sorting;

import java.util.Arrays;

public class Point {
	private double x;
	private double y;
	private double angle;
	
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public String toString(){
		return "(" + x + ", " + y + ")";
	}
	
	public static int isLower(Point a, Point b){
		if(a.y < b.y) return 1;
		else if (a.y > b.y) return -1;
		else return 0;
	}
	
	public static void sortByPolarAngle(Point[] points){
		for(int i = 1; i < points.length; i++){
			double dx = points[i].x - points[0].x;
			double dy = points[i].y - points[0].y;
			points[i].angle = Math.atan2(dy,dx);
		}
		//selection sorting
		for(int i = 1; i < points.length; i++){
			int minIndex = i;
			for(int j = i + 1; j < points.length; j ++){
				if(points[j].angle < points[minIndex].angle)
					minIndex = j;
			}
			if(minIndex != i){
				Point temp = points[i];
				points[i] = points[minIndex];
				points[minIndex] = temp;
			}
		}
	}
	
	public static int counterclockwise(Point a, Point b, Point c){
		double area2 = (b.x-a.x) *(c.y-a.y)- (b.y-a.y)*(c.x-a.x);
		if(area2 > 0) return 1;
		else if(area2 < 0) return -1;
		else return 0;
	}
	
}
