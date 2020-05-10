object BusquedaBinaria extends App {

  def busquedaBinaria[A](coleccion: Array[A], aBuscar: A, criterio: (A, A) => Boolean): Int = {

    @annotation.tailrec
    def buscar(coleccion: Array[A], contador: Int = 0): Int = {
      if (0 == coleccion.length) {
        return -1
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

  def test(): Unit = {

    val listaCaracteres: Array[Char] = Array('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
    val listaNumerica: Array[Int] = Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

    val comparadorCaracteres = (x: Char, y: Char) => x < y
    val comparadorNumerico = (x: Int, y: Int) => x < y

    println("Busqueda Binaria Generica (Test)" + "\n")

    println("El resultado de la busqueda en la lista  " + listaCaracteres.mkString + " del valor 'a' es " + busquedaBinaria[Char](listaCaracteres, 'a', comparadorCaracteres) + "\n")
    println("El resultado de la busqueda en la lista  " + listaCaracteres.mkString + " del valor 'l' es " + busquedaBinaria[Char](listaCaracteres, 'l', comparadorCaracteres) + "\n")
    println("El resultado de la busqueda en la lista  " + listaCaracteres.mkString + " del valor 'r' es " + busquedaBinaria[Char](listaCaracteres, 'r', comparadorCaracteres) + "\n")

    println("El resultado de la busqueda en la lista  " + listaNumerica.mkString + " del valor '3' es " + busquedaBinaria[Int](listaNumerica, 3, comparadorNumerico) + "\n")
    println("El resultado de la busqueda en la lista  " + listaNumerica.mkString + " del valor '7' es " + busquedaBinaria[Int](listaNumerica, 7, comparadorNumerico) + "\n")
    println("El resultado de la busqueda en la lista  " + listaNumerica.mkString + " del valor '9' es " + busquedaBinaria[Int](listaNumerica, 9, comparadorNumerico) + "\n")
  }

  test()
}
