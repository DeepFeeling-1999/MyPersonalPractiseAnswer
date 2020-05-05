package Test.ATemp;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) { val = x; }

}

public class LeetCode {
    public static ListNode tempMerge(ListNode L1, ListNode L2) {
        if (L2 == null) {
            return L1;
        }

        ListNode result = new ListNode(Integer.MIN_VALUE);
        result.next = null;
        ListNode tempResult = result;

        while (L2 != null && L1 != null) {
            if (L1.val <= L2.val) {
                result.next = L1;
                L1 = L1.next;
                result=result.next;
                result.next=null;
            } else {
                result.next = L2;
                L2 = L2.next;
                result=result.next;
                result.next=null;
            }
        }
        if (L2 != null) {
            result.next = L2;
        }
        if (L1 != null) {
            result.next = L1;
        }

        return tempResult.next;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        ListNode result = lists[0];
        for (int i = 0; i < lists.length - 1; i++) {
            result = tempMerge(result, lists[i + 1]);
        }
        return result;
    }


    public static void show(ListNode l) {
        while (l != null) {
            System.out.println(l);
            l = l.next;
        }
    }

    public static void main(String[] args) {
        ListNode t1 = new ListNode(1);
        ListNode t4 = new ListNode(4);
        ListNode t5 = new ListNode(5);

        ListNode tt1 = new ListNode(1);
        ListNode tt3 = new ListNode(3);
        ListNode tt4 = new ListNode(4);

        ListNode ttt2 = new ListNode(2);
        ListNode ttt6 = new ListNode(6);

        t5.next = null;
        t4.next = t5;
        t1.next = t4;

        tt4.next = null;
        tt3.next = tt4;
        tt1.next = tt3;

        ttt6.next = null;
        ttt2.next = ttt6;

        show(mergeKLists(new ListNode[]{t1, tt1, ttt2}));

    }
}

