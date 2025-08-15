import java.math.BigInteger
import java.security.SecureRandom

val random = SecureRandom()

fun getPrime(bits: Int = 1024): BigInteger = BigInteger(bits, 1000, random)

fun withTrapdoor(a: BigInteger, t: BigInteger, p: BigInteger, q: BigInteger): BigInteger {
    val phi = (p - BigInteger.ONE) * (q - BigInteger.ONE)
    val e = BigInteger.TWO.modPow(t, phi)
    return a.modPow(e, p * q)
}

fun withoutTrapdoor(a: BigInteger = BigInteger.TWO, t: BigInteger, n: BigInteger): BigInteger {
    var x = a

    var i = BigInteger.ZERO
    while (i < t) {
        x = x.modPow(BigInteger.TWO, n)

        i = i.add(BigInteger.ONE)
    }

    return x
}
