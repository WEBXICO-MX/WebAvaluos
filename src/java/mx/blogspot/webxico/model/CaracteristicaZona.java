/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.blogspot.webxico.model;

import java.io.Serializable;
import java.util.Calendar;
import mx.blogspot.webxico.comun.ErrorSistema;
import mx.blogspot.webxico.comun.Resultados;
import mx.blogspot.webxico.comun.UtilDB;
import mx.blogspot.webxico.comun.Utilerias;

public class CaracteristicaZona implements Serializable {

    private int id_caracteristica_zona;
    private String otros_servicios_municipales;
    private String en_radio_se_ubican;
    private String otro_equipamiento_urbano;
    private int nivel_equipamiento;
    private ClasificacionZona id_clasificacion;
    private ProximidadUrbana id_proximidad;
    private String construcciones_predominantes;
    private String vias_acceso_importancia;
    private Calendar fecha_registro;
    private boolean activo;
    private boolean _existe;

    public CaracteristicaZona() {
        limpiar();
    }

    public CaracteristicaZona(int id_caracteristica_zona) {
        limpiar();
        this.id_caracteristica_zona = id_caracteristica_zona;
        cargar();
    }

    public CaracteristicaZona(int id_caracteristica_zona, String otros_servicios_municipales, String en_radio_se_ubican, String otro_equipamiento_urbano, int nivel_equipamiento, ClasificacionZona id_clasificacion, ProximidadUrbana id_proximidad, String construcciones_predominantes, String vias_acceso_importancia, Calendar fecha_registro, boolean activo) {
        this.id_caracteristica_zona = id_caracteristica_zona;
        this.otros_servicios_municipales = otros_servicios_municipales;
        this.en_radio_se_ubican = en_radio_se_ubican;
        this.otro_equipamiento_urbano = otro_equipamiento_urbano;
        this.nivel_equipamiento = nivel_equipamiento;
        this.id_clasificacion = id_clasificacion;
        this.id_proximidad = id_proximidad;
        this.construcciones_predominantes = construcciones_predominantes;
        this.vias_acceso_importancia = vias_acceso_importancia;
        this.fecha_registro = fecha_registro;
        this.activo = activo;
    }

    private void limpiar() {
        this.id_caracteristica_zona = 0;
        this.otros_servicios_municipales = "";
        this.en_radio_se_ubican = "";
        this.otro_equipamiento_urbano = "";
        this.nivel_equipamiento = 0;
        this.id_clasificacion = null;
        this.id_proximidad = null;
        this.construcciones_predominantes = "";
        this.vias_acceso_importancia = "";
        this.fecha_registro = null;
        this.activo = false;
        this._existe = false;
    }

    public int getId_caracteristica_zona() {
        return id_caracteristica_zona;
    }

    public void setId_caracteristica_zona(int id_caracteristica_zona) {
        this.id_caracteristica_zona = id_caracteristica_zona;
    }

    public String getOtros_servicios_municipales() {
        return otros_servicios_municipales;
    }

    public void setOtros_servicios_municipales(String otros_servicios_municipales) {
        this.otros_servicios_municipales = otros_servicios_municipales;
    }

    public String getEn_radio_se_ubican() {
        return en_radio_se_ubican;
    }

    public void setEn_radio_se_ubican(String en_radio_se_ubican) {
        this.en_radio_se_ubican = en_radio_se_ubican;
    }

    public String getOtro_equipamiento_urbano() {
        return otro_equipamiento_urbano;
    }

    public void setOtro_equipamiento_urbano(String otro_equipamiento_urbano) {
        this.otro_equipamiento_urbano = otro_equipamiento_urbano;
    }

    public int getNivel_equipamiento() {
        return nivel_equipamiento;
    }

    public void setNivel_equipamiento(int nivel_equipamiento) {
        this.nivel_equipamiento = nivel_equipamiento;
    }

    public ClasificacionZona getId_clasificacion() {
        return id_clasificacion;
    }

    public void setId_clasificacion(ClasificacionZona id_clasificacion) {
        this.id_clasificacion = id_clasificacion;
    }

    public ProximidadUrbana getId_proximidad() {
        return id_proximidad;
    }

    public void setId_proximidad(ProximidadUrbana id_proximidad) {
        this.id_proximidad = id_proximidad;
    }

    public String getConstrucciones_predominantes() {
        return construcciones_predominantes;
    }

    public void setConstrucciones_predominantes(String construcciones_predominantes) {
        this.construcciones_predominantes = construcciones_predominantes;
    }

