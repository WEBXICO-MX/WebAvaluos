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

public class TipoAcabado implements Serializable {

    private int id_tipo_acabado;
    private String nombre_tipo;
    private boolean activo;
    private boolean _existe;

    public TipoAcabado() {
        limpiar();
    }

    public TipoAcabado(int id_tipo_acabado) {
        limpiar();
        this.id_tipo_acabado = id_tipo_acabado;
        cargar();
    }

    public TipoAcabado(int id_tipo_acabado, String nombre_tipo, boolean activo) {
        this.id_tipo_acabado = id_tipo_acabado;
        this.nombre_tipo = nombre_tipo;
        this.activo = activo;
    }

    private void limpiar() {
        this.id_tipo_acabado = 0;
        this.nombre_tipo = "";
        this.activo = false;
        this._existe = false;
    }

    public int getId_tipo_acabado() {
        return id_tipo_acabado;
    }

    public void setId_tipo_acabado(int id_tipo_acabado) {
        this.id_tipo_acabado = id_tipo_acabado;
    }

    public String getNombre_tipo() {
        return nombre_tipo;
    }

    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "TipoAcabado{" + "id_tipo_acabado=" + id_tipo_acabado + ", nombre_tipo=" + nombre_tipo + ", activo=" + activo + '}';
    }

    public ErrorSistema grabar() {
        ErrorSistema err;
        StringBuilder sql;

        if (!this._existe) {
            this.id_tipo_acabado = UtilDB.getSiguienteNumero("Tipos_acabados", "id_tipo_acabado");
            sql = new StringBuilder("INSERT INTO Tipos_acabados VALUES(");
            sql.append(this.id_tipo_acabado).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.nombre_tipo)).append(",");
            sql.append(this.activo ? "1" : "0");
            sql.append(")");
            err = UtilDB.ejecutaSQL(sql.toString());
            if (err.getNumeroError() == 0) {
                this._existe = true;
            }
        } else {
            sql = new StringBuilder("UPDATE Tipos_acabados SET ");
            sql.append("nombre_tipo=").append(Utilerias.CadenaEncomillada(this.nombre_tipo)).append(",");
            sql.append("activo=").append(this.activo ? "1" : "0");
            sql.append(" WHERE id_tipo_acabado=").append(this.id_tipo_acabado);
            err = UtilDB.ejecutaSQL(sql.toString());
        }

        return err;
    }

    private void cargar() {
        String sql = "SELECT * FROM ﻿Tipos_acabados";
        Resultados rst = UtilDB.ejecutaConsulta(sql);
        if (rst.next()) {
            cargar(rst);
        }
        rst.close();
    }

    private void cargar(Resultados rst) {
        this.id_tipo_acabado = rst.getInt("id_tipo_acabado");
        this.nombre_tipo = rst.getString("nombre_tipo");
        this.activo = rst.getBoolean("activo");
        this._existe = true;
    }

}
