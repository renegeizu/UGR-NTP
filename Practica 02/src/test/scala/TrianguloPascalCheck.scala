import TrianguloPascal.calcularValorTrianguloPascal
import org.scalacheck.{Gen, Properties}
import org.scalacheck.Prop.forAll

object TrianguloPascalCheck extends Properties("Triangulo de Pascal") {

  private val MAXIMO = 30

  val coordenadasExtremos: Gen[(Int, Int)] = for {
    fila <- Gen.choose(0, MAXIMO)
    columna <- Gen.oneOf(0, fila)
  } yield (fila, columna)

  property("Valor Extremos = 1") = {
    forAll(coordenadasExtremos) {
      i => {
        1 == calcularValorTrianguloPascal(i._1, i._2)
      }
    }
  }

  val coordenadasInteriores: Gen[(Int, Int)] = for {
    fila <- Gen.choose(2, MAXIMO)
    columna <- Gen.choose(1, fila - 1)
  } yield(fila, columna)

  property("Valores Interiores = Suma Superiores ") = {
    forAll(coordenadasInteriores) {
      (i) => {
        val izq = TrianguloPascal.calcularValorTrianguloPascal(i._1-1, i._2-1)
        val der = TrianguloPascal.calcularValorTrianguloPascal(i._1-1, i._2)
        val result = TrianguloPascal.calcularValorTrianguloPascal(i._1, i._2)

        result == (izq + der)
      }
    }
  }

}