package main.day1

import java.io.File

fun main() {
    val sortedExpenses = File("./src/main/day1/input_day_1").readLines().sorted().map(Integer::parseInt)
    val matchingPair = findMatchingPair(sortedExpenses)
    println(
        """
        Matching pair: $matchingPair
        Result: ${matchingPair.first * matchingPair.second}
    """.trimIndent()
    )
}

fun findMatchingPair(sortedExpenses: List<Int>): Pair<Int, Int> {
    sortedExpenses.forEach { expense ->
        sortedExpenses.find { (it + expense == 2020 && it != expense) }?.let { match ->
            return Pair(expense, match)
        }
    }
    throw IllegalStateException()
}
