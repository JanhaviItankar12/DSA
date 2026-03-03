import java.util.*;

public class DeterministicSelectionAlgo {

    public static int deterministicAlgo(int arr[],int k){
        
        //return kth smallest lement from it
        if(arr.length<=5){
            Arrays.sort(arr);
            return arr[k];
        }

        //step1:Divide into groups of 5 and find medians
        int numGroups=(int)Math.ceil(arr.length/5.0);
        int []medians=new int[numGroups];

        for(int i=0;i<numGroups;i++){
            int start=i*5;
            int end=Math.min(start+5,arr.length);

            int group[]=Arrays.copyOfRange(arr,start,end);
            Arrays.sort(group);

            medians[i]=group[group.length/2];
        }
        
        //step2:find median of medians
        int pivot=deterministicAlgo(medians, medians.length/2);

        //step3:partition
        List<Integer> low=new ArrayList<>();
        List<Integer> high=new ArrayList<>();
        List<Integer> equal=new ArrayList<>();

        for(int num:arr){
            if(num<pivot){
                low.add(num);
            }
            else if(num>pivot){
                high.add(num);
            }
            else{
                equal.add(pivot);
            }
        }

        if(k<low.size()){
            return deterministicAlgo(low.stream().mapToInt(i->i).toArray(), k);
        }
        else if(k<low.size()+equal.size()){
            return pivot;
        }
        else{
            return deterministicAlgo(high.stream().mapToInt(i->i).toArray(), k-low.size()-equal.size());
        }


    }
    public static void main(String[] args){
        int arr[]={12, 3, 5, 7, 4, 19, 26};
        int n=arr.length;
        int k=6;

        int ans=deterministicAlgo(arr,k-1);

        System.out.println("Kth smallest element: "+ans);

    }
}
