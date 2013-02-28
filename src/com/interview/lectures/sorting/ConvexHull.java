package com.interview.lectures.sorting;

import com.interview.lectures.stack.LinkedStack;
import com.interview.lectures.stack.Stack;

/**
 * The convex hull of a set of N points is the smallest perimeter fence enclosing the points.
 * There are 2 facts of the problem:
 * Fact1. Can traverse the convex hull by making only counterclockwise turns.
 * Fact2. The vertices of convex hull appear in increasing order of polar angle 
 * 		  with respect to point p with lowest y-coordinate.
 * 
 * Solution is based on the previous 2 facts:
 * 1. Choose point p with smallest y-coordinate.
 * 2. Sort points by polar angle with p.
 * 3. Consider points in order; discard unless it create a counterclockwise turn.
 * 
 * About counter clockwise:
 * by calculate (b.x-a.x) *(c.y-a.y)- (b.y-a.y)*(c.x-a.x), 
 * 		if the result > 0, they are clockwise, 
 * 		if result < 0, they ain't clockwise, 
 * 		if result = 0, they are in a line  
 * 
 * @author stefaniezhao
 *
 */
public class ConvexHull {
	
	public static Point[] grahamScan(Point[] points){
		Stack<Point> hull = new LinkedStack<Point>();
		
		//1. sort point based on Y-coordinate to find p0.
		getLowestY(points);
		//2. sort pints by polar angle with respect to p0.
		Point.sortByPolarAngle(points);
	
		//find the edges
		hull.push(points[0]);
		hull.push(points[1]);
		
		for(int i = 2; i < points.length; i ++){
			Point top = hull.pop();
			while(Point.counterclockwise(hull.peek(), top, points[i]) <= 0){
				top = hull.pop();
			}
			hull.push(top);
			hull.push(points[i]);
		}
		
		int size = hull.size();
		Point[] edges = new Point[size];
		int index = 0;
		while(!hull.isEmpty()){
			edges[index] = hull.pop();
			index ++;
		}
		return edges;
	}
	
	public static void getLowestY(Point[] points){
		int min = 0;
		for(int i = 1; i < points.length; i ++){
			if(Point.isLower(points[i], points[min]) > 0){
				min = i;
			}
		}
		//swap min and 0
		Point temp = points[0];
		points[0] = points[min];
		points[min] = temp;
	}
	
	
	private static Point[] generateTestPoint() {
		Point[] testPoint = new Point[9];
		String pointStr = "0,0#1,0.5#1,1#2,1.5#0.5,1.5#1,2#0,2#0,1#-0.5,1";
		String[] points = pointStr.split("#");
		for(int i = 0; i < points.length; i ++){
			String[] coords = points[i].split(",");
			double x = Double.parseDouble(coords[0]);
			double y = Double.parseDouble(coords[1]);
			testPoint[i] = new Point(x, y);
		}
		return testPoint;
	}
	
	public static void main(String[] args){
		Point[] testPoint = generateTestPoint();
		for(Point p : testPoint){
			System.out.print(p.toString() + ", ");
		}
		System.out.println();
		Point[] edges = grahamScan(testPoint);
		for(Point p : edges){
			System.out.print(p.toString() + ", ");
		}
	}

}
