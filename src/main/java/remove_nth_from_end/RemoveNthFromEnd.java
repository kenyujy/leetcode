package remove_nth_from_end;

/* 给定一个链表和n，删除末尾第n个node */

public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int nodeCount=1;
        int currentNodeNumber= 1;

        if (null== head){
            return null;
        }

        ListNode currentNode= head;
        while (null!= currentNode.next){
            currentNode= currentNode.next;
            nodeCount++;   //遍历得出链表大小
        }

        int nodeNumToDelete= nodeCount-n+1;
        if(nodeNumToDelete== 1){  //如果要删除的是第一个，直接返回head.next,否则下面判断会出异常
            return head.next;
        }

        currentNode= head;
        while (currentNodeNumber!= nodeNumToDelete-1){ // 找出要删除的node 的前一个
            currentNode= currentNode.next;
            currentNodeNumber++;
        }

        if (null== currentNode.next){  //如果要删除的是最后一个node,直接把currentNode改成最后一个node, 否则空指针异常
            currentNode.next=null;
        }else{
            currentNode.next= currentNode.next.next;
        }

        return head;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) { val = x; }
}