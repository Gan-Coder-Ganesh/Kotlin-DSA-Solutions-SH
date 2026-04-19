package kotlinDSA.imp

import java.util.*

class LC20ValidParenthesis {
  class Solution {
    fun isValid(s: String): Boolean {
      val stack = ArrayDeque<Char>()

      s.forEach {
        if (it == '(' || it == '[' || it == '{') {
          stack.addLast(it)
        } else {
          if (stack.isEmpty()) return false

          val top = stack.last()

          if ((it == ')' && top == '(') || (it == ']' && top == '[') || (it == '}' && top == '{')) {
            stack.removeLast()
          } else return false
        }
      }

      return stack.isEmpty()
    }
  }
}