package mx.blogspot.webxico.comun;

import java.util.Hashtable;
import java.util.Vector;

public class PermisosUsuario {

    public PermisosUsuario() {
        limpia();
    }

    public PermisosUsuario(int clave) {
        limpia();
        this.cveUsuario = clave;
        carga();
    }

    public PermisosUsuario(Usuario user) {
        limpia();
        this.cveUsuario = user.getClave();
        carga();
    }

    private void limpia() {
        tabla = new Hashtable();
        cveUsuario = 0;
    }

    public void setUsuario(int clave) {
        this.cveUsuario = clave;
        carga();
    }

    public void setUsuario(Usuario user) {
        this.cveUsuario = user.getClave();
        carga();
    }

    public int getTipoAcceso(int cveModulo) {
        int res = -2;
        if (tabla.containsKey(Utilerias.rellenarCeros(String.valueOf(cveModulo), 3))) {
            res = ((Integer) tabla.get(Utilerias.rellenarCeros(String.valueOf(cveModulo), 3))).intValue();
        }
        return res;
    }

    public int getTipoAcceso(String modulo, int xUniversidad) {
        int res = -2;
        int cveModulo = -1;
        String sqlCorto = String.valueOf(String.valueOf((new StringBuffer("select cve_modulo from informacion_institucional..modulos ")).append(" where ").append("liga=").append(Utilerias.CadenaEncomillada(modulo))));
        Resultados rs = UtilDB.ejecutaConsulta(sqlCorto);
        if (rs.next()) {
            cveModulo = rs.getInt("cve_modulo");
        }
        if (cveModulo >= 0 && tabla.containsKey(Utilerias.rellenarCeros(String.valueOf(cveModulo), 3))) {
            res = ((Integer) tabla.get(Utilerias.rellenarCeros(String.valueOf(cveModulo), 3))).intValue();
        }
        return res;
    }
    
    public Hashtable getTabla() {
        return tabla;
    }

    private void carga() {
        String jerarquia = "";
        int acceso = -2;
        int clave = 0;
        int rol = 0;
        tabla.clear();
        String sql = String.valueOf(String.valueOf((new StringBuffer("select m.cve_modulo, m.jerarquia, pg.rol from informacion_institucional..permisos_grupo pg, informacion_institucional..usuarios_grupo ug, informacion_institucional..modulos m where pg.cve_grupo=ug.cve_grupo and m.cve_modulo=pg.cve_modulo and m.activo=1 and ug.cve_persona=")).append(String.valueOf(cveUsuario)).append(" order by m.jerarquia")));
        Resultados rs = UtilDB.ejecutaConsulta(sql);
        String cad = "";
        while (rs.next()) {
            jerarquia = rs.getString("jerarquia");
            clave = rs.getInt("cve_modulo");
            rol = rs.getInt("rol");
            Vector paso = Utilerias.split(".", jerarquia);
            for (int i = 0; i < paso.size(); i++) {
                cad = (String) paso.elementAt(i);
                if (cad.equals(Utilerias.rellenarCeros(String.valueOf(clave), 3))) {
                    acceso = rol;
                } else {
                    acceso = -1;
                }
                if (!tabla.containsKey(cad)) {
                    tabla.put(cad, new Integer(acceso));
                    continue;
                }
                Integer ip = (Integer) tabla.get(cad);
                if (ip.intValue() < acceso) {
                    tabla.put(cad, new Integer(acceso));
                }
            }

            sql = String.valueOf(String.valueOf((new StringBuffer("select cve_modulo from informacion_institucional..modulos where jerarquia like '")).append(jerarquia).append("%' ").append("order by jerarquia")));
            Resultados res = UtilDB.ejecutaConsulta(sql);
            int cve2 = 0;
            while (res.next()) {
                cve2 = res.getInt("cve_modulo");
                if (cve2 != clave) {
                    cad = Utilerias.rellenarCeros(String.valueOf(cve2), 3);
                    if (!tabla.containsKey(cad)) {
                        tabla.put(cad, new Integer(rol));
                    } else {
                        Integer ip = (Integer) tabla.get(cad);
                        if (ip.intValue() < rol) {
                            tabla.put(cad, new Integer(rol));
                        }
                    }
                }
            }
        }
        rs.close();
    }

    Hashtable tabla;
    int cveUsuario;
    public static final int SIN_ACCESO = -2;
    public static final int CON_ACCESO = -1;
    public static final int OPERADOR = 0;
    public static final int SUPERVISOR = 1;
    public static final int ADMINISTRADOR = 2;
    public static final int CONSULTA = 3;
    public static final int SUPERUSUARIO = 9;

}
