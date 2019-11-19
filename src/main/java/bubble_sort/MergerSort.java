package bubble_sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MergerSort {

    public static void main(String[] args) {

        List<Integer> list= new ArrayList<Integer>();
        list.add(5);
        list.add(3);
        list.add(6);
        list.add(100);
        list.add(8);
        list.add(2);
        list.add(9);
        list.add(88);
        list.add(12);
        list.add(66);
        list.add(55);
        list.add(18);

        List<Integer> list5=new ArrayList<>();
        Random r= new Random();
        for (int i=0; i<1000000; i++){
            list5.add(r.nextInt(1000));
        }

        long start= System.currentTimeMillis();
        mergeSort(list5);
        long end= System.currentTimeMillis();
        System.out.println(end-start);
    }


    public static List<Integer> mergeSort(List<Integer> list){
        int size= list.size();
        int mid= (int) Math.floor(size/2);

        if (list.size()<2) {     //递归终止条件
            return list;
        }

        List left= list.subList(0, mid);   // 注意某些情况 right 会比left大
        List right= list.subList(mid, size);

        return merge(mergeSort(left),mergeSort(right));  // 用了递归的方法
    }

    public static List<Integer> merge(List<Integer> left, List<Integer> right) {

        List<Integer> mergeList = new ArrayList<>();

        int leftIndex=0; // 下标操作，交替遍历
        int rightIndex=0; // 下标操作，交替遍历

        while(leftIndex < left.size() && rightIndex < right.size()) {   //注意left 某个元素可能 比right所有都大
            if (left.get(leftIndex) < right.get(rightIndex)) {
                mergeList.add(left.get(leftIndex));
                leftIndex++;
            }else{
                mergeList.add(right.get(rightIndex));
                rightIndex++;
            }
            // 2个index 都有可能先到末尾
        }

        // 这里的条件注意, 上面的插入排序完了以后某一个Index= list 的 size
        if (leftIndex < left.size()){  // right reaches to it end, add those left by left
            for (int i= leftIndex; i<left.size(); i++)
                mergeList.add(left.get(i));
        }else {
            for (int i= rightIndex; i<right.size(); i++)
                mergeList.add(right.get(i));
        }

        return mergeList;
    }

    public static boolean compareStr(String a, String b){
        for (int i=0; i<a.length(); i++){
            if (i<b.length() && (a.charAt(i)+"").compareTo(b.charAt(i)+"")>0) {
                return true;
            }
        }
        return false;
    }
}
