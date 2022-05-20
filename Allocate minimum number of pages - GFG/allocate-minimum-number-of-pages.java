// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        int max = 0;
        int sum = 0;
        for(int i = 0;i<N;i++){
        sum+=A[i];
        max = Math.max(max,A[i]);
        }
        
        
        
        int low = max;
        int high = sum;
        int res = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(isAnswer(A,N,M,mid)){
                res = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return res;
    }
    public static boolean isAnswer(int[] A,int N,int M,int ans){
        int sum = 0;
        int students = 1;
        for(int i = 0;i<N;i++){
            if(sum+A[i]>ans){
                students++;
                sum = A[i];
            }else{
                sum+=A[i];
            }
        }
        return (students<=M);
    }
};