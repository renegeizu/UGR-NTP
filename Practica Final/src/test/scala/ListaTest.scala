import org.scalatest.FunSuite

class ListaTest extends FunSuite {

  /**
   * Comprueba que la Instancia de la Lista Creada se Corresponde con el Contenido que se
   * le Pasa
   */
  test("Metodo Apply"){
    assert(Lista(1, 3, 5, 7, 9).isInstanceOf[Cons[Int]])
    assert(Lista(1.3, 3.5, 5.7, 7.9).isInstanceOf[Cons[Double]])
    assert(Lista('a', 'b', 'c', 'x', 'y', 'z').isInstanceOf[Cons[Char]])
    assert(Lista("Variable", "Constante", "Funcion", "Objeto", "Clase").isInstanceOf[Cons[String]])
  }

  /**
   * Metodo que Imita el Metodo de la Clase List. Devuelve una Lista con Todos los Elementos
   * Menos el Primero
   */
  test("Metodo ObtenerCola"){
    assert(Lista.obtenerCola(Lista(1, 3, 5, 7, 9)) == Lista(3, 5, 7, 9))
    assert(Lista.obtenerCola(Lista(9, 7, 5, 3, 1)) == Lista(7, 5, 3, 1))
    assert(Lista.obtenerCola(Lista(3, 1, 5, 9, 7)) == Lista(1, 5, 9, 7))
  }

  /**
   * Devuelve una Lista con los Valores que Cumplen la Condicion
   */
  test("Metodo Filtrar"){
    assert(Lista.filtrar(Lista(1, 3, 5, 7, 9, 7, 5, 3, 1))(x => x == 7) == Lista(7, 7))
    assert(Lista.filtrar(Lista(1, 3, 5, 7, 9, 7, 5, 3, 1))(x => x == 11) == Lista())
    assert(Lista.filtrar(Lista(1, 3, 5, 7, 1, 7, 5, 3, 1))(x => x == 1) == Lista(1, 1, 1))
    assert(Lista.filtrar(Lista(1, 3, 5, 7, 1, 7, 5, 3, 1))(x => x > 1 && x < 7) == Lista(3, 5, 5, 3))
  }

  /**
   * Transforma la Lista en un Objeto de la Clase List
   */
  test("Metodo ToList"){
    assert(Lista.toList(Lista(1, 3, 5, 7, 9)) == List(1, 3, 5, 7, 9))
    assert(Lista.toList(Lista(9, 7, 5, 3, 1)) == List(9, 7, 5, 3, 1))
  }

}
