import BusquedaBinaria.busquedaBinaria
import org.scalatest.FunSuite

class BusquedaBinariaTest extends FunSuite {

  val listaCaracteres: Array[Char] = Array('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
  val listaNumerica: Array[Int] = Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

  val comparadorCaracteres: (Char, Char) => Boolean = (x: Char, y: Char) => x < y
  val comparadorNumerico: (Int, Int) => Boolean = (x: Int, y: Int) => x < y

  test("Busqueda Binaria -> Buscar Caracteres") {
    assert(busquedaBinaria[Char](listaCaracteres, 'a', comparadorCaracteres) == 0)
    assert(busquedaBinaria[Char](listaCaracteres, 'l', comparadorCaracteres) == 11)
    assert(busquedaBinaria[Char](listaCaracteres, 'r', comparadorCaracteres) == 17)
  }

  test("Busqueda Binaria -> Buscar Numeros") {
    assert(busquedaBinaria[Int](listaNumerica, 3, comparadorNumerico) == 3)
    assert(busquedaBinaria[Int](listaNumerica, 7, comparadorNumerico) == 7)
    assert(busquedaBinaria[Int](listaNumerica, 9, comparadorNumerico) == 9)
  }

}