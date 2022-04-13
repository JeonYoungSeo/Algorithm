import java.util.*

fun main(args : Array<String>){
    val sc = Scanner(System.`in`)

    var st = StringTokenizer(sc.nextLine())

    var a :Long = st.nextToken().toLong()
    var b :Long = st.nextToken().toLong()

    if(a%2==0L || b%2==0L){
        println(0)
    }else{
        println(Math.min(a,b))
    }

}
