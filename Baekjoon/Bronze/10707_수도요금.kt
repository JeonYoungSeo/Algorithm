import java.util.*

fun main(args : Array<String>){
    val sc = Scanner(System.`in`)

    var A = sc.nextLine().toInt()
    var B = sc.nextLine().toInt()
    var C = sc.nextLine().toInt()
    var D = sc.nextLine().toInt()
    var P = sc.nextLine().toInt()

    var ans1 = A*P

    var ans2 = if(C>=P) B else B+(P-C)*D

    println(minOf(ans1, ans2))
}
