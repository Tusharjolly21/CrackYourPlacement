class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        if(n==1){
            ans.add("1");
            return ans;
        }
        ans.add("1");
        ans.add("2");
        for(int i = 3;i<=n;i++){
            if(i%3==0 && i%5==0){
                ans.add("FizzBuzz");
            }else if(i%3==0){
                ans.add("Fizz");
            }else if(i%5==0){
                ans.add("Buzz");
            }else{
                ans.add(Integer.toString(i));
            }
        }
        return ans;
    }
}