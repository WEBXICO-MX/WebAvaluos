/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.blogspot.webxico.model;

import java.io.Serializable;
import java.util.Calendar;

public class AnalisisFisico implements Serializable {

    private int id_analisis_fisico;
    private float valor_terreno;
    private float valor_construccion;
    private float valor_fisico_total;
    private Calendar fecha_registro;
    private boolean activo;

    public AnalisisFisico() {
    }

    public AnalisisFisico(int id_analisis_fisico, float valor_terreno, float valor_construccion, float valor_fisico_total, Calendar fecha_registro, boolean activo) {
        this.id_analisis_fisico = id_analisis_fisico;
        this.valor_terreno = valor_terreno;
        this.valor_construccion = valor_construccion;
        this.valor_fisico_total = valor_fisico_total;
        this.fecha_registro = fecha_registro;
        this.activo = activo;
    }

    public int getId_analisis_fisico() {
        return id_analisis_fisico;
    }

    public void setId_analisis_fisico(int id_analisis_fisico) {
        this.id_analisis_fisico = id_analisis_fisico;
    }

    public float getValor_terreno() {
        return valor_terreno;
    }

    public void setValor_terreno(float valor_terreno) {
        this.valor_terreno = valor_terreno;
    }

    public float getValor_construccion() {
        return valor_construccion;
    }

    public void setValor_construccion(float valor_construccion) {
        this.valor_construccion = valor_construccion;
    }

    public float getValor_fisico_total() {
        return valor_fisico_total;
    }

    public void setValor_fisico_total(float valor_fisico_total) {
        this.valor_fisico_total = valor_fisico_total;
    }

    public Calendar getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Calendar fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "AnalisisFisico{" + "id_analisis_fisico=" + id_analisis_fisico + ", valor_terreno=" + valor_terreno + ", valor_construccion=" + valor_construccion + ", valor_fisico_total=" + valor_fisico_total + ", fecha_registro=" + fecha_registro + ", activo=" + activo + '}';
    }

}
