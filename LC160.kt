package kotlinDSA

import kotlin.math.abs

class LC160 {
  class Solution {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
      val lengthA = headA.length()
      val lengthB = headB.length()
      val difference = abs(lengthB - lengthA)

      var a = if (lengthA > lengthB) traverseToNode(headA, difference) else headA
      var b = if (lengthA < lengthB) traverseToNode(headB, difference) else headB

      while (a != b) {
        a = a?.next
        b = b?.next
      }

      return a
    }

    private fun ListNode?.length(): Int {
      var length = 0
      var temp = this

      while (temp != null) {
        temp = temp.next
        length++
      }

      return length
    }

    private fun traverseToNode(head: ListNode?, n: Int): ListNode? {
      var temp = head
      var count = 0
      while (temp != null) {
        temp = temp.next
        count++

        if (count == n) return temp
      }

      return null
    }
  }
}