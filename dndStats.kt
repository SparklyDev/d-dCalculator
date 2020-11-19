var rolled = mutableListOf<Int>()//Liste des résultats de jets
var stats = listOf("Strenght", "Dexterity", "Intelligence", "Wisdom", "Constitution", "Charism")//Liste de cara possibles
var hud = listOf("Roll Stats", "Dice", "Stop Program")
fun main() {
    println("Select a task")
    println(hud)
    val selectedHud = readLine()

    if (selectedHud == "Roll Stats") {
        rollChoice()

    } else if (selectedHud == "Dice") {

        println("Enter a valid dice ex: 1d6")
        val dice = readLine()!!.toString()
        val n = dice[0].toString().toInt()
        val f = dice[2].toString().toInt()
        val result = throwDice(n, f)
        println(result)
        main()

    }else if (selectedHud == "Stop Program"){
        return

    }else{
        println("Enter a valid choice")
        main()
    }

}

fun rollChoice(){

    println("Roll one or all stats ?")
    println("One / All")

    val choice = readLine()//Entrée de l'utilisateur

    if (choice == "One"){//Si One est choisie le programme lance 1d6 et renvoie le résultat
        oneRoll()
        reRoll()

    }else if (choice == "All"){//Si All est choisi le programme lance 6 fois 1d6 et affiche sous forme de liste

        for (j in stats.indices){//On boucle avec for jusqu'a obtenir 6 jets
            val roll = throwDice(3, 6)
            rolled.add(j, roll)
        }
        println(stats)
        println(rolled)
    }else{
        println("Please enter a valid choice")
        rollChoice()
    }
}
fun throwDice(n: Int, f: Int): Int{//Fonction qui renvoie autant de lancer de dé à autant de faces qu'on veut

    val results = mutableListOf(0)//On crée une liste modifiable ayant 0 pour valeur initiale

    for (i in 0 until n){
        results.add(i, (1..f).random())//Puis on ajoute à la liste les jets obtenus
    }
    return results.sum()//La fonction renvoie la somme des jets
}

fun oneRoll(){

        print("Which one ?")//On demande la stat que l'utilisateur veut roll
        println(stats)

        val stat = readLine()//L'orthographe importe peu vu que la saisie est stockée dans une variable
    val roll = throwDice(3, 6)//On éxécute la fonction générant 3d6

    println("You got $roll in $stat")//On affiche le résultat et termine le programme
}


fun reRoll() {

    loop@ for (i in 2 downTo 1) {

        println("Reroll ? $i reroll left. Yes / No")//On propose au joueur de reroll jusq'à deux fois
        val choice = readLine()

        if (choice == "Yes") {//Si oui on relance la fonction de jets
            oneRoll()

        }else if (choice == "No"){//Sinon on termine la boucle et le programme
            break@loop
        }else{
            println("Bad orthographe = Malus (Cheh)")//L'utilisateur gâche un lancer si il répond autre que Yes et No
        }//Parce que ça bug si je renvoie directement à la fonction et flemme de me prendre la tête
    }
}