package mx.blogspot.webxico.comun;

public class TipoPersona {

    protected int cve_tipo_persona;
    protected String descripcion;
    protected boolean _activo;
    private boolean _existe;

    public TipoPersona() {
        limpiar();
    }

    public TipoPersona(int xCveTipoPersona) {
        limpiar();
        this.cve_tipo_persona = xCveTipoPersona;
        cargar();
    }

    public int getCve_tipo_persona() {
        return cve_tipo_persona;
    }

    public void setCve_tipo_persona(int cve_tipo_persona) {
        this.cve_tipo_persona = cve_tipo_persona;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isActivo() {
        return _activo;
    }

    public void setActivo(boolean _activo) {
        this._activo = _activo;
    }

    public boolean existe() {
        return _existe;
    }

    private void limpiar() {
        this.cve_tipo_persona = 0;
        this.descripcion = "";
        this._activo = false;
        this._existe = false;
    }

    private void cargar() {
        String sql = "SELECT cve_tipo_persona, descripcion, activo FROM informacion_institucional..tipo_persona WHERE cve_tipo_persona=" + this.cve_tipo_persona;
        Resultados res = UtilDB.ejecutaConsulta(sql);
        if (res.next()) {
            cargar(res);
        }
        res.close();
    }

    public void cargar(Resultados res) {
        this.cve_tipo_persona = res.getInt("cve_tipo_persona");
        this.descripcion = res.getString("descripcion");
        this._activo = res.getBoolean("activo");
        this._existe = true;
    }

    public ErrorSistema grabar() {
        StringBuilder SQL;
        if (!this._existe) {
            this.cve_tipo_persona = UtilDB.getSiguienteNumero("informacion_institucional..tipo_persona", "cve_tipo_persona");
            SQL = new StringBuilder("INSERT INTO informacion_institucional..tipo_persona ");
            SQL.append("VALUES (");
            SQL.append(this.cve_tipo_persona).append(",");
            SQL.append(Utilerias.CadenaEncomillada(this.descripcion)).append(",");
            SQL.append(this._activo ? "1" : "0");
            SQL.append(")");

        } else {
            SQL = new StringBuilder("UPDATE informacion_institucional..tipo_persona ");
            SQL.append("SET descripcion = ").append(Utilerias.CadenaEncomillada(this.descripcion)).append(",");
            SQL.append("activo = ").append(this._activo ? "1" : "0");
            SQL.append(" WHERE cve_tipo_persona = ").append(this.cve_tipo_persona);

        }
        ErrorSistema err = UtilDB.ejecutaSQL(SQL.toString());
        return err;
    }

    public ErrorSistema borrar() {
        if (this._existe) {
            this._activo = false;
            return grabar();
        } else {
            return new ErrorSistema();
        }
    }

}
