// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} // } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    boolean knows(int M[][],int a,int b){
        if(M[a][b]==1){
            return true;
        }else{
            return false;
        }
    }
    int celebrity(int M[][], int n)
    {
        Stack<Integer> s = new Stack<>();
        for(int i = 0;i<n;i++){
            s.push(i);
        }
        while(s.size()>1){
            int a = s.peek();
            s.pop();
            int b = s.peek();
            s.pop();
            if(knows(M,a,b)){
                s.push(b);
            }else{
                s.push(a);
            }
        }
        int ans = s.peek();
        
        int countZero = 0;
        for(int i = 0;i<n;i++){
            if(M[ans][i]==0) countZero++;
        }
        if(countZero!=n) return -1;
        
        
        int countOnes = 0;
        for(int i = 0;i<n;i++){
            if(M[i][ans]==1) countOnes++;
        }
        if(countOnes!=n-1) return -1;
        
        return ans;
    }
    }