/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.blogspot.webxico.model;

import java.io.Serializable;
import mx.blogspot.webxico.comun.ErrorSistema;
import mx.blogspot.webxico.comun.Resultados;
import mx.blogspot.webxico.comun.UtilDB;
import mx.blogspot.webxico.comun.Utilerias;

public class ServicioMunicipal implements Serializable {

    private int id_servicio;
    private String nombre_servicio;
    private boolean activo;
    private boolean _existe;

    public ServicioMunicipal() {
        limpiar();
    }

    public ServicioMunicipal(int id_servicio) {
        limpiar();
        this.id_servicio = id_servicio;
        cargar();
    }

    public ServicioMunicipal(int id_servicio, String nombre_servicio, boolean activo) {
        this.id_servicio = id_servicio;
        this.nombre_servicio = nombre_servicio;
        this.activo = activo;
    }

    private void limpiar() {
        this.id_servicio = 0;
        this.nombre_servicio = "";
        this.activo = false;
        this._existe = false;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getNombre_servicio() {
        return nombre_servicio;
    }

    public void setNombre_servicio(String nombre_servicio) {
        this.nombre_servicio = nombre_servicio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "ServicioMunicipal{" + "id_servicio=" + id_servicio + ", nombre_servicio=" + nombre_servicio + ", activo=" + activo + '}';
    }

    public ErrorSistema grabar() {
        ErrorSistema err;
        StringBuilder sql;

        if (!this._existe) {
            this.id_servicio = UtilDB.getSiguienteNumero("Servicios_municipales", "id_servicio");
            sql = new StringBuilder("INSERT INTO Servicios_municipales VALUES(");
            sql.append(this.id_servicio).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.nombre_servicio)).append(",");
            sql.append(this.activo ? "1" : "0");
            sql.append(")");
            err = UtilDB.ejecutaSQL(sql.toString());
            if (err.getNumeroError() == 0) {
                this._existe = true;
            }
        } else {
            sql = new StringBuilder("UPDATE Servicios_municipales SET ");
            sql.append("nombre_servicio=").append(Utilerias.CadenaEncomillada(this.nombre_servicio)).append(",");
            sql.append("activo=").append(this.activo ? "1" : "0");
            sql.append(" WHERE id_servicio =").append(this.id_servicio);
            err = UtilDB.ejecutaSQL(sql.toString());
        }
        return err;
    }

    private void cargar() {
        String sql = "SELECT * FROM ﻿Servicios_municipales WHERE id_servicio=" + this.id_servicio;
        Resultados rst = UtilDB.ejecutaConsulta(sql);
        if (rst.next()) {
            cargar(rst);
        }
        rst.close();

    }

    private void cargar(Resultados rst) {
        this.id_servicio = rst.getInt("id_servicio");
        this.nombre_servicio = rst.getString("nombre_servicio");
        this.activo = rst.getBoolean("activo");
        this._existe = true;

    }

}
