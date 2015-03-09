/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.blogspot.webxico.model;

import java.io.Serializable;
import mx.blogspot.webxico.comun.Resultados;
import mx.blogspot.webxico.comun.UtilDB;

public class Estado implements Serializable {
    
    private int id_estado;
    private String nombre_estado;
    private boolean _existe;
    
    public Estado() {
        limpiar();
    }
    
    public Estado(int id_estado) {
        limpiar();
        this.id_estado = id_estado;
        cargar();
    }
    
    public Estado(int id_estado, String nombre_estado) {
        this.id_estado = id_estado;
        this.nombre_estado = nombre_estado;
    }
    
    private void limpiar() {
        this.id_estado = 0;
        this.nombre_estado = "";
        this._existe = false;
    }
    
    public int getId_estado() {
        return id_estado;
    }
    
    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }
    
    public String getNombre_estado() {
        return nombre_estado;
    }
    
    public void setNombre_estado(String nombre_estado) {
        this.nombre_estado = nombre_estado;
    }
    
    @Override
    public String toString() {
        return "Estado{" + "id_estado=" + id_estado + ", nombre_estado=" + nombre_estado + '}';
    }
    
    private void cargar() {
        String sql = "select * from estados where id_estado= " + this.id_estado;
        Resultados res = UtilDB.ejecutaConsulta(sql);
        if (res.next()) {
            cargar(res);
        }
        res.close();
    }
    
    private void cargar(Resultados res) {
        this.id_estado = res.getInt("id_estado");
        this.nombre_estado = res.getString("nombre_estado");
        _existe = true;
    }
    
}
