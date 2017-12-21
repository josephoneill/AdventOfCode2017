package day3

import java.io.File

/**
 * Created by Joseph on 12/17/2017
 */
class Day3P2 {
    fun init() {
        File("data/inputd3.txt").readLines(Charsets.UTF_8).forEach {
            println(findAnswer(it))
        }
    }

    //Brute-force the answer because it's the easiest solution
    private fun findAnswer() {
        var counter = 0
        var prevPerimSize = 1
        var iteration = 1
        val squareList : MutableList<Int> = mutableListOf(1)
        while(squareList[counter] < 1000) {
            counter++
            if(counter > prevPerimSize + (8*iteration)) {
                if(prevPerimSize == 1) { prevPerimSize-- }
                prevPerimSize += 8
                iteration++
            }
            var nextValue = squareList[counter-1]
            squareList.add(counter, 995+counter)
        }
        println(squareList[counter])
    }

    private fun findAnswer(input: String): Int {
        val answer : Int
        val squareList : MutableList<Int> = mutableListOf(1)
        val counter = 1
        var currIteration = 0
        var currIterationPerimeter = 0
        var currIterationMax = 1
        val location = input.toInt()
        while (currIterationMax < location) {
            currIterationPerimeter += 8
            currIteration++
            currIterationMax += currIterationPerimeter
        }
        answer = findDistance(location, currIteration, currIterationPerimeter, currIterationMax)
        return answer
    }

    private fun findDistance(input : Int, iteration: Int, currItPeri : Int, currMax: Int): Int {
        val distance : Int
        val lastMax = currMax - currItPeri
        val currSideLength = iteration*2 + 1
        val locationInPeri = ((input - (lastMax+1))%currSideLength)+1
        val locationAboveCenter = locationInPeri - ((currSideLength)/2)
        distance = iteration+locationAboveCenter
        return distance
    }
}

fun main(args: Array<String>) {
    Day3().init()
}