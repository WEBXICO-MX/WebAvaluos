package mx.blogspot.webxico.comun;

public class Persona {

    protected int clave;
    protected TipoPersona cve_tipo_persona;
    protected String nombre;
    protected String apPaterno;
    protected String apMaterno;
    private boolean _existe;
    public static final String FEMENINO = "M";
    public static final String MASCULINO = "H";
    public static final int ORDEN_APELLIDOS_NOMBRE = 1;
    public static final int ORDEN_NOMBRE_APELLIDOS = 0;

    public Persona(int xCve) {
        limpiar();
        if (xCve > 0) {
            setClave(xCve);
        }
    }

    public Persona() {
        limpiar();
    }

    public String getApellidoMaterno() {
        return apMaterno;
    }

    public String getApellidoPaterno() {
        return apPaterno;
    }

    public int getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreCompleto() {
        return String.valueOf(String.valueOf((new StringBuilder(String.valueOf(String.valueOf(nombre)))).append(" ").append(apPaterno).append(" ").append(apMaterno)));
    }

    public String getNombreCompleto(int tipo) {
        if (tipo == 1) {
            return String.valueOf(String.valueOf((new StringBuilder(String.valueOf(String.valueOf(apPaterno)))).append(" ").append(apMaterno).append(" ").append(nombre)));
        } else {
            return String.valueOf(String.valueOf((new StringBuilder(String.valueOf(String.valueOf(nombre)))).append(" ").append(apPaterno).append(" ").append(apMaterno)));
        }
    }

    public void setApellidoMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public void setApellidoPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public void setClave(int clave) {
        this.clave = clave;
        cargar();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoPersona getCve_tipo_persona() {
        return cve_tipo_persona;
    }

    public void setCve_tipo_persona(TipoPersona cve_tipo_persona) {
        this.cve_tipo_persona = cve_tipo_persona;
    }

    public void limpiar() {
        this.clave = 0;
        this.cve_tipo_persona = null;
        this.nombre = "";
        this.apPaterno = "";
        this.apMaterno = "";
        this._existe = false;
    }

    public void cargar() {
        StringBuilder sql = new StringBuilder("SELECT * FROM informacion_institucional..personas ");
        sql.append(" WHERE cve_persona   = ").append(this.clave);
        Resultados rs = UtilDB.ejecutaConsulta(sql.toString());
        if (rs.next()) {
            cargar(rs);
        }
        rs.close();
        rs = null;
    }

    public void cargar(Resultados rs) {
        this.clave = rs.getInt("cve_persona");
        this.cve_tipo_persona = new TipoPersona(rs.getInt("cve_tipo_persona"));
        this.nombre = rs.getString("nombre");
        this.apPaterno = rs.getString("apellido_pat");
        this.apMaterno = rs.getString("apellido_mat");
        this._existe = true;
    }

    public boolean existe() {
        return _existe;
    }

    private ErrorSistema validar() {
        ErrorSistema err = new ErrorSistema();
        if (nombre.equals("")) {
            err.setCadenaError(String.valueOf(String.valueOf(err.getCadenaError())).concat("No esta asignado el nombre\n"));
        }
        if (apPaterno.equals("")) {
            err.setCadenaError(String.valueOf(String.valueOf(err.getCadenaError())).concat("No esta asignado el apellido paterno\n"));
        }
        if (!err.getCadenaError().equals("")) {
            err.setNumeroError(-1);
        }
        return err;
    }

    public ErrorSistema grabar() {
        ErrorSistema err = validar();
        StringBuilder sb = new StringBuilder();

        if (err.getNumeroError() == 0) {
            if (!_existe) {
                clave = UtilDB.getSiguienteNumero("informacion_institucional..personas", "cve_persona");
                sb.append(" insert into informacion_institucional..personas (cve_persona,cve_tipo_persona, nombre, apellido_pat, apellido_mat ) ");
                sb.append(" values (");
                sb.append(this.clave).append(",");
                sb.append(this.cve_tipo_persona.getCve_tipo_persona()).append(",");
                sb.append(Utilerias.CadenaEncomillada(this.nombre)).append(",");
                sb.append(Utilerias.CadenaEncomillada(this.apPaterno)).append(",");
                sb.append(Utilerias.CadenaEncomillada(this.apMaterno));
                sb.append(")");
                err = UtilDB.ejecutaSQL(sb.toString());
                if (err.getNumeroError() == 0) {
                    _existe = true;
                }
            } else {
                sb.append("update informacion_institucional..personas set ");
                sb.append("nombre= ").append(Utilerias.CadenaEncomillada(nombre)).append(", ");
                sb.append("apellido_pat=").append(Utilerias.CadenaEncomillada(apPaterno)).append(", ");
                sb.append("apellido_mat=").append(Utilerias.CadenaEncomillada(apMaterno)).append(", ");
                sb.append(" WHERE cve_persona =").append(clave);
                err = UtilDB.ejecutaSQL(sb.toString());
                _existe = true;
            }
        }
        return err;
    }

    public ErrorSistema borrar() {
        ErrorSistema err = new ErrorSistema();
        err.setCadenaError("No se puede borrar la informaci\363n de una persona");
        err.setNumeroError(-1);
        return err;
    }
}
