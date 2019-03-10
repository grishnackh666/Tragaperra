package tragaperras;

import java.util.ArrayList;
import java.util.Objects;

public class Premio {
    private final ArrayList <Fruta> combGanadora;
    private final double cantDinero;
    
    public Premio(double cantDinero, Fruta... frutas) {
        this.cantDinero = cantDinero;
        combGanadora = new ArrayList<>();
        for(Fruta ft : frutas) {
            this.combGanadora.add(ft);
        }
    }
    
    //Metodos de Consulta
    public ArrayList<Fruta> getCombGanadora() { return combGanadora; }
    public double getCantDinero() { return cantDinero; }
    
    //Metodos Redefinidos de Object
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.combGanadora);
        hash = 73 * hash + (int) (Double.doubleToLongBits(this.cantDinero) ^ (Double.doubleToLongBits(this.cantDinero) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Premio other = (Premio) obj;
        return Objects.equals(this.combGanadora, other.combGanadora);
    }
}
