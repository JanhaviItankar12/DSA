

public class MedianOfTwoSortedArray {
    public static void main(String[] args) {
        int a[]={2,3,5,8};
        int b[]={10 ,12 ,14, 16 ,18 ,20};

        int l=0;
        int h=a.length;

        while(l<=h){
            
            //partition of 1 st array
            int m1=(l+h)/2;
            

            //partition of second array
            int m2=((a.length+b.length+1)/2)-m1;

            //  codition to check  correct partition has been made or not
            int l1=(m1==0) ? Integer.MIN_VALUE :a[m1-1];
            int r1=(m1==a.length)? Integer.MAX_VALUE :a[m1];
            int l2=(m2==0) ? Integer.MIN_VALUE:b[m2-1];
            int r2=(m2==b.length)?Integer.MAX_VALUE:b[m2];

            if(l1<=r2 && l2<=r1){
                if((a.length+b.length)%2==0){ //if even length then take max from l1,l2, and min from r1,r2 and take median
                    int maxl=Math.max(l1,l2);
                    int minr=Math.min(r1,r2);
                    double res=(maxl+minr)/2;
                    System.out.println(res);
                    break;
                }
                else{
                    int maxl=Math.max(l1,l2);
                    System.out.println(maxl);
                }
            }
            else if(l2>r1){ //right
                l=m1+1;
            }
            else{
                h=m1-1;  //move to left
            }
        }
    }
}
