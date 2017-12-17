package day2

import java.io.File

/**
 * Created by Joseph on 12/17/2017
 */
class Day2 {
    var sum: Int = 0
    fun init() {
        File("data/inputd2.txt").readLines(Charsets.UTF_8).forEach {
            sum += findDifference(it)
        }
        println(sum)
    }
    fun findDifference(input : String) : Int {
        var min = -1
        var max = -1
        input.split("\\s+".toRegex()).forEach {
            val value = it.toInt()
            if(min == -1 || value < min) {
                min = value
            }
            if(max == -1 || value > max) {
                max = value
            }
        }
        return max-min
    }
}

fun main(args: Array<String>) {
    Day2().init()
}