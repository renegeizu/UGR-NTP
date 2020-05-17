import TrianguloPascal.calcularValorTrianguloPascal
import org.scalatest.FunSuite

class TrianguloPascalTest extends FunSuite {

  println("El valor para (15, 10) es " + calcularValorTrianguloPascal(15, 10))
  println("El valor para (10, 15) es " + calcularValorTrianguloPascal(10, 15))
  println("El valor para (3, 2) es " + calcularValorTrianguloPascal(3, 2))

  test("Triangulo Pascal -> Valores Extremos = 1") {
    assert(calcularValorTrianguloPascal(5,5) == 1)
    assert(calcularValorTrianguloPascal(5,0) == 1)
    assert(calcularValorTrianguloPascal(10, 10) == 1)
    assert(calcularValorTrianguloPascal(15, 15) == 1)
  }

  test("Triangulo Pascal -> Valores Internos") {
    assert(calcularValorTrianguloPascal(15, 10) == 3003)
    assert(calcularValorTrianguloPascal(3, 2) == 3)
  }

  test("Triangulo Pascal -> Valor Invalido (fila < columna)") {
    assert(calcularValorTrianguloPascal(10, 15) == -1)
  }

}