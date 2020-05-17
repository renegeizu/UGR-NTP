import ContadorCambios.listarCambiosPosibles
import org.scalatest.FunSuite

class ContadorCambiosTest extends FunSuite {

  test("Contador Cambios -> Valores Positivos de Monedas y Cambio") {
    assert(listarCambiosPosibles(4, List(1, 2, 3, 4)).length == 5)
    assert(listarCambiosPosibles(4, List(1, 2, 3)).length == 4)
    assert(listarCambiosPosibles(4, List(1, 2)).length == 3)
    assert(listarCambiosPosibles(4, List(1)).length == 1)
  }

  test("Contador Cambios -> Sin Monedas") {
    assert(listarCambiosPosibles(4, List()).isEmpty)
  }

  test("Contador Cambios -> Cambio Nulo") {
    assert(listarCambiosPosibles(0, List(1, 2, 3, 4)).isEmpty)
  }

}