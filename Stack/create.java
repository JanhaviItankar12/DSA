
class MyStack{
    int arr[];
    int size;
    int top;

    MyStack(int size){
        this.size=size;
        arr=new int[size];
        top=-1;
    }

    public Boolean push(int data){
        if(top==size-1)  return false;
        arr[++top]=data;
        return true;
    }

    public int pop(){
        if(top==-1){
            return -1;
        }
        int x=arr[top--];
        return x;
    }

    public boolean isEmpty(){
        if(top==-1)  return true;
        return false;
    }

    public boolean isFull(){
        if(top==size-1)  return true;
        return false;
    }
}
public class create{
    public static void main(String[] args) {
        MyStack obj=new MyStack(5);

        System.out.println(obj.push(4));
        System.out.println(obj.push(3));
        System.out.println(obj.push(3));
        System.out.println(obj.push(3));
        System.out.println(obj.push(3));
        System.out.println(obj.push(3));

        System.out.println(obj.isFull());

        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());

        System.out.println(obj.isEmpty());


    }
}