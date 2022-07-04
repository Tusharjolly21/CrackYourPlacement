// { Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int m = Integer.parseInt(input[0]); 
            int n = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.numberOfPaths(m,n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
   long numberOfPaths(int m, int n)
   {
       long dp[][]=new long[m+1][n+1];
       return find(0,0,m,n,dp);
   }
   long find(int i,int j,int m,int n,long dp[][])
   {
       if(i<0||j<0||i>m||j>n)
       return 0l;
       
       if(dp[i][j]>0)
       return dp[i][j];
       
       if(i==m-1&&j==n-1)
       return 1l;
       
   return dp[i][j]=(find(i+1,j,m,n,dp)+find(i,j+1,m,n,dp))%1000000007;
       
   }
}