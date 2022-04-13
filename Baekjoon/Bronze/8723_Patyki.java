import java.util.*

fun main(args : Array<String>){
    val sc = Scanner(System.`in`)

    var st = StringTokenizer(sc.nextLine())

    var a = st.nextToken().toInt()
    var b = st.nextToken().toInt()
    var c = st.nextToken().toInt()

    if(a==b && b==c){
        println(2)
    }else{
        var arr = arrayOf (a,b,c)
        Arrays.sort(arr)
        if(arr[0]*arr[0]+arr[1]*arr[1]==arr[2]*arr[2]){
            println(1)
        }else{
            println(0)
        }
    }

}
