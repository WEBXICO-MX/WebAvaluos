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

public class CaracteristicaInmueble implements Serializable {

    private int id_caracteristica_inm;
    private String ruta_croquis_localizacion;
    private String ruta_fachada;
    private UsoSuelo id_uso_suelo;
    private String servidumbre_restricciones;
    private int numero_niveles_unidad;
    private int u_ren_estructura;
    private String descripcion_general;
    private Calendar fecha_registro;
    private boolean activo;
    private boolean _existe;

    public CaracteristicaInmueble() {
        limpiar();
    }

    public CaracteristicaInmueble(int id_caracteristica_inm) {
        limpiar();
        this.id_caracteristica_inm = id_caracteristica_inm;
        cargar();
    }

    public CaracteristicaInmueble(int id_caracteristica_inm, String ruta_croquis_localizacion, String ruta_fachada, UsoSuelo id_uso_suelo, String servidumbre_restricciones, int numero_niveles_unidad, int u_ren_estructura, String descripcion_general, Calendar fecha_registro, boolean activo) {
        this.id_caracteristica_inm = id_caracteristica_inm;
        this.ruta_croquis_localizacion = ruta_croquis_localizacion;
        this.ruta_fachada = ruta_fachada;
        this.id_uso_suelo = id_uso_suelo;
        this.servidumbre_restricciones = servidumbre_restricciones;
        this.numero_niveles_unidad = numero_niveles_unidad;
        this.u_ren_estructura = u_ren_estructura;
        this.descripcion_general = descripcion_general;
        this.fecha_registro = fecha_registro;
        this.activo = activo;
    }

    private void limpiar() {
        this.id_caracteristica_inm = 0;
        this.ruta_croquis_localizacion = "";
        this.ruta_fachada = "";
        this.id_uso_suelo = null;
        this.servidumbre_restricciones = "";
        this.numero_niveles_unidad = 0;
        this.u_ren_estructura = 0;
        this.descripcion_general = "";
        this.fecha_registro = null;
        this.activo = false;
        this._existe = false;
    }

    public int getId_caracteristica_inm() {
        return id_caracteristica_inm;
    }

    public void setId_caracteristica_inm(int id_caracteristica_inm) {
        this.id_caracteristica_inm = id_caracteristica_inm;
    }

    public String getRuta_croquis_localizacion() {
        return ruta_croquis_localizacion;
    }

    public void setRuta_croquis_localizacion(String ruta_croquis_localizacion) {
        this.ruta_croquis_localizacion = ruta_croquis_localizacion;
    }

    public String getRuta_fachada() {
        return ruta_fachada;
    }

    public void setRuta_fachada(String ruta_fachada) {
        this.ruta_fachada = ruta_fachada;
    }

    public UsoSuelo getId_uso_suelo() {
        return id_uso_suelo;
    }

    public void setId_uso_suelo(UsoSuelo id_uso_suelo) {
        this.id_uso_suelo = id_uso_suelo;
    }

    public String getServidumbre_restricciones() {
        return servidumbre_restricciones;
    }

    public void setServidumbre_restricciones(String servidumbre_restricciones) {
        this.servidumbre_restricciones = servidumbre_restricciones;
    }

    public int getNumero_niveles_unidad() {
        return numero_niveles_unidad;
    }

    public void setNumero_niveles_unidad(int numero_niveles_unidad) {
        this.numero_niveles_unidad = numero_niveles_unidad;
    }

    public int getU_ren_estructura() {
        return u_ren_estructura;
    }

    public void setU_ren_estructura(int u_ren_estructura) {
        this.u_ren_estructura = u_ren_estructura;
    }

    public String getDescripcion_general() {
        return descripcion_general;
    }

