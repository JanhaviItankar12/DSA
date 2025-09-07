
import java.util.ArrayList;

public class FindMinimaMaxima {

    static ArrayList<Integer> findMaxMin(int a[],int st,int end){
        ArrayList<Integer> list=new ArrayList<>();

        if(a[st]==a[end]){
            list.add(a[st]);
            list.add(a[end]);
        }
        else if(a[st]<a[end]){
             list.add(a[st]);
             list.add(a[end]);
        }
        else{
            list.add(a[end]);
            list.add(a[end]);
        }

        return list;
    }

    static ArrayList<Integer> findMinMax(int a[],int st,int end){
        ArrayList<Integer> list=new ArrayList<>();
     
         if(st==end){
          ArrayList<Integer> list1=new ArrayList<>();
          list1.add(a[st]);
          list1.add(a[end]);
          return list1;
        }
        
        if(st==end+1){
            return findMinMax(a, st, end);
        }


        int mid=st+(end-st)/2;

        //left max and min
        ArrayList<Integer> list2=findMinMax(a,st,mid);

        ArrayList<Integer> list3=findMinMax(a,mid+1,end);

        int min=Math.min(list2.get(0),list3.get(0));
        int max=Math.max(list2.get(1),list3.get(1));
        
        list.add(min);
        list.add(max);
      
      
        return list;
       
    }
    public static void main(String[] args) {
        int a[]={400,80,9,6,5,3};
        int n=a.length;
        int st=0;
        int end=n-1;

        ArrayList<Integer> res=findMinMax(a,st,end);
        System.out.println(res);
    }
}
