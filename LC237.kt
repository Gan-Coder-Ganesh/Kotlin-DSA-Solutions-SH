package kotlinDSA

// ACCEPTED

class LC237 {
  class Solution {
    fun deleteNode(node: ListNode?) {
      if (node == null || node.next == null) return

      node.`val` = node.next?.`val` ?: -1
      node.next = node.next?.next
    }
  }
}