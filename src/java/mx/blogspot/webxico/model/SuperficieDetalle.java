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

public class SuperficieDetalle implements Serializable {

    private int id_superficie;
    private CaracteristicaInmueble id_caracteristica_inm;
    private float superficie_total_terreno;
    private float superficie_terreno;
    private float superficie_construccion;
    private float supercie_acentada_escritura;
    private float indiviso_terreno;
    private float indiviso_areas_comunes;
    private float indiviso_accesoria;
    private float superficie_vendible;
    private Calendar fecha_registro;
    private boolean activo;
    private boolean _existe;

    public SuperficieDetalle() {
        this.limpiar();
    }

    public SuperficieDetalle(int id_superficie, CaracteristicaInmueble id_caracteristica_inm) {
        this.limpiar();
        this.id_superficie = id_superficie;
        this.id_caracteristica_inm = id_caracteristica_inm;
        this.cargar();
    }

    public SuperficieDetalle(int id_superficie, CaracteristicaInmueble id_caracteristica_inm, float superficie_total_terreno, float superficie_terreno, float superficie_construccion, float supercie_acentada_escritura, float indiviso_terreno, float indiviso_areas_comunes, float indiviso_accesoria, float superficie_vendible, Calendar fecha_registro, boolean activo) {
        this.id_superficie = id_superficie;
        this.id_caracteristica_inm = id_caracteristica_inm;
        this.superficie_total_terreno = superficie_total_terreno;
        this.superficie_terreno = superficie_terreno;
        this.superficie_construccion = superficie_construccion;
        this.supercie_acentada_escritura = supercie_acentada_escritura;
        this.indiviso_terreno = indiviso_terreno;
        this.indiviso_areas_comunes = indiviso_areas_comunes;
        this.indiviso_accesoria = indiviso_accesoria;
        this.superficie_vendible = superficie_vendible;
        this.fecha_registro = fecha_registro;
        this.activo = activo;
    }

    private void limpiar() {
        this.id_superficie = 0;
        this.id_caracteristica_inm = null;
        this.superficie_total_terreno = 0;
        this.superficie_terreno = 0;
        this.superficie_construccion = 0;
        this.supercie_acentada_escritura = 0;
        this.indiviso_terreno = 0;
        this.indiviso_areas_comunes = 0;
        this.indiviso_accesoria = 0;
        this.superficie_vendible = 0;
        this.fecha_registro = null;
        this.activo = false;
        this._existe = false;
    }

    public int getId_superficie() {
        return id_superficie;
    }

    public void setId_superficie(int id_superficie) {
        this.id_superficie = id_superficie;
    }

    public CaracteristicaInmueble getId_caracteristica_inm() {
        return id_caracteristica_inm;
    }

    public void setId_caracteristica_inm(CaracteristicaInmueble id_caracteristica_inm) {
        this.id_caracteristica_inm = id_caracteristica_inm;
    }

    public float getSuperficie_total_terreno() {
        return superficie_total_terreno;
    }

    public void setSuperficie_total_terreno(float superficie_total_terreno) {
        this.superficie_total_terreno = superficie_total_terreno;
    }

    public float getSuperficie_terreno() {
        return superficie_terreno;
    }

    public void setSuperficie_terreno(float superficie_terreno) {
        this.superficie_terreno = superficie_terreno;
    }

    public float getSuperficie_construccion() {
        return superficie_construccion;
    }

    public void setSuperficie_construccion(float superficie_construccion) {
        this.superficie_construccion = superficie_construccion;
    }

    public float getSupercie_acentada_escritura() {
        return supercie_acentada_escritura;
    }

    public void setSupercie_acentada_escritura(float supercie_acentada_escritura) {
        this.supercie_acentada_escritura = supercie_acentada_escritura;
    }

    public float getIndiviso_terreno() {
        return indiviso_terreno;
    }

    public void setIndiviso_terreno(float indiviso_terreno) {
        this.indiviso_terreno = indiviso_terreno;
    }

    public float getIndiviso_areas_comunes() {
        return indiviso_areas_comunes;
    }

    public void setIndiviso_areas_comunes(float indiviso_areas_comunes) {
        this.indiviso_areas_comunes = indiviso_areas_comunes;
    }

    public float getIndiviso_accesoria() {
        return indiviso_accesoria;
    }

    public void setIndiviso_accesoria(float indiviso_accesoria) {
        this.indiviso_accesoria = indiviso_accesoria;
    }

    public float getSuperficie_vendible() {
        return superficie_vendible;
    }

    public void setSuperficie_vendible(float superficie_vendible) {
        this.superficie_vendible = superficie_vendible;
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
        return "SuperficieDetalle{" + "id_superficie=" + id_superficie + ", id_caracteristica_inm=" + id_caracteristica_inm
                + ", superficie_total_terreno=" + superficie_total_terreno + ", superficie_terreno=" + superficie_terreno
                + ", superficie_construccion=" + superficie_construccion + ", supercie_acentada_escritura=" + supercie_acentada_escritura + ", indiviso_terreno=" + indiviso_terreno
                + ", indiviso_areas_comunes=" + indiviso_areas_comunes + ", indiviso_accesoria=" + indiviso_accesoria + ", superficie_vendible=" + superficie_vendible
                + ", fecha_registro=" + fecha_registro + ", activo=" + activo + '}';
    }

    public ErrorSistema grabar() {
        ErrorSistema err;
        StringBuilder sql;

        if (!this._existe) {
            this.id_superficie = UtilDB.getSiguienteNumero("Superficies_detalle", "id_superficie");
            sql = new StringBuilder("INSERT INTO Superficies_detalle VALUES(");
            sql.append(this.id_superficie).append(",");
            sql.append(this.id_caracteristica_inm.getId_caracteristica_inm()).append(",");
            sql.append(this.superficie_total_terreno).append(",");
            sql.append(this.superficie_terreno).append(",");
            sql.append(this.superficie_construccion).append(",");
            sql.append(this.supercie_acentada_escritura).append(",");
            sql.append(this.indiviso_terreno).append(",");
            sql.append(this.indiviso_areas_comunes).append(",");
            sql.append(this.indiviso_accesoria).append(",");
            sql.append(this.superficie_vendible).append(",");
            sql.append("GETDATE()").append(",");
            sql.append(this.activo ? "1" : "0");
            sql.append(")");
            err = UtilDB.ejecutaSQL(sql.toString());
            if (err.getNumeroError() == 0) {
                this._existe = true;
            }
        } else {
            sql = new StringBuilder("UPDATE Superficies_detalle SET ");
            sql.append("superficie_total_terreno=").append(this.superficie_total_terreno).append(",");
            sql.append("superficie_terreno=").append(this.superficie_terreno).append(",");
            sql.append("superficie_construccion=").append(this.superficie_construccion).append(",");
            sql.append("supercie_acentada_escritura=").append(this.supercie_acentada_escritura).append(",");
            sql.append("indiviso_terreno=").append(this.indiviso_terreno).append(",");
            sql.append("indiviso_areas_comunesP").append(this.indiviso_areas_comunes).append(",");
            sql.append("indiviso_accesoria=").append(this.indiviso_accesoria).append(",");
            sql.append("superficie_vendible=").append(this.superficie_vendible).append(",");
            sql.append("activo=").append(this.activo ? "1" : "0");
            sql.append(" WHERE id_superficie=").append(this.id_superficie).append(" AND  id_caracteristica_inm=").append(this.id_caracteristica_inm.getId_caracteristica_inm());
            err = UtilDB.ejecutaSQL(sql.toString());
        }

        return err;
    }

    private void cargar() {
        String sql = "SELECT * FROM ﻿Superficies_detalle WHERE id_superficie=" + this.id_superficie + " AND id_caracteristica_inm=" + this.id_caracteristica_inm.getId_caracteristica_inm();
        Resultados rst = UtilDB.ejecutaConsulta(sql);
        if (rst.next()) {
            cargar(rst);
        }
        rst.close();
    }

    private void cargar(Resultados rst) {
        this.id_superficie = rst.getInt("id_superficie");
        this.id_caracteristica_inm = new CaracteristicaInmueble(rst.getInt("id_caracteristica_inm"));
        this.superficie_total_terreno = rst.getFloat("superficie_total_terreno");
        this.superficie_terreno = rst.getFloat("superficie_terreno");
        this.superficie_construccion = rst.getFloat("superficie_construccion");
        this.supercie_acentada_escritura = rst.getFloat("supercie_acentada_escritura");
        this.indiviso_terreno = rst.getFloat("indiviso_terreno");
        this.indiviso_areas_comunes = rst.getFloat("indiviso_areas_comunes");
        this.indiviso_accesoria = rst.getFloat("indiviso_accesoria");
        this.superficie_vendible = rst.getFloat("superficie_vendible");
        this.fecha_registro = rst.getCalendar("fecha_registro");
        this.activo = rst.getBoolean("activo");
        this._existe = true;
    }

}
