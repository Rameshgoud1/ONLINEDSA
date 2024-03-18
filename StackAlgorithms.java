import java.util.*;
public  class StackAlgorithms {
    public  static void nextGretestelementRight(int[] a){
        Stack<Integer> st=new Stack<>();
        int[] gretest=new int[a.length];
        for(int i=a.length-1;i>=0;i--){
            while(!st.isEmpty() && a[i]>=a[st.peek()]){
                st.pop();
        }
        if(st.isEmpty()) gretest[i]=-1;
        else gretest[i]=a[st.peek()];
        st.push(i);
    }
        for(int i=0;i<gretest.length;i++){
            System.out.print(gretest[i]+" ");
        }
    }
    public  static void nextSmallestelementRight(int[] a){
        Stack<Integer> st=new Stack<>();
        int[] gretest=new int[a.length];
        for(int i=a.length-1;i>=0;i--){
            while(!st.isEmpty() && a[i]<=a[st.peek()]){
                st.pop();
        }
        if(st.isEmpty()) gretest[i]=-1;
        else gretest[i]=a[st.peek()];
        st.push(i);
    }
        for(int i=0;i<gretest.length;i++){
            System.out.print(gretest[i]+" ");
        }
    }
    public  static void nextGretestelementLeft(int[] a){
        Stack<Integer> st=new Stack<>();
        int[] gretest=new int[a.length];
        for(int i=0;i<a.length;i++){
            while(!st.isEmpty() && a[i]>=a[st.peek()]){
                st.pop();
        }
        if(st.isEmpty()) gretest[i]=-1;
        else gretest[i]=a[st.peek()];
        st.push(i);
    }
        for(int i=0;i<gretest.length;i++){
            System.out.print(gretest[i]+" ");
        }
    }
    public  static void nextSmallestelementLeft(int[] a){
        Stack<Integer> st=new Stack<>();
        int[] gretest=new int[a.length];
        for(int i=0;i<a.length;i++){
            while(!st.isEmpty() && a[i]<=a[st.peek()]){
                st.pop();
        }
        if(st.isEmpty()) gretest[i]=-1;
        else gretest[i]=a[st.peek()];
        st.push(i);
    }
        for(int i=0;i<gretest.length;i++){
            System.out.print(gretest[i]+" ");
        }
    }

    public static void calculateSpan(int price[], int n)
    {
        Stack<Integer> st=new Stack<>();
        int[] span=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&& price[i]>=price[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) span[i]=i+1;
            else span[i]=i-st.peek();
            st.push(i);
            
        }
        for(int i=0;i<n;i++){
            System.out.print(span[i]+" ");
        }
    }
    public static boolean isvalidParenthesis(String s) {
        Stack<Character> st=new Stack<>();
        if(s.length()==1) return false;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='(' || c=='{' || c=='[' ){
                st.push(c);
            }
            else{
                if(c==')'){
                    if(st.isEmpty()) return false;
                    if(st.peek()!='(') return false;
                    st.pop();
                 }
                else if(c==']'){
                    if(st.isEmpty()) return false;
                    if(st.peek()!='[')   return false;
                    st.pop();
                }
                else if(c=='}'){
                    if(st.isEmpty()) return false;
                    if(st.peek()!='{') return false;
                     st.pop();
                }
                
            }

        }
        return st.isEmpty();  
    }
    public static int largestRectangleArea(int[] hist) {
        Stack<Integer> st=new Stack<>();
        int[] nsr=new int[hist.length];
        for(int i=hist.length-1;i>=0;i--){
            while(!st.isEmpty() && hist[i]<=hist[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) nsr[i]=hist.length;
            else nsr[i]=st.peek();
            st.push(i);
        }
        st.clear();
        st=new Stack<>();
        int[] nsl=new int[hist.length];
        for(int i=0;i<hist.length;i++){
            while(!st.isEmpty() && hist[i]<=hist[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) nsl[i]=-1;
            else nsl[i]=st.peek();;
            st.push(i);
        }
        int maxarea=0;
        for(int i=0;i<hist.length;i++){
          int area=(nsr[i]-nsl[i]-1)*hist[i];  
           maxarea=Math.max(area,maxarea);
        }
        return maxarea;
    }
    public static void infixToPostfix(String exp) {
        Stack<Character> st=new Stack();
        String postfix="";
        for(int i=0;i<exp.length();i++){
            char c=exp.charAt(i);
            if(Character.isLetterOrDigit(c))postfix+=c;
            else if(c=='(') st.push(c);
            else if(c==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    postfix+=st.peek();
                    st.pop();
                }
                st.pop();
            }
            else {
                while(!st.isEmpty() && pred(st.peek())>=pred(c)){
                    postfix+=st.peek();
                    st.pop();
                }
                st.push(c);
            }
        }
        while(!st.isEmpty()){
            postfix+=st.peek();
            st.pop();
        }
        for(int i=0;i<postfix.length();i++){
            System.out.print(postfix.charAt(i));
        }
    }
    public static String rev(String a){
        String reverse="";
        for(int i=a.length()-1;i>=0;i--){
            reverse=reverse+a.charAt(i);
        }
        return reverse;
    }
    public static void infixToPrefix(String exp) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<exp.length();i++){
            System.out.print(exp.charAt(i));
        }
        System.out.println();
        String postfix="";
        String prefix;
        exp=rev(exp);
        for(int i=0;i<exp.length();i++){
            char c=exp.charAt(i);
            if(Character.isLetterOrDigit(c))postfix+=c;
            else if(c==')') st.push(c);
            else if(c=='('){
                while(!st.isEmpty() && st.peek()!=')'){
                    postfix+=st.peek();
                    st.pop();
                }
                st.pop();
            }
            else {
                while(!st.isEmpty() && pred(st.peek())>pred(c)){
                    postfix+=st.peek();
                    st.pop();
                }
                st.push(c);
            }
        }
        while(!st.isEmpty()){
            postfix+=st.peek();
            st.pop();
        }
        prefix=rev(postfix);
        for(int i=0;i<prefix.length();i++){
            System.out.print(prefix.charAt(i));
        }
    }
    public  static int pred(char c){
            if(c== '+'|| c=='-') return 1;
            else if( c=='*' || c=='/') return 2;
            else if(c=='^') return 3;
            return -1;
    }
    public static void preToInfix(String pre_exp) {
        Stack<String> st=new Stack<>();
        String infix="";
        String top1;
        String top2;
        for(int i=pre_exp.length()-1;i>=0;i--){
            char c=pre_exp.charAt(i);
            if((c>='a' && c<='z') || (c>='A'&& c<='Z')) st.push(c+"");
            else{
                if(!st.isEmpty()){
                    top1=st.pop();
                    top2=st.pop();
                    st.push('('+top1+c+top2+')');
                }
            }
        }
        infix=st.pop();
        for(int i=0;i<infix.length();i++){
            System.out.print(infix.charAt(i));
        }
    }
    public static void preToPostfix(String pre_exp) {
        Stack<String> st=new Stack<>();
        String postfix="";
        String top1;
        String top2;
        for(int i=pre_exp.length()-1;i>=0;i--){
            char c=pre_exp.charAt(i);
            if((c>='a' && c<='z') || (c>='A'&& c<='Z')) st.push(c+"");
            else{
                if(!st.isEmpty()){
                    top1=st.pop();
                    top2=st.pop();
                    st.push(top1+top2+c);
                }
            }
        }
        postfix=st.pop();
        for(int i=0;i<postfix.length();i++){
            System.out.print(postfix.charAt(i));
        }
    }
    static void postToInfix(String exp) {
        // code here
        Stack<String> st=new Stack<>();
        String infix="";
        String top1;
        String top2;
        for(int i=0;i<exp.length();i++){
            char c=exp.charAt(i);
            if((c>='a' && c<='z') || (c>='A'&& c<='Z')) st.push(c+"");
            else{
                if(!st.isEmpty()){
                    top1=st.pop();
                    top2=st.pop();
                    st.push('('+top2+c+top1+')');
                }
            }
        }
        infix=st.pop();
        for(int i=0;i<infix.length();i++){
            System.out.print(infix.charAt(i));
        }
    }
    static void postToPre(String post_exp) {
        // code here
        Stack<String> st=new Stack<>();
        String prefix="";
        String top1;
        String top2;
        for(int i=0;i<post_exp.length();i++){
            char c=post_exp.charAt(i);
            if((c>='a' && c<='z') || (c>='A'&& c<='Z')) st.push(c+"");
            else{
                if(!st.isEmpty()){
                    top1=st.pop();
                    top2=st.pop();
                    st.push(c+top2+top1);
                }
            }
        }
        prefix=st.pop();
        for(int i=0;i<prefix.length();i++){
            System.out.print(prefix.charAt(i));
        }
        
    }

    public static void main(String args[]){
       //s.push(10);
       //s.push(20);
       //s.push(30);
      // System.out.println(s.size());
      // System.out.println(s.pop());
       //System.out.println(s.peek());
       //int[] a={6,9,2,0,8,1,3};
       //nextGretestelementRight(a);
       //int[] a={6,9,2,0,8,1,3};
       //nextSmallestelementRight(a);
      // int[] a={6,9,2,0,8,1,3};
       //nextGretestelementLeft(a);
       //int[] a={6,9,2,0,8,1,3};
       //nextSmallestelementLeft(a);
       //int price[] = {100 ,80 ,60 ,70 ,60 ,75, 85};
       //calculateSpan(price,price.length);
       //String s="(){}[]";
       //System.out.println(isvalidParenthesis(s));
       //int[] hist={2,1,5,6,2,3};
        //System.out.println(largestRectangleArea(hist));
        //String s="a+b*c+d";
         //infixToPostfix(s);
         //String exp="(A-B/C)*(A/K-L)";
         //infixToPrefix(exp);
        // String pre_exp="*-A/BC-/AKL";
        // preToInfix(pre_exp);
        //String pre_exp="*-A/BC-/AKL";
        //preToPostfix(pre_exp);
        //String exp="ABC/-AK/L-*";
        //postToPre(exp);
        //String exp="ab*c+";
        //postToInfix(exp);

        }
}
