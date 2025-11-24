public class TowerOfHonoi {

    static int allocateDisk(int n,int from,int to,int aux,int count){
        
       if(n==1){
        count++;
        return count;
       }

       count=allocateDisk(n-1, from, aux,to, count);
       count++;
       count=allocateDisk(n-1, aux, to, from, count);
       return count;
    }
    public static void main(String[] args){
        int n=3;
        int from=1;
        int to=2;
        int aux=3;
        int count=0;
         
        int res=allocateDisk(n,from,to,aux,count);
        System.out.println(res);
    }
}
