/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.blogspot.webxico.model;

import java.io.Serializable;
import java.util.Calendar;

public class PrivativaInstalacionEspecialObraComplementaria implements Serializable {

    private AnalisisFisico id_analisis_fisico;
    private ObraComplementaria id_obra;
    private String unidad;
    private int cantidad;
    private float vr_nuevo;
    private int vida_util_remanente;
    private int edad_anios;
    private float factor_edad;
    private float factor_conservacion;
    private float factor_resultante;
    private float v_neto_rep;
    private float valor_parcial_elementos_adicionales;
    private Calendar fecha_registro;
    private boolean activo;

    public PrivativaInstalacionEspecialObraComplementaria() {
    }

    public PrivativaInstalacionEspecialObraComplementaria(AnalisisFisico id_analisis_fisico, ObraComplementaria id_obra, String unidad, int cantidad, float vr_nuevo, int vida_util_remanente, int edad_anios, float factor_edad, float factor_conservacion, float factor_resultante, float v_neto_rep, float valor_parcial_elementos_adicionales, Calendar fecha_registro, boolean activo) {
        this.id_analisis_fisico = id_analisis_fisico;
        this.id_obra = id_obra;
        this.unidad = unidad;
        this.cantidad = cantidad;
        this.vr_nuevo = vr_nuevo;
        this.vida_util_remanente = vida_util_remanente;
        this.edad_anios = edad_anios;
        this.factor_edad = factor_edad;
        this.factor_conservacion = factor_conservacion;
        this.factor_resultante = factor_resultante;
        this.v_neto_rep = v_neto_rep;
        this.valor_parcial_elementos_adicionales = valor_parcial_elementos_adicionales;
        this.fecha_registro = fecha_registro;
        this.activo = activo;
    }

    public AnalisisFisico getId_analisis_fisico() {
        return id_analisis_fisico;
    }

    public void setId_analisis_fisico(AnalisisFisico id_analisis_fisico) {
        this.id_analisis_fisico = id_analisis_fisico;
    }

    public ObraComplementaria getId_obra() {
        return id_obra;
    }

    public void setId_obra(ObraComplementaria id_obra) {
        this.id_obra = id_obra;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getVr_nuevo() {
        return vr_nuevo;
    }

    public void setVr_nuevo(float vr_nuevo) {
        this.vr_nuevo = vr_nuevo;
    }

    public int getVida_util_remanente() {
        return vida_util_remanente;
    }

    public void setVida_util_remanente(int vida_util_remanente) {
        this.vida_util_remanente = vida_util_remanente;
    }

    public int getEdad_anios() {
        return edad_anios;
    }

    public void setEdad_anios(int edad_anios) {
        this.edad_anios = edad_anios;
    }

    public float getFactor_edad() {
        return factor_edad;
    }

    public void setFactor_edad(float factor_edad) {
        this.factor_edad = factor_edad;
    }

    public float getFactor_conservacion() {
        return factor_conservacion;
    }

    public void setFactor_conservacion(float factor_conservacion) {
        this.factor_conservacion = factor_conservacion;
    }

    public float getFactor_resultante() {
        return factor_resultante;
    }

    public void setFactor_resultante(float factor_resultante) {
        this.factor_resultante = factor_resultante;
    }

    public float getV_neto_rep() {
        return v_neto_rep;
    }

    public void setV_neto_rep(float v_neto_rep) {
        this.v_neto_rep = v_neto_rep;
    }

    public float getValor_parcial_elementos_adicionales() {
        return valor_parcial_elementos_adicionales;
    }

    public void setValor_parcial_elementos_adicionales(float valor_parcial_elementos_adicionales) {
        this.valor_parcial_elementos_adicionales = valor_parcial_elementos_adicionales;
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
        return "PrivativaInstalacionEspecialObraComplementaria{" + "id_analisis_fisico=" + id_analisis_fisico + ", id_obra=" + id_obra + ", unidad=" + unidad + ", cantidad=" + cantidad + ", vr_nuevo=" + vr_nuevo + ", vida_util_remanente=" + vida_util_remanente + ", edad_anios=" + edad_anios + ", factor_edad=" + factor_edad + ", factor_conservacion=" + factor_conservacion + ", factor_resultante=" + factor_resultante + ", v_neto_rep=" + v_neto_rep + ", valor_parcial_elementos_adicionales=" + valor_parcial_elementos_adicionales + ", fecha_registro=" + fecha_registro + ", activo=" + activo + '}';
    }

}
