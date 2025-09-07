package leetcode.problems;

public class LongestSubstringKDistinct {

    public static int solution(int k,String s){
//
//        int max=0;
//        int right=0;
//        int left=0;
//        StringBuilder sb=new StringBuilder();
//        int []map=new int[26];
//
//        while (right<s.length()){
//            if(sb.indexOf(String.valueOf(s.charAt(right)))>=0 && k>=0){
//                sb.append(s.charAt(right));
//                map[s.charAt(right)-'a']++;
//            }
//            else{
//                k--;
//                sb.append(s.charAt(right));
//            }
//            map[s.charAt(right)-'a']++;
//            right++;
//
//            while (k<0){
//                max=Math.max(max,right-left-1);
//                sb.deleteCharAt(0);
//                map[s.charAt(left)-'a']--;
//                if(map[s.charAt(left)-'a']==0){
//                    left++;
//                    k++;
//                }
//            }
//        }
//        if(max==0) max=s.length();
//        max=Math.max(sb.length(),max);
//        max=Math.max(max,right-left+1);
//        return max;
        if(s.length()==0 || s==null ) return 0;

        int []map=new int[26];
        int distinct=0;
        int left=0;
        int max=0;
        for(int i=0;i<s.length();i++){
            int idx= s.charAt(i)-'a';
            if(map[idx]==0){
                distinct++;
            }
            map[idx]++;

            while ((distinct>k)){
                int leftIdx=s.charAt(left)-'a';
                map[leftIdx]--;
                if(map[leftIdx]==0){
                    distinct--;
                }
                left++;
            }

            max=Math.max(max,i-left+1);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(solution(6,"zcviqwyuydegijtgwxujqdn"));
        System.out.println(solution(1,"abcdef"));
        System.out.println(solution(3,"aaaaaaaa"));
        System.out.println(solution(2,"abbbbbbc"));
        System.out.println(solution(3,"abcddefg"));
    }
}
