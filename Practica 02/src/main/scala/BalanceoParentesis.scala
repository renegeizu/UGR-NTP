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

  println("Balanceo de Cadenas con Parentesis" + "\n")

  var lista1: List[Char] = List('(', 'i', 'f', '(', 'a', '>', 'b', ')', '(', 'b', '/', 'a', ')',
    'e', 'l', 's', 'e', '(', 'a', '/', '(', 'b', '*', 'b', ')', ')', ')')
  var lista2: List[Char] = List('(', 'c', 'c', 'c', '(', 'c', 'c', 'c', ')', 'c', 'c', '(', '(',
    'c', 'c', 'c', '(', 'c', ')', ')', ')', ')')
  var lista3: List[Char] = List('(', 'i', 'f', '(', 'a', '>', 'b', ')', 'b', '/', 'a', ')', 'e',
    'l', 's', 'e', '(', 'a', '/', '(', 'b', '*', 'b', ')', ')', ')')
  var lista4: List[Char] = List('(', 'c', 'c', 'c', '(', 'c', 'c', 'c', 'c', 'c', '(', '(', 'c',
    'c', 'c', '(', 'c', ')', ')', ')', ')')
  var lista5: List[Char] = List('(', ')', ')', '(', ')', '(', ')', ')')
  var lista6: List[Char] = List('(', ')', ')', '(')

  var lista: List[List[Char]] = List(lista1, lista2, lista3, lista4, lista5, lista6)

  for (sublista <- lista) {
    if (chequearBalance(sublista)) {
      println("La cadena " + sublista.mkString + " esta balanceada" + "\n")
    } else {
      println("La cadena " + sublista.mkString + " no esta balanceada" + "\n")
    }
  }
}
