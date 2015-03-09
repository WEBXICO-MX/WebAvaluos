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

public class EquipamientoUrbanoDetalle implements Serializable {

    private CaracteristicaZona id_caracteristica_zona;
    private EquipamientoUrbano id_equipamiento;
    private Calendar fecha_registro;
    private boolean activo;
    private boolean _existe;

    public EquipamientoUrbanoDetalle() {
        limpiar();
    }

    public EquipamientoUrbanoDetalle(CaracteristicaZona id_caracteristica_zona, EquipamientoUrbano id_equipamiento) {
        limpiar();
        this.id_caracteristica_zona = id_caracteristica_zona;
        this.id_equipamiento = id_equipamiento;
        cargar();
    }

    public EquipamientoUrbanoDetalle(CaracteristicaZona id_caracteristica_zona, EquipamientoUrbano id_equipamiento, Calendar fecha_registro, boolean activo) {
        this.id_caracteristica_zona = id_caracteristica_zona;
        this.id_equipamiento = id_equipamiento;
        this.fecha_registro = fecha_registro;
        this.activo = activo;
    }

    private void limpiar() {
        this.id_caracteristica_zona = null;
        this.id_equipamiento = null;
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

    public EquipamientoUrbano getId_equipamiento() {
        return id_equipamiento;
    }

    public void setId_equipamiento(EquipamientoUrbano id_equipamiento) {
        this.id_equipamiento = id_equipamiento;
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
        return "EquipamientoUrbanoDetalle{" + "id_caracteristica_zona=" + id_caracteristica_zona + ", id_equipamiento=" + id_equipamiento + ", fecha_registro=" + fecha_registro + ", activo=" + activo + '}';
    }

    public ErrorSistema grabar() {
        ErrorSistema err;
        StringBuilder sql;

        if (!this._existe) {
            sql = new StringBuilder("INSERT INTO Equipamiento_urbano_detalle VALUES(");
            sql.append(this.id_caracteristica_zona.getId_caracteristica_zona()).append(",");
            sql.append(this.id_equipamiento.getId_equipamiento()).append(",");
            sql.append("GETDATE()").append(",");
            sql.append(this.activo ? "1" : "0");
            sql.append(")");
            err = UtilDB.ejecutaSQL(sql.toString());
            if (err.getNumeroError() == 0) {
                this._existe = true;
            }
        } else {
            sql = new StringBuilder("UPDATE Equipamiento_urbano_detalle SET ");
            sql.append(this.activo ? "1" : "0");
            sql.append(" WHERE id_caracteristica_zona=").append(this.id_caracteristica_zona.getId_caracteristica_zona()).append(" AND id_equipamiento=").append(this.id_equipamiento.getId_equipamiento());
            err = UtilDB.ejecutaSQL(sql.toString());
        }

        return err;
    }

    private void cargar() {
        String sql = "SELECT * FROM ﻿Equipamiento_urbano_detalle WHERE id_caracteristica_zona=" + this.id_caracteristica_zona.getId_caracteristica_zona() + " AND id_equipamiento=" + this.id_equipamiento.getId_equipamiento();
        Resultados rst = UtilDB.ejecutaConsulta(sql);
        if (rst.next()) {
            cargar(rst);
        }
        rst.close();
    }

    private void cargar(Resultados rst) {
        this.id_caracteristica_zona = new CaracteristicaZona(rst.getInt("id_caracteristica_zona"));
        this.id_equipamiento = new EquipamientoUrbano(rst.getInt("id_equipamiento"));
        this.fecha_registro = rst.getCalendar("fecha_registro");
        this.activo = rst.getBoolean("activo");
        this._existe = true;
    }

}
