/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.blogspot.webxico.model;

import java.io.Serializable;
import java.util.Calendar;

public class InvestigacionMercado implements Serializable {

    private int id_investigacion_mercado;
    private String lote_tipo_moda;
    private float valor_unitario_promedio;
    private float valor_aplicado_m2;
    private float valor_promedio;
    private float superficie_construida_sujeto;
    private float valor_comparativo_mercado;
    private String conclusiones_investigacion;
    private Calendar fecha_registro;
    private boolean activo;

    public InvestigacionMercado() {
    }

    public InvestigacionMercado(int id_investigacion_mercado, String lote_tipo_moda, float valor_unitario_promedio, float valor_aplicado_m2, float valor_promedio, float superficie_construida_sujeto, float valor_comparativo_mercado, String conclusiones_investigacion, Calendar fecha_registro, boolean activo) {
        this.id_investigacion_mercado = id_investigacion_mercado;
        this.lote_tipo_moda = lote_tipo_moda;
        this.valor_unitario_promedio = valor_unitario_promedio;
        this.valor_aplicado_m2 = valor_aplicado_m2;
        this.valor_promedio = valor_promedio;
        this.superficie_construida_sujeto = superficie_construida_sujeto;
        this.valor_comparativo_mercado = valor_comparativo_mercado;
        this.conclusiones_investigacion = conclusiones_investigacion;
        this.fecha_registro = fecha_registro;
        this.activo = activo;
    }

    public int getId_investigacion_mercado() {
        return id_investigacion_mercado;
    }

    public void setId_investigacion_mercado(int id_investigacion_mercado) {
        this.id_investigacion_mercado = id_investigacion_mercado;
    }

    public String getLote_tipo_moda() {
        return lote_tipo_moda;
    }

    public void setLote_tipo_moda(String lote_tipo_moda) {
        this.lote_tipo_moda = lote_tipo_moda;
    }

    public float getValor_unitario_promedio() {
        return valor_unitario_promedio;
    }

    public void setValor_unitario_promedio(float valor_unitario_promedio) {
        this.valor_unitario_promedio = valor_unitario_promedio;
    }

    public float getValor_aplicado_m2() {
        return valor_aplicado_m2;
    }

    public void setValor_aplicado_m2(float valor_aplicado_m2) {
        this.valor_aplicado_m2 = valor_aplicado_m2;
    }

    public float getValor_promedio() {
        return valor_promedio;
    }

    public void setValor_promedio(float valor_promedio) {
        this.valor_promedio = valor_promedio;
    }

    public float getSuperficie_construida_sujeto() {
        return superficie_construida_sujeto;
    }

    public void setSuperficie_construida_sujeto(float superficie_construida_sujeto) {
        this.superficie_construida_sujeto = superficie_construida_sujeto;
    }

    public float getValor_comparativo_mercado() {
        return valor_comparativo_mercado;
    }

    public void setValor_comparativo_mercado(float valor_comparativo_mercado) {
        this.valor_comparativo_mercado = valor_comparativo_mercado;
    }

    public String getConclusiones_investigacion() {
        return conclusiones_investigacion;
    }

    public void setConclusiones_investigacion(String conclusiones_investigacion) {
        this.conclusiones_investigacion = conclusiones_investigacion;
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
        return "InvestigacionMercado{" + "id_investigacion_mercado=" + id_investigacion_mercado + ", lote_tipo_moda=" + lote_tipo_moda + ", valor_unitario_promedio=" + valor_unitario_promedio + ", valor_aplicado_m2=" + valor_aplicado_m2 + ", valor_promedio=" + valor_promedio + ", superficie_construida_sujeto=" + superficie_construida_sujeto + ", valor_comparativo_mercado=" + valor_comparativo_mercado + ", conclusiones_investigacion=" + conclusiones_investigacion + ", fecha_registro=" + fecha_registro + ", activo=" + activo + '}';
    }

}
