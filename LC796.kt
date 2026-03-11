package kotlinDSA.accepted

// Accepted
class LC796 {
  class Solution {
    fun rotateString(s: String, goal: String): Boolean {
      val maxNoOfRotations = s.length


      for (i in 0 until maxNoOfRotations) {
        val res = s.slice(i + 1 until maxNoOfRotations) + s.slice(0..i)
        println(res)

        if (res == goal) return true
      }

      return false
    }
  }
}

fun main() {
  LC796.Solution().rotateString("abcde", "cdeab")
}