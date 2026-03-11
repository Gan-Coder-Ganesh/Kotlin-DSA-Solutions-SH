class LC38 {
  class Solution {
    fun countAndSay(n: Int): String {
      var current = "1"

      repeat(n - 1) {
        val pairs = this.mapFrequencies(current)
        current = pairToString(pairs).toString()
      }

      return current
    }

    private fun mapFrequencies(str: String): MutableList<Pair<Char, Int>> {
      val res = mutableListOf<Pair<Char, Int>>()

      var count = 1
      for (i in 0 until str.lastIndex) {
        if (str[i] == str[i + 1]) {
          count++
        } else {
          res.add(Pair(str[i], count))
          count = 1
        }
      }

      res.add(Pair(str.last(), count))

      return res
    }

    private fun pairToString(pair: List<Pair<Char, Int>>): StringBuilder {
      val res = StringBuilder()

      pair.forEach {
        res.append(it.second).append(it.first)
      }

      return res
    }
  }
}

fun main() {
  LC38.Solution().countAndSay(2)
}

// if (n == 4) then countAndSay(4 - 1) == countAndSay(3) = countAndSay(2)...
// countAndSay(n) = countAndSay(n - 1) = countAndSay(n - 2)....
// Accepted
