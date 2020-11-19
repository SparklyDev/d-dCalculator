fun reader(){
    var dice = readLine()!!.toString()
    println(dice)
    var n = dice[0].toString().toInt()
    var sides = dice[2].toString().toInt()
    println("You rolled $n dice(s) with $sides sides")
    println(sides)
    println(n)
}