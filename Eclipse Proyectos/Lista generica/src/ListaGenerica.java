import parcial2.Nodo;

public class ListaGenerica {

	class Nodo {
		int info;
		Nodo sig;
	}

	private Nodo raiz;

	public ListaGenerica() {
		raiz = null;
	}

	void insertar(int pos, int x) {
		if (pos <= cantidad() + 1) {
			Nodo nuevo = new Nodo();
			nuevo.info = x;
			if (pos == 1) {
				nuevo.sig = raiz;
				raiz = nuevo;
			} else if (pos == cantidad() + 1) {
				Nodo reco = raiz;
				while (reco.sig != null) {
					reco = reco.sig;
				}
				reco.sig = nuevo;
				nuevo.sig = null;
			} else {
				Nodo reco = raiz;
				for (int f = 1; f <= pos - 2; f++)
					reco = reco.sig;
				Nodo siguiente = reco.sig;
				reco.sig = nuevo;
				nuevo.sig = siguiente;
			}
		}
	}

	public int extraer(int pos) {
		if (pos <= cantidad()) {
			int informacion;
			if (pos == 1) {
				informacion = raiz.info;
				raiz = raiz.sig;
			} else {
				Nodo reco;
				reco = raiz;
				for (int f = 1; f <= pos - 2; f++)
					reco = reco.sig;
				Nodo prox = reco.sig;
				reco.sig = prox.sig;
				informacion = prox.info;
			}
			return informacion;
		} else
			return Integer.MAX_VALUE;
	}

	public void borrar(int pos) {
		if (pos <= cantidad()) {
			if (pos == 1) {
				raiz = raiz.sig;
			} else {
				Nodo reco;
				reco = raiz;
				for (int f = 1; f <= pos - 2; f++)
					reco = reco.sig;
				Nodo prox = reco.sig;
				reco.sig = prox.sig;
			}
		}
	}

	public void intercambiar(int pos1, int pos2) {
		if (pos1 <= cantidad() && pos2 <= cantidad()) {
			Nodo reco1 = raiz;
			for (int f = 1; f < pos1; f++)
				reco1 = reco1.sig;
			Nodo reco2 = raiz;
			for (int f = 1; f < pos2; f++)
				reco2 = reco2.sig;
			int aux = reco1.info;
			reco1.info = reco2.info;
			reco2.info = aux;
		}
	}

	public int mayor() {
		if (!vacia()) {
			int may = raiz.info;
			Nodo reco = raiz.sig;
			while (reco != null) {
				if (reco.info > may)
					may = reco.info;
				reco = reco.sig;
			}
			return may;
		} else
			return Integer.MAX_VALUE;
	}

	public int posMayor() {
		if (!vacia()) {
			int may = raiz.info;
			int x = 1;
			int pos = x;
			Nodo reco = raiz.sig;
			x = 2;
			while (reco != null) {
				if (reco.info > may) {
					may = reco.info;
					pos = x;
				}
				reco = reco.sig;
				x++;
			}
			return pos;
		} else
			return Integer.MAX_VALUE;
	}

	public int cantidad() {
		int cant = 0;
		Nodo reco = raiz;
		while (reco != null) {
			reco = reco.sig;
			cant++;
		}
		return cant;
	}

	public boolean ordenada() {
		if (cantidad() > 1) {
			Nodo reco1 = raiz;
			Nodo reco2 = raiz.sig;
			while (reco2 != null) {
				if (reco2.info < reco1.info) {
					return false;
				}
				reco2 = reco2.sig;
				reco1 = reco1.sig;
			}
		}
		return true;
	}

	public boolean existe(int x) {
		Nodo reco = raiz;
		while (reco != null) {
			if (reco.info == x)
				return true;
			reco = reco.sig;
		}
		return false;
	}

	public boolean vacia() {
		if (raiz == null)
			return true;
		else
			return false;
	}

	public void imprimir() {
		Nodo reco = raiz;
		while (reco != null) {
			System.out.print(reco.info + "-");
			reco = reco.sig;
		}
		System.out.println();
	}

	public void nodoprimero(int info) {
		Nodo nuevo = new Nodo();
		nuevo.sig = raiz;
		nuevo.info = info;
		raiz = nuevo;
	}

