package application.model;


public class Expendedora {
	final static double CREDITOMAXIMO = 10;
	private double credito;
	private double cambioDisponible;
	private double importeVentas;
	private String[] nombreProductos;
	private double[] precioProductos;
	private int[] stockProductos;
	
	public Expendedora (double cambioDisponible, String[] nombreProductos, double[] precioProducto, int[] stockProducto) {
		// Comprobar si los 3 arrays son iguales
		if (nombreProductos.length != precioProducto.length || nombreProductos.length != stockProducto.length ) {
			throw new IllegalArgumentException();
		}
		
		this.credito = 0;
		this.importeVentas = 0;
		this.cambioDisponible = cambioDisponible;
		this.nombreProductos = nombreProductos;
		this.precioProductos = precioProducto;
		this.stockProductos = stockProducto;
	}
	
	public String toString() {
		String texto = String.format(
				  "Credito			: %6.2f euros%n"
				+ "Cambio			: %6.2f euros%n"
				+ "Importede ventas	: %6.2f euros%n"
				+ "Productos: %d"
				, this.credito, this.cambioDisponible, this.importeVentas, this.nombreProductos.length);
		
		for (int i = 0; i < nombreProductos.length; i++) {
			texto += String.format("%n\t%s\t- %03.2f euros\t- %d uds.",
					this.nombreProductos[i],this.precioProductos[i],this.stockProductos[i]);
		}
		return texto;
	}
	
	public void anyadirDinero(double importe) {
		importe = importe * 100;
		importe = Math.round(importe);
		importe = importe / 100;
		
		if (this.credito + importe <= CREDITOMAXIMO) {
			this.credito += importe;
		}
	}
	
	public double devolverCredito() {
		double creditoDevolver = this.credito;
		this.credito = 0;
		return creditoDevolver;
	}
	
	public double comprar(int i) throws StockInsuficienteException, CreditoInsuficienteException, CambioInsuficienteException {
		String producto = this.nombreProductos[i];
		double precio = this.precioProductos[i];
		
		if (this.stockProductos[i] < 1) throw new StockInsuficienteException("Stock insuficiente");
		if (this.credito < precio) throw new CreditoInsuficienteException("Credito insuficiente");
		if (this.cambioDisponible < (this.credito - precio)) throw new CambioInsuficienteException("Cambio insuficiente");
		
		stockProductos[i]--;
		
		double cambio = this.credito - precio;
		
		this.importeVentas += precio;
		this.cambioDisponible -= cambio;
		this.credito = 0;
		
		return cambio;
		
	}
	
	public double getCredito() {
		return credito;
	}
	public double getCambioDisponible() {
		return cambioDisponible;
	}
	public double getImporteVentas() {
		return importeVentas;
	}
	
	public int getNumeroProductos() {
		return nombreProductos.length;
	}
	
	public String getNombre(int i) {
		return this.nombreProductos[i];
	}
	
	public double getPrecio(int i) {
		return this.precioProductos[i];
	}
	
	public int getStock(int i) {
		return this.stockProductos[i];
	}
}
