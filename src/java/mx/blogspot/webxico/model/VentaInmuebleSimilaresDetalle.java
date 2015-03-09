/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.blogspot.webxico.model;

import java.io.Serializable;
import java.util.Calendar;

public class VentaInmuebleSimilaresDetalle implements Serializable {

    private int id_venta_inmuebles_similares;
    private InvestigacionMercado id_investigacion_mercado;
    private String unbicacion_oferta_comparable;
    private int edad;
    private String telefono;
    private String fuente;
    private Calendar fecha_registro;
    private boolean activo;

    public VentaInmuebleSimilaresDetalle() {
    }

    public VentaInmuebleSimilaresDetalle(int id_venta_inmuebles_similares, InvestigacionMercado id_investigacion_mercado, String unbicacion_oferta_comparable, int edad, String telefono, String fuente, Calendar fecha_registro, boolean activo) {
        this.id_venta_inmuebles_similares = id_venta_inmuebles_similares;
        this.id_investigacion_mercado = id_investigacion_mercado;
        this.unbicacion_oferta_comparable = unbicacion_oferta_comparable;
        this.edad = edad;
        this.telefono = telefono;
        this.fuente = fuente;
        this.fecha_registro = fecha_registro;
        this.activo = activo;
    }

    public int getId_venta_inmuebles_similares() {
        return id_venta_inmuebles_similares;
    }

    public void setId_venta_inmuebles_similares(int id_venta_inmuebles_similares) {
        this.id_venta_inmuebles_similares = id_venta_inmuebles_similares;
    }

    public InvestigacionMercado getId_investigacion_mercado() {
        return id_investigacion_mercado;
    }

    public void setId_investigacion_mercado(InvestigacionMercado id_investigacion_mercado) {
        this.id_investigacion_mercado = id_investigacion_mercado;
    }

    public String getUnbicacion_oferta_comparable() {
        return unbicacion_oferta_comparable;
    }

    public void setUnbicacion_oferta_comparable(String unbicacion_oferta_comparable) {
        this.unbicacion_oferta_comparable = unbicacion_oferta_comparable;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
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
        return "VentaInmuebleSimilaresDetalle{" + "id_venta_inmuebles_similares=" + id_venta_inmuebles_similares + ", id_investigacion_mercado=" + id_investigacion_mercado + ", unbicacion_oferta_comparable=" + unbicacion_oferta_comparable + ", edad=" + edad + ", telefono=" + telefono + ", fuente=" + fuente + ", fecha_registro=" + fecha_registro + ", activo=" + activo + '}';
    }

}
