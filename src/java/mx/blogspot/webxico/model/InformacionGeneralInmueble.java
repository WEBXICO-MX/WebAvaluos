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

public class InformacionGeneralInmueble implements Serializable {

    private int id_informacion_gen;
    private TipoInmueble id_tipo_inm;
    private ConjuntoHabitacional id_conjunto;
    private Colonia id_colonia;
    private String calle;
    private String numero_o_manzana;
    private String cp;
    private String longuitud;
    private String latitud;
    private String altitud_snm;
    private RegimenPropiedad id_regimen;
    private String cuenta_predial;
    private String clave_catastral;
    private Solicitante id_solicitante;
    private Calendar fecha_registro;
    private boolean activo;
    private boolean _existe;

    public InformacionGeneralInmueble() {
        limpiar();
    }

    public InformacionGeneralInmueble(int id_informacion_gen) {
        limpiar();
        this.id_informacion_gen = id_informacion_gen;
        cargar();
    }

    public InformacionGeneralInmueble(int id_informacion_gen, TipoInmueble id_tipo_inm, ConjuntoHabitacional id_conjunto, Colonia id_colonia, String calle, String numero_o_manzana, String cp, String longuitud, String latitud, String altitud_snm, RegimenPropiedad id_regimen, String cuenta_predial, String clave_catastral, Solicitante id_solicitante, Calendar fecha_registro, boolean activo) {
        this.id_informacion_gen = id_informacion_gen;
        this.id_tipo_inm = id_tipo_inm;
        this.id_conjunto = id_conjunto;
        this.id_colonia = id_colonia;
        this.calle = calle;
        this.numero_o_manzana = numero_o_manzana;
        this.cp = cp;
        this.longuitud = longuitud;
        this.latitud = latitud;
        this.altitud_snm = altitud_snm;
        this.id_regimen = id_regimen;
        this.cuenta_predial = cuenta_predial;
        this.clave_catastral = clave_catastral;
        this.id_solicitante = id_solicitante;
        this.fecha_registro = fecha_registro;
        this.activo = activo;
    }

    private void limpiar() {
        this.id_informacion_gen = 0;
        this.id_tipo_inm = null;
        this.id_conjunto = null;
        this.id_colonia = null;
        this.calle = "";
        this.numero_o_manzana = "";
        this.cp = "";
        this.longuitud = "";
        this.latitud = "";
        this.altitud_snm = "";
        this.id_regimen = null;
        this.cuenta_predial = "";
        this.clave_catastral = "";
        this.id_solicitante = null;
        this.fecha_registro = null;
        this.activo = false;
        this._existe = false;
    }

    public int getId_informacion_gen() {
        return id_informacion_gen;
    }

    public void setId_informacion_gen(int id_informacion_gen) {
        this.id_informacion_gen = id_informacion_gen;
    }

    public TipoInmueble getId_tipo_inm() {
        return id_tipo_inm;
    }

    public void setId_tipo_inm(TipoInmueble id_tipo_inm) {
        this.id_tipo_inm = id_tipo_inm;
    }

    public ConjuntoHabitacional getId_conjunto() {
        return id_conjunto;
    }

    public void setId_conjunto(ConjuntoHabitacional id_conjunto) {
        this.id_conjunto = id_conjunto;
    }

    public Colonia getId_colonia() {
        return id_colonia;
    }

    public void setId_colonia(Colonia id_colonia) {
        this.id_colonia = id_colonia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero_o_manzana() {
        return numero_o_manzana;
    }

    public void setNumero_o_manzana(String numero_o_manzana) {
        this.numero_o_manzana = numero_o_manzana;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getLonguitud() {
        return longuitud;
    }

    public void setLonguitud(String longuitud) {
        this.longuitud = longuitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getAltitud_snm() {
        return altitud_snm;
    }

    public void setAltitud_snm(String altitud_snm) {
        this.altitud_snm = altitud_snm;
    }

    public RegimenPropiedad getId_regimen() {
        return id_regimen;
    }

    public void setId_regimen(RegimenPropiedad id_regimen) {
        this.id_regimen = id_regimen;
    }

    public String getCuenta_predial() {
        return cuenta_predial;
    }

    public void setCuenta_predial(String cuenta_predial) {
        this.cuenta_predial = cuenta_predial;
    }

    public String getClave_catastral() {
        return clave_catastral;
    }

    public void setClave_catastral(String clave_catastral) {
        this.clave_catastral = clave_catastral;
    }

    public Solicitante getId_solicitante() {
        return id_solicitante;
    }

    public void setId_solicitante(Solicitante id_solicitante) {
        this.id_solicitante = id_solicitante;
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
        return "InformacionGeneralInmueble{" + "id_informacion_gen=" + id_informacion_gen + ", id_tipo_inm=" + id_tipo_inm + ", id_conjunto="
                + id_conjunto + ", id_colonia=" + id_colonia + ", calle=" + calle + ", numero_o_manzana=" + numero_o_manzana + ", cp=" + cp + ", longuitud="
                + longuitud + ", latitud=" + latitud + ", altitud_snm=" + altitud_snm + ", id_regimen=" + id_regimen + ", cuenta_predial=" + cuenta_predial + ", clave_catastral=" + clave_catastral
                + ", id_solicitante=" + id_solicitante + ", fecha_registro=" + fecha_registro + ", activo=" + activo + '}';
    }

    private ErrorSistema grabar() {
        ErrorSistema err;
        StringBuilder sql;

        if (!this._existe) {
            this.id_informacion_gen = UtilDB.getSiguienteNumero("Informacion_genenal_inmueble", "id_informacion_gen");
            sql = new StringBuilder("INSERT INTO Informacion_genenal_inmueble VALUES(");
            sql.append(this.id_informacion_gen).append(",");
            sql.append(this.id_tipo_inm.getId_tipo_inm()).append(",");
            sql.append(this.id_conjunto != null ? this.id_conjunto.getId_conjunto() : "NULL").append(",");
            sql.append(this.id_colonia.getId_colonia()).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.calle)).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.numero_o_manzana)).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.cp)).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.longuitud)).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.latitud)).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.altitud_snm)).append(",");
            sql.append(this.id_regimen.getId_regimen()).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.cuenta_predial)).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.clave_catastral)).append(",");
            sql.append(this.id_solicitante.getId_solicitante().getId_persona()).append(",");
            sql.append("GERTDATE()").append(",");
            sql.append(this.activo ? "1" : "0");
            sql.append(")");
            err = UtilDB.ejecutaSQL(sql.toString());
            if (err.getNumeroError() == 0) {
                this._existe = true;
            }

        } else {
            sql = new StringBuilder("UPDATE Informacion_genenal_inmueble SET ");
            sql.append("id_tipo_inm =").append(this.id_tipo_inm.getId_tipo_inm()).append(",");
            sql.append("id_conjunto =").append(this.id_conjunto != null ? this.id_conjunto.getId_conjunto() : "NULL").append(",");
            sql.append("id_colonia =").append(this.id_colonia.getId_colonia()).append(",");
            sql.append("calle =").append(Utilerias.CadenaEncomillada(this.calle)).append(",");
            sql.append("numero_o_manzana =").append(Utilerias.CadenaEncomillada(this.numero_o_manzana)).append(",");
            sql.append("cp = ").append(Utilerias.CadenaEncomillada(this.cp)).append(",");
            sql.append("longuitud = ").append(Utilerias.CadenaEncomillada(this.longuitud)).append(",");
            sql.append("latitud = ").append(Utilerias.CadenaEncomillada(this.latitud)).append(",");
            sql.append("altitud_snm = ").append(Utilerias.CadenaEncomillada(this.altitud_snm)).append(",");
            sql.append("id_regimen = ").append(this.id_regimen.getId_regimen()).append(",");
            sql.append("cuenta_predial =").append(Utilerias.CadenaEncomillada(this.cuenta_predial)).append(",");
            sql.append("clave_catastral =").append(Utilerias.CadenaEncomillada(this.clave_catastral)).append(",");
            sql.append("id_solicitante = ").append(this.id_solicitante.getId_solicitante().getId_persona()).append(",");
            sql.append("activo =").append(this.activo ? "1" : "0");
            sql.append(" WHERE id_informacion_gen =").append(this.id_informacion_gen);
            err = UtilDB.ejecutaSQL(sql.toString());
        }
        return err;

    }

    private void cargar() {
        String sql = "SELECT * FROM ﻿Informacion_genenal_inmueble WHERE id_informacion_gen =" + this.id_informacion_gen;
        Resultados rst = UtilDB.ejecutaConsulta(sql);
        if (rst.next()) {
            cargar(rst);
        }
        rst.close();
    }

    private void cargar(Resultados rst) {
        this.id_informacion_gen = rst.getInt("id_informacion_gen");
        this.id_tipo_inm = new TipoInmueble(rst.getInt("id_tipo_inm"));
        this.id_conjunto = new ConjuntoHabitacional(rst.getInt("id_conjunto"));
        this.id_colonia = new Colonia(rst.getInt("id_colonia"));
        this.calle = rst.getString("calle");
        this.numero_o_manzana = rst.getString("numero_o_manzana");
        this.cp = rst.getString("cp");
        this.longuitud = rst.getString("longuitud");
        this.latitud = rst.getString("latitud");
        this.altitud_snm = rst.getString("altitud_snm");
        this.id_regimen = new RegimenPropiedad(rst.getInt("id_regimen"));
        this.cuenta_predial = rst.getString("cuenta_predial");
        this.clave_catastral = rst.getString("clave_catastral");
        this.id_solicitante = new Solicitante(new Persona(rst.getInt("id_solicitante")));
        this.fecha_registro = rst.getCalendar("fecha_registro");
        this.activo = rst.getBoolean("activo");
        this._existe = false;
    }
}
