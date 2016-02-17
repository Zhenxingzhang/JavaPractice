package com.zhenxing.careercup;


/**
 * Created by zhenxingzhang on 17/02/2016.
 */

public class MeanAndMedian {

    private int[] valueArray = new int[1000];
    private int sum =0;
    private int count =0;


    public void insert(int number){
        if(number > 999 || number < 0)
        {
            System.out.println("Value: out of range");
            return;
        }

        this.sum += number;
        this.count += 1;
        valueArray[number] ++;
    }

    public float getMean(){
        return (float)this.sum/this.count;
    }

    public float getMedia(){
        int idx = 0;
        int median_left, median_right = 0;
        float median = 0.0f;

        if(count % 2 == 0){
            median_left = count/2;
            median_right= median_left + 1;
        }else{
            median_left = count/2;
            median_right = median_left;
        }
        for(int i = 0; i < 1000; i++){
            idx += valueArray[i];
            if(idx >= median_left && idx >= median_right){
                median = i;
                break;
            }
            if(idx >= median_left && idx < median_right){
                median = (float)(i + i+ 1)/2;
                break;
            }
        }
        return median;
    }

    public static void main(String[] args){
//        int[] array = {1,2,3,4,5,6};
        int array[] = {13, 18, 13, 14, 13, 16, 14, 21, 13};

        MeanAndMedian mm = new MeanAndMedian();
        for(int value : array){
            mm.insert(value);
        }

        System.out.println("Mean: "+ mm.getMean());
        System.out.println("Median: "+ mm.getMedia());
    }
}
