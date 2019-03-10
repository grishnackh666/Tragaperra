package tragaperras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class Maquina {
    private final int numCasillas;
    private double precioJugada;
    private double creditoActual;
    private final HashSet <Premio> premios = new HashSet<>();
    
    public Maquina(int numCasillas, double precio, Premio... premios) {
        this.numCasillas = numCasillas;
        this.precioJugada = precio;
        for(Premio pt : premios) {
            this.premios.add(pt);
        }
         
        
    }

   
    public int getNumCasillas() { return numCasillas; }
    public double getPrecioJugada() { return precioJugada; }
    public double getCreditoActual() { return creditoActual; }
    
   
    public void setPrecioJugada(double precioJugada) { this.precioJugada = precioJugada; }
    
    public void incrementarCredito(double credito) {
        this.creditoActual += credito;
    }
    
    private ArrayList<Fruta> generarCombinacion() {
        ArrayList<Fruta> combinacion = new ArrayList<>(this.numCasillas);
        Random random = new Random();
        Fruta[] frutas = Fruta.values();
        for(int i = 0; i < this.numCasillas; i++) {
            Fruta fruta = frutas[random.nextInt(frutas.length)];
            combinacion.add(fruta);
        }
        
        return combinacion;
    }
    
    public ArrayList<Fruta> jugar() {
        if(this.creditoActual >= this.precioJugada) {
            this.creditoActual -= this.precioJugada;
            ArrayList <Fruta> combActual, combPremio;
            combActual = this.generarCombinacion();
            for(Premio pt : this.premios) {
                combPremio = pt.getCombGanadora();
                if(combActual.equals(combPremio)) {
                    this.creditoActual += pt.getCantDinero();
                }
            }
            return combActual;
        }
        
            return null;
    }
    
    
}
