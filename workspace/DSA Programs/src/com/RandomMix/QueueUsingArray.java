package PractiseJavaPrograms;

import java.util.Queue;

public class QueueUsingArray {
	 int front, rear;
     int arr[] = new int[1000];
     QueueUsingArray()
 	{
 		front=0;
 		rear=0;
 	}
     /* The method push to push element
	   into the queue */
	void push(int a)
	{
	    // Your code here
	    arr[front] = a;
	    front = (front+1)%arr.length;
	} 
  /* The method pop which return the 
     element poped out of the queue*/
	int pop()
	{
		// Your code here
		if(rear == front){
		    return -1;
		}
		int a = arr[rear];
		rear = (rear+1)%arr.length;
		return a;
	}  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
