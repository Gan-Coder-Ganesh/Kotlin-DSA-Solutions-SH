class Solution {
  fun detectCycle(head: ListNode?): ListNode? {
    var slow = head
    var fast = head
    var temp = head

    while (fast != null && fast?.next != null) {
      slow = slow?.next
      fast = fast.next?.next

      if (slow == fast) break
    }

    if (fast == null || fast.next == null) {
      return null
    }

    while (temp != slow) {
      temp = temp?.next
      slow = slow?.next
    }

    return temp
  }
}
