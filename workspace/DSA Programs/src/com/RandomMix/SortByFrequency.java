package com.RandomMix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class SortByFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int[] arr = {5, 5, 4, 6, 4};
     sortByFreq(arr,arr.length);
	}
	static void sortByFreq(int arr[], int n)
    {
        // add your code here
        HashMap<Integer,Integer> mp = new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++){
            if(mp.containsKey(arr[i])){
                mp.put(arr[i],mp.get(arr[i])+1);
            }else{
                mp.put(arr[i],1);
            }
        }
        HashMap<Integer,ArrayList<Integer>> ali = new HashMap<Integer,ArrayList<Integer>>();
        ArrayList<Integer> freq = new ArrayList<Integer>();
        for(Integer a: mp.keySet()){
            int fre1 = mp.get(a);
            //System.out.println("fre1 "+fre1+" a "+a);
            if(ali.containsKey(fre1)){
            	//System.out.println("array LISST "+ali.get(fre1));
            	ArrayList<Integer> tempal1 = ali.get(fre1);
            	tempal1.add(a);
                ali.put(fre1,tempal1);
            }else{
            	freq.add(fre1);
            	ArrayList<Integer> alTemp2 = new ArrayList<Integer>();
            	alTemp2.add(a);
                ali.put(fre1,alTemp2);
                //System.out.println("arrayyyyy list "+ali.get(fre1));
            }
        }
        Collections.sort(freq,Collections.reverseOrder());
        StringBuffer ab = new StringBuffer();
        Iterator<Integer> it = freq.iterator();
        while(it.hasNext()){
            int temp = it.next();
            ArrayList<Integer> tempal = ali.get(temp);
            Collections.sort(tempal);
            Iterator<Integer> itemp = tempal.iterator();
            while(itemp.hasNext()){
                int temp2 = itemp.next(),ftemp = temp;
            while(ftemp-->0){
                ab.append(temp2+" ");
            }
            }
        }
        System.out.println(ab);    
    }

}
