object BusquedaBinaria extends App {

  def busquedaBinaria[A](coleccion: Array[A], aBuscar: A, criterio: (A, A) => Boolean): Int = {

    @annotation.tailrec
    def buscar(coleccion: Array[A], contador: Int = 0): Int = {
      if (0 == coleccion.length) {
        -1
      }

      val pivote = coleccion.length / 2
      val elemento = coleccion(pivote)

      if (elemento == aBuscar) {
        pivote + contador
      } else if (1 == coleccion.length) {
        -1
      } else if (criterio(elemento, aBuscar)) {
        buscar(coleccion.slice(pivote + 1, coleccion.length), pivote + contador + 1)
      } else {
        buscar(coleccion.slice(0, pivote), contador)
      }
    }

    buscar(coleccion)
  }

  val lista1: Array[Char] = Array('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
    'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
  val valor1: Char = 'r'

  val lista2: Array[Int] = Array('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
  val valor2: Int = '3'

  println("Busqueda Binaria Generica" + "\n")

  val resultado1 = busquedaBinaria[Char](lista1, valor1, _<_)
  val resultado2 = busquedaBinaria[Int](lista2, valor2, _>_)

  println("El resultado de la busqueda en la lista  " + lista1.mkString + " del valor " + valor1 +
    " es " + resultado1 + "\n")

  println("El resultado de la busqueda en la lista  " + lista2.mkString + " del valor " + valor2 +
    " es " + resultado2 + "\n")
}
