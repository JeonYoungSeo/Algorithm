import java.util.*

fun main(args : Array<String>){
    val sc = Scanner(System.`in`)

    var A = sc.nextLine().toInt()
    var B = sc.nextLine().toInt()
    var C = sc.nextLine().toInt()
    var D = sc.nextLine().toInt()
    var P = sc.nextLine().toInt()

    if(A<0){
        println(-A*C+D+B*P)
    }else{
        println((B-A)*P)
    }

}
