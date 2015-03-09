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

public class ServicioMunicipalDetalle implements Serializable {
    
    private CaracteristicaZona id_caracteristica_zona;
    private ServicioMunicipal id_servicio;
    private Calendar fecha_registro;
    private boolean activo;
    private boolean _existe;
    
    public ServicioMunicipalDetalle() {
        limpiar();
    }
    
    public ServicioMunicipalDetalle(CaracteristicaZona id_caracteristica_zona, ServicioMunicipal id_servicio) {
        limpiar();
        this.id_caracteristica_zona = id_caracteristica_zona;
        this.id_servicio = id_servicio;
        cargar();
    }
    
    public ServicioMunicipalDetalle(CaracteristicaZona id_caracteristica_zona, ServicioMunicipal id_servicio, Calendar fecha_registro, boolean activo) {
        this.id_caracteristica_zona = id_caracteristica_zona;
        this.id_servicio = id_servicio;
        this.fecha_registro = fecha_registro;
        this.activo = activo;
    }
    
    private void limpiar() {
        this.id_caracteristica_zona = null;
        this.id_servicio = null;
        this.fecha_registro = null;
        this.activo = false;
        this._existe = false;
    }
    
    public CaracteristicaZona getId_caracteristica_zona() {
        return id_caracteristica_zona;
    }
    
    public void setId_caracteristica_zona(CaracteristicaZona id_caracteristica_zona) {
        this.id_caracteristica_zona = id_caracteristica_zona;
    }
    
    public ServicioMunicipal getId_servicio() {
        return id_servicio;
    }
    
    public void setId_servicio(ServicioMunicipal id_servicio) {
        this.id_servicio = id_servicio;
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
        return "ServicioMunicipalDetalle{" + "id_caracteristica_zona=" + id_caracteristica_zona + ", id_servicio=" + id_servicio + ", fecha_registro=" + fecha_registro + ", activo=" + activo + '}';
    }
    
    public ErrorSistema grabar() {
        ErrorSistema err;
        StringBuilder sql;
        
        if (!this._existe) {
            sql = new StringBuilder("INSERTO INTO Servicios_municipales_detalle VALUES(");
            sql.append(this.id_caracteristica_zona.getId_caracteristica_zona()).append(",");
            sql.append(this.id_servicio.getId_servicio()).append(",");
            sql.append("GETDATE()").append(",");
            sql.append(this.activo ? "1" : "0");
            sql.append(")");
            err = UtilDB.ejecutaSQL(sql.toString());
            if (err.getNumeroError() == 0) {
                this._existe = true;
            }
            
        } else {
            sql = new StringBuilder("UPDATE Servicios_municipales_detalle SET ");
            sql.append("activo = ").append(this.activo ? "1" : "0");
            sql.append(" WHERE id_caracteristica_zona=").append(this.id_caracteristica_zona.getId_caracteristica_zona()).append(" AND id_servicio=").append(this.id_servicio.getId_servicio());
            err = UtilDB.ejecutaSQL(sql.toString());
        }
        return err;
    }
    
    private void cargar() {
        String sql = "SELECT * FROM ﻿Servicios_municipales_detalle WHERE id_caracteristica_zona=" + this.id_caracteristica_zona.getId_caracteristica_zona() + " AND id_servicio=" + this.id_servicio.getId_servicio();
        Resultados rst = UtilDB.ejecutaConsulta(sql);
        if (rst.next()) {
            cargar(rst);
        }
        rst.close();
        
    }
    
    private void cargar(Resultados rst) {
        this.id_caracteristica_zona = new CaracteristicaZona(rst.getInt("id_caracteristica_zona"));
        this.id_servicio = new ServicioMunicipal(rst.getInt("id_servicio"));
        this.fecha_registro = rst.getCalendar("fecha_registro");
        this.activo = rst.getBoolean("activo");
        this._existe = true;
        
    }
}
