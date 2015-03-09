/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.blogspot.webxico.model;

import java.io.Serializable;
import java.util.Calendar;

public class VentaTerrenoDetalle implements Serializable {

    private int id_venta_terreno;
    private InvestigacionMercado id_investigacion_mercado;
    private String ubicacion_oferta_comparable;
    private float precio_oferta;
    private float superficie_terreno;
    private float superficie_construida;
    private float p_u_m2;
    private String fuente_antecedente_telefono;
    private Calendar fecha_registro;
    private boolean activo;

    public VentaTerrenoDetalle() {
    }

    public VentaTerrenoDetalle(int id_venta_terreno, InvestigacionMercado id_investigacion_mercado, String ubicacion_oferta_comparable, float precio_oferta, float superficie_terreno, float superficie_construida, float p_u_m2, String fuente_antecedente_telefono, Calendar fecha_registro, boolean activo) {
        this.id_venta_terreno = id_venta_terreno;
        this.id_investigacion_mercado = id_investigacion_mercado;
        this.ubicacion_oferta_comparable = ubicacion_oferta_comparable;
        this.precio_oferta = precio_oferta;
        this.superficie_terreno = superficie_terreno;
        this.superficie_construida = superficie_construida;
        this.p_u_m2 = p_u_m2;
        this.fuente_antecedente_telefono = fuente_antecedente_telefono;
        this.fecha_registro = fecha_registro;
        this.activo = activo;
    }

    public int getId_venta_terreno() {
        return id_venta_terreno;
    }

    public void setId_venta_terreno(int id_venta_terreno) {
        this.id_venta_terreno = id_venta_terreno;
    }

    public InvestigacionMercado getId_investigacion_mercado() {
        return id_investigacion_mercado;
    }

    public void setId_investigacion_mercado(InvestigacionMercado id_investigacion_mercado) {
        this.id_investigacion_mercado = id_investigacion_mercado;
    }

    public String getUbicacion_oferta_comparable() {
        return ubicacion_oferta_comparable;
    }

    public void setUbicacion_oferta_comparable(String ubicacion_oferta_comparable) {
        this.ubicacion_oferta_comparable = ubicacion_oferta_comparable;
    }

    public float getPrecio_oferta() {
        return precio_oferta;
    }

    public void setPrecio_oferta(float precio_oferta) {
        this.precio_oferta = precio_oferta;
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

    public float getP_u_m2() {
        return p_u_m2;
    }

    public void setP_u_m2(float p_u_m2) {
        this.p_u_m2 = p_u_m2;
    }

    public String getFuente_antecedente_telefono() {
        return fuente_antecedente_telefono;
    }

    public void setFuente_antecedente_telefono(String fuente_antecedente_telefono) {
        this.fuente_antecedente_telefono = fuente_antecedente_telefono;
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
        return "VentaTerrenoDetalle{" + "id_venta_terreno=" + id_venta_terreno + ", id_investigacion_mercado=" + id_investigacion_mercado + ", ubicacion_oferta_comparable=" + ubicacion_oferta_comparable + ", precio_oferta=" + precio_oferta + ", superficie_terreno=" + superficie_terreno + ", superficie_construida=" + superficie_construida + ", p_u_m2=" + p_u_m2 + ", fuente_antecedente_telefono=" + fuente_antecedente_telefono + ", fecha_registro=" + fecha_registro + ", activo=" + activo + '}';
    }

}
