import java.util.*;
public class Greedy {
    public static void printgd(int[][] a){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                System.out.print(a[i][j]+" ");
            }
        System.out.println();
        }
        System.out.println("-----------");
    }
    public static void maximumActivities(int[] start,int[] end){
        int a[][]=new int[start.length][2];
        for(int i=0;i<start.length;i++){
                a[i][0]=start[i];
                a[i][1]=end[i];
            }
            Arrays.sort(a,Comparator.comparingDouble(o->o[1]));
            int maxact=1;
            int lastact=a[0][1];
            for(int i=1;i<a.length;i++){
                if(lastact<=a[i][0]){
                    maxact++;
                    lastact=a[i][1];
                }
            }
             System.out.println(maxact);
        }
        public static void fractionalknapsack(int[] weigth,int[] profit,int totalwegt){
            int[][] a=new int[weigth.length][3];
            int totalprofit=0;
            for(int i=0;i<weigth.length;i++){
                a[i][0]=weigth[i];
                a[i][1]=profit[i];
                a[i][2]=profit[i] / weigth[i];
            }
            Arrays.sort(a,Comparator.comparingDouble(o->o[2]));
             for(int i=a.length-1;i>=0;i--){
                if(totalwegt>a[i][0]){
                    totalprofit+=a[i][1];
                    totalwegt-=a[i][0];

                }
                else{
                    totalprofit+=totalwegt*a[i][2];
                    break;
                }

            }
            System.out.println(totalprofit);
        }
        public static int minimumSumOfPairs(int a[],int b[]){
            Arrays.sort(a);
            Arrays.sort(b);
            int sum=0;
            for(int i=0;i<a.length;i++){
                sum+=Math.abs(a[i]-b[i]);
            }
              return sum;
        }
        public static int longestChain(int[][] a){
            int chains=1;
            Arrays.sort(a,Comparator.comparingDouble(o->o[1]));
            int end=a[0][1];
            for(int i=0;i<a.length;i++){
                if(end<a[i][0]){
                    chains++;
                    end=a[i][1];
                }
            }
            return chains;
        }
        public static void jobSequence(int[] schedule,int[] profitarr){
            int[][] a=new int[profitarr.length][schedule.length];
            int maxdays=0;
            for(int i=0;i<profitarr.length;i++){
                a[i][0]=schedule[i];
                a[i][1]=profitarr[i];
                maxdays=Math.max(maxdays,a[i][0]);
            }
            Arrays.sort(a,Comparator.comparingDouble(o->o[1]));
            int[] days=new int[maxdays];
            int ind=0;
            int profit=0;
            for(int i=a.length-1;i>=0;i--){
                ind=a[i][0]-1;
                while(ind>=0 && days[ind]!=0){
                    ind--;
                }
                if(ind>=0){
                   profit+=a[i][1];
                   days[ind]=-1;
                }
        }
           System.out.println(profit);
        }
        public static int[] reverse(int[] a ){
            int left=0;
            int right=a.length-1;
            while(left<right){
                int temp=a[left];
                a[left]=a[right];
                a[right]=temp;
                left++;
                right--;
            }
            return a;
        }
        public static void squareCutting(int[] horizontal,int[] vertical){
            int hc=1;
            int vc=1;
            Arrays.sort(horizontal);
            Arrays.sort(vertical);
            horizontal=reverse(horizontal);
            vertical=reverse(vertical);
            int maxcost=0;
            int vcost=0;
            int hcost=0;
            int totalcost=0;
            while(vcost<vertical.length && hcost<horizontal.length){
                maxcost=Math.max(horizontal[hcost],vertical[vcost]);
                if(maxcost==horizontal[hcost]){
                    totalcost+=horizontal[hcost]*vc;
                    hc++;
                    hcost++;

                }
                else{
                    totalcost+=vertical[vcost]*hc;
                    vc++;
                    vcost++;

                }
            }
            while(hcost<horizontal.length){
                totalcost+=horizontal[hcost]*vc;
                    hc++;
                    hcost++;

            }
            while(vcost<vertical.length){
                totalcost+=vertical[vcost]*hc;
                    vc++;
                    vcost++;
            }
            System.out.println(totalcost);
        }

    public static void main(String args[]){
       // int[][] a={{5,90},{6,89},{2,56},{8,95}};
       // printgd(a);
       // Arrays.sort(a,Comparator.comparingDouble(o->o[1]));
       // printgd(a);
      // int[] start={1,2,0,8,5};
      // int[] end={3,4,2,9,8};
       //maximumActivities(start,end);
      // int[] weigth={5,10,10};
      // int[] profit={50,160,80};
       //int totalwegt=20;
       // fractionalknapsack(weigth,profit,totalwegt);
      // int[] a={4,1,8,7};
      // int[] b={2,3,6,5};
       //System.out.println(minimumSumOfPairs(a,b));
        //int[][] a=[[1,2],[7,8],[4,5]]
       //System.out.println(longestChain(a));
      // int[] schedule={1,1,2,2,1};
       //int[] profitarr={15,19,100,27,25};
       //jobSequence(schedule,profitarr);
       int[] vertical={2,1,3,1,4};
       int[] horizontal={4,1,4};
       squareCutting(horizontal,vertical);
       }
    
}
