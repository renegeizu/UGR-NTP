object BusquedaSaltos extends App {

  def busquedaSaltos[A](coleccion: Array[A], aBuscar: A, criterio: (A, A) => Boolean): Int = {

    val bloque = math.sqrt(coleccion.length).toInt

    def buscar(coleccion: Array[A], contador: Int = 0): Int = {
      if (0 == coleccion.length) {
        return -1
      }

      if (bloque > coleccion.length || !criterio(coleccion(bloque - 1), aBuscar)) {
        for (posicion <- coleccion.indices) {
          if (aBuscar == coleccion(posicion)) {
            return contador + posicion
          }
        }

        -1
      }else if (coleccion(bloque - 1) == aBuscar) {
        bloque + contador - 1
      } else {
        buscar(coleccion.slice(bloque, coleccion.length), bloque + contador)
      }

    }

    buscar(coleccion)
  }

  def printColeccion(coleccion: Array[Int]): Unit = {
    for (elemento <- coleccion) {
      printf("%d ", elemento)
    }
  }

  def test(): Unit = {
    val listas: List[Array[Int]] = List(
      Array(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610),
      Array(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55),
      Array(0, 1, 1, 2, 3, 5, 8, 13, 21, 34)
    )

    val valor: Int = 55

    val comparador = (x: Int, y: Int) => x < y

    println("Busqueda a Saltos Generica (Test)" + "\n")

    for (lista <- listas) {
      print("El resultado de la busqueda en la lista  ")
      printColeccion(lista)
      println("del valor " + valor + " es " + busquedaSaltos[Int](lista, valor, comparador) + "\n")
    }
  }

  test()
}
