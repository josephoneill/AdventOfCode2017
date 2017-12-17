package day2

import java.io.File

/**
 * Created by Joseph on 12/17/2017
 */
class Day2P2 {
    private var sum: Int = 0
    fun init() {
        File("data/inputd2.txt").readLines(Charsets.UTF_8).forEach {
            sum += findDivisionResult(it)
        }
        println(sum)
    }

    private fun findDivisionResult(input: String) : Int {
        var value = 0
        val inputList : List<String> = input.split("\\s+".toRegex())
        for (i in 0 until inputList.size) {
            val a = inputList[i].toInt()
            for(j in i+1 until inputList.size) {
                val b = inputList[j].toInt()
                val remainder = if (a > b) a % b else b % a
                if (remainder == 0) {
                    value = if (a > b) a / b else b / a
                    break
                }
            }
        }
        return value
    }
}

fun main(args: Array<String>) {
    Day2P2().init()
}