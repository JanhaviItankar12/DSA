

import java.util.ArrayList;
import java.util.Collections;

public class MajorityElement {
    public static  ArrayList<Integer> Solution(int arr[],int n){
        int ele1=-1;
        int ele2=-1;
        int count1=0;
        int count2=0;

        ArrayList<Integer> list=new ArrayList<>();
         
        //step1: find two elemets
         for(int i=0;i<n;i++){
            if(ele1==arr[i]){
                count1++;
            }
            else if(ele2==arr[i]){
                count2++;
            }
            // for new element
            else if(count1==0){
              ele1=arr[i];
              count1++;
            }
            // for new element
            else if(count2==0){
                ele2=arr[i];
                count2++;
            }
            else{
                count1--;
                count2--;
            }
         }
        
        //step2:  traverse array and count occurences of ele1 and ele2
        count1=0;
        count2=0;
        for(int i=0;i<n;i++){
           if(ele1==arr[i]){
              count1++;
           }
           else if(ele2==arr[i]){
             count2++;
           }
        }

        // step3:check whether majority or not
        if(count1>n/3){
            list.add(ele1);
        }
        if(count2>ele2){
            list.add(ele2);
        }

        //step4:sort the array in inc order
        Collections.sort(list);
        return list;


         
    }
    public static void main(String[] args) {
        int arr[]={2, 2, 3, 1, 3, 2, 1, 1};
        int n=arr.length;
        // Arrays.sort(arr);
        // int count=1;
       
        
       
        // brute-Force approach
        // for(int i=1;i<n;i++){   //TC=O(n)
        //     if(arr[i]==arr[i-1]){   //TC=O(logn)
        //         count++;
        //         // System.out.println(count);
        //         if(count>n/3 && !list.contains(arr[i])){
        //            list.add(arr[i]);
        //         }
        //     }
        //     else{
        //       count=1;
        //     }
        // }
  
        // // TC=O(nlogn)
        // Collections.sort(list);
        // System.out.println(list);
        

        // TC=O(n)
        // optimal approach-moore's voting algorithm
        
        ArrayList<Integer> list=Solution(arr,n);
        System.out.println(list);
    }
}
