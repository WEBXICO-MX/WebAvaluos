/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.blogspot.webxico.model;

import java.io.Serializable;
import java.util.Calendar;

public class VentaInmuebleSimilaresHomologacionDetalle implements Serializable {

    private int id_venta_inmuebles_similares_h;
    private InvestigacionMercado id_investigacion_mercado;
    private float precio_venta;
    private float superficie_terreno;
    private float superficie_construida;
    private float valor_unitario_m2;
    private float zona;
    private float ubic;
    private float sup;
    private float edad;
    private float cons;
    private float neg;
    private float fr;
    private float valor_unitario_resultante;
    private Calendar fecha_registro;
    private boolean activo;

    public VentaInmuebleSimilaresHomologacionDetalle() {
    }

    public VentaInmuebleSimilaresHomologacionDetalle(int id_venta_inmuebles_similares_h, InvestigacionMercado id_investigacion_mercado, float precio_venta, float superficie_terreno, float superficie_construida, float valor_unitario_m2, float zona, float ubic, float sup, float edad, float cons, float neg, float fr, float valor_unitario_resultante, Calendar fecha_registro, boolean activo) {
        this.id_venta_inmuebles_similares_h = id_venta_inmuebles_similares_h;
        this.id_investigacion_mercado = id_investigacion_mercado;
        this.precio_venta = precio_venta;
        this.superficie_terreno = superficie_terreno;
        this.superficie_construida = superficie_construida;
        this.valor_unitario_m2 = valor_unitario_m2;
        this.zona = zona;
        this.ubic = ubic;
        this.sup = sup;
        this.edad = edad;
        this.cons = cons;
        this.neg = neg;
        this.fr = fr;
        this.valor_unitario_resultante = valor_unitario_resultante;
        this.fecha_registro = fecha_registro;
        this.activo = activo;
    }

    public int getId_venta_inmuebles_similares_h() {
        return id_venta_inmuebles_similares_h;
    }

    public void setId_venta_inmuebles_similares_h(int id_venta_inmuebles_similares_h) {
        this.id_venta_inmuebles_similares_h = id_venta_inmuebles_similares_h;
    }

    public InvestigacionMercado getId_investigacion_mercado() {
        return id_investigacion_mercado;
    }

    public void setId_investigacion_mercado(InvestigacionMercado id_investigacion_mercado) {
        this.id_investigacion_mercado = id_investigacion_mercado;
    }

    public float getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(float precio_venta) {
        this.precio_venta = precio_venta;
    }

    public float getSuperficie_terreno() {
        return superficie_terreno;
    }

    public void setSuperficie_terreno(float superficie_terreno) {
        this.superficie_terreno = superficie_terreno;
    }

    public float getSuperficie_construida() {
        return superficie_construida;
    }

    public void setSuperficie_construida(float superficie_construida) {
        this.superficie_construida = superficie_construida;
    }

    public float getValor_unitario_m2() {
        return valor_unitario_m2;
    }

    public void setValor_unitario_m2(float valor_unitario_m2) {
        this.valor_unitario_m2 = valor_unitario_m2;
    }

    public float getZona() {
        return zona;
    }

    public void setZona(float zona) {
        this.zona = zona;
    }

    public float getUbic() {
        return ubic;
    }

    public void setUbic(float ubic) {
        this.ubic = ubic;
    }

    public float getSup() {
        return sup;
    }

    public void setSup(float sup) {
        this.sup = sup;
    }

    public float getEdad() {
        return edad;
    }

    public void setEdad(float edad) {
        this.edad = edad;
    }

    public float getCons() {
        return cons;
    }

    public void setCons(float cons) {
        this.cons = cons;
    }

    public float getNeg() {
        return neg;
    }

    public void setNeg(float neg) {
        this.neg = neg;
    }

    public float getFr() {
        return fr;
    }

    public void setFr(float fr) {
        this.fr = fr;
    }

    public float getValor_unitario_resultante() {
        return valor_unitario_resultante;
    }

    public void setValor_unitario_resultante(float valor_unitario_resultante) {
        this.valor_unitario_resultante = valor_unitario_resultante;
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
        return "VentaInmuebleSimilaresHomologacionDetalle{" + "id_venta_inmuebles_similares_h=" + id_venta_inmuebles_similares_h + ", id_investigacion_mercado=" + id_investigacion_mercado + ", precio_venta=" + precio_venta + ", superficie_terreno=" + superficie_terreno + ", superficie_construida=" + superficie_construida + ", valor_unitario_m2=" + valor_unitario_m2 + ", zona=" + zona + ", ubic=" + ubic + ", sup=" + sup + ", edad=" + edad + ", cons=" + cons + ", neg=" + neg + ", fr=" + fr + ", valor_unitario_resultante=" + valor_unitario_resultante + ", fecha_registro=" + fecha_registro + ", activo=" + activo + '}';
    }

}
