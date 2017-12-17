package day1

import java.io.File

/**
 * Created by Joseph on 12/17/2017
 */
class Day1P2 {
    private var sum: Int = 0
    fun init() {
        File("data/inputd1.txt").readLines(Charsets.UTF_8).forEach {
            findSum(it, it[0])
        }
        println(sum)
    }

    private fun findSum(input: String, start: Char) {
        var streak = 0
        var currChar: Char = start
        for (i in 1..(input.length/2)) {
            if (currChar == input[input.length/2+(i-1)]) {
                sum += (Character.getNumericValue(currChar) * 2)
            }
            currChar = input[i]
        }
    }
}

fun main(args: Array<String>) {
    Day1P2().init()
}