package day4

import java.io.File

/**
 * Created by Joseph on 12/17/2017
 */
class Day4 {
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
            (i + 1 until inputList.size)
                    .filter { inputList[i] == inputList[it] }
                    .forEach { return 0 }
        }
        return 1
    }
}

fun main(args: Array<String>) {
    Day4().init()
}