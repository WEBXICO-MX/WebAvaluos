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

public class AcabadoDetalle implements Serializable {

    private TipoAcabado id_tipo_acabado;
    private AreaConsiderarAcabado id_areas_considerar;
    private CaracteristicaInmueble id_caracteristica_inm;
    private String descripcion;
    private Calendar fecha_registro;
    private boolean activo;
    private boolean _existe;

    public AcabadoDetalle() {
        limpiar();
    }

    public AcabadoDetalle(TipoAcabado id_tipo_acabado, AreaConsiderarAcabado id_areas_considerar, CaracteristicaInmueble id_caracteristica_inm) {
        limpiar();
        this.id_tipo_acabado = id_tipo_acabado;
        this.id_areas_considerar = id_areas_considerar;
        this.id_caracteristica_inm = id_caracteristica_inm;
        cargar();
    }

    public AcabadoDetalle(TipoAcabado id_tipo_acabado, AreaConsiderarAcabado id_areas_considerar, CaracteristicaInmueble id_caracteristica_inm, String descripcion, Calendar fecha_registro, boolean activo) {
        this.id_tipo_acabado = id_tipo_acabado;
        this.id_areas_considerar = id_areas_considerar;
        this.id_caracteristica_inm = id_caracteristica_inm;
        this.descripcion = descripcion;
        this.fecha_registro = fecha_registro;
        this.activo = activo;
    }

    private void limpiar() {
        this.id_tipo_acabado = null;
        this.id_areas_considerar = null;
        this.id_caracteristica_inm = null;
        this.descripcion = "";
        this.fecha_registro = null;
        this.activo = false;
        this._existe = false;
    }

    public TipoAcabado getId_tipo_acabado() {
        return id_tipo_acabado;
    }

    public void setId_tipo_acabado(TipoAcabado id_tipo_acabado) {
        this.id_tipo_acabado = id_tipo_acabado;
    }

    public AreaConsiderarAcabado getId_areas_considerar() {
        return id_areas_considerar;
    }

    public void setId_areas_considerar(AreaConsiderarAcabado id_areas_considerar) {
        this.id_areas_considerar = id_areas_considerar;
    }

    public CaracteristicaInmueble getId_caracteristica_inm() {
        return id_caracteristica_inm;
    }

    public void setId_caracteristica_inm(CaracteristicaInmueble id_caracteristica_inm) {
        this.id_caracteristica_inm = id_caracteristica_inm;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        return "AcabadoDetalle{" + "id_tipo_acabado=" + id_tipo_acabado + ", id_areas_considerar=" + id_areas_considerar + ", id_caracteristica_inm=" + id_caracteristica_inm + ", descripcion=" + descripcion + ", fecha_registro=" + fecha_registro + ", activo=" + activo + '}';
    }

    public ErrorSistema grabar() {
        ErrorSistema err;
        StringBuilder sql;

        if (!this._existe) {
            sql = new StringBuilder("INSERT INTO Acabados_detalles VALUES(");
            sql.append(this.id_tipo_acabado.getId_tipo_acabado()).append(",");
            sql.append(this.id_areas_considerar.getId_areas_considerar()).append(",");
            sql.append(this.id_caracteristica_inm.getId_caracteristica_inm()).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.descripcion)).append(",");
            sql.append("GETDATE()").append(",");
            sql.append(this.activo ? "1" : "0");
            sql.append(")");
            err = UtilDB.ejecutaSQL(sql.toString());
            if (err.getNumeroError() == 0) {
                this._existe = true;
            }

        } else {
            sql = new StringBuilder("UPDATE Acabados_detalles SET ");
            sql.append("descripcion=").append(Utilerias.CadenaEncomillada(this.descripcion)).append(",");
            sql.append("activo=").append(this.activo ? "1" : "0");
            sql.append(" WHERE id_tipo_acabado=").append(this.id_tipo_acabado.getId_tipo_acabado());
            sql.append(" AND id_areas_considerar =").append(this.id_areas_considerar.getId_areas_considerar());
            sql.append(" AND id_caracteristica_inm=").append(this.id_caracteristica_inm.getId_caracteristica_inm());
            err = UtilDB.ejecutaSQL(sql.toString());
        }

        return err;

    }

    private void cargar() {
        String sql = "SELECT * FROM ﻿Acabados_detalles WHERE id_tipo_acabado=" + this.id_tipo_acabado.getId_tipo_acabado() + " AND id_areas_considerar=" + this.id_areas_considerar.getId_areas_considerar() + " AND id_caracteristica_inm=" + this.id_caracteristica_inm.getId_caracteristica_inm();
        Resultados rst = UtilDB.ejecutaConsulta(sql);
        if (rst.next()) {
            cargar(rst);
        }
        rst.close();
    }

    private void cargar(Resultados rst) {
        this.id_tipo_acabado = new TipoAcabado(rst.getInt("id_tipo_acabado"));
        this.id_areas_considerar = new AreaConsiderarAcabado(rst.getInt("id_areas_considerar"));
        this.id_caracteristica_inm = new CaracteristicaInmueble(rst.getInt("id_caracteristica_inm"));
        this.descripcion = rst.getString("descripcion");
        this.fecha_registro = rst.getCalendar("fecha_registro");
        this.activo = rst.getBoolean("activo");
        this._existe = true;
    }
}
