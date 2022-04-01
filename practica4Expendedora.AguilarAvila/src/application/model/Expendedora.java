package application.model;


public class Expendedora {
	final static double CREDITOMAXIMO = 10;
	private double credito;
	private double cambioDisponible;
	private double importeVentas;
	private String[] nombreProductos;
	private double[] precioProductos;
	private int[] stockProductos;
	
	public String toString() {
		String texto = String.format(
				  "Credito			: %6.2f euros"
				+ "Cambio			: %6.2f euros"
				+ "Importede ventas	: %6.2f euros"
				+ "Productos: %d"
				, this.credito,this.cambioDisponible,this.importeVentas);
		
		for (int i = 0; i < nombreProductos.length; i++) {
			texto += String.format("%n%s	- %03.2f euros	- %d uds.",
					this.nombreProductos[i],this.precioProductos[i],this.stockProductos[i]);
		}
		return texto;
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
