package leetcode.linkedlist;

public class NumberToWord {

    private static final String[] belowTen = { "", "One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine" };

    private static final String[] belowTwenty = { "Ten", "Eleven", "Twelve", "Thirteen",
            "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };

    private static final String[] belowHundred = { "", "Ten", "Twenty", "Thirty", "Forty",
            "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

    public static String solution(int Num){
        if(Num==0) return "Zero";

       return rec(Num);
    }

    static String rec(int Num){

        if(Num<10) return belowTen[Num];

        if(Num<20) return belowTwenty[Num-10];

        if(Num<100) {

            return belowHundred[Num/10]+ (Num%10!=0 );
        }
        return null;
    }


    public static void main(String[] args) {
        System.out.println(solution(123));
//        System.out.println(solution(12345));
//        System.out.println(solution(1234567));
    }
}
