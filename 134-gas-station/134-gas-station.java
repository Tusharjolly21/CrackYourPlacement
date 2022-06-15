class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int position = 0;
        int sum = 0;
        int total = 0;
        for(int i = 0;i<gas.length;i++){
            
            sum+=gas[i]-cost[i];
            total+=gas[i]-cost[i];
            
            if(sum<0){
                position = i+1;
                sum = 0;
            }     
        }
        return total>=0?position:-1;
    }
}
/*
Keep a starting position
Keep total from the gas stations.
Keep a sum from starting candidate to the current station
If sum < 0 it means that our current position is not the one. Make the candidate the next element
Iterate the arrays and if total >= 0, return the position, otherwise return -1
*/