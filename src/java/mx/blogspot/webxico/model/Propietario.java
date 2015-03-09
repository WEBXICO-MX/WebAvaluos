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

public class Propietario implements Serializable {

    private int id_propietario;
    private InformacionGeneralInmueble id_informacion_gen;
    private Calendar fecha_registro;
    private boolean activo;
    private boolean _existe;

    public Propietario() {
        limpiar();
    }

    public Propietario(int id_propietario, InformacionGeneralInmueble id_informacion_gen) {
        limpiar();
        this.id_propietario = id_propietario;
        this.id_informacion_gen = id_informacion_gen;
        cargar();
    }

    public Propietario(int id_propietario, InformacionGeneralInmueble id_informacion_gen, Calendar fecha_registro, boolean activo) {
        this.id_propietario = id_propietario;
        this.id_informacion_gen = id_informacion_gen;
        this.fecha_registro = fecha_registro;
        this.activo = activo;
    }

    private void limpiar() {
        this.id_propietario = 0;
        this.id_informacion_gen = null;
        this.fecha_registro = null;
        this.activo = false;
        this._existe = false;
    }

    public int getId_propietario() {
        return id_propietario;
    }

    public void setId_propietario(int id_propietario) {
        this.id_propietario = id_propietario;
    }

    public InformacionGeneralInmueble getId_informacion_gen() {
        return id_informacion_gen;
    }

    public void setId_informacion_gen(InformacionGeneralInmueble id_informacion_gen) {
        this.id_informacion_gen = id_informacion_gen;
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
        return "Propietario{" + "id_propietario=" + id_propietario + ", id_informacion_gen=" + id_informacion_gen + ", fecha_registro=" + fecha_registro + ", activo=" + activo + '}';
    }

    public ErrorSistema grabar() {
        ErrorSistema err;
        StringBuilder sql;

        if (!this._existe) {
            this.id_propietario = UtilDB.getSiguienteNumero("Propietarios", "id_propietario");
            sql = new StringBuilder("INSERT INTO Propietarios VALUES(");
            sql.append(this.id_propietario).append(",");
            sql.append(this.id_informacion_gen.getId_informacion_gen()).append(",");
            sql.append("GETDATE()").append(",");
            sql.append(this.activo ? "1" : "0");
            sql.append(")");
            err = UtilDB.ejecutaSQL(sql.toString());
            if (err.getNumeroError() == 0) {
                this._existe = true;
            }
        } else {
            sql = new StringBuilder("UPDATE Propietarios SET ");
            sql.append(" WHERE id_propietario = ").append(this.id_propietario).append(" AND id_informacion_gen= ").append(this.id_informacion_gen.getId_informacion_gen());
            err = UtilDB.ejecutaSQL(sql.toString());
        }

        return err;

    }

    private void cargar() {
        String sql = "SELECT * FROM ﻿Propietarios WHERE id_propietario =" + this.id_propietario + " AND id_informacion_gen=" + this.id_informacion_gen.getId_informacion_gen();
        Resultados rst = UtilDB.ejecutaConsulta(sql);
        if (rst.next()) {
            cargar(rst);
        }
        rst.close();

    }

    private void cargar(Resultados rst) {
        this.id_propietario = rst.getInt("id_propietario");
        this.id_informacion_gen = new InformacionGeneralInmueble(rst.getInt("id_informacion_gen"));
        this.fecha_registro = rst.getCalendar("fecha_registro");
        this.activo = rst.getBoolean("activo");
        this._existe = true;
    }

}
