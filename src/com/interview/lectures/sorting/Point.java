package com.interview.lectures.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class Point {
	public static final Comparator<Point> BY_Y_AXIS = new YAxisComparator();
	public static final Comparator<Point> BY_ANGLE = new AngleComparator();
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
	
	private static class YAxisComparator implements Comparator<Point>{

		@Override
		public int compare(Point p1, Point p2) {
			if(p1.y == p2.y) return 0;
			else if (p1.y > p2.y) return 1;
			else return -1;
		}
	}
	
	private static class AngleComparator implements Comparator<Point>{

		@Override
		public int compare(Point p1, Point p2) {
			if (p1.angle == p2.angle) return 0;
			else if(p1.angle > p2.angle) return 1;
			else return -1;
		}
		
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
		
		Arrays.sort(points, 1, points.length, Point.BY_ANGLE);
//		//selection sorting
//		for(int i = 1; i < points.length; i++){
//			int minIndex = i;
//			for(int j = i + 1; j < points.length; j ++){
//				if(points[j].angle < points[minIndex].angle)
//					minIndex = j;
//			}
//			if(minIndex != i){
//				Point temp = points[i];
//				points[i] = points[minIndex];
//				points[minIndex] = temp;
//			}
//		}
	}
	
	public static int counterclockwise(Point a, Point b, Point c){
		double area2 = (b.x-a.x) *(c.y-a.y)- (b.y-a.y)*(c.x-a.x);
		if(area2 > 0) return 1;
		else if(area2 < 0) return -1;
		else return 0;
	}
	
}
