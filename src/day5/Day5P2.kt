package day5

import java.io.File

/**
 * Created by Joseph on 12/17/2017
 */
class Day5P2 {
    var data : MutableList<Int> = mutableListOf()
    fun init() {
        File("data/inputd5.txt").readLines(Charsets.UTF_8).forEach {
            data.add(it.toInt())
        }
        println(findNumOfJumps(data))
    }

    private fun findNumOfJumps(input: MutableList<Int>): Int {
        var jumps = 0
        var prevIndex = 0
        var currIndex = 0
        while(currIndex >= 0 && currIndex < input.size) {
            currIndex = prevIndex + input[prevIndex]
            if(input[prevIndex] >=3) input[prevIndex]-- else input[prevIndex]++
            jumps++
            prevIndex = currIndex
        }
        return jumps
    }
}

fun main(args: Array<String>) {
    Day5P2().init()
}