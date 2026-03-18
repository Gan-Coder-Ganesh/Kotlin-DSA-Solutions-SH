package kotlinDSA.imp

import kotlinDSA.ListNode

class LC25ReverseNodesInKGroup {
  class Solution {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
      val dummy = ListNode(0)
      dummy.next = head
      var groupPrev = dummy

      while (true) {
        val kthNode = getKthNode(groupPrev, k) ?: break
        val groupNext = kthNode.next
        val groupStart = groupPrev.next

        var prev: ListNode? = groupNext
        var curr: ListNode? = groupStart
        repeat(k) {
          val next = curr?.next
          curr?.next = prev
          prev = curr
          curr = next
        }

        groupPrev.next = kthNode
        groupPrev = groupStart!!
      }

      return dummy.next
    }

    private fun getKthNode(head: ListNode?, k: Int): ListNode? {
      var count = 0
      var temp = head

      while (temp != null) {
        temp = temp.next
        count++
        if (count == k) return temp
      }

      return null
    }
  }
}