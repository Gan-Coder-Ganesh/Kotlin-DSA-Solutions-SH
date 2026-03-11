class LC2095 {
  class Solution {
    fun deleteMiddle(head: ListNode?): ListNode? {
      if (head == null || head.next == null) return null

      var slow = head
      var fast = head.next!!.next

      while (fast != null && fast.next != null) {
        slow = slow?.next
        fast = fast.next?.next
      }

      slow?.next = slow.next?.next
      return head
    }
  }
}
