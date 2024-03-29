import java.util.*;
public class Recursion {
    public static void print1to5(int start,int end){
        if(start>end) return;
        else System.out.println(start);
        print1to5(start+1,end);
    }
    public static void print5to1(int start,int end){
        if(start>end) return;
        else {
            print5to1(start+1,end);
            System.out.println(start);

        }
    }
    public static void sum5(int n,int i,int sum){
        if(i>n) {
            System.out.println(sum);
            return;
        }
        sum5(n,i+1,sum+i);
    }
    public static void factorial(int n,int fact){
        if(n==0) {
            System.out.println(fact);
            return;
        }
        factorial(n-1,fact*n);
    }
    public static int fibonnacci(int n){
        if(n<=1)  return n;
        return fibonnacci(n-1) + fibonnacci(n-2);
    }
    public static void firstlastoccurance(String s,int i,char target,int first,int last){
        if(i==s.length()-1){
            if(first==-1){
               last=-1;
               first=-1;
            }
            System.out.println(+first+" "+last);
            return;
        }
        if(s.charAt(i)==target){
            if(first==-1){
                first=i;
            }
            last=i;
        }
        firstlastoccurance(s,i+1,target,first,last);
    }
    public static void removeDuplicates(String s,int i, String newstr){
        if(i==s.length()-1){
            for(int j=0;j<newstr.length();j++){
                System.out.print(newstr.charAt(j));
            }
            return;
        }
        if(s.charAt(i)!=s.charAt(i-1)){
            newstr+=s.charAt(i);
        }
        removeDuplicates(s,i+1,newstr);
    }
    public static void moveXToLast(String s, int i,int count,String newstr){
       if(i==s.length()){
        for(int j=0;j<count;j++){
            newstr+='x';
        }
        for(int j=0;j<newstr.length();j++){
            System.out.print(newstr.charAt(j));
        }
        return;
       }
        if(s.charAt(i)=='x') {
            count++;
        }
        else newstr+=s.charAt(i);
        moveXToLast(s,i+1,count,newstr);
    }
    public static void subSequence(String s,int i,String newstr){
         if(i==s.length()){
            System.out.print(newstr+" ");
            return;
         }
        subSequence(s,i+1,newstr+s.charAt(i));
        subSequence(s,i+1,newstr);
         
    }
    public static void permutationsOnStrings(String s,String per){
        if(s.length()==0){
            System.out.print(per+" ");
            return;
        }
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            permutationsOnStrings(s.substring(0,i)+s.substring(i+1),per+c);
        }
    }
    public static void permutationsOnArray(int[] a,ArrayList<Integer> al,boolean[] b){
        if(al.size()==a.length){
            System.out.println(al+" ");
            return;
        }
        for(int i=0;i<a.length;i++){
            if( b[i]==false) {
                 b[i]=true;
                 al.add(a[i]);
                 permutationsOnArray(a,al,b);
                 b[i]=false;
                 al.remove(al.size()-1);
            }
        }
    }
    public static void combination(int i,int target,int[] arr,List<List<Integer>> ans,ArrayList<Integer> al){
        if(i==arr.length){
            if(target==0){
                ans.add(new ArrayList<>(al));
            }
            return;
        }
            if(target>=arr[i]){
                al.add(arr[i]);
                combination(i,target-arr[i],arr,ans,al);
                al.remove(al.size()-1);
            }
            combination(i+1,target,arr,ans,al);
        }
    public  static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        combination(0,target,candidates,ans, new  ArrayList<>());
        return ans;
        
    }
    public static void combination2(int ind,int target,int[] a,List<List<Integer>> ans,ArrayList<Integer> al){
        if(target==0){
            ans.add(new ArrayList<>(al));
            return;
        }
        for(int i=ind;i<a.length;i++){
            if(i>ind && a[i]==a[i-1]) continue;
            if(a[i]>target) break;
            al.add(a[i]);
            combination2(i+1,target-a[i],a,ans,al);
            al.remove(al.size()-1);
        }
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        combination2(0,target,candidates,ans,new ArrayList<>());
        return ans;
        
    }
    public static void main(String[] args){
       // print1to5(1,5);
        //print5to1(1,5);
        //sum5(5,0,0);
        //factorial(5,1);
       //System.out.println(fibonnacci(6));
       //firstlastoccurance("rameshgoud",0,'g',-1,-1);
       //String s="abbbcddeffg";
       //removeDuplicates(s,1,s.charAt(0)+"");
       //String s="raxmexsxhx";
       //moveXToLast(s,0,0,"");
       //String s="abc";
       //subSequence(s,0,"");
       //String s="abc";
       //String per="";
       //permutationsOnStrings( s, per);
       //int[] a={1,2,3};
       //ArrayList<Integer> al=new ArrayList<>();
       //boolean[] b=new boolean[a.length];
       //permutationsOnArray(a,al,b);
        // int[] candidates={2,3,6,7};
       //int target=7;
       //System.out.println(combinationSum(candidates,target));
        //int[] candidates={10,1,2,7,6,1,5};
       //int target=8;
      // System.out.println(combinationSum2(candidates,target));


        }
}
