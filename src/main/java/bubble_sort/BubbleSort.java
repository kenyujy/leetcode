package bubble_sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BubbleSort<T> {

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

        List<String> list2= new ArrayList<String>();
        list2.add("Go");
        list2.add("k");
        list2.add("b");
        list2.add("hi");
        list2.add("H");
        list2.add("CD");
        list2.add("lol");
        list2.add("aq");
        list2.add("aa");
        list2.add("cd");
        list2.add("A");
        list2.add("中文");
        list2.add("啊");
        list2.add("英文");
        list2.add("法文");

        /*
        System.out.println(list2);
        bubbleSortStr(list2);

        System.out.println(list2);

        System.out.println(compareStr("中","华"));
        System.out.println(compareStr("我","你"));
        System.out.println("我你".charAt(0));

         */

        List<Integer> list5=new ArrayList<>();
        Random r= new Random();
        for (int i=0; i<10000; i++){
            list5.add(r.nextInt(1000));
        }

        long start= System.currentTimeMillis();
        bubbleSortInt(list5);
        long end= System.currentTimeMillis();
        System.out.println(end-start);

        start= System.currentTimeMillis();
        mergeSort(list5);
        end= System.currentTimeMillis();
        System.out.println(end-start);
    }


    public static void bubbleSortInt(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size()-i; j++) {
                if (j + 1 < list.size() && list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j + 1);
                    list.set(j + 1, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }

    public static void bubbleSortStr(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size()-i; j++) {
                if (j + 1 < list.size() && compareStr(list.get(j),list.get(j+1))) {
                    String temp = list.get(j + 1);
                    list.set(j + 1, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }

    public static List<Integer> mergeSort(List<Integer> list){
        int size=list.size();
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
