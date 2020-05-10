object BalanceoParentesis extends App {

  def chequearBalance(cadena: List[Char]): Boolean = {

    @annotation.tailrec
    def chequeo(cadena: List[Char], contador: Int = 0): Boolean = {
      if (cadena.isEmpty) {
        0 == contador
      } else if (0 > contador) {
        false
      } else if ('(' == cadena.head) {
        chequeo(cadena.tail, contador + 1)
      } else if (')' == cadena.head) {
        chequeo(cadena.tail, contador - 1)
      } else {
        chequeo(cadena.tail, contador)
      }
    }

    chequeo(cadena)
  }

  def test(): Unit = {

    val listas: List[List[Char]] = List(
      List('(', 'i', 'f', '(', 'a', '>', 'b', ')', '(', 'b', '/', 'a', ')', 'e', 'l', 's', 'e', '(', 'a', '/', '(', 'b', '*', 'b', ')', ')', ')'),
      List('(', 'c', 'c', 'c', '(', 'c', 'c', 'c', ')', 'c', 'c', '(', '(', 'c', 'c', 'c', '(', 'c', ')', ')', ')', ')'),
      List('(', 'i', 'f', '(', 'a', '>', 'b', ')', 'b', '/', 'a', ')', 'e', 'l', 's', 'e', '(', 'a', '/', '(', 'b', '*', 'b', ')', ')', ')'),
      List('(', 'c', 'c', 'c', '(', 'c', 'c', 'c', 'c', 'c', '(', '(', 'c', 'c', 'c', '(', 'c', ')', ')', ')', ')'),
      List('(', ')', ')', '(', ')', '(', ')', ')'),
      List('(', ')', ')', '(')
    )

    println("Balanceo de Cadenas con Parentesis (Test): " + "\n")

    for (lista <- listas) {
      if (chequearBalance(lista)) {
        println("La cadena " + lista.mkString + " esta balanceada" + "\n")
      } else {
        println("La cadena " + lista.mkString + " no esta balanceada" + "\n")
      }
    }
  }

  test()
}
