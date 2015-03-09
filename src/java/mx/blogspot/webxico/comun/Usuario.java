package mx.blogspot.webxico.comun;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;

public class Usuario extends Persona {

    protected String loginUsuario;
    protected int clave;
    protected String contrasena;
    protected Calendar fechaAlta;
    protected boolean activo;
    private PermisosUsuario permisos;
    private boolean _existe;
    protected boolean _cambiado;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public Usuario() {
        limpiar();
    }

    public Usuario(int cve) {
        limpiar();
        this.clave = cve;
        cargar();
    }

    public static Usuario existeUsuario(String loginUsuario, int cveUniversidad) {
        Usuario usr = new Usuario();
        String sql = String.valueOf(String.valueOf((new StringBuilder("select p.*, u.login_usuario, u.contrasena, u.fecha_alta, u.activo from informacion_institucional..usuarios u, informacion_institucional..personas p where u.cve_persona=p.cve_persona and u.login_usuario=")).append(Utilerias.CadenaEncomillada(loginUsuario))));
        Resultados res = UtilDB.ejecutaConsulta(sql);
        if (res.next()) {
            usr.cargar(res);
        }
        return usr;
    }

    public static Usuario existeUsuarioUniversidad(String loginUsuario, int cveUniversidad) {
        Usuario usr = new Usuario();
        String sql = String.valueOf(String.valueOf((new StringBuilder("select p.*, u.login_usuario, u.contrasena, u.fecha_alta, u.activo from informacion_institucional..usuarios u, informacion_institucional..personas p where u.cve_persona=p.cve_persona and u.login_usuario=")).append(Utilerias.CadenaEncomillada(loginUsuario)).append(" And ").append("u.cve_Universidad=").append(String.valueOf(cveUniversidad))));
        Resultados res = UtilDB.ejecutaConsulta(sql);
        if (res.next()) {
            usr.cargar(res);
        }
        return usr;
    }

    @Override
    public void limpiar() {
        super.limpiar();
        clave = 0;
        loginUsuario = "";
        contrasena = "";
        fechaAlta = Calendar.getInstance();
        activo = true;
        permisos = null;
        _existe = false;
        _cambiado = false;
    }

    @Override
    public int getClave() {
        return clave;
    }

    public boolean getCambiado() {
        return _cambiado;
    }

