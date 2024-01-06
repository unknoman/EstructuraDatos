
public class parcial2 {

	class Nodo {
		int info;
		Nodo izq, der;
	}

	Nodo raiz;

	public void insertar(int info) {
		Nodo nuevo;
		nuevo = new Nodo();
		nuevo.info = info;
		nuevo.izq = null;
		nuevo.der = null;
		if (raiz == null) {
			raiz = nuevo;
			System.out.println(nuevo.info + " Es el nodo raiz ");
		} else {
			Nodo anterior = null, reco;
			reco = raiz;
			while (reco != null) {
				anterior = reco;
				if (info < reco.info) {

					reco = reco.izq;
				}

				else {
					reco = reco.der;
				}
			}
			if (info < anterior.info) {
				anterior.izq = nuevo;
				System.out.println(nuevo.info + " Se inserto por la izquierda del nodo " + anterior.info);
			} else {
				anterior.der = nuevo;
				System.out.println(nuevo.info + " Se inserto por la derecha del nodo " + anterior.info);
			}

		}
	}
	


	
	public void mayorValor()
	{
		int contador = 0;
		if(raiz != null)
		{
			if(raiz.izq != null)
			{
				Nodo reco = raiz;
				
				if(contador == 0);
				{
				 reco = reco.izq;
				 contador = contador + 1;
				}
				if(reco.der == null && contador == 1)
				{
				System.out.println("No hay nodo mayor en el sub arbol izquierdo");
				} else
				{
					while(reco.der != null)
					{
						reco = reco.der;
					}
					System.out.println("El mayor nodo del sub arbol izquierdo es: " + reco.info);
				}

			} else
			{
				System.out.println("No hay subnodo izquierdo");
			}

		}

	}
	
	
	public boolean existe(int info) {
		Nodo reco = raiz;
		while (reco != null) {
			if (info == reco.info)
				return true;
			else if (info > reco.info)
				reco = reco.der;
			else
				reco = reco.izq;
		}
		return false;
	}

	private void tresNiveles(Nodo reco, int nivel, int valor) {

		if(existe(valor))
		{
			if (reco != null) {
				if(valor == reco.info && nivel < 4)
				{
					System.out.print("El numero " + valor + " existe dentro de los tres niveles - nivel:" + "(" + nivel + ")");
				}  else if (valor == reco.info)
				{
					System.out.print("El numero " + valor + " no existe dentro de los tres niveles - Nivel:" + "(" + nivel + ")");				
				} 
			 	tresNiveles(reco.izq, nivel + 1, valor);
				tresNiveles(reco.der, nivel + 1, valor); 
			}
		} else
		{
			System.out.print("No existe el numero ingresado en el arbol");
		}
		
	}

	public void tresNiveles(int valor) {
		tresNiveles(raiz, 1, valor);
		System.out.println();
	}


	
	
	public void menorValor()
	{
		int contador = 0;
		if(raiz != null)
		{
			if(raiz.izq != null)
			{
				Nodo reco = raiz;
				
				if(contador == 0);
				{
				 reco = reco.izq;
				 contador = contador + 1;
				}
				if(reco.izq == null && contador == 1)
				{
				System.out.println("No hay nodo menor en el sub arbol izquierdo");
				} else
				{
					while(reco.izq != null)
					{
						reco = reco.izq;
					}
					System.out.println("El menor nodo del sub arbol izquierdo es: " + reco.info);
				}

			} else
			{
				System.out.println("No hay subnodo izquierdo");
			}

		}

	}
	
int cant;

	private void cantidadNodosHoja(Nodo reco) {
		if(reco == raiz)
        reco = reco.izq;
		if (reco != null) {
			if (reco.izq == null && reco.der == null)
				cant++;
			cantidadNodosHoja(reco.izq);
			cantidadNodosHoja(reco.der);
		}
	}


	
	//
	public void BorrarMayor()
	{
		int contador = 0;
		if(raiz != null)
		{
			if(raiz.izq != null)
			{
				Nodo reco = raiz;
				Nodo seguir = raiz;
				if(contador == 0);
				{
				 reco = reco.izq;
				 contador = contador + 1;
				}
				if(reco.der == null && contador == 1)
				{
				System.out.println("No hay mayor para borrar");
				} else
				{
					while(reco.der != null)
					{
						seguir = reco;
						reco = reco.der;
					}
					System.out.println("Se borro el numero: " + reco.info);
					reco = seguir;
					seguir.der = null;
				}

			} else
			{
				System.out.println("No hay subarbol izquierdo");
			}

		}

	}
	
	//
	public int cantidadNodosHoja() {
		cant = 0;
		cantidadNodosHoja(raiz);
		return cant;
	}
	
	private void imprimirPre(Nodo reco) {
		if (reco != null) {
			System.out.print(reco.info + " ");
			imprimirPre(reco.izq);
			imprimirPre(reco.der);
		}
	}

	public void imprimirPre() {
		imprimirPre(raiz);
		System.out.println();
	}

	
	
	public static void main(String[] ar) {
		parcial2 abo = new parcial2();
		abo.insertar(10);
		abo.insertar(7);
		abo.insertar(9);
		abo.insertar(20);
		abo.insertar(15);
		abo.mayorValor();
        abo.menorValor();
        abo.tresNiveles(15);
        System.out.println("Hay: "+ abo.cantidadNodosHoja() +" Nodos hoja a partir del subarbol izquierdo");
        System.out.println("Lista sin borrar el nodo mayor");
        abo.imprimirPre();
        System.out.println("Lista luego de borrar el nodo mayor");
        abo.BorrarMayor();
        abo.imprimirPre();
	}
}


