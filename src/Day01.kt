import kotlin.math.abs

fun main() {
    fun separateNum(line: String,listOne: MutableList<Int>, listTwo: MutableList<Int> ){
        val nums = line.split(" ").filter{it.isNotEmpty()}
        val num1 = nums[0].toInt()
        val num2 = nums[1].toInt()
        listOne.add(num1)
        listTwo.add(num2)
    }

    fun getTotalDistance(One: MutableList<Int>, Two: MutableList<Int>): Int{
        One.sort()
        Two.sort()
        var distance = 0
        for (i in One.indices){
                val diff : Int =abs( One[i] - Two[i])
                distance += diff
        }
        return distance
    }

    fun part1(input: List<String>): Int {
        val listOne : MutableList<Int> = arrayListOf()
        val listTwo : MutableList<Int> = arrayListOf()

        for (line in input){
            separateNum(line,listOne,listTwo)
        }

        return getTotalDistance(listOne, listTwo)

    }

    fun part2(input: List<String>): Int {
        val  valCounter= HashMap<Int,Int>()
        val (left, right) = input.map{
            val firstNum = it.substringBefore(" ").toInt()
            val secondNum = it.substringAfterLast(" ").toInt()
            firstNum to secondNum
        }.unzip()
        for (num in right){
            if (num in left) {
                valCounter[num] = (valCounter[num] ?: 0) + 1
            }
        }
        val similarityScore : Int= valCounter.map{(key ,value)->
            key *value
        }.sum()
        return similarityScore
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    //val testInput = readInput("Day01_test")
    //check(part1(testInput) == 1)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
