import java.math.BigInteger
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    println("RSW Time-Lock Puzzle | Options:")

    while (true) {
        println("1: Generate Keys")
        println("2: Encrypt/Decrypt with keys")
        println("3: Encrypt/Decrypt without keys")
        println("4: Exit")
        when (scanner.nextInt()) {
            1 -> {
                println("How many bits? Enter:")
                val bits = scanner.nextInt()
                val p = getPrime(bits)
                val q = getPrime(bits)
                println("p = $p")
                println("q = $q")
                println("n = ${p * q}")
            }

            2 -> {
                println("Enter p, q, a, t in that order:")
                val p = BigInteger(scanner.next())
                val q = BigInteger(scanner.next())
                val a = BigInteger(scanner.next())
                val t = BigInteger(scanner.next())
                println("y = ${withTrapdoor(a, t, p, q)}")
            }

            3 -> {
                println("Enter n, a, t in that order:")
                val n = BigInteger(scanner.next())
                val a = BigInteger(scanner.next())
                val t = BigInteger(scanner.next())
                println("y = ${withoutTrapdoor(a, t, n)}")
            }

            4 -> {
                break
            }

            else -> {
                println("Not an option.")
            }
        }
    }
}

