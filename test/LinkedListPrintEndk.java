public class LinkedListPrintEndk {
    // 递归方法的辅助类，用于存储当前的计数值
    static int count=0;

    // 递归方法，返回倒数第2个节点
    public static void findPenultimateNode(ListNode head) {
        if (head == null) {
            return;
        }

        findPenultimateNode(head.next);
        count++;

        if (count == 2) {
            System.out.println(head.val);
        }
    }

    public static void main(String[] args) {
        // 创建链表 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        findPenultimateNode(head);
    }
}
