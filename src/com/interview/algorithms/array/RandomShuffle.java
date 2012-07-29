package com.interview.algorithms.array;

import java.util.Random;

import com.interview.utils.ConsoleReader;

/**
 * 问题： 给定一个有序序列1~n，要你将其完全打乱，要求每个元素在任何一个位置出现的概率均为1/n。<br>
   解决方案：依次遍历数组，对第k+1个元素，以1/k的概率与前k个元素中的某个元素互换位置，最后生成的序列即满足要求。<br>
   使用数学归纳法证明：<br>
		1） 当n=1时，元素arr[0]在任何一个位置的概率为1/1，命题成立。<br>
		2） 假设当n=k时，命题成立，即n=k时，原数组中任何一个元素在任何一个位置的概率为1/k。<br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;则当n=k+1时，当算法执行完k次时，前k个元素在前k个位置的概率均为1/k。<br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;当执行最后一步时，前k个元素中任何一个元素被替换到第k+1位置的概率为：(1-1/(k+1)) * 1/k = 1/(k+1); <br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在前面k个位置任何一个位置的概率为(1-1/(k+1)) * 1/k = 1/(k+1); <br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;故前k个元素在任意位置的的概率都为1/(k+1)； <br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;所以，对于前k个元素，它们在k+1的位置上概率为1/(k+1)。<br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;对于第k+1个元素，其在原位置的概率为1/k+1，在前k个位置任何一个位置的概率为：(1-k/（k+1)） * (1/k)=1/（k+1）<br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;所以对于第k+1个元素，其在整个数组前k+1个位置上的概率也均为1/k+1。<br>
        3） 综上所述，对于任意n，只要按照方案中的方法，即可满足每个元素在任何一个位置出现的概率均为1/n。<br>
 * 
 * @author zouzhile (zouzhile@gmail.com)
 *
 */
public class RandomShuffle {
	
	public void shuffle(int [] array){
		Random random = new Random();
		for(int i = 1; i < array.length; i ++){
			int randomIndex = random.nextInt(i);
			swap(array, randomIndex, i);
		}
	}
	
	private void swap(int[] array, int i, int j){
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public static void main(String[] args){
		System.out.println("The Random Shuffle Implementation");
		System.out.println("========================================================================");
		
		ConsoleReader reader = new ConsoleReader();
		System.out.print("Please input the int array elements: ");
		int[] array = reader.readIntItems();
		System.out.println();
		
		RandomShuffle shuffler = new RandomShuffle();
		shuffler.shuffle(array);
		System.out.print("The shuffled array is : ");
		for(int i: array){
			System.out.print(" " + i);
		}
	}
}
