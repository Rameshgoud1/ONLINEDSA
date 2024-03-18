public class LinkedList {
    static class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }
    public static Node head;
    public static void printLL(){
        Node temp=head;
        if (head==null) System.out.println("list is empty");
        else{
            while(temp!=null){
               System.out.print(temp.data+"-->");
                temp=temp.next;
           }
            System.out.println("null");
        }
    }
    public static int count(){
        Node temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
    public static void addBegging(int d){
        Node newnode=new Node(d);
        if(head==null){
            head=newnode;
        }
        else{
            Node temp=head;
            newnode.next=temp;
            head=newnode;
        }
    }
    public static void addLast(int d){
       Node newnode=new Node(60);
        if(head==null){
           head=newnode;
        }
        else{
           Node temp=head;
           while(temp.next!=null){
               temp=temp.next;
            }
            temp.next=newnode;
        }
    }
    public static void delFirst(){
        Node temp=head;
        head=head.next;
        temp.next=null;
    }
    public static void delLast(){
        Node temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
    }
    public static void addPosition(int k){
        int count=1;
        Node temp=head;
        if(k==0) System.out.println("the position is zero");
        else if(k==1) addBegging(500);
        else{
        while(count<k-1){
            temp=temp.next;
             count++;
        }
        Node newnode=new Node(500);
        newnode.next=temp.next;
        temp.next=newnode;
    }
    }
    public static void delPosition(int k){
        int count=1;
        Node temp=head;
        if(k==0) System.out.println("the position is zero");
        else if(k==1) delFirst();
        else{
            while(count<k-1){
                temp=temp.next;
                count++;
            }
            temp.next=temp.next.next;
        }
    }
    public static void toFind(int d){
            Node temp=head;
            int c=count();
           // System.out.println(count);
            if(c==0){
                System.out.println("Linked list is empty");
               }
             else{
                while(temp!=null){
                    if(temp.data==d){
                     System.out.println(temp);
                     }
                     temp=temp.next;
                }
             }
    }                   
    public static void midEle(){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        System.out.println(slow.data);
    }

     public static boolean  isCircle(){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow) { return true;}
        }
        return false;
      }
      public static void cirEle(){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                break;
            }
       }
       slow=head;
       while(fast!=slow){
            slow=slow.next;
            fast=fast.next;
       }
       System.out.println(slow.data);
      }
     public static void countLoop(){
        Node slow=head;
        Node fast=head;
        int count=1;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast ==slow) break;
        }
        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        slow=slow.next;
        while(slow!=fast){
            count++;
            slow=slow.next;
        }
         System.out.println(count);
     }
     public static Node addTwoNumbers(Node l1, Node l2) {
        Node newnode=new Node(-1);
        Node head=newnode;
        Node t1=l1;
        Node t2=l2;
        int carry=0;
        while(t1!=null || t2!=null){
            int sum=0;
            if(t1!=null){
                sum+=t1.data;
                t1=t1.next;
            }
            if(t2!=null){
                sum+=t2.data;
                t2=t2.next;
            }
            sum+=carry;
            carry=sum/10;
            Node temp=new Node(sum%10);
            newnode.next=temp;
            newnode=newnode.next;
        }
        if(carry!=0){
            Node carrynode=new Node(carry);
            newnode.next=carrynode;
          
            }
     return head.next;
    }
    public static void deleteKelement(int k){
        Node fast=head;
        Node slow=head;
        while(k!=0 && fast!=null){
            fast=fast.next;
            k--;

        }
        if(k!=0) System.out.println("enter a valid  key");
        if(fast==null){
           head=head.next;
        }
        else{
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
         slow.next=slow.next.next;
        
      }
    }
    public static Node toReverse(){
        Node previs=null;
        Node curr=head;
        Node nxt;
        while(curr!=null){
            nxt=curr.next;
            curr.next=previs;
            previs=curr;
            curr=nxt;
        }
        return previs;
    }
    public static Node evenoddindices(){
        Node evenhead=new Node(-1);
        Node oddhead=new Node(-1);
        Node even=evenhead;
        Node odd=oddhead;
        Node temp=head;
        int count=0;
        while(temp!=null){
            if(count%2==0){
                even.next=temp;
                even=even.next;
            }
            else{
                odd.next=temp;
                odd=odd.next;
            }
            temp=temp.next;
            count++;
        }
        odd.next=null;
        even.next=oddhead.next;
     return evenhead.next;
    }
    public static Node sortinglist(){
        Node zerohead=new  Node(-1);
        Node onehead=new Node(-1);
        Node twohead=new Node(-1);
        Node zero=zerohead;
        Node one=onehead;
        Node two=twohead;
        Node temp=head;
        while(temp!=null){
            if(temp.data==0){
                zero.next=temp;
                zero=zero.next;
            }
            else if(temp.data==1){
                one.next=temp;
                one=one.next;
            }
            else{
                two.next=temp;
                two=two.next;
            }
            temp=temp.next;
        }
        two.next=null;
        if(onehead.next==null){
            zero.next=twohead.next;
        }
        else {
            zero.next=onehead.next;
            one.next=twohead.next;
        }
        return zerohead.next;

    }
    public static boolean isPalindrome(){
        Node previshead=null;
        Node previs=previshead;
        Node fast=head;
        Node slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node curr=slow;
        Node nxt;
        while(curr!=null){
            nxt=curr.next; 
            curr.next=previs;
            previs=curr;
            curr=nxt;
        }
        Node temp=head;
        while(temp!=null && previs!=null){
            if(temp.data!=previs.data){
                return false;
            }
            temp=temp.next;
            previs=previs.next;
         }
         return true;
    }
    public static Node rightRotate(int k){
        int count=1;
        Node temp=head;
        while(temp.next!=null){  
        count++;
        temp=temp.next;
       }
       if(k%count==0){
        return head;
       }
      else{
       temp.next=head;
       temp=head;
       Node previs=null;
        k=k%count;
        int i=0;
       while(i<count-k){
        previs=temp;
        temp=temp.next;
        i++;
       }
       previs.next=null;
       head=temp;
       return head;
    }
}
public static Node leftRotate(int k){
    Node temp=head;
    Node previs=null;
    int i=0;
    int count=1;
    while(temp.next!=null){
        temp=temp.next;
        count++;
    }
    if(k%count==0) {return head;}
    else{
    k=k%count;
    temp.next=head;
    while(i<k+1){
        previs=temp;
        temp=temp.next;
        i++;
    }
    previs.next=null;
    return temp;
    }
}


    
    public static  void main(String args[]){
       head=new Node(10);
       head.next=new Node(20);
       head.next.next=new Node(30);
       head.next.next.next=new Node(40);
       head.next.next.next.next=new Node(50);
       head.next.next.next.next.next=new Node(60);
       //printLL();
       //printLL();
      //addPosition(3);
       //printLL();
     //  delPosition(2);
       //printLL();
       //addBegging(100);
       //printLL();
       //delFirst();
       //printLL();
      //addLast(200);
       //printLL();
       //delLast();
       //printLL();
       //System.out.println(count());
       //toFind(30);
       //printLL();
      // midEle();
      //System.out.println(isCircle());
      //cirEle();
      //countLoop();
      //head=addTwoNumbers(l1,l2);
      // deleteKelement(8);
     // printLL();
      //Node temp=toReverse();
      //printLL(temp);
      //head=evenoddindices();
     // head=sortinglist();
      //printLL();
      //System.out.println(isPalindrome());
      //printLL();
      //head=leftRotate(15);
      //printLL();

      
    }
}
