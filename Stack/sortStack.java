import java.util.*;

public class sortStack {
    public static void main(String[] args) {
        
        Stack<Integer> stack=new Stack<>();

        stack.push(8);
        stack.push(87);
        stack.push(18);
        stack.push(38);
        stack.push(28);
        
        
        int arr[]=new int[stack.size()];
        int i=0;
        while(!stack.isEmpty()){
            arr[i]=stack.pop();
            i++;
        }

        Arrays.sort(arr);

        for(int j=0;j<arr.length;j++){
            stack.push(arr[j]);
        }

        System.out.println(stack);



       
    }
}
