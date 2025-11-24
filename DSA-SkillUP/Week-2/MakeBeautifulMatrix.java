public class MakeBeautifulMatrix {
    public static void main(String[] args) {
        int mat[][]={
            {1,2,3},
            {4,2,3},
            {3,2,1}
            
        };

        int row=mat.length;
        int col=mat[0].length;
        int ans=0;

        for(int i=0;i<row;i++){
            int rowSum=0;
            int colSum=0;
            for(int j=0;j<col;j++){
               rowSum+=mat[i][j];
               colSum+=mat[j][i];
            }
            ans=Math.max(Math.max(rowSum,colSum),ans);
        }

        int stR=0;
        int stC=0;
        int count=0;

        while(stR<row && stC<col){

            //calulate row sum
            int sum1=0;
            for(int i=0;i<col;i++){
                sum1+=mat[stR][i];
            }

            //calculate col sum
            int sum2=0;
            for(int i=0;i<row;i++){
                sum2+=mat[i][stC];
            }

            int diff=Math.min(ans-sum1,ans-sum2);

            mat[stR][stC]+=diff;
            sum1+=diff;
            sum2+=diff;
            count+=diff;

            if(sum1==ans) stR++;
            if(sum2==ans) stC++;
        }
       
        System.out.println(count);
    }
 
}