    public void setDescripcion_general(String descripcion_general) {
        this.descripcion_general = descripcion_general;
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
        return "CaracteristicaInmueble{" + "id_caracteristica_inm=" + id_caracteristica_inm + ", ruta_croquis_localizacion=" + ruta_croquis_localizacion + ", ruta_fachada=" + ruta_fachada
                + ", id_uso_suelo=" + id_uso_suelo + ", servidumbre_restricciones=" + servidumbre_restricciones + ", numero_niveles_unidad=" + numero_niveles_unidad
                + ", u_ren_estructura=" + u_ren_estructura + ", descripcion_general=" + descripcion_general + ", fecha_registro=" + fecha_registro + ", activo=" + activo + '}';
    }

    public ErrorSistema grabar() {
        ErrorSistema err;
        StringBuilder sql;

        if (!this._existe) {
            this.id_caracteristica_inm = UtilDB.getSiguienteNumero("Caracteristicas_inmueble", "id_caracteristica_inm");
            sql = new StringBuilder("INSERT INTO Caracteristicas_inmueble VALUES(");
            sql.append(this.id_caracteristica_inm).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.ruta_croquis_localizacion)).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.ruta_fachada)).append(",");
            sql.append(this.id_uso_suelo.getId_uso_suelo()).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.servidumbre_restricciones)).append(",");
            sql.append(this.numero_niveles_unidad).append(",");
            sql.append(this.u_ren_estructura).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.descripcion_general)).append(",");
            sql.append("GETDATE()").append(",");
            sql.append(this.activo ? "1" : "0");
            sql.append(")");
            err = UtilDB.ejecutaSQL(sql.toString());
            if (err.getNumeroError() == 0) {
                this._existe = true;
            }
        } else {
            sql = new StringBuilder("UPDATE Caracteristicas_inmueble SET ");
            sql.append("ruta_croquis_localizacion=").append(Utilerias.CadenaEncomillada(this.ruta_croquis_localizacion)).append(",");
            sql.append("ruta_fachada=").append(Utilerias.CadenaEncomillada(this.ruta_fachada)).append(",");
            sql.append("id_uso_suelo=").append(this.id_uso_suelo.getId_uso_suelo()).append(",");
            sql.append("servidumbre_restricciones=").append(Utilerias.CadenaEncomillada(this.servidumbre_restricciones)).append(",");
            sql.append("numero_niveles_unidad=").append(this.numero_niveles_unidad).append(",");
            sql.append("u_ren_estructura=").append(this.u_ren_estructura).append(",");
            sql.append("descripcion_general=").append(Utilerias.CadenaEncomillada(this.descripcion_general)).append(",");
            sql.append("activo=").append(this.activo ? "1" : "0");
            sql.append(" WHERE id_caracteristica_inm =").append(this.id_caracteristica_inm);
            err = UtilDB.ejecutaSQL(sql.toString());
        }

        return err;

    }

    private void cargar() {
        String sql = "SELECT * FROM Caracteristicas_inmueble WHERE id_caracteristica_inm = " + this.id_caracteristica_inm;
        Resultados rst = UtilDB.ejecutaConsulta(sql);
        if (rst.next()) {
            cargar(rst);
        }
        rst.close();
    }

    private void cargar(Resultados rst) {
        this.id_caracteristica_inm = rst.getInt("id_caracteristica_inm");
        this.ruta_croquis_localizacion = rst.getString("ruta_croquis_localizacion");
        this.ruta_fachada = rst.getString("ruta_fachada");
        this.id_uso_suelo = new UsoSuelo(rst.getInt("id_uso_suelo"));
        this.servidumbre_restricciones = rst.getString("servidumbre_restricciones");
        this.numero_niveles_unidad = rst.getInt("numero_niveles_unidad");
        this.u_ren_estructura = rst.getInt("u_ren_estructura");
        this.descripcion_general = rst.getString("descripcion_general");
        this.fecha_registro = rst.getCalendar("fecha_registro");
        this.activo = rst.getBoolean("activo");
        this._existe = true;
    }
}
