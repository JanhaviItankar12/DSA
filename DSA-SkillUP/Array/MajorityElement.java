public class MajorityElement {
    public static void main(String args[]){
        int arr[]={4,3};
        int n=arr.length;

        int freq=0;
        int ans=0;
        
        //find majority element
        for(int i=0;i<n;i++){
            if(freq==0){
                ans=arr[i];
            }
            if(ans==arr[i]){
                freq++;
            }
            else{
                freq--;
            }
        }

        

        //count its freq
        freq=0;
        for(int i=0;i<n;i++){
            if(ans==arr[i]){
                freq++;
            }
        }

        if(freq>n/2){
            System.out.println(ans);
        }
        else{
            System.out.println(-1);
        }
    }
}