    @Override
    public void setClave(int ocv) {
        this.clave = ocv;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String xloginUsuario) {
        loginUsuario = xloginUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = encriptarContrasena(contrasena);
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setCambiado(boolean cambiado) {
        _cambiado = cambiado;
    }

    public boolean esActivo() {
        return activo;
    }

    public Calendar getFechaAlta() {
        return fechaAlta;
    }

    public PermisosUsuario getPermisos() {
        if (permisos == null) {
            permisos = new PermisosUsuario();
            permisos.setUsuario(clave);
        }
        return permisos;
    }

    public String encriptarContrasena(String contrasena) {
        String original = "ABCDEFGHIJKLMN\321OPQRSTUVWXYZabcdefghijklmn\361opqrstuvwxyz1234567890!$%&/()=?\277\241,.-;:_ ";
        String encriptada = "Uqyh.-aJ,g4TPVDE/2WZ15uBC78b3X:_ 6AOHIYrstNFGvcj\361z\321def)=?\277\241omKL90!(i$%&QRklwxnMSp;";
        String temporal = "";
        label0:
        for (int x = 0; x < contrasena.length(); x++) {
            int y = 0;
            do {
                if (y >= original.length()) {
                    continue label0;
                }
                char xContrasena = contrasena.charAt(x);
                char xOriginal = original.charAt(y);
                if (xContrasena == xOriginal) {
                    if ((x + 1) % 2 == 0) {
                        temporal = String.valueOf(temporal) + String.valueOf(encriptada.charAt(y));
                        continue label0;
                    }
                    if (y == encriptada.length()) {
                        temporal = String.valueOf(temporal) + String.valueOf(encriptada.charAt(1));
                    } else {
                        temporal = String.valueOf(temporal) + String.valueOf(encriptada.charAt(y + 1));
                    }
                    continue label0;
                }
                y++;
            } while (true);
        }

        String cadenaEncriptada = temporal;
        return cadenaEncriptada;
    }

    @Override
    public ErrorSistema grabar() {
        String sql = "";
        ErrorSistema err = new ErrorSistema();
        err = super.grabar();
        if (!_existe) {
            sql = String.valueOf(String.valueOf((new StringBuilder("insert into informacion_institucional..usuarios (cve_persona, login_usuario, contrasena, fecha_alta, cambiado, activo) values (")).append(String.valueOf(clave)).append(", ").append(Utilerias.CadenaEncomillada(loginUsuario)).append(", ").append(Utilerias.CadenaEncomillada(contrasena)).append(", ").append(Utilerias.formatoFechaDB(Calendar.getInstance())).append(", ").append(_cambiado ? "1" : "0").append(",").append(activo ? "1" : "0").append(")")));
            err = UtilDB.ejecutaSQL(sql);
        } else {
            sql = String.valueOf(String.valueOf((new StringBuilder("update informacion_institucional..usuarios set login_usuario=")).append(Utilerias.CadenaEncomillada(loginUsuario)).append(", ").append("contrasena=").append(Utilerias.CadenaEncomillada(contrasena)).append(", ").append("activo=").append(activo ? "1" : "0").append(" ").append(",cambiado=").append(_cambiado ? "1" : "0").append(" ").append("where cve_persona=").append(String.valueOf(clave))));
            err = UtilDB.ejecutaSQL(sql);
        }
        return err;
    }

    @Override
    public ErrorSistema borrar() {
        ErrorSistema err = new ErrorSistema();
        if (_existe) {
            activo = false;
            err = grabar();
        }
        limpiar();
        return err;
    }

    @Override
    public void cargar() {
        if (clave == 0) {
            return;
        }
        String sql = String.valueOf(String.valueOf((new StringBuilder("select p.*, u.login_usuario, u.contrasena, u.fecha_alta, u.activo, u.cambiado from informacion_institucional..personas p left join informacion_institucional..usuarios u on (u.cve_persona=p.cve_persona) where p.cve_persona=")).append(String.valueOf(clave))));
        Resultados res = UtilDB.ejecutaConsulta(sql);
        if (res.next()) {
            cargar(res);
        }
        res.close();
    }

    @Override
    public void cargar(Resultados res) {
        super.cargar(res);
        if (!res.isNull("login_usuario")) {
            clave = res.getInt("cve_persona");
            loginUsuario = res.getString("login_usuario");
            contrasena = res.getString("contrasena");
            fechaAlta = res.getCalendar("fecha_alta");
            activo = res.getBoolean("activo");
            _cambiado = res.getBoolean("cambiado");
            _existe = true;
        }
    }

    public void cargarLoginUsuario() {
        if (loginUsuario.equals("")) {
            return;
        }
        String sql = String.valueOf(String.valueOf((new StringBuilder("select p.*, u.login_usuario, u.contrasena, u.fecha_alta, u.activo, u.cambiado from informacion_institucional..personas p left join informacion_institucional..usuarios u on (u.cve_persona=p.cve_persona) where u.login_usuario=")).append(Utilerias.CadenaEncomillada(loginUsuario))));
        Resultados res = UtilDB.ejecutaConsulta(sql);
        if (res.next()) {
            cargar(res);
        }
        res.close();
    }

    @Override
    public boolean existe() {
        return _existe;
    }

    public boolean cambiado() {
        return _cambiado;
    }

    public void generaContrasena() {
        String original = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890ABCDEFGHIJKLMN";
        String temporal = "";
        contrasena = "";
        for (int x = 0; x < 4; x++) {
            int aleatorio = 1 + (int) (Math.random() * (double) 30);
            char xContrasena = original.charAt(aleatorio);
            contrasena = String.valueOf(contrasena) + String.valueOf(xContrasena);
        }

    }

    private boolean accesoIlegalXML(String jsp, String ip, String contextPath, String cadenaRequest) throws FileNotFoundException, JDOMException, IOException {
        String xPath = "/accesosIlegales/acceso/@id[not(. < ../../acceso/@id)][1]";
        boolean creado = false;
        Document document = null;
        Element root = null;
        String nombreXML = contextPath + "\\WEB-INF\\accesosIlegales.xml";
        File xmlFile = new File(nombreXML);
        writeLock.lock();
        try {

            if (xmlFile.exists()) {
                // try to load document from xml file if it exist
                // create a file input stream
                FileInputStream fis = new FileInputStream(xmlFile);
                // create a sax builder to parse the document
                SAXBuilder sb = new SAXBuilder();
                // parse the xml content provided by the file input stream and create a Document object
                document = sb.build(fis);
                // get the root element of the document
                root = document.getRootElement();
                fis.close();

                Element usuario = new Element("acceso")/*.setAttribute("id", String.valueOf(getMaxIdXML(document, xPath) + 1))*/;

                usuario.addContent(new Element("cveUsuario").setText(String.valueOf(this.clave)));
                usuario.addContent(new Element("nombre").setText(getNombreCompleto()));
                usuario.addContent(new Element("jsp").setText(jsp));
                usuario.addContent(new Element("request").setText(cadenaRequest));
                usuario.addContent(new Element("fechaHora").setText(Utilerias.getCadenaFechaHora(Calendar.getInstance())));
                usuario.addContent(new Element("ip").setText(ip));

                root.addContent(usuario);
                document.setContent(root);
                try {

                    FileOutputStream writer = new FileOutputStream(nombreXML);
                    Format format = Format.getPrettyFormat();
                    format.setEncoding("UTF-8");
                    XMLOutputter outputter = new XMLOutputter(format);
                    outputter.setFormat(Format.getPrettyFormat());
                    outputter.output(document, writer);
                    //outputter.output(document, System.out);
                    //System.out.println("Actualizado!!");
                    creado = true;
                    writer.close(); // close writer
                } catch (IOException e) {
                    creado = false;
                }
            } else {
                // si no existe el documento
                try {
                    Element company = new Element("accesosIlegales");
                    Document doc = new Document(company);
                    //doc.setRootElement(company);

                    Element usuario = new Element("acceso")/*.setAttribute(new Attribute("id", "1"))*/;
                    usuario.addContent(new Element("cveUsuario").setText(String.valueOf(this.clave)));
                    usuario.addContent(new Element("nombre").setText(getNombreCompleto()));
                    usuario.addContent(new Element("jsp").setText(jsp));
                    usuario.addContent(new Element("request").setText(cadenaRequest));
                    usuario.addContent(new Element("fechaHora").setText(Utilerias.getCadenaFechaHora(Calendar.getInstance())));
                    usuario.addContent(new Element("ip").setText(ip));

                    doc.getRootElement().addContent(usuario);
                    Format format = Format.getPrettyFormat();
                    format.setEncoding("UTF-8");
                    // new XMLOutputter().output(doc, System.out);
                    XMLOutputter xmlOutput = new XMLOutputter(format);

                    // display nice nice
                    xmlOutput.setFormat(Format.getPrettyFormat());
                    //xmlOutput.output(doc, new FileOutputStream("C:\\Users\\Sistemas\\Documents\\Sistemas\\arch1.xml"));
                    //xmlOutput.output(doc, new FileOutputStream("c:\\file.xml"));
                    xmlOutput.output(doc, new FileOutputStream(nombreXML));
                    //System.out.println("Creado!!");
                    creado = true;
                } catch (IOException io) {
                    System.out.println(io.getMessage());
                    creado = false;
                }
            }
        } finally {
            writeLock.unlock();
        }
        return creado;
    }

    private boolean XMLError(String jsp, String ip, String contextPath, String request, String err) throws FileNotFoundException, JDOMException, IOException {
        String xPath = "/errores/acceso/@id[not(. < ../../acceso/@id)][1]";
        boolean creado = false;
        Document document = null;
        Element root = null;
        String nombreXML = contextPath + "\\WEB-INF\\errores.xml";
        File xmlFile = new File(nombreXML);
        writeLock.lock();
        try {

            if (xmlFile.exists()) {
                // try to load document from xml file if it exist
                // create a file input stream
                FileInputStream fis = new FileInputStream(xmlFile);
                // create a sax builder to parse the document
                SAXBuilder sb = new SAXBuilder();
                // parse the xml content provided by the file input stream and create a Document object
                document = sb.build(fis);
                // get the root element of the document
                root = document.getRootElement();
                fis.close();

                Element usuario = new Element("acceso")/*.setAttribute("id", String.valueOf(getMaxIdXML(document, xPath) + 1))*/;

                usuario.addContent(new Element("cveUsuario").setText(String.valueOf(this.clave)));
                usuario.addContent(new Element("nombre").setText(getNombreCompleto()));
                usuario.addContent(new Element("jsp").setText(jsp));
                usuario.addContent(new Element("fechaHora").setText(Utilerias.getCadenaFechaHora(Calendar.getInstance())));
                usuario.addContent(new Element("ip").setText(ip));
                usuario.addContent(new Element("Excepcion").setText(err));
                usuario.addContent(new Element("parametros").setText(request));

                root.addContent(usuario);
                document.setContent(root);
                try {
                    FileOutputStream writer = new FileOutputStream(nombreXML);
                    Format format = Format.getPrettyFormat();
                    format.setEncoding("UTF-8");
                    XMLOutputter outputter = new XMLOutputter(format);
                    outputter.setFormat(Format.getPrettyFormat());
                    outputter.output(document, writer);
                    //outputter.output(document, System.out);
                    //System.out.println("Actualizado!!");
                    creado = true;
                    writer.close(); // close writer
                } catch (IOException e) {
                    creado = false;
                }
            } else {
                // si no existe el documento
                try {
                    Element company = new Element("errores");
                    Document doc = new Document(company);
                    //doc.setRootElement(company);

                    Element usuario = new Element("acceso")/*.setAttribute(new Attribute("id", "1"))*/;
                    usuario.addContent(new Element("cveUsuario").setText(String.valueOf(this.clave)));
                    usuario.addContent(new Element("nombre").setText(getNombreCompleto()));
                    usuario.addContent(new Element("jsp").setText(jsp));
                    usuario.addContent(new Element("fechaHora").setText(Utilerias.getCadenaFechaHora(Calendar.getInstance())));
                    usuario.addContent(new Element("ip").setText(ip));
                    usuario.addContent(new Element("Excepcion").setText(err));
                    usuario.addContent(new Element("parametros").setText(request));

                    doc.getRootElement().addContent(usuario);
                    Format format = Format.getPrettyFormat();
                    format.setEncoding("UTF-8");
                    // new XMLOutputter().output(doc, System.out);
                    XMLOutputter xmlOutput = new XMLOutputter(format);

                    // display nice nice
                    xmlOutput.setFormat(Format.getPrettyFormat());
                    //xmlOutput.output(doc, new FileOutputStream("C:\\Users\\Sistemas\\Documents\\Sistemas\\arch1.xml"));
                    //xmlOutput.output(doc, new FileOutputStream("c:\\file.xml"));
                    xmlOutput.output(doc, new FileOutputStream(nombreXML));
                    //System.out.println("Creado!!");
                    creado = true;
                } catch (IOException io) {
                    System.out.println(io.getMessage());
                    creado = false;
                }
            }
        } finally {
            writeLock.unlock();
        }
        return creado;
    }

    @Override
    public String toString() {
        return "Usuario{" + "loginUsuario=" + loginUsuario + ", clave=" + clave + ", contrasena=" + contrasena + ", fechaAlta=" + fechaAlta + ", activo=" + activo + ", " + ", permisos=" + permisos + ", _existe=" + _existe + ", _cambiado=" + _cambiado + '}';
    }

}
