object TrianguloPascal extends App {

  def calcularValorTrianguloPascal(fila: Int, columna: Int): Int = {
    if (columna == 0 || columna == fila) {
      1
    } else {
      calcularValorTrianguloPascal(fila - 1, columna) + calcularValorTrianguloPascal(fila - 1, columna)
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

  calcularValorTrianguloPascal(15, 10)
}
