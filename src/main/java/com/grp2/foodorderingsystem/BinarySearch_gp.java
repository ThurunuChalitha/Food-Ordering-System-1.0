package com.grp2.foodorderingsystem;

public class BinarySearch_gp {
    
    public static int binarySearch(int arr[], int left, int right, int key){  
        if (right>= left){  
            int mid= left + (right - left)/2;  
            if (arr[mid]== key){  
                return mid;  
            }if (arr[mid]> key){  
                return binarySearch(arr, left, mid-1, key); 
            }else{  
                return binarySearch(arr, mid+1, right, key);
            }  
        }  
        return -1;  
    }  
    public static void main(String args[]){  
        int arr[]= {10,20,30,40,50,60,70,80,90,100};// Dush   
        int key= 90;  // text area 
        int right=arr.length-1;  
        int result= binarySearch(arr,0,right,key); 
        
        if (result== -1){ 
            System.out.println("Element is not found!");  
        }else{  
            System.out.println("Element is found at index: "+ result); // display
        }
    }  
}