class Solution {
    public String intToRoman(int num) {
        int[] intCode = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] code = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<intCode.length;i++){
            while(num>=intCode[i]){ /*eg. 58>=50, 8>=5 , 3>=1 , 2>=1 , 1>=1*/
            sb.append(code[i]); /*sb = L+V+I+I+I*/
            num-=intCode[i]; /*58-50=8, 8-5=3 , 3-1 = 2 , 2-1 = 1*/
            }
            
        }
        return sb.toString();
    }
}
/*
I- >1
IV- >4
V - >5
IX- >9
X- >10
L- >50
XL- >40
C- >100
XC- >90
D- >500
CD- >400
M- >1000
CM-> 900
*/
