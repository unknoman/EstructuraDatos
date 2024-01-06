
public class Parcial1 {

	class Nodo {
		int info;
		Nodo ante, sig;
	}

	private Nodo raiz;

	Parcial1() {
		raiz = null;
	}

	public int cantidad() {
		int cant = 0;
		Nodo reco = raiz;
		while (reco != null) {
			cant++;
			reco = reco.sig;
		}
		return cant;
	}

	public void insertar(int valor1, int valor2) {
		Nodo nuevo1 = new Nodo();
		nuevo1.info = valor1;
		Nodo nuevo2 = new Nodo();
		nuevo2.info = valor2;
		if (raiz == null && cantidad() != 4) {
			nuevo1.sig = nuevo2;
			nuevo2.ante = nuevo1;
			raiz = nuevo1;
		} else if (cantidad() != 4) {
			nuevo2.sig = raiz;
			nuevo2.ante = nuevo1;
			nuevo1.sig = nuevo2;
			nuevo1.ante = null;
			raiz = nuevo1;
		} else {
			Nodo reco = raiz;
			for (int i = 1; i < 4; i++) {
				reco = reco.sig;
			}
			reco.sig = nuevo1;
			nuevo1.ante = reco;
			nuevo1.sig = nuevo2;
			nuevo2.ante = nuevo1;
			nuevo2.sig = null;
		}
	}

	public int impares() {
		if (raiz != null) {
			Nodo reco = raiz;
			int par = 1;
			int sumapar = 0;
			while (reco.sig != null) {
				if (par % 2 != 0) {
					sumapar = sumapar + reco.info;
				}
				reco = reco.sig;
				par++;
			}
			return sumapar;
		} else {
			return 0;
		}
	}

	// punto 1
	public void imprimirLista() {
		if (raiz != null) {
			Nodo reco = raiz;
			while (reco != null) {
				System.out.print(reco.info + "-");
				reco = reco.sig;
			}
			System.out.println();
		} else {
			System.out.println("No hay nodos que mostrar");
		}
	}
// punto 2 
	public void borrarnodos() {
		if (raiz != null) {
			raiz = raiz.sig;
			Nodo reco = raiz;
			Nodo aux = raiz;
			while (reco.sig != null) {
				reco = reco.sig;
			}
			aux = reco.ante;
			reco = aux;
			reco.sig = null;
			aux.sig = null;
			if (cantidad() == 1) {
				reco = null;
				aux = null;
				raiz = null;
			}
		} else 
		{
			System.out.println("No hay nodos para borrar");
		}

	}

	// punto 3 
	public void intercambiarnodos() {
		if (raiz != null) {
			Nodo reco = raiz;
			int auxiliar = 0;
			while (reco.sig != null) {
				reco = reco.sig;
			}
			auxiliar = raiz.info;
			raiz.info = reco.info;
			reco.info = auxiliar;

		} else {
			System.out.println("No hay nodos para intercambiar");
		}

	}


	
	// punto 4 

	public void eliminarrepetido()
	{
		if(raiz != null)
		{
			Nodo reco = raiz;
		    Nodo aux = raiz;
			while(reco.sig != null)
			{
				if(reco == raiz)
				{
					reco = reco.sig;
				} else
				{
					if(reco.info == raiz.info)
					{
	                   
			                 aux.sig = reco.sig;
			                 reco = reco.sig;
			                 reco.ante = aux;
						
					}  else
					{
						aux = reco;
						reco = reco.sig;
					}
				}

			}
			
			if(reco.sig == null && reco.info == raiz.info)
			{
				reco = reco.ante;
				reco.sig = null;
			}
		} else 
		{
			System.out.println("Insertar nodo y volver a utilizar el metodo");
		}
		
		
		//--------
	}

	public static void main(String[] args) {
		Parcial1 lg = new Parcial1();
		Parcial1 lg2 = new Parcial1();
		// ---------- Insertar punto 1 
		lg.insertar(10,20);
		lg.insertar(5,8);
		lg.insertar(200,4);
		lg.insertar(1,2);
		// ----------- insertar con otro objeto para eliminar repetidos
		lg2.insertar(10,20);
		lg2.insertar(5,8);
		lg2.insertar(200,4);
		lg2.insertar(1,2);
		lg2.imprimirLista();
		// ------------------------------- sumar impares punto 2 
		System.out.println("La suma de las posiciones impares es: " + lg.impares());
		// -------- intercambio de nodos ------------------------------------------ punto 3 
		System.out.println("Intercambio de nodos: ");
		lg.intercambiarnodos();
		lg.imprimirLista();
		///-------------------------Eliminar repetidos del primer nodo ----------- punto 4 (con otro objeto)
		System.out.println("Repetidos del primer nodo eliminados");
		lg2.eliminarrepetido();
		lg2.imprimirLista();
	}

}
