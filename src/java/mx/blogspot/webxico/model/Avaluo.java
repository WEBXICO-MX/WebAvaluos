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

public class Avaluo implements Serializable {

    private int id_avaluo;
    private String numero_avaluo;
    private Valuador id_valuador;
    private Proposito id_proposito;
    private Finalidad id_finalidad;
    private InformacionGeneralInmueble id_informacion_gen;
    private CaracteristicaZona id_caracteristica_zona;
    private CaracteristicaInmueble id_caracteritica_inm;
    private InvestigacionMercado id_investigacion_mercado;
    private AnalisisFisico id_analisis_fisico;
    private Conclusion id_conclusion;
    private float importe_valor_comercial;
    private String importe_valor_comercial_letras;
    private String ruta_plano;
    private Calendar fecha_avaluo;
    private Calendar fecha_registro;
    private boolean activo;
    private boolean _existe;

    public Avaluo() {
        limpiar();
    }

    public Avaluo(int id_avaluo) {
        limpiar();
        this.id_avaluo = id_avaluo;
        cargar();
    }

    public Avaluo(int id_avaluo, String numero_avaluo, Valuador id_valuador, Proposito id_proposito, Finalidad id_finalidad, InformacionGeneralInmueble id_informacion_gen, CaracteristicaZona id_caracteristica_zona, CaracteristicaInmueble id_caracteritica_inm, InvestigacionMercado id_investigacion_mercado, AnalisisFisico id_analisis_fisico, Conclusion id_conclusion, float importe_valor_comercial, String importe_valor_comercial_letras, String ruta_plano, Calendar fecha_avaluo, Calendar fecha_registro, boolean activo) {
        this.id_avaluo = id_avaluo;
        this.numero_avaluo = numero_avaluo;
        this.id_valuador = id_valuador;
        this.id_proposito = id_proposito;
        this.id_finalidad = id_finalidad;
        this.id_informacion_gen = id_informacion_gen;
        this.id_caracteristica_zona = id_caracteristica_zona;
        this.id_caracteritica_inm = id_caracteritica_inm;
        this.id_investigacion_mercado = id_investigacion_mercado;
        this.id_analisis_fisico = id_analisis_fisico;
        this.id_conclusion = id_conclusion;
        this.importe_valor_comercial = importe_valor_comercial;
        this.importe_valor_comercial_letras = importe_valor_comercial_letras;
        this.ruta_plano = ruta_plano;
        this.fecha_avaluo = fecha_avaluo;
        this.fecha_registro = fecha_registro;
        this.activo = activo;
    }

    private void limpiar() {
        this.id_avaluo = 0;
        this.numero_avaluo = "";
        this.id_valuador = null;
        this.id_proposito = null;
        this.id_finalidad = null;
        this.id_informacion_gen = null;
        this.id_caracteristica_zona = null;
        this.id_caracteritica_inm = null;
        this.id_investigacion_mercado = null;
        this.id_analisis_fisico = null;
        this.id_conclusion = null;
        this.importe_valor_comercial = 0.0f;
        this.importe_valor_comercial_letras = "";
        this.ruta_plano = "";
        this.fecha_avaluo = null;
        this.fecha_registro = null;
        this.activo = false;
        this._existe = false;
    }

    public int getId_avaluo() {
        return id_avaluo;
    }

    public void setId_avaluo(int id_avaluo) {
        this.id_avaluo = id_avaluo;
    }

    public String getNumero_avaluo() {
        return numero_avaluo;
    }

    public void setNumero_avaluo(String numero_avaluo) {
        this.numero_avaluo = numero_avaluo;
    }

    public Valuador getId_valuador() {
        return id_valuador;
    }

    public void setId_valuador(Valuador id_valuador) {
        this.id_valuador = id_valuador;
    }

    public Proposito getId_proposito() {
        return id_proposito;
    }

    public void setId_proposito(Proposito id_proposito) {
        this.id_proposito = id_proposito;
    }

    public Finalidad getId_finalidad() {
        return id_finalidad;
    }

    public void setId_finalidad(Finalidad id_finalidad) {
        this.id_finalidad = id_finalidad;
    }

    public InformacionGeneralInmueble getId_informacion_gen() {
        return id_informacion_gen;
    }

    public void setId_informacion_gen(InformacionGeneralInmueble id_informacion_gen) {
        this.id_informacion_gen = id_informacion_gen;
    }

    public CaracteristicaZona getId_caracteristica_zona() {
        return id_caracteristica_zona;
    }

    public void setId_caracteristica_zona(CaracteristicaZona id_caracteristica_zona) {
        this.id_caracteristica_zona = id_caracteristica_zona;
    }

    public CaracteristicaInmueble getId_caracteritica_inm() {
        return id_caracteritica_inm;
    }

