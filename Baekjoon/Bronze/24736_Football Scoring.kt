import java.util.*

fun main(args : Array<String>){
    val sc : Scanner = Scanner(System.`in`)

    var ast : StringTokenizer = StringTokenizer(sc.nextLine())
    var bst : StringTokenizer = StringTokenizer(sc.nextLine())
    var arr1 = IntArray(5)
    var arr2 = IntArray(5)

    for(i in 0..4){
        arr1[i] = ast.nextToken().toInt()
    }
    for(i in 0..4){
        arr2[i] = bst.nextToken().toInt()
    }
    var sum1 = 0;
    sum1 += arr1[0]*6
    sum1 += arr1[1]*3
    sum1 += arr1[2]*2
    sum1 += arr1[3]*1
    sum1 += arr1[4]*2
    var sum2 = 0;
    sum2 += arr2[0]*6
    sum2 += arr2[1]*3
    sum2 += arr2[2]*2
    sum2 += arr2[3]*1
    sum2 += arr2[4]*2

    println("$sum1 $sum2")

}
