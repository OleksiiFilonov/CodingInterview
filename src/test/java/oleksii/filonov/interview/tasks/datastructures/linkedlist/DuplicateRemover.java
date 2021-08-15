package oleksii.filonov.interview.tasks.datastructures.linkedlist;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class DuplicateRemover {

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode firstDuplicate = head;
        ListNode lastDuplicate = head.next;
        ListNode lastUnique = head;
        while (lastDuplicate != null) {
            //duplication found - iterate lastDuplicate untill it will reach unique value
            if (firstDuplicate.val == lastDuplicate.val) {
                lastDuplicate = lastDuplicate.next;
            } else {
                //firstDuplicate value is different from the lastDuplicate
                if (firstDuplicate.next == lastDuplicate) {
                    //is it next value, aka 1->2->3->4 - then just move ponters forward
                    if (firstDuplicate != head)
                        lastUnique = lastUnique.next;
                    firstDuplicate = firstDuplicate.next;
                    lastDuplicate = lastDuplicate.next;
                } else {
                    //if actually lastDuplicate moved >1 index, aka 1->2->2->3, so firstDup -> 2, lastDup ->3
                    if (firstDuplicate != head) {
                        lastUnique.next = lastDuplicate;
                    } else {
                        lastUnique = lastDuplicate;
                        head = lastUnique;
                    }
                    firstDuplicate = lastDuplicate;
                    lastDuplicate = lastDuplicate.next;
                }
            }
        }

        if (firstDuplicate.next != lastDuplicate) {
            //if actually lastDuplicate moved >1 index, aka 1->2->2->3, so firstDup -> 2, lastDup ->3
            if (firstDuplicate != head) {
                lastUnique.next = lastDuplicate;
            } else {
                lastUnique = lastDuplicate;
                head = lastUnique;
            }
            firstDuplicate = lastDuplicate;
        }
        return head;
    }
}
