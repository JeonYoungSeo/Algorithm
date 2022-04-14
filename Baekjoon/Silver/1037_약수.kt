import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(args : Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()

    var min = 1_000_001
    var max = 0
    var n:Int

    var st = StringTokenizer(br.readLine())
    for(i in 0 until N){
        n = st.nextToken().toInt()

        min = minOf(min, n)
        max = maxOf(max, n)
    }

    println(min*max)
}