	public void nodoultimo(int info) {
		Nodo nuevo = new Nodo();
		nuevo.info = info;
		if (raiz == null) {
			raiz = nuevo;
		} else {
			Nodo reco = raiz;
			while (reco.sig != null) {
				reco = reco.sig;
			}
			reco.sig = nuevo;
		}

	}

	
	public void borrarultimo() {
		Nodo reco = raiz;
		Nodo atras = raiz;
		while(reco != null)
		{
			if(raiz.sig == null)
			{
				raiz = raiz.sig;
			} else
			{
				atras = reco;
				reco = reco.sig;
			}
			

			
		}
	}
	
	
	public void insertarUtlimo(int x) {
		Nodo nuevo = new Nodo();
		nuevo.info = x;
		if (raiz == null)
			raiz = nuevo;
		else {
			Nodo reco = raiz;
			while (reco.sig != null) {
				reco = reco.sig;
			}
			reco.sig = nuevo;
		}
	}

	public void insertarsegundo(int x) {
		if (raiz.sig != null) {
			Nodo nuevo = new Nodo();
			nuevo.info = x;
			nuevo.sig = raiz.sig;
			raiz.sig = nuevo;
		}
	}

	public void anteultima(int x) {
		Nodo nuevo = new Nodo();
		nuevo.info = x;
		Nodo reco = raiz;
		while (reco.sig != null) {

		}

	}

	public void insertarAnteUltimo(int x) {
		if (raiz != null) {
			Nodo nuevo = new Nodo();
			nuevo.info = x;
			if (raiz.sig == null) {
				// Hay un solo nodo
				nuevo.sig = raiz;
				raiz = nuevo;
			} else {
				Nodo atras = raiz;
				Nodo reco = raiz.sig;
				while (reco.sig != null) {
					atras = reco;
					reco = reco.sig;
				}
				nuevo.sig = atras.sig;
				atras.sig = nuevo;
			}
		}
	}

	public void borrarSegundo() {
		if (raiz != null) {
			if (raiz.sig != null) {
				Nodo tercero = raiz.sig;
				tercero = tercero.sig;
				raiz.sig = tercero;
			}
		}
	}

	public void borrarUltimo() {
		if (raiz != null) {
			if (raiz.sig == null) {
				raiz = null;
			} else {
				Nodo reco = raiz.sig;
				Nodo atras = reco;
				while (reco.sig != null) {
					atras = reco;
					reco = reco.sig;
				}
				atras.sig = null;
			}
		}

	}

	public void borrarnodomayorinfo() {
		Nodo reco = raiz;
		Nodo borrarmayor = reco;
		int x = 0;
		while (reco.sig != null) {
			if (x < reco.info) {
				x = reco.info;
			}
			reco = reco.sig;
		}
	}

	public void borrarMayor() {
		if (raiz != null) {
			Nodo reco = raiz;
			int may = raiz.info;
			while (reco != null) {
				if (reco.info > may) {
					may = reco.info;
				}
				reco = reco.sig;
			}
			reco = raiz;
			Nodo atras = raiz;
			while (reco != null) {
				if (reco.info == may) {
					if (reco == raiz) {
						raiz = raiz.sig;
						atras = raiz;
						reco = raiz;
					} else { // entender esta parte
						atras.sig = reco.sig;
						reco = reco.sig;
					}
				} else {
					atras = reco;
					reco = reco.sig;
				}
			}
		}
	}

public void prueba(int y)
{
	int x, z;
	Nodo reco = raiz;
	x=1;
	z=0;
	while(reco!= null)
	{
		if(reco.info == y) {
			System.out.println("Nodo:" + x);
		}
		reco = reco.sig;
		x++;
		if(z!=1)
		{
			System.out.println("No esta");
		}
	}
}
		
	public static void main(String[] ar) {
		ListaGenerica lg = new ListaGenerica();
		lg.insertar(1, 10);
		lg.insertar(2, 20);
		lg.insertar(3, 30);
		lg.prueba(30);
		// lg.insertar(2, 15);
		// lg.insertar(1, 115);
		/* lg.imprimir();
		System.out.println("Luego de Borrar el primero");
		lg.borrar(1);
		lg.imprimir();
		System.out.println("Luego de Extraer el segundo");
		lg.extraer(2);
		lg.imprimir();
		System.out.println("Luego de Intercambiar el primero con el tercero");
		lg.intercambiar(1, 3);
		lg.imprimir();
		if (lg.existe(10))
			System.out.println("Se encuentra el 20 en la lista");
		else
			System.out.println("No se encuentra el 20 en la lista");
		System.out.println("La posición del mayor es:" + lg.posMayor());
		if (lg.ordenada())
			System.out.println("La lista está ordenada de menor a mayor");
		else
			System.out.println("La lista no está ordenada de menor a mayor");*/ 
	}
}
