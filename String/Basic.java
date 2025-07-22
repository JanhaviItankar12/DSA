
import java.util.Scanner;


public class Basic {
    public static void main(String[] args) {
       
        // Scanner sc=new Scanner(System.in);
        // String college=sc.nextLine();
        // System.out.println("My college is "+college);

        // concatenate
        // String firstName="Tonyi";
        // String lastName="Tonyi";
        // String FullName=firstName+" "+lastName;

        // System.out.println(FullName.length());

        // // charAt
        // for(int i=0;i<FullName.length();i++){
        //     System.out.print(FullName.charAt(i)+" ");
        // }

        // compare-it return 0 if equal
        // s1>s2 +ve
        // s1<s2 -ve
        // int result=firstName.compareTo(lastName);
        // System.out.println(result);
        // if(firstName.compareTo(lastName)==0){
        //     System.out.println("Strings are equal");
        // }
        // else if(firstName.compareTo(lastName)>0){
        //     System.out.println("firstname is greater thsn lastname");
        // }
        // else{
        //      System.out.println("lastName is greater thsn firstname");
        // }

        // if(firstName==lastName){
        //     System.out.println("Strings are equal");
        // }
        // else{
        //     System.out.println("Strings are not equal");
        // }


        String sentence1="My name is tony";
        String sentence2="I can do it!!";
        String name=sentence1.substring(11,sentence1.length());
        System.out.println(name);

        Scanner sc=new Scanner(System.in);

        // String line1=sc.next();
        // String line2=sc.next();
        // String line=line1+line2;
        // System.out.println(line.length());


        // int size=sc.nextInt();
        // String arr[]=new String[size];
        // int totLength=0;

        // for(int i=0;i<size;i++){
        //     arr[i]=sc.next();
        //     totLength++;
        // }

        // System.out.println(totLength);

    //     String str=sc.next();

    //     String result="";
        
        

    //     for(int i=0;i<str.length();i++){
    //         if(str.charAt(i)=='h'){
    //             result+="i";
    //         }
    //         else{
    //            result+=str.charAt(i);
    //         }
    //     }

    //    System.out.println(result);


         String str=sc.next();
         String username="";
         for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='@'){
                break;
            }
            else{
                username+=str.charAt(i);
            }
         }

         System.out.println(username);
    }
}
