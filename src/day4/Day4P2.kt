package day4

import java.io.File

/**
 * Created by Joseph on 12/17/2017
 */
class Day4P2 {
    var sum = 0
    fun init() {
        File("data/inputd4.txt").readLines(Charsets.UTF_8).forEach {
            sum += getLineValue(it)
        }
        println(sum)
    }

    private fun getLineValue(input: String): Int {
        val inputList: List<String> = input.split("\\s+".toRegex())
        for (i in 0 until inputList.size) {
            for (j in i + 1 until inputList.size) {
                val a : CharArray = inputList[i].toCharArray()
                val b : CharArray = inputList[j].toCharArray()
                a.sort()
                b.sort()
                if (a.joinToString("") == b.joinToString("")) {
                    return 0
                }
            }
        }
        return 1
    }
}

fun main(args: Array<String>) {
    Day4P2().init()
}