import BalanceoParentesis.chequearBalance
import org.scalacheck.{Gen, Properties}
import org.scalacheck.Prop.forAll

object BalanceoParentesisCheck extends Properties("Balanceo de Cadenas con Parentesis") {

  val generarCadenas: Int => Gen[List[Char]] = (n: Int) => {
    Gen.listOfN(n, Gen.oneOf('(', Gen.alphaChar.sample.get, ')'))
  }

  private def checkBalanceo(list: List[Char]): Boolean = {
    var abiertos = 0
    var cerrados = 0
    var estaBalanceado = true

    list.foreach(
      c => {
        if (c == '(') {
          abiertos += 1
        } else if (c == ')') {
          cerrados += 1
        }

        if (abiertos < cerrados) {
          estaBalanceado = false
        }
    })

    estaBalanceado && abiertos == cerrados
  }

  property("Comprobar Balanceo de Parentesis") = forAll(generarCadenas(13)){
    (list) => {
      chequearBalance(list) == checkBalanceo(list)
    }
  }

}