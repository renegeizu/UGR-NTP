import BusquedaSaltos.busquedaSaltos
import org.scalatest.FunSuite

class BusquedaSaltosTest extends FunSuite {

  val listas: List[Array[Int]] = List(
    Array(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610),
    Array(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55),
    Array(0, 1, 1, 2, 3, 5, 8, 13, 21, 34)
  )

  val valor: Int = 55

  val comparador: (Int, Int) => Boolean = (x: Int, y: Int) => x < y

  test("Busqueda Saltos -> Buscar Numeros") {
    assert(busquedaSaltos[Int](listas.head, valor, comparador) == 10)
    assert(busquedaSaltos[Int](listas.tail.head, valor, comparador) == 10)
    assert(busquedaSaltos[Int](listas.last, valor, comparador) == -1)
  }

}