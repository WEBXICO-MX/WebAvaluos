/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */

package mx.blogspot.webxico.model;

import java.io.Serializable;
import java.util.Calendar;

public class ClasificacionConstruccionDetalle implements Serializable {
    
    private int id_clasificacion_construccion;
    private AnalisisFisico id_analisis_fisico;
    private ClaseGeneralInmueble id_clase_general_inm;
    private TipoInmueble id_tipo_inm;
    private EstadoConservacion id_estado_conservacion;
    private CalidadProyecto id_calidad_proyecto;
    private int edad_construccion_anios;
    private int edad_util_remanente;
    private int numero_niveles;
    private int nivel_edificio_condominio;
    private float superficie_m2;
    private float vr_nuevo;
    private float factor_edad;
    private float factor_conservacion;
    private float factor_resultante;
    private float vr_neto;
    private float valor_parcial_construccion;
    private Calendar fecha_registro;
    private boolean activo;
    
    
    
    
    
    
    
    
    
    
    
    
    

}
