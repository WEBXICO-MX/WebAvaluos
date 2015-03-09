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

public class MedidaColindanciaDetalle implements Serializable {

    private int id_medidas_col;
    private CaracteristicaInmueble id_caracteristica_inm;
    private String noreste1;
    private String descripcion1;
    private String noreste2;
    private String descripcion2;
    private String sureste1;
    private String descripcion3;
    private String sureste2;
    private String descripcion4;
    private float superficie_libre;
    private String descripcion5;
    private float area_construida;
    private String descripcion6;
    private float area_total;
    private String descripcion7;
    private Calendar fecha_registro;
    private boolean activo;
    private boolean _existe;

    public MedidaColindanciaDetalle() {
        this.limpiar();
    }

    public MedidaColindanciaDetalle(int id_medidas_col, CaracteristicaInmueble id_caracteristica_inm) {
        this.limpiar();
        this.id_medidas_col = id_medidas_col;
        this.id_caracteristica_inm = id_caracteristica_inm;
        this.cargar();
    }

    public MedidaColindanciaDetalle(int id_medidas_col, CaracteristicaInmueble id_caracteristica_inm, String noreste1, String descripcion1, String noreste2, String descripcion2, String sureste1, String descripcion3, String sureste2, String descripcion4, float superficie_libre, String descripcion5, float area_construida, String descripcion6, float area_total, String descripcion7, Calendar fecha_registro, boolean activo) {
        this.id_medidas_col = id_medidas_col;
        this.id_caracteristica_inm = id_caracteristica_inm;
        this.noreste1 = noreste1;
        this.descripcion1 = descripcion1;
        this.noreste2 = noreste2;
        this.descripcion2 = descripcion2;
        this.sureste1 = sureste1;
        this.descripcion3 = descripcion3;
        this.sureste2 = sureste2;
        this.descripcion4 = descripcion4;
        this.superficie_libre = superficie_libre;
        this.descripcion5 = descripcion5;
        this.area_construida = area_construida;
        this.descripcion6 = descripcion6;
        this.area_total = area_total;
        this.descripcion7 = descripcion7;
        this.fecha_registro = fecha_registro;
        this.activo = activo;
    }

    private void limpiar() {

        this.id_medidas_col = 0;
        this.id_caracteristica_inm = null;
        this.noreste1 = "";
        this.descripcion1 = "";
        this.noreste2 = "";
        this.descripcion2 = "";
        this.sureste1 = "";
        this.descripcion3 = "";
        this.sureste2 = "";
        this.descripcion4 = "";
        this.superficie_libre = 0;
        this.descripcion5 = "";
        this.area_construida = 0;
        this.descripcion6 = "";
        this.area_total = 0;
        this.descripcion7 = "";
        this.fecha_registro = null;
        this.activo = false;
        this._existe = false;
    }

    public int getId_medidas_col() {
        return id_medidas_col;
    }

    public void setId_medidas_col(int id_medidas_col) {
        this.id_medidas_col = id_medidas_col;
    }

    public CaracteristicaInmueble getId_carcteristica_inm() {
        return id_caracteristica_inm;
    }

    public void setId_carcteristica_inm(CaracteristicaInmueble id_caracteristica_inm) {
        this.id_caracteristica_inm = id_caracteristica_inm;
    }

    public String getNoreste1() {
        return noreste1;
    }

    public void setNoreste1(String noreste1) {
        this.noreste1 = noreste1;
    }

    public String getDescripcion1() {
        return descripcion1;
    }

    public void setDescripcion1(String descripcion1) {
        this.descripcion1 = descripcion1;
    }

    public String getNoreste2() {
        return noreste2;
    }

    public void setNoreste2(String noreste2) {
        this.noreste2 = noreste2;
    }

    public String getDescripcion2() {
        return descripcion2;
    }

    public void setDescripcion2(String descripcion2) {
        this.descripcion2 = descripcion2;
    }

    public String getSureste1() {
        return sureste1;
    }

    public void setSureste1(String sureste1) {
        this.sureste1 = sureste1;
    }

    public String getDescripcion3() {
        return descripcion3;
    }

    public void setDescripcion3(String descripcion3) {
        this.descripcion3 = descripcion3;
    }

    public String getSureste2() {
        return sureste2;
    }

    public void setSureste2(String sureste2) {
        this.sureste2 = sureste2;
    }

    public String getDescripcion4() {
        return descripcion4;
    }

    public void setDescripcion4(String descripcion4) {
        this.descripcion4 = descripcion4;
    }

    public float getSuperficie_libre() {
        return superficie_libre;
    }

    public void setSuperficie_libre(float superficie_libre) {
        this.superficie_libre = superficie_libre;
    }

    public String getDescripcion5() {
        return descripcion5;
    }

    public void setDescripcion5(String descripcion5) {
        this.descripcion5 = descripcion5;
    }

    public float getArea_construida() {
        return area_construida;
    }

    public void setArea_construida(float area_construida) {
        this.area_construida = area_construida;
    }

    public String getDescripcion6() {
        return descripcion6;
    }

    public void setDescripcion6(String descripcion6) {
        this.descripcion6 = descripcion6;
    }

    public float getArea_total() {
        return area_total;
    }

    public void setArea_total(float area_total) {
        this.area_total = area_total;
    }

    public String getDescripcion7() {
        return descripcion7;
    }

