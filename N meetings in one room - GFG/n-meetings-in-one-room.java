// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Meeting{
    int start;
    int end;
    int position;
    public Meeting(int start,int end,int position){
        this.start = start;
        this.end = end;
        this.position = position;
    }
}
class Compare implements Comparator<Meeting>{
    public int compare(Meeting m1,Meeting m2){
        return m1.end-m2.end;
    }
}
class Solution 
{
    public static int maxMeetings(int start[], int end[], int n)
    {
        ArrayList<Meeting> meet = new ArrayList<>();
        for(int i = 0;i<start.length;i++)
        meet.add(new Meeting(start[i],end[i],i+1)); /*one based indexing*/
        
        Collections.sort(meet,new Compare());
        int ans = 1;
        int endLimit = meet.get(0).end;
        for(int i = 1;i<meet.size();i++){
            if(meet.get(i).start>endLimit){
                ans++;
                endLimit = meet.get(i).end;
            }
        }
        return ans;
    }
}
