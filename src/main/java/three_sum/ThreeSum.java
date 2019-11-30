package three_sum;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {

        int[] nums = {-13,11,11,0,-5,-14,12,-11,-11,-14,-3,0,-3,12,-1,-9,-5,-13,9,-7,-2,9,-1,4,-6,-13,-7,10,10,9,7,13,5,4,-2,7,5,-13,11,10,-12,-14,-5,-8,13,2,-2,-14,4,-8,-6,-13,9,8,6,10,2,6,5,-10,0,-11,-12,12,8,-7,-4,-9,-13,-7,8,12,-14,10,-10,14,-3,3,-15,-14,3,-14,10,-11,1,1,14,-11,14,4,-6,-1,0,-11,-12,-14,-11,0,14,-9,0,7,-12,1,-6};

        List list =three_sum(nums);
        System.out.println(list);
    }

    public static List<List<Integer>> three_sum(int[] num){
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> l2= new ArrayList<>();

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
            for(int j=i+1; j<list.size(); j++) {
                List<Integer> list1= list.get(i);//取出元素去重
                List<Integer> list2= list.get(j);//取出元素去重
                Collections.sort(list1); //排序去重
                Collections.sort(list2); //排序去重
                if(list1.equals(list2)) {
                    if (!l2.contains(j))  //防止重复标记
                    l2.add(j);
                }
            }
        }
        Collections.sort(l2); //要把标记的重复序列排序，按顺序去除

        for (int i=0; i<l2.size(); i++){
            list.remove(l2.get(i)-i); //把标记重复的去掉,因为list重新排列，要去掉-i个
        }

        return list;
    }
}