    public void setDescripcion7(String descripcion7) {
        this.descripcion7 = descripcion7;
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
        return "MedidaColindanciaDetalle{" + "id_medidas_col=" + id_medidas_col + ", id_caracteristica_inm=" + id_caracteristica_inm + ", noreste1=" + noreste1 + ", descripcion1=" + descripcion1
                + ", noreste2=" + noreste2 + ", descripcion2=" + descripcion2 + ", sureste1=" + sureste1 + ", descripcion3=" + descripcion3 + ", sureste2=" + sureste2 + ", descripcion4=" + descripcion4
                + ", superficie_libre=" + superficie_libre + ", descripcion5=" + descripcion5 + ", area_construida=" + area_construida + ", descripcion6=" + descripcion6 + ", area_total=" + area_total
                + ", descripcion7=" + descripcion7 + ", fecha_registro=" + fecha_registro + ", activo=" + activo + ", _existe=" + _existe + '}';
    }

    public ErrorSistema grabar() {
        ErrorSistema err;
        StringBuilder sql;
        if (!this._existe) {
            this.id_medidas_col = UtilDB.getSiguienteNumero("Medidas_colindancias_detalle", "id_medidas_col");
            sql = new StringBuilder("INSERT INTO Medidas_colindancias_detalle VALUES(");
            sql.append(this.id_medidas_col).append(",");
            sql.append(this.id_caracteristica_inm.getId_caracteristica_inm()).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.noreste1)).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.descripcion1)).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.noreste2)).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.descripcion2)).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.sureste1)).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.descripcion3)).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.sureste2)).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.descripcion4)).append(",");
            sql.append(this.superficie_libre).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.descripcion5)).append(",");
            sql.append(this.area_construida).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.descripcion6)).append(",");
            sql.append(this.area_total).append(",");
            sql.append(this.descripcion7).append(",");
            sql.append("GETDATE()").append(",");
            sql.append(this.activo ? "1" : "0");
            sql.append(")");
            err = UtilDB.ejecutaSQL(sql.toString());
            if (err.getNumeroError() == 0) {
                this._existe = true;
            }
        } else {
            sql = new StringBuilder("UPDATE Medidas_colindancias_detalle SET ");
            sql.append("noreste1=").append(Utilerias.CadenaEncomillada(this.noreste1)).append(",");
            sql.append("descripcion1=").append(Utilerias.CadenaEncomillada(this.descripcion1)).append(",");
            sql.append("noreste2=").append(Utilerias.CadenaEncomillada(this.noreste2)).append(",");
            sql.append("descripcion2=").append(Utilerias.CadenaEncomillada(this.descripcion2)).append(",");
            sql.append("sureste1=").append(Utilerias.CadenaEncomillada(this.sureste1)).append(",");
            sql.append("descripcion3=").append(Utilerias.CadenaEncomillada(this.descripcion3)).append(",");
            sql.append("sureste2").append(Utilerias.CadenaEncomillada(this.sureste2)).append(",");
            sql.append("descripcion4=").append(Utilerias.CadenaEncomillada(this.descripcion4)).append(",");
            sql.append("superficie_libre=").append(this.superficie_libre).append(",");
            sql.append("descripcion5=").append(Utilerias.CadenaEncomillada(this.descripcion5)).append(",");
            sql.append("area_construida=").append(this.area_construida).append(",");
            sql.append("descripcion6=").append(Utilerias.CadenaEncomillada(this.descripcion6)).append(",");
            sql.append("area_total=").append(this.area_total).append(",");
            sql.append("descripcion7=").append(Utilerias.CadenaEncomillada(this.descripcion7)).append(",");
            sql.append("activo=").append(this.activo ? "1" : "0").append(",");
            sql.append(" WHERE id_medidas_col=").append(this.id_medidas_col);
            sql.append(" AND id_caracteristica_inm=").append(this.id_caracteristica_inm.getId_caracteristica_inm());
            err = UtilDB.ejecutaSQL(sql.toString());
        }
        return err;

    }

    private void cargar() {
        String sql = "SELECT * FROM ﻿Medidas_colindancias_detalle WHERE id_medidas_col=" + this.id_medidas_col + " AND id_caracteristica_inm=" + this.id_caracteristica_inm.getId_caracteristica_inm();
        Resultados rst = UtilDB.ejecutaConsulta(sql);
        if (rst.next()) {
            cargar(rst);
        }
        rst.close();
    }

    private void cargar(Resultados rst) {
        this.id_medidas_col = rst.getInt("id_medidas_col");
        this.id_caracteristica_inm = new CaracteristicaInmueble(rst.getInt("id_caracteristica_inm"));
        this.noreste1 = rst.getString("noreste1");
        this.descripcion1 = rst.getString("descripcion1");
        this.noreste2 = rst.getString("noreste2");
        this.descripcion2 = rst.getString("descripcion2");
        this.sureste1 = rst.getString("sureste1");
        this.descripcion3 = rst.getString("descripcion3");
        this.sureste2 = rst.getString("sureste2");
        this.descripcion4 = rst.getString("descripcion4");
        this.superficie_libre = rst.getFloat("superficie_libre");
        this.descripcion5 = rst.getString("descripcion5");
        this.area_construida = rst.getFloat("area_construida");
        this.descripcion6 = rst.getString("descripcion6");
        this.area_total = rst.getFloat("area_total");
        this.descripcion7 = rst.getString("descripcion7");
        this.fecha_registro = rst.getCalendar("fecha_registro");
        this.activo = rst.getBoolean("activo");
        this._existe = true;
    }

}
