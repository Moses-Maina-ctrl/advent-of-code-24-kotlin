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
            if(One[i]>Two[i]){
                val diff : Int = One[i] - Two[i]
                distance += diff
            }else{
                val diff :Int = Two[i] - One[i]
                distance += diff
            }
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
        return input.size
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
