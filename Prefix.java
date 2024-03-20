public class Prefix {
    public static void  prefixarray(int[] a,int left,int right){
        int[] prefix=new int[a.length];
        prefix[0]=a[0];
        for(int i=1;i<a.length;i++){
            prefix[i]=prefix[i-1]+a[i];
        }
        if(left==0) System.out.println(prefix[right]);
        else{
            System.out.println(prefix[right]-prefix[left-1]);
          }
        }
        public static void evenoddsumuptoIndex(int k,int[] a){
		int[] prefix=new int[a.length];
		prefix[0]=a[0];
		prefix[1]=a[1];
		for(int i=2;i<a.length;i++){
		    prefix[i]=prefix[i-2]+a[i];
		}
		if((k&1)==0){
		    System.out.println("evensum="+prefix[k]);
            System.out.println("oddsum="+prefix[k-1]);
	}
	else{
	    System.out.println("evensum="+prefix[k-1]);
	    System.out.println("oddsum="+prefix[k]);
	    }
    }
    public static void main(String[] args){
        //int left=2;
        //int right=5;
       // int[] a={6,3,-2,4,-1,0,-5};
       // prefixarray(a,left,right);
        int k=4;
        int[] a={1,2,3,4,5,6};
        evenoddsumuptoIndex(k,a);
    }
}
