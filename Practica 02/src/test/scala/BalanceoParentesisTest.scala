import BalanceoParentesis.chequearBalance
import org.scalatest.FunSuite

class BalanceoParentesisTest extends FunSuite {

  val listasBalanceadas: List[List[Char]] = List(
    List('(', 'i', 'f', '(', 'a', '>', 'b', ')', '(', 'b', '/', 'a', ')', 'e', 'l', 's', 'e', '(', 'a', '/', '(', 'b', '*', 'b', ')', ')', ')'),
    List('(', 'c', 'c', 'c', '(', 'c', 'c', 'c', ')', 'c', 'c', '(', '(', 'c', 'c', 'c', '(', 'c', ')', ')', ')', ')')
  )

  val listasNoBalanceadas: List[List[Char]] = List(
    List('(', 'i', 'f', '(', 'a', '>', 'b', ')', 'b', '/', 'a', ')', 'e', 'l', 's', 'e', '(', 'a', '/', '(', 'b', '*', 'b', ')', ')', ')'),
    List('(', 'c', 'c', 'c', '(', 'c', 'c', 'c', 'c', 'c', '(', '(', 'c', 'c', 'c', '(', 'c', ')', ')', ')', ')'),
    List('(', ')', ')', '(', ')', '(', ')', ')'),
    List('(', ')', ')', '(')
  )

  test("Balanceo Parentesis -> Listas Balanceadas") {
    assert(chequearBalance(listasBalanceadas.head))
    assert(chequearBalance(listasBalanceadas.last))
  }

  test("Balanceo Parentesis -> Listas No Balanceadas") {
    assert(!chequearBalance(listasNoBalanceadas.head))
    assert(!chequearBalance(listasNoBalanceadas.tail.head))
    assert(!chequearBalance(listasNoBalanceadas.tail.tail.head))
    assert(!chequearBalance(listasNoBalanceadas.last))
  }

}