/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.blogspot.webxico.model;

import java.io.Serializable;
import java.util.Calendar;

public class VentaTerrenoHomologacionDetalle implements Serializable {

    private int id_venta_tereno_h;
    private InvestigacionMercado id_investigacion_mercado;
    private String comparable;
    private float superficie;
    private float valor_unitario;
    private float zona;
    private float ubicacion;
    private float frente;
    private float forma;
    private float superficie2;
    private float negociacion;
    private float resultante;
    private Calendar fecha_registro;
    private boolean activo;

    public VentaTerrenoHomologacionDetalle() {
    }

    public VentaTerrenoHomologacionDetalle(int id_venta_tereno_h, InvestigacionMercado id_investigacion_mercado, String comparable, float superficie, float valor_unitario, float zona, float ubicacion, float frente, float forma, float superficie2, float negociacion, float resultante, Calendar fecha_registro, boolean activo) {
        this.id_venta_tereno_h = id_venta_tereno_h;
        this.id_investigacion_mercado = id_investigacion_mercado;
        this.comparable = comparable;
        this.superficie = superficie;
        this.valor_unitario = valor_unitario;
        this.zona = zona;
        this.ubicacion = ubicacion;
        this.frente = frente;
        this.forma = forma;
        this.superficie2 = superficie2;
        this.negociacion = negociacion;
        this.resultante = resultante;
        this.fecha_registro = fecha_registro;
        this.activo = activo;
    }

    public int getId_venta_tereno_h() {
        return id_venta_tereno_h;
    }

    public void setId_venta_tereno_h(int id_venta_tereno_h) {
        this.id_venta_tereno_h = id_venta_tereno_h;
    }

    public InvestigacionMercado getId_investigacion_mercado() {
        return id_investigacion_mercado;
    }

    public void setId_investigacion_mercado(InvestigacionMercado id_investigacion_mercado) {
        this.id_investigacion_mercado = id_investigacion_mercado;
    }

    public String getComparable() {
        return comparable;
    }

    public void setComparable(String comparable) {
        this.comparable = comparable;
    }

    public float getSuperficie() {
        return superficie;
    }

    public void setSuperficie(float superficie) {
        this.superficie = superficie;
    }

    public float getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(float valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public float getZona() {
        return zona;
    }

    public void setZona(float zona) {
        this.zona = zona;
    }

    public float getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(float ubicacion) {
        this.ubicacion = ubicacion;
    }

    public float getFrente() {
        return frente;
    }

    public void setFrente(float frente) {
        this.frente = frente;
    }

    public float getForma() {
        return forma;
    }

    public void setForma(float forma) {
        this.forma = forma;
    }

    public float getSuperficie2() {
        return superficie2;
    }

    public void setSuperficie2(float superficie2) {
        this.superficie2 = superficie2;
    }

    public float getNegociacion() {
        return negociacion;
    }

    public void setNegociacion(float negociacion) {
        this.negociacion = negociacion;
    }

    public float getResultante() {
        return resultante;
    }

    public void setResultante(float resultante) {
        this.resultante = resultante;
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
        return "VentaTerrenoHomologacionDetalle{" + "id_venta_tereno_h=" + id_venta_tereno_h + ", id_investigacion_mercado=" + id_investigacion_mercado + ", comparable=" + comparable + ", superficie=" + superficie + ", valor_unitario=" + valor_unitario + ", zona=" + zona + ", ubicacion=" + ubicacion + ", frente=" + frente + ", forma=" + forma + ", superficie2=" + superficie2 + ", negociacion=" + negociacion + ", resultante=" + resultante + ", fecha_registro=" + fecha_registro + ", activo=" + activo + '}';
    }

}
