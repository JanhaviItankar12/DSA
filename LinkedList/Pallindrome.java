package LinkedList;


    class Node{
    int data;
    Node next;

    // constructor
    Node(int data){
        this.data=data;
        this.next=null;
    }
}

class LinkedList{
   Node head;

   //insert at begining
   public void insertAthead(int data){
     Node newNode=new Node(data);

     newNode.next=head;
     head=newNode;
   }
   
   //insert at end
   public void inserAtend(int data){
     Node newNode=new Node(data);

     //list is empty
     if(head==null){
        head=newNode;
        return ;
     }

     Node curr=head;
     while(curr.next!=null){
        curr=curr.next;
     }

     curr.next=newNode;
   }

   //at the specific position
   public void insertAtpos(int data,int index){
   
    if(index==0){
        insertAthead(data);
        return;
    }

    Node newNode=new Node(data);
    Node curr=head;

    for(int i=0;i<index-1;i++){
        curr=curr.next;
    }

    newNode.next=curr.next;
    curr.next=newNode;

    }

    //deletion

    //at head
    public void deleteAthead(){

        if(head!=null){
            head=head.next;
        }
    }

    //delete at end
    public void deleteAtend(){
       
        if(head==null || head.next==null){
            head=null;
            return;
        }

        Node curr=head;

        while(curr.next.next!=null){
            curr=curr.next;
        }

        curr.next=null;
    }

    public void deleteAtpos(int index){
        
        if(index==0){
            deleteAthead();
            return;
        }


        Node curr=head;
        for(int i=0;i<index-1;i++){
           curr=curr.next;
        }

        curr.next=curr.next.next;

    }

    public void printList(){
        Node curr=head;

        while(curr!=null){
            System.out.print(curr.data+"->");
            curr=curr.next;
        }

        System.out.print("null");
    }

    //search element
    public void search(int data){

        //list is empty
        if(head==null){
           System.out.println("list is empty...");
           return ;
        }

        Node curr=head;
        boolean found=false;
        while(curr!=null){
            if(curr.data==data){
                System.out.println("Element found...");
                found=true;
                break;
            }
            curr=curr.next;
        }

        if(!found){
            System.out.println("Not found...");
        }
    }


    //palindrome
    public Boolean pallindromecheck(){

      //step1:find middle element
      
      Node slow=head;
      Node fast=head;

      while(fast!=null && fast.next!=null){
          slow=slow.next;
          fast=fast.next.next;
      }

      

      //step2: rev second half
      Node prev=null;
      Node next=null;
      Node curr=slow;

      while(curr!=null){
         next=curr.next;
         curr.next=prev;
         prev=curr;
         curr=next;
      }
      
      //step3:check pallindrome
      Node left=head;
      Node right=prev;
      while(right!=null){

          if(left.data!=right.data){
            return false;
          }
          left=left.next;
          right=right.next;
      }

      return true;




    }


}

public class Pallindrome{
public static void main(String[] args){
        LinkedList ll1=new LinkedList();

        ll1.insertAthead(1);
        ll1.inserAtend(2);
        ll1.inserAtend(1);
        

        // ll1.printList();

        Boolean res=ll1.pallindromecheck();
        System.out.println(res);


       


    }

    
}



