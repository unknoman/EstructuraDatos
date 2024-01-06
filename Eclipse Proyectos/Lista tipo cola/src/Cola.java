public class Cola {

	class Nodo {
		int info;
		Nodo sig;
	}

	private Nodo raiz, fondo;

	Cola() {
		raiz = null;
		fondo = null;
	}

	public boolean vacia() {
		if (raiz == null)
			return true;
		else
			return false;
	}

	public void insertar(int info) {
		Nodo nuevo;
		nuevo = new Nodo();
		nuevo.info = info;
		nuevo.sig = null;
		if (vacia()) {
			raiz = nuevo;
			fondo = nuevo;
		} else {
			fondo.sig = nuevo;
			fondo = nuevo;
		}
	}


	
	public int extraer() {
		if (!vacia()) {
			int informacion = raiz.info;
			if (raiz == fondo) {
				raiz = null;
				fondo = null;
			} else {
				raiz = raiz.sig;
			}
			return informacion;
		} else
			return Integer.MAX_VALUE;
	}

	public void imprimir() {
		Nodo reco = raiz;
		System.out.println("Listado de todos los elementos de la cola.");
		while (reco != null) {
			System.out.print(reco.info + "-");
			reco = reco.sig;
		}
		System.out.println();
	}
	

	public static void main(String[] ar) {
		Cola cola1 = new Cola();
		cola1.insertar(5);
		cola1.insertar(10);
		cola1.insertar(50);
		cola1.imprimir();
		System.out.println("Extraemos uno de la cola:" + cola1.extraer());
		cola1.imprimir();
	}
}
