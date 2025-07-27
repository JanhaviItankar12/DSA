public class AngleBetweenHourandMinuteHand{
    public static void main(String[] args) {
        String s="03:32";
        int n=s.length();
        int hour=0;
        int min=0;
        

        for(int i=0;i<2;i++){
             hour=hour*10+(s.charAt(i)-'0');
        }

        for(int i=3;i<n;i++){
            min=min*10+(s.charAt(i)-'0') ;
        }
       
        double angle1=(30*hour)-5.5*min;
        if(angle1<0){
            angle1=-angle1;
        }
        else if(angle1>360){
            angle1=angle1-360;
        }
        
        double res=Math.min(angle1,360-angle1);
        System.out.println(res);

        

    }
}