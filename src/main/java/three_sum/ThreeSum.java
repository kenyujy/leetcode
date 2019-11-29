package three_sum;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4, 5};

        List list =three_sum(nums);

        System.out.println(list);
    }

    public static List<List<Integer>> three_sum(int[] num){
        List<List<Integer>> list=new ArrayList<>();

        for (int i=0; i<num.length; i++){
            for(int j=i+1; j<num.length; j++){
                for(int k=j+1; k<num.length; k++){
                    if(num[i]+ num[j]+ num[k] ==0){
                        list.add(Arrays.asList(num[i], num[j], num[k]));
                    }
                }
            }
        }

        for (int i=0; i<list.size(); i++){
            for(int j=i+1; j<list.size(); j++){
                if( list.get(i).containsAll(list.get(j)) ){ //去重
                    list.remove(list.get(j));
                }
            }
        }
        return list;
    }
}