    public String getVias_acceso_importancia() {
        return vias_acceso_importancia;
    }

    public void setVias_acceso_importancia(String vias_acceso_importancia) {
        this.vias_acceso_importancia = vias_acceso_importancia;
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
        return "CaracteristicaZona{" + "id_caracteristica_zona=" + id_caracteristica_zona + ", otros_servicios_municipales=" + otros_servicios_municipales + ", en_radio_se_ubican=" + en_radio_se_ubican
                + ", otro_equipamiento_urbano=" + otro_equipamiento_urbano + ", nivel_equipamiento=" + nivel_equipamiento + ", id_clasificacion=" + id_clasificacion + ", id_proximidad=" + id_proximidad
                + ", construcciones_predominantes=" + construcciones_predominantes + ", vias_acceso_importancia=" + vias_acceso_importancia + ", fecha_registro=" + fecha_registro + ", activo=" + activo + '}';
    }

    public ErrorSistema grabar() {
        ErrorSistema err;
        StringBuilder sql;
        if (!this._existe) {
            this.id_caracteristica_zona = UtilDB.getSiguienteNumero("Caracteristicas_zona", "id_caracteristica_zona");
            sql = new StringBuilder("INSERT INTO Caracteristicas_zona VALUES(");
            sql.append(this.id_caracteristica_zona).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.otros_servicios_municipales)).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.en_radio_se_ubican)).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.otro_equipamiento_urbano)).append(",");
            sql.append(this.nivel_equipamiento).append(",");
            sql.append(this.id_clasificacion.getId_clasificacion()).append(",");
            sql.append(this.id_proximidad.getId_proximidad()).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.construcciones_predominantes)).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.vias_acceso_importancia)).append(",");
            sql.append("GETDATE()").append(",");
            sql.append(this.activo ? "1" : "0");
            sql.append(")");
            err = UtilDB.ejecutaSQL(sql.toString());
            if (err.getNumeroError() == 0) {
                this._existe = true;
            }

        } else {
            sql = new StringBuilder("UPDATE Caracteristicas_zona SET ");
            sql.append("otros_servicios_municipales =").append(Utilerias.CadenaEncomillada(this.otros_servicios_municipales)).append(",");
            sql.append("en_radio_se_ubican =").append(Utilerias.CadenaEncomillada(this.en_radio_se_ubican)).append(",");
            sql.append("otro_equipamiento_urbano =").append(Utilerias.CadenaEncomillada(this.otro_equipamiento_urbano)).append(",");
            sql.append("nivel_equipamiento =").append(this.nivel_equipamiento).append(",");
            sql.append("id_clasificacion =").append(this.id_clasificacion.getId_clasificacion()).append(",");
            sql.append("id_proximidad =").append(this.id_proximidad.getId_proximidad()).append(",");
            sql.append("construcciones_predominantes =").append(Utilerias.CadenaEncomillada(this.construcciones_predominantes)).append(",");
            sql.append("vias_acceso_importancia =").append(Utilerias.CadenaEncomillada(this.vias_acceso_importancia)).append(",");
            sql.append("activo = ").append(this.activo ? "1" : "0");
            sql.append(" WHERE id_caracteristica_zona = ").append(this.id_caracteristica_zona);
            err = UtilDB.ejecutaSQL(sql.toString());
        }
        return err;

    }

    private void cargar() {
        String sql = "SELECT * FROM ﻿Caracteristicas_zona WHERE id_caracteristica_zona=" + this.id_caracteristica_zona;
        Resultados rst = UtilDB.ejecutaConsulta(sql);
        if (rst.next()) {
            cargar(rst);
        }
        rst.close();
    }

    private void cargar(Resultados rst) {
        this.id_caracteristica_zona = rst.getInt("id_caracteristica_zona");
        this.otros_servicios_municipales = rst.getString("otros_servicios_municipales");
        this.en_radio_se_ubican = rst.getString("en_radio_se_ubican");
        this.otro_equipamiento_urbano = rst.getString("otro_equipamiento_urbano");
        this.nivel_equipamiento = rst.getInt("nivel_equipamiento");
        this.id_clasificacion = new ClasificacionZona(rst.getInt("id_clasificacion"));
        this.id_proximidad = new ProximidadUrbana(rst.getInt("id_proximidad"));
        this.construcciones_predominantes = rst.getString("construcciones_predominantes");
        this.vias_acceso_importancia = rst.getString("vias_acceso_importancia");
        this.fecha_registro = rst.getCalendar("fecha_registro");
        this.activo = rst.getBoolean("activo");
        this._existe = true;
    }

}
