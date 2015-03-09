/**
 *
 *
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.blogspot.webxico.model;

import java.io.Serializable;
import java.util.Calendar;

public class Conclusion implements Serializable {

    private int id_conclusion;
    private float valor_comparativo_mercado;
    private float valor_fisico;
    private Calendar fecha_registro;
    private boolean activo;

    public Conclusion() {
    }

    public Conclusion(int id_conclusion, float valor_comparativo_mercado, float valor_fisico, Calendar fecha_registro, boolean activo) {
        this.id_conclusion = id_conclusion;
        this.valor_comparativo_mercado = valor_comparativo_mercado;
        this.valor_fisico = valor_fisico;
        this.fecha_registro = fecha_registro;
        this.activo = activo;
    }

    public int getId_conclusion() {
        return id_conclusion;
    }

    public void setId_conclusion(int id_conclusion) {
        this.id_conclusion = id_conclusion;
    }

    public float getValor_comparativo_mercado() {
        return valor_comparativo_mercado;
    }

    public void setValor_comparativo_mercado(float valor_comparativo_mercado) {
        this.valor_comparativo_mercado = valor_comparativo_mercado;
    }

    public float getValor_fisico() {
        return valor_fisico;
    }

    public void setValor_fisico(float valor_fisico) {
        this.valor_fisico = valor_fisico;
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
        return "Conclusion{" + "id_conclusion=" + id_conclusion + ", valor_comparativo_mercado=" + valor_comparativo_mercado + ", valor_fisico=" + valor_fisico + ", fecha_registro=" + fecha_registro + ", activo=" + activo + '}';
    }

}
