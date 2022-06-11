// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class PhoneDigit
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//testcases
        
        
        while(t-- > 0)
        {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; //input the elements of array that are keys to be pressed
            
            for(int i = 0; i < n; i++)
               arr[i] = sc.nextInt();//input the elements of array that are keys to be pressed
            ArrayList <String> res = new Solution().possibleWords(arr, n);
            for (String i : res) System.out.print (i + " ");
             System.out.println();
              
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static String keys[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    static void solve(int a[],String s,int idx,ArrayList<String> ans){
        if(idx==a.length){
            ans.add(s);
            return;
        }
        for(int i=0; i<keys[a[idx]].length(); i++) {
            char curr = keys[a[idx]].charAt(i);
            solve(a,s+curr,idx+1,ans);
        }
        
    }
    static ArrayList <String> possibleWords(int a[], int N)
    {
        ArrayList<String> ans = new ArrayList<>();
        solve(a,"",0,ans);
        return ans;
    }
}


