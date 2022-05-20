class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while(columnNumber>0){
            columnNumber--;
            res.append((char)('A'+columnNumber%26));
            columnNumber/=26;
        }
        res.reverse();
        return res.toString();
    }
}
/*
reason to do columnNumber--
Because we always use 'A' + n%26, 'A' is virtually stand for 1 at here, we have to deduct 1 before doing this operation.
eg. if n%26 == 1 now, we definitely need to append A at current iteration, however, 'A' + 1 will give us 'B', 
so we need 'A' + 0 to get correct result.
*/