object TrianguloPascal extends App {

  def calcularValorTrianguloPascal(fila: Int, columna: Int): Int = {
    if (fila < columna) {
      -1
    }else if (columna == 0 || columna == fila) {
      1
    } else {
      calcularValorTrianguloPascal(fila - 1, columna) + calcularValorTrianguloPascal(fila - 1, columna - 1)
    }
  }

  def generarTriangulo(filas: Int): Unit = {
    for (fila <- 0 to filas) {
      for (columna <- 0 to fila) {
        print(calcularValorTrianguloPascal(fila, columna) + " ")
      }

      println("")
    }

    println("")
  }

  println("Triangulo de Pascal" + "\n")

  generarTriangulo(10)

  println(calcularValorTrianguloPascal(15, 10))
}
