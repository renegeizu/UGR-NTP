object BusquedaSaltos extends App {

  def busquedaSaltos[A](coleccion: Array[A], aBuscar: A, criterio: (A, A) => Boolean): Int = {

    val bloque = math.sqrt(coleccion.length).toInt

    def buscar(coleccion: Array[A], contador: Int = 0): Int = {
      if (0 == coleccion.length) {
        return -1
      }

      if (bloque > coleccion.length || !criterio(coleccion(bloque - 1), aBuscar)) {
        for (posicion <- 0 to bloque) {
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

  val lista: Array[Int] = Array(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610)
  val valor: Int = 55
  val comparador = (x: Int, y: Int) => x < y

  println("Busqueda a Saltos Generica" + "\n")

  val resultado = busquedaSaltos[Int](lista, valor, comparador)

  println("El resultado de la busqueda en la lista  " + lista.mkString + " del valor " + valor +
    " es " + resultado + "\n")

}
