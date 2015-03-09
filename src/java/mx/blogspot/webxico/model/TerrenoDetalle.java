/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.blogspot.webxico.model;

import java.io.Serializable;
import java.util.Calendar;

public class TerrenoDetalle implements Serializable {

    private int id_terreno_detalle;
    private AnalisisFisico id_analisis_fisico;
    private float superficie_m2;
    private float irre;
    private float top;
    private float frente;
    private float forma;
    private float otros;
    private float fr;
    private float valor_unitario_neto;
    private float indiviso;
    private float valor_parcial;
    private Calendar fecha_registro;
    private boolean activo;

    public TerrenoDetalle() {
    }

    public TerrenoDetalle(int id_terreno_detalle, AnalisisFisico id_analisis_fisico, float superficie_m2, float irre, float top, float frente, float forma, float otros, float fr, float valor_unitario_neto, float indiviso, float valor_parcial, Calendar fecha_registro, boolean activo) {
        this.id_terreno_detalle = id_terreno_detalle;
        this.id_analisis_fisico = id_analisis_fisico;
        this.superficie_m2 = superficie_m2;
        this.irre = irre;
        this.top = top;
        this.frente = frente;
        this.forma = forma;
        this.otros = otros;
        this.fr = fr;
        this.valor_unitario_neto = valor_unitario_neto;
        this.indiviso = indiviso;
        this.valor_parcial = valor_parcial;
        this.fecha_registro = fecha_registro;
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "TerrenoDetalle{" + "id_terreno_detalle=" + id_terreno_detalle + ", id_analisis_fisico=" + id_analisis_fisico + ", superficie_m2=" + superficie_m2 + ", irre=" + irre + ", top=" + top + ", frente=" + frente + ", forma=" + forma + ", otros=" + otros + ", fr=" + fr + ", valor_unitario_neto=" + valor_unitario_neto + ", indiviso=" + indiviso + ", valor_parcial=" + valor_parcial + ", fecha_registro=" + fecha_registro + ", activo=" + activo + '}';
    }

}
