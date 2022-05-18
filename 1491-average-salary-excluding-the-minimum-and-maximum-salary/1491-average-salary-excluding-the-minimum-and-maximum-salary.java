class Solution {
    public double average(int[] salary) {
        Arrays.sort(salary);
        int amount = 0;
        for(int i = 1;i<salary.length-1;i++){
            amount+=salary[i];
        }
        return (double)amount/(salary.length-2);
    }
}