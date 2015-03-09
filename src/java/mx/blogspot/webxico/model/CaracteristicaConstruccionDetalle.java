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

public class CaracteristicaConstruccionDetalle implements Serializable {

    private int id_caracteritica_construccion;
    private CaracteristicaInmueble id_caracteristica_inm;
    private String cimentacion;
    private String estructuras;
    private String muros;
    private String entrepisos;
    private String techos;
    private String bardas;
    private Calendar fecha_registro;
    private boolean activo;
    private boolean _existe;

    public CaracteristicaConstruccionDetalle() {
        this.limpiar();
    }

    public CaracteristicaConstruccionDetalle(int id_caracteritica_construccion, CaracteristicaInmueble id_caracteristica_inm) {
        this.limpiar();
        this.id_caracteritica_construccion = id_caracteritica_construccion;
        this.id_caracteristica_inm = id_caracteristica_inm;
        this.cargar();
    }

    public CaracteristicaConstruccionDetalle(int id_caracteritica_construccion, CaracteristicaInmueble id_caracteristica_inm, String cimentacion, String estructuras, String muros, String entrepisos, String techos, String bardas, Calendar fecha_registro, boolean activo) {
        this.id_caracteritica_construccion = id_caracteritica_construccion;
        this.id_caracteristica_inm = id_caracteristica_inm;
        this.cimentacion = cimentacion;
        this.estructuras = estructuras;
        this.muros = muros;
        this.entrepisos = entrepisos;
        this.techos = techos;
        this.bardas = bardas;
        this.fecha_registro = fecha_registro;
        this.activo = activo;
    }

    private void limpiar() {
        this.id_caracteritica_construccion = 0;
        this.id_caracteristica_inm = null;
        this.cimentacion = "";
        this.estructuras = "";
        this.muros = "";
        this.entrepisos = "";
        this.techos = "";
        this.bardas = "";
        this.fecha_registro = null;
        this.activo = false;
        this._existe = false;
    }

    public int getId_caracteritica_construccion() {
        return id_caracteritica_construccion;
    }

    public void setId_caracteritica_construccion(int id_caracteritica_construccion) {
        this.id_caracteritica_construccion = id_caracteritica_construccion;
    }

    public CaracteristicaInmueble getId_caracteristica_inm() {
        return id_caracteristica_inm;
    }

    public void setId_caracteristica_inm(CaracteristicaInmueble id_caracteristica_inm) {
        this.id_caracteristica_inm = id_caracteristica_inm;
    }

    public String getCimentacion() {
        return cimentacion;
    }

    public void setCimentacion(String cimentacion) {
        this.cimentacion = cimentacion;
    }

    public String getEstructuras() {
        return estructuras;
    }

    public void setEstructuras(String estructuras) {
        this.estructuras = estructuras;
    }

    public String getMuros() {
        return muros;
    }

    public void setMuros(String muros) {
        this.muros = muros;
    }

    public String getEntrepisos() {
        return entrepisos;
    }

    public void setEntrepisos(String entrepisos) {
        this.entrepisos = entrepisos;
    }

    public String getTechos() {
        return techos;
    }

    public void setTechos(String techos) {
        this.techos = techos;
    }

    public String getBardas() {
        return bardas;
    }

    public void setBardas(String bardas) {
        this.bardas = bardas;
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
        return "CaracteristicaConstruccionDetalle{" + "id_caracteritica_construccion=" + id_caracteritica_construccion + ", id_caracteristica_inm=" + id_caracteristica_inm + ", cimentacion=" + cimentacion + ", estructuras=" + estructuras + ", muros=" + muros + ", entrepisos=" + entrepisos + ", techos=" + techos + ", bardas=" + bardas + ", fecha_registro=" + fecha_registro + ", activo=" + activo + '}';
    }

    public ErrorSistema grabar() {
        ErrorSistema err;
        StringBuilder sql;

        if (!this._existe) {
            this.id_caracteritica_construccion = UtilDB.getSiguienteNumero("Caracteristicas_construccion_detalle", "id_caracteritica_construccion");
            sql = new StringBuilder("INSERT INTO Caracteristicas_construccion_detalle VALUES(");
            sql.append(this.id_caracteritica_construccion).append(",");
            sql.append(this.id_caracteristica_inm.getId_caracteristica_inm()).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.cimentacion)).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.estructuras)).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.muros)).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.entrepisos)).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.techos)).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.bardas)).append(",");
            sql.append("GETDATE()").append(",");
            sql.append(this.activo ? "1" : "0");
            sql.append(")");
            err = UtilDB.ejecutaSQL(sql.toString());
            if (err.getNumeroError() == 0) {
                this._existe = true;
            }
        } else {
            sql = new StringBuilder("UPDATE Caracteristicas_construccion_detalle SET ");
            sql.append("cimentacion=").append(Utilerias.CadenaEncomillada(this.cimentacion)).append(",");
            sql.append("estructuras=").append(Utilerias.CadenaEncomillada(this.estructuras)).append(",");
            sql.append("muros=").append(Utilerias.CadenaEncomillada(this.muros)).append(",");
            sql.append("entrepisos=").append(Utilerias.CadenaEncomillada(this.entrepisos)).append(",");
            sql.append("techos=").append(Utilerias.CadenaEncomillada(this.techos)).append(",");
            sql.append("bardas=").append(Utilerias.CadenaEncomillada(this.bardas)).append(",");
            sql.append("activo=").append(this.activo ? "1" : "0");
            sql.append(" WHERE id_caracteritica_construccion=").append(this.id_caracteritica_construccion);
            sql.append(" AND id_caracteristica_inm=").append(this.id_caracteristica_inm.getId_caracteristica_inm());
            err = UtilDB.ejecutaSQL(sql.toString());
        }

        return err;
    }

    private void cargar() {
        String sql = "SELECT * FROM ﻿Caracteristicas_construccion_detalle WHERE id_caracteritica_construccion=" + this.id_caracteritica_construccion + " AND id_caracteristica_inm=" + this.id_caracteristica_inm.getId_caracteristica_inm();
        Resultados rst = UtilDB.ejecutaConsulta(sql);
        if (rst.next()) {
            cargar(rst);
        }
        rst.close();
    }

    private void cargar(Resultados rst) {
        this.id_caracteritica_construccion = rst.getInt("id_caracteritica_construccion");
        this.id_caracteristica_inm = new CaracteristicaInmueble(rst.getInt("id_caracteristica_inm"));
        this.cimentacion = rst.getString("cimentacion");
        this.estructuras = rst.getString("estructuras");
        this.muros = rst.getString("muros");
        this.entrepisos = rst.getString("entrepisos");
        this.techos = rst.getString("techos");
        this.bardas = rst.getString("bardas");
        this.fecha_registro = rst.getCalendar("fecha_registro");
        this.activo = rst.getBoolean("activo");
        this._existe = true;
    }
}
