package mx.blogspot.webxico.comun;

import java.util.Calendar;

public class Periodo {

    public Periodo() {
        limpia();
    }

    public Periodo(int xValor) {
        limpia();
        setClave(xValor);
    }

    private void limpia() {
        cvePeriodo = 0;
        fechaInicio = Calendar.getInstance();
        fechaFin = Calendar.getInstance();
        numPeriodo = 0;
        anio = 0;
        _existe = false;
    }

    public int getClave() {
        return cvePeriodo;
    }

    public void setClave(int cvePeriodo) {
        this.cvePeriodo = cvePeriodo;
        cargar();
    }

    public Calendar getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Calendar fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setFechaInicio(Calendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Calendar getFechaInicio() {
        return fechaInicio;
    }

    public int getNumPeriodo() {
        return numPeriodo;
    }

    public void setNumPeriodo(int numPeriodo) {
        this.numPeriodo = numPeriodo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public ErrorSistema grabar() {
        ErrorSistema err = validar();
        if (err.getNumeroError() == 0) {
            if (!_existe) {
                cvePeriodo = UtilDB.getSiguienteNumero("informacion_institucional..periodos", "cve_periodo");
                String c[] = {
                    "cve_periodo", "numero_periodo", "fecha_inicio", "fecha_fin", "anio"
                };
                String v[] = {
                    String.valueOf(cvePeriodo), String.valueOf(numPeriodo), Utilerias.formatoFechaDB(fechaInicio), Utilerias.formatoFechaDB(fechaFin), String.valueOf(anio)
                };
                err = UtilDB.insertaDatos("informacion_institucional..periodos", c, v);
            } else {
                StringBuilder cadSQL = new StringBuilder("update informacion_institucional..periodos set numero_periodo=").append(String.valueOf(numPeriodo)).append(", ").append("fecha_inicio=").append(Utilerias.formatoFechaDB(fechaInicio)).append(", ").append("fecha_fin=").append(Utilerias.formatoFechaDB(fechaFin)).append(", ").append("anio=").append(String.valueOf(anio)).append(" where cve_periodo=").append(String.valueOf(cvePeriodo));
                err = UtilDB.ejecutaSQL(cadSQL.toString());
            }
        }
        return err;
    }

    private ErrorSistema validar() {
        ErrorSistema err = new ErrorSistema();
        if (fechaInicio.after(fechaFin)) {
            err.setCadenaError(String.valueOf(String.valueOf(err.getCadenaError())).concat("La fecha de inicio es mayor que la fecha final\n"));
        }
        if (fechaInicio.equals(fechaFin)) {
            err.setCadenaError(String.valueOf(String.valueOf(err.getCadenaError())).concat("La fecha de inicio es igual que la fecha final\n"));
        }
        return err;
    }

    public void cargar() {
        String cadSQL = "select * from informacion_institucional..periodos where cve_periodo=" + cvePeriodo;
        Resultados res = UtilDB.ejecutaConsulta(cadSQL);
        if (res.next()) {
            cargar(res);
        }
        res.close();
    }

    public void cargar(Resultados res) {
        cvePeriodo = res.getInt("cve_periodo");
        numPeriodo = res.getInt("numero_periodo");
        fechaInicio = res.getCalendar("fecha_inicio");
        fechaFin = res.getCalendar("fecha_fin");
        anio = res.getInt("ano");
        _existe = true;
    }

    public boolean existe() {
        return _existe;
    }

    public ErrorSistema borrar() {
        return new ErrorSistema();
    }

    public boolean esAnterior(Periodo periodo) {
        boolean anterior = false;
        if (periodo != null && fechaInicio.after(periodo.getFechaFin())) {
            anterior = true;
        }
        return anterior;
    }

    public boolean esPosterior(Periodo periodo) {
        boolean posterior = false;
        if (periodo != null && fechaFin.before(periodo.getFechaInicio())) {
            posterior = true;
        }
        return posterior;
    }

    public String getRangoFechas() {
        String periodoActual = "";

        if (getClave() != 0) {
            switch (getFechaInicio().get(Calendar.MONTH) + 1) {
                case 1:
                    periodoActual = "Enero";
                    break;
                case 4:
                case 5:
                    periodoActual = "Mayo";
                    break;
                case 8:
                case 9:
                    periodoActual = "Septiembre";
                    break;
            }
            periodoActual += " - ";
            switch (getFechaFin().get(Calendar.MONTH) + 1) {
                case 4:
                case 5:
                    periodoActual += "Abril ";
                    break;
                case 8:
                case 9:
                    periodoActual += "Agosto ";
                    break;
                case 12:
                    periodoActual += "Diciembre ";
                    break;
            }
            periodoActual += getAnio();
        }
        return periodoActual;
    }

    public boolean esIgual(Periodo periodo) {
        boolean igual = false;
        if (periodo != null && fechaInicio.equals(periodo.getFechaInicio()) && fechaFin.equals(periodo.getFechaFin())) {
            igual = true;
        }
        return igual;
    }

    public boolean esVigente(Periodo periodo) {
        boolean vigente = false;
        if (periodo != null && (Calendar.getInstance().equals(periodo.getFechaInicio()) || Calendar.getInstance().after(periodo.getFechaInicio())) && (Calendar.getInstance().equals(periodo.getFechaFin()) || Calendar.getInstance().before(periodo.getFechaFin()))) {
            vigente = true;
        }
        return vigente;
    }

    protected int cvePeriodo;
    protected int numPeriodo;
    protected Calendar fechaInicio;
    protected Calendar fechaFin;
    protected int anio;
    private boolean _existe;
}