    public void setId_caracteritica_inm(CaracteristicaInmueble id_caracteritica_inm) {
        this.id_caracteritica_inm = id_caracteritica_inm;
    }

    public InvestigacionMercado getId_investigacion_mercado() {
        return id_investigacion_mercado;
    }

    public void setId_investigacion_mercado(InvestigacionMercado id_investigacion_mercado) {
        this.id_investigacion_mercado = id_investigacion_mercado;
    }

    public AnalisisFisico getId_analisis_fisico() {
        return id_analisis_fisico;
    }

    public void setId_analisis_fisico(AnalisisFisico id_analisis_fisico) {
        this.id_analisis_fisico = id_analisis_fisico;
    }

    public Conclusion getId_conclusion() {
        return id_conclusion;
    }

    public void setId_conclusion(Conclusion id_conclusion) {
        this.id_conclusion = id_conclusion;
    }

    public float getImporte_valor_comercial() {
        return importe_valor_comercial;
    }

    public void setImporte_valor_comercial(float importe_valor_comercial) {
        this.importe_valor_comercial = importe_valor_comercial;
    }

    public String getImporte_valor_comercial_letras() {
        return importe_valor_comercial_letras;
    }

    public void setImporte_valor_comercial_letras(String importe_valor_comercial_letras) {
        this.importe_valor_comercial_letras = importe_valor_comercial_letras;
    }

    public String getRuta_plano() {
        return ruta_plano;
    }

    public void setRuta_plano(String ruta_plano) {
        this.ruta_plano = ruta_plano;
    }

    public Calendar getFecha_avaluo() {
        return fecha_avaluo;
    }

    public void setFecha_avaluo(Calendar fecha_avaluo) {
        this.fecha_avaluo = fecha_avaluo;
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
        return "Avaluo{" + "id_avaluo=" + id_avaluo + ", numero_avaluo=" + numero_avaluo + ", id_valuador=" + id_valuador + ", id_proposito=" + id_proposito + ", id_finalidad=" + id_finalidad + ", id_informacion_gen=" + id_informacion_gen + ", id_caracteristica_zona=" + id_caracteristica_zona + ", id_caracteritica_inm=" + id_caracteritica_inm + ", id_investigacion_mercado=" + id_investigacion_mercado + ", id_analisis_fisico=" + id_analisis_fisico + ", id_conclusion=" + id_conclusion + ", importe_valor_comercial=" + importe_valor_comercial + ", importe_valor_comercial_letras=" + importe_valor_comercial_letras + ", ruta_plano=" + ruta_plano + ", fecha_avaluo=" + fecha_avaluo + ", fecha_registro=" + fecha_registro + ", activo=" + activo + '}';
    }

    public ErrorSistema grabar() {
        ErrorSistema err;
        StringBuilder sql;

        if (!this._existe) {
            this.id_avaluo = UtilDB.getSiguienteNumero("Avaluos", "id_avaluo");
            sql = new StringBuilder("INSERT INTO Avaluos VALUES(");
            sql.append("").append(",");
            sql.append("").append(",");
            sql.append("").append(",");
            sql.append("").append(",");
            sql.append("").append(",");
            sql.append("").append(",");
            sql.append("").append(",");
            sql.append("").append(",");
            sql.append("").append(",");
            sql.append("").append(",");
            sql.append("").append(",");
            sql.append("").append(",");
            sql.append("").append(",");
            sql.append("").append(",");
            sql.append("").append(",");
            sql.append("").append(",");
            sql.append("").append(",");
            sql.append(")");
            err = UtilDB.ejecutaSQL(sql.toString());
            if (err.getNumeroError() == 0) {
                this._existe = true;
            }
        } else {
            sql = new StringBuilder("UPDATE Avaluos SET ");
            sql.append("").append("").append(",");
            sql.append("").append("").append(",");
            sql.append("").append("").append(",");
            sql.append("").append("").append(",");
            sql.append("").append("").append(",");
            sql.append("").append("").append(",");
            sql.append("").append("").append(",");
            sql.append("").append("").append(",");
            sql.append("").append("").append(",");
            sql.append("").append("").append(",");
            sql.append("").append("").append(",");
            sql.append("").append("").append(",");
            sql.append("").append("").append(",");
            sql.append("").append("").append(",");
            sql.append("").append("").append(",");
            sql.append(" WHERE id_avaluo = ").append(this.id_avaluo);
            err = UtilDB.ejecutaSQL(sql.toString());
        }

        return err;

    }

    private void cargar() {
        String sql = "SELECT * FROM Avaluos WHERE id_avaluo=" + this.id_avaluo;
        Resultados rst = UtilDB.ejecutaConsulta(sql);
        if (rst.next()) {
            cargar(rst);
        }
        rst.close();
    }

    private void cargar(Resultados rst) {
    }

}
