import java.util.*

fun main(args : Array<String>){
    val sc : Scanner = Scanner(System.`in`)

    val antenna : Int = sc.nextLine().toInt()
    val eyes:Int = sc.nextLine().toInt()

    if(antenna>=3 && eyes<=4){
        println("TroyMartian")
    }

    if(antenna<=6 && eyes>=2){
        println("VladSaturnian")
    }

    if(antenna<=2 && eyes<=3){
        println("GraemeMercurian")
    }


}
