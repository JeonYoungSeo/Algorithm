import java.util.*

fun main(args : Array<String>){
    val sc = Scanner(System.`in`)

    var st = StringTokenizer(sc.nextLine())

    var a = st.nextToken().toInt()
    var b = st.nextToken().toInt()
    var c = st.nextToken().toInt()

    if(a>=b){
        println(0)
    }else {
        b -= a
        println(if (b % c == 0) b / c else b / c + 1)
    }
}
