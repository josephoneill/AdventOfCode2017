package day1

import java.io.File

/**
 * Created by Joseph on 12/17/2017
 */
class Day1 {
    var sum: Int = 0
    fun init() {
        File("data/inputd1.txt").readLines(Charsets.UTF_8).forEach {
            findSum(it, it[0])
        }
        println(sum)
    }

    fun findSum(input: String, start: Char) {
        var streak = 0
        var currChar: Char = start
        println(input.length)
        for (i in 1..input.length + 1) {
            if (currChar == input[i % input.length]) {
                streak++
            } else {
                sum += (Character.getNumericValue(currChar) * (streak))
                println(currChar)
                streak = 0
            }
            currChar = input[i % input.length]
        }
    }
}

fun main(args: Array<String>) {
    Day1().init()
}