object ContadorCambios extends App {

  def listarCambiosPosibles(cantidad: Int, monedas: List[Int]): List[List[Int]] = {

    def contar(cantidad: Int, monedas: List[Int], cambio: List[Int]): List[List[Int]] = {
      if (0 == cantidad) {
        List(cambio)
      } else if (cantidad < 0 || monedas.isEmpty) {
        List(List())
      } else {
        contar(cantidad - monedas.head, monedas, monedas.head :: cambio) ::: contar(cantidad, monedas.tail, cambio)
      }
    }

    contar(cantidad, monedas, List()).filter((lista) => lista.nonEmpty)
  }

  def test(): Unit = {

    println("Contador de Posibles Cambios de Moneda" + "\n")

    println(listarCambiosPosibles(4, List(1, 2, 3, 4)))
    println(listarCambiosPosibles(4, List(1, 2, 3)))
    println(listarCambiosPosibles(4, List(1, 2)))
    println(listarCambiosPosibles(4, List(1)))
    println(listarCambiosPosibles(4, List()))
    println(listarCambiosPosibles(0, List(1, 2, 3, 4)))
  }

  test()
}
