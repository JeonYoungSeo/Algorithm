import java.util.*

fun main(args : Array<String>){
    val sc : Scanner = Scanner(System.`in`)

    val code : String = "1313131313131"
    var isbn : String = "9780921418"

    for(i in 0..2){
        isbn += sc.nextLine()
    }
    var sum:Int = 0

    for(i in 0..12){
        sum += (code[i] -'0')*(isbn[i]-'0')
    }

    println("The 1-3-sum is $sum")

}
