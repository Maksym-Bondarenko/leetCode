/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        // // Idea 4 (Using Stack): put all elements to the stacks. Create new list by poping and summing elements from stacks.
        // // *** Runtime: 4ms (23.55%), Memory: 44.43mb (6.99%) ***
        // Stack<Integer> stack1 = new Stack();
        // Stack<Integer> stack2 = new Stack();

        // // fill-up the stacks
        // while(l1 != null) {
        //     stack1.push(l1.val);
        //     l1 = l1.next;
        // }
        // while(l2 != null) {
        //     stack2.push(l2.val);
        //     l2 = l2.next;
        // }

        // // create new list BACKWARDS (in reverse order), with values of elements-sum and overflow
        // ListNode res = new ListNode(0);
        // int runningSum = 0;
        // int carry = 0;

        // while(!stack1.empty() || !stack2.empty()) {
        //     runningSum = carry;
        //     if(!stack1.empty())
        //         runningSum += stack1.pop();
        //     if(!stack2.empty())
        //         runningSum += stack2.pop();
        //     carry = runningSum >= 10 ? 1 : 0;
        //     // save in reverse order
        //     res.val = runningSum % 10;
        //     ListNode head = new ListNode(runningSum / 10);    // value is needed for the las iteration: if it is 1 -> +1 new element, 0 -> skip it
        //     head.next = res;
        //     res = head;
        // }

        // return res.val == 0 ? res.next : res;
        
        // Idea 3 (similar to Idea 2): get sizes of two lists, starting from the same point create a new LL and add there sum of elements but in REVERSED ORDER
        // at the end do normalisation
        // [7,7,10,7] -> [7,10,7,7] | [9,9,10,10] -> [10,10,9,9]
        // *** Runtime: 2ms (66.75%), Memory: 43.10mb (83.58%) ***

        int size1 = getSize(l1);
        int size2 = getSize(l2);

        ListNode reversedSumHead = null;
        ListNode reversedSumCurrent = null;

        while(l1 != null || l2 != null) {
            int val1 = 0;
            int val2 = 0;

            if(size1 >= size2) {
                val1 = l1 != null ? l1.val : 0;
                l1 = l1.next;
                size1--;
            }
            // Comparing with s1 + 1 since s1 might be decremented previously
            if(size2 >= size1 + 1) {
                val2 = l2 != null ? l2.val : 0;
                l2 = l2.next;
                size2--;
            }
            // Create result-list in REVERSED ORDER without overflows
            reversedSumCurrent = new ListNode(val1 + val2);
            reversedSumCurrent.next = reversedSumHead;
            reversedSumHead = reversedSumCurrent;
        }

        // normilize with overflow (carry)
        // reversedSumCurrent is now HEAD (also last digits-sum)
        int carry = 0;
        reversedSumHead = null;
        while(reversedSumCurrent != null) {
            reversedSumCurrent.val += carry;
            carry = reversedSumCurrent.val >= 10 ? 1 : 0;
            reversedSumCurrent.val = reversedSumCurrent.val % 10;

            // reverse the pointers of LL
            ListNode tmp = reversedSumCurrent.next;
            reversedSumCurrent.next = reversedSumHead;
            reversedSumHead = reversedSumCurrent;
            reversedSumCurrent = tmp;
        }

        // check if last carry is 1 => then add a new node
        if(carry > 0) {
            reversedSumCurrent = new ListNode(carry);
            reversedSumCurrent.next = reversedSumHead;
            reversedSumHead = reversedSumCurrent;
        }

        return reversedSumHead;
        
        // // Idea 2 (Doubly-Linked List): by iterating the list make out of it doubly-linked list. Then add all pairs (depending on their digit-placement)
        // // and in the end calculate all overflows by backwards-pointers

        // // Idea 1 (Reverse LL): reverse both lists, add them starting from the first element (paying attention to overflow) and reverse the result
        // l1 = reverseList(l1);
        // l2 = reverseList(l2);
        // ListNode ans = helper(l1, l2);
        // return reverseList(ans);
    }

    private int getSize(ListNode head) {
        int count = 0;

        while(head != null) {
            count++;
            head = head.next;
        }

        return count;
    }

    // private ListNode reverseList(ListNode head) {
    //     ListNode prev = null;
    //     ListNode curr = head;

    //     while (curr != null) {
    //         ListNode next = curr.next;
    //         curr.next = prev;
    //         prev = curr;
    //         curr = next;
    //     }
        
    //     return prev;
    // }

    // private ListNode helper(ListNode l1, ListNode l2) {
    //     ListNode dummyHead = new ListNode(0);
    //     ListNode tail = dummyHead;
    //     int carry = 0;

    //     while (l1 != null || l2 != null || carry != 0) {
    //         int digit1 = (l1 != null) ? l1.val : 0;
    //         int digit2 = (l2 != null) ? l2.val : 0;

    //         int sum = digit1 + digit2 + carry;
    //         int digit = sum % 10;
    //         carry = sum / 10;

    //         ListNode newNode = new ListNode(digit);
    //         tail.next = newNode;
    //         tail = tail.next;

    //         l1 = (l1 != null) ? l1.next : null;
    //         l2 = (l2 != null) ? l2.next : null;
    //     }

    //     ListNode result = dummyHead.next;
    //     return result;
    // }
}