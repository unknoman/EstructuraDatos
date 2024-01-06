package test;

public class Algoritmo {

	class Nodo {
		int info;
		Nodo sig;
	}

	private Nodo raiz;

	Algoritmo()
	{
		raiz = null;
	}
	
	public void insertar(int x) {
		Nodo nuevo = new Nodo(); // se crea un nuevo nodo
		nuevo.info = x; // se introduce dato
		if (raiz == null) { // si no hay mas nodos
			raiz = nuevo; // se le introduce datos del objeto nuevo por lo que ya no es null
		} else { // si hay un nodo creado
			nuevo.sig = raiz; // la parte de sig apunta al nodo anterior
			raiz = nuevo; // se guardan los datos
		}
	}

	public int extraer() {
		if (raiz != null) {
			int informacion = raiz.info;
			raiz = raiz.sig;
			return informacion;
		} else {
			return Integer.MAX_VALUE;
		}
	}

	public int retornar() {
		if (raiz != null) {
			 int informacion = raiz.info;
			return informacion;
		} else {
			return Integer.MAX_VALUE;
		}
	}
	

	public int cantidad() {
		int valor = 0;
		Nodo reco1 = raiz;
		while(reco1 != null) {
			{
             valor++;
             reco1 = reco1.sig;
			}
		}
		return valor;
	}

	public void imprimir() {
		Nodo reco = raiz;
		System.out.println("Listado de todos los elementos de la raiz.");
		while (reco != null) {
			System.out.print(reco.info + "-");
			reco = reco.sig;
		}
		System.out.println();
	}
	
	public void inicializarEnCero()
	{
		Nodo nuevo = new Nodo();
	   while(raiz != null)
	   {
			nuevo.info = 0;   
			raiz = raiz.sig;
	   }
	}
	
	public int retornarultimo()
	{
		Nodo reco = raiz;
		int numero = 0;
		while(reco != null)
		{
			numero = reco.info;
			reco = reco.sig;
		}
		
		return numero;
	}
	
	public static void main(String[] ar) {
		Algoritmo pila1 = new Algoritmo();
		pila1.insertar(1);
		pila1.insertar(2);
		pila1.insertar(3);
		pila1.imprimir();
		System.out.print("retornando ultimo numero:" + pila1.retornarultimo() + "\n");
		System.out.println("Extraemos de la raiz:" + pila1.extraer());
		System.out.println("Retornamos primero de la raiz:" + pila1.retornar());
		System.out.print("Cantidad de numeros:" + pila1.cantidad());
      
	}
}
