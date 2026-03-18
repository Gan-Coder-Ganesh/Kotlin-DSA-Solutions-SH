package kotlinDSA

class LC61 {
  class Solution {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
      if (head == null || head.next == null) return head

      val n: Int = head.length()
      val tail = this.getTail(head)
      var temp = head

      if (k % n == 0) return head

      val newK = k % n
      val newLastNode = this.getElemBeforeK(head, n - newK)

      tail?.next = head

      temp = newLastNode?.next
      newLastNode?.next = null

      return temp
    }

    private fun getTail(head: ListNode?): ListNode? {
      if (head == null || head.next == null) return head

      var temp = head
      while (temp?.next != null) {
        temp = temp.next
      }

      return temp
    }

    private fun getElemBeforeK(head: ListNode?, k: Int): ListNode? {
      var count = 1
      var temp = head

      while (temp != null) {
        if (count == k) return temp

        temp = temp.next
        count++
      }

      return null
    }

    fun ListNode.length(): Int {
      var temp: ListNode? = this
      var length = 0

      while (temp != null) {
        temp = temp.next
        length++
      }

      return length
    }
  }
}