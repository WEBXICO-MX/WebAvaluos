/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2008                    */
/* Created on:     27/01/2015 16:57:56                          */
/*==============================================================*/


if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ACABADOS_DETALLES') and o.name = 'FK_ACABADOS_REFERENCE_TIPOS_AC')
alter table ACABADOS_DETALLES
   drop constraint FK_ACABADOS_REFERENCE_TIPOS_AC
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ACABADOS_DETALLES') and o.name = 'FK_ACABADOS_REFERENCE_AREAS_CO')
alter table ACABADOS_DETALLES
   drop constraint FK_ACABADOS_REFERENCE_AREAS_CO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ACABADOS_DETALLES') and o.name = 'FK_ACABADOS_REFERENCE_CARACTER')
alter table ACABADOS_DETALLES
   drop constraint FK_ACABADOS_REFERENCE_CARACTER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('AVALUOS') and o.name = 'FK_AVALUOS_REFERENCE_VALUADOR')
alter table AVALUOS
   drop constraint FK_AVALUOS_REFERENCE_VALUADOR
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('AVALUOS') and o.name = 'FK_AVALUOS_REFERENCE_INFORMAC')
alter table AVALUOS
   drop constraint FK_AVALUOS_REFERENCE_INFORMAC
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('AVALUOS') and o.name = 'FK_AVALUOS_REFERENCE_CARACTER2')
alter table AVALUOS
   drop constraint FK_AVALUOS_REFERENCE_CARACTER2
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('AVALUOS') and o.name = 'FK_AVALUOS_REFERENCE_CARACTER')
alter table AVALUOS
   drop constraint FK_AVALUOS_REFERENCE_CARACTER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('AVALUOS') and o.name = 'FK_AVALUOS_REFERENCE_INVESTIG')
alter table AVALUOS
   drop constraint FK_AVALUOS_REFERENCE_INVESTIG
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('AVALUOS') and o.name = 'FK_AVALUOS_REFERENCE_ANALISIS')
alter table AVALUOS
   drop constraint FK_AVALUOS_REFERENCE_ANALISIS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('AVALUOS') and o.name = 'FK_AVALUOS_REFERENCE_CONCLUSI')
alter table AVALUOS
   drop constraint FK_AVALUOS_REFERENCE_CONCLUSI
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('AVALUOS') and o.name = 'FK_AVALUOS_REFERENCE_PROPOSIT')
alter table AVALUOS
   drop constraint FK_AVALUOS_REFERENCE_PROPOSIT
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('AVALUOS') and o.name = 'FK_AVALUOS_REFERENCE_FINALIDA')
alter table AVALUOS
   drop constraint FK_AVALUOS_REFERENCE_FINALIDA
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CARACTERISTICAS_CONSTRUCCION_DETALLE') and o.name = 'FK_CARACTER_REFERENCE_CARACTER')
alter table CARACTERISTICAS_CONSTRUCCION_DETALLE
   drop constraint FK_CARACTER_REFERENCE_CARACTER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CARACTERISTICAS_INMUEBLE') and o.name = 'FK_CARACTER_REFERENCE_USOS_SUE')
alter table CARACTERISTICAS_INMUEBLE
   drop constraint FK_CARACTER_REFERENCE_USOS_SUE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CARACTERISTICAS_ZONA') and o.name = 'FK_CARACTER_REFERENCE_CLASIFIC')
alter table CARACTERISTICAS_ZONA
   drop constraint FK_CARACTER_REFERENCE_CLASIFIC
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CARACTERISTICAS_ZONA') and o.name = 'FK_CARACTER_REFERENCE_PROXIMID')
alter table CARACTERISTICAS_ZONA
   drop constraint FK_CARACTER_REFERENCE_PROXIMID
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CARACTERISTICAS_ZONA_SERVICIOS_MUNICIPALES') and o.name = 'FK_CARACTER_REFERENCE_CARACTER3')
alter table CARACTERISTICAS_ZONA_SERVICIOS_MUNICIPALES
   drop constraint FK_CARACTER_REFERENCE_CARACTER3
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CARACTERISTICAS_ZONA_SERVICIOS_MUNICIPALES') and o.name = 'FK_CARACTER_REFERENCE_SERVICIO')
alter table CARACTERISTICAS_ZONA_SERVICIOS_MUNICIPALES
   drop constraint FK_CARACTER_REFERENCE_SERVICIO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CARACTERITICAS_ZONA_EQUIPAMIENTO_URBANO') and o.name = 'FK_CARACTER_REFERENCE_CARACTER2')
alter table CARACTERITICAS_ZONA_EQUIPAMIENTO_URBANO
   drop constraint FK_CARACTER_REFERENCE_CARACTER2
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CARACTERITICAS_ZONA_EQUIPAMIENTO_URBANO') and o.name = 'FK_CARACTER_REFERENCE_EQUIPAMI')
alter table CARACTERITICAS_ZONA_EQUIPAMIENTO_URBANO
   drop constraint FK_CARACTER_REFERENCE_EQUIPAMI
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CLASIFICACION_CONSTRUCCIONES_DETALLE') and o.name = 'FK_CLASIFIC_REFERENCE_CLASES_G')
alter table CLASIFICACION_CONSTRUCCIONES_DETALLE
   drop constraint FK_CLASIFIC_REFERENCE_CLASES_G
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CLASIFICACION_CONSTRUCCIONES_DETALLE') and o.name = 'FK_CLASIFIC_REFERENCE_TIPOS_IN')
alter table CLASIFICACION_CONSTRUCCIONES_DETALLE
   drop constraint FK_CLASIFIC_REFERENCE_TIPOS_IN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CLASIFICACION_CONSTRUCCIONES_DETALLE') and o.name = 'FK_CLASIFIC_REFERENCE_ESTADOS_')
alter table CLASIFICACION_CONSTRUCCIONES_DETALLE
   drop constraint FK_CLASIFIC_REFERENCE_ESTADOS_
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CLASIFICACION_CONSTRUCCIONES_DETALLE') and o.name = 'FK_CLASIFIC_REFERENCE_CALIDADE')
alter table CLASIFICACION_CONSTRUCCIONES_DETALLE
   drop constraint FK_CLASIFIC_REFERENCE_CALIDADE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CLASIFICACION_CONSTRUCCIONES_DETALLE') and o.name = 'FK_CLASIFIC_REFERENCE_ANALISIS')
alter table CLASIFICACION_CONSTRUCCIONES_DETALLE
   drop constraint FK_CLASIFIC_REFERENCE_ANALISIS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('COLONIAS') and o.name = 'FK_COLONIAS_REFERENCE_MUNICIPI')
alter table COLONIAS
   drop constraint FK_COLONIAS_REFERENCE_MUNICIPI
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('COMUNES_INSTALACIONES_ESPECIALES_OBRAS_COMPLEMENTARIAS') and o.name = 'FK_COMUNES__REFERENCE_ANALISIS')
alter table COMUNES_INSTALACIONES_ESPECIALES_OBRAS_COMPLEMENTARIAS
   drop constraint FK_COMUNES__REFERENCE_ANALISIS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('COMUNES_INSTALACIONES_ESPECIALES_OBRAS_COMPLEMENTARIAS') and o.name = 'FK_COMUNES__REFERENCE_OBRAS_CO')
alter table COMUNES_INSTALACIONES_ESPECIALES_OBRAS_COMPLEMENTARIAS
   drop constraint FK_COMUNES__REFERENCE_OBRAS_CO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('INFORMACION_GENENAL_INMUEBLE') and o.name = 'FK_INFORMAC_REFERENCE_SOLICITA')
alter table INFORMACION_GENENAL_INMUEBLE
   drop constraint FK_INFORMAC_REFERENCE_SOLICITA
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('INFORMACION_GENENAL_INMUEBLE') and o.name = 'FK_INFORMAC_REFERENCE_TIPOS_IN')
alter table INFORMACION_GENENAL_INMUEBLE
   drop constraint FK_INFORMAC_REFERENCE_TIPOS_IN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('INFORMACION_GENENAL_INMUEBLE') and o.name = 'FK_INFORMAC_REFERENCE_CONJUNTO')
alter table INFORMACION_GENENAL_INMUEBLE
   drop constraint FK_INFORMAC_REFERENCE_CONJUNTO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('INFORMACION_GENENAL_INMUEBLE') and o.name = 'FK_INFORMAC_REFERENCE_COLONIAS')
alter table INFORMACION_GENENAL_INMUEBLE
   drop constraint FK_INFORMAC_REFERENCE_COLONIAS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('INFORMACION_GENENAL_INMUEBLE') and o.name = 'FK_INFORMAC_REFERENCE_REGIMENE')
alter table INFORMACION_GENENAL_INMUEBLE
   drop constraint FK_INFORMAC_REFERENCE_REGIMENE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('MEDIDAS_COLINDANCIAS_DETALLE') and o.name = 'FK_MEDIDAS__REFERENCE_CARACTER')
alter table MEDIDAS_COLINDANCIAS_DETALLE
   drop constraint FK_MEDIDAS__REFERENCE_CARACTER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('MUNICIPIOS') and o.name = 'FK_MUNICIPI_REFERENCE_ESTADOS')
alter table MUNICIPIOS
   drop constraint FK_MUNICIPI_REFERENCE_ESTADOS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PRIVATIVAS_INSTALACIONES_ESPECIALES_OBRAS_COMPLEMENTARIAS') and o.name = 'FK_PRIVATIV_REFERENCE_ANALISIS')
alter table PRIVATIVAS_INSTALACIONES_ESPECIALES_OBRAS_COMPLEMENTARIAS
   drop constraint FK_PRIVATIV_REFERENCE_ANALISIS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PRIVATIVAS_INSTALACIONES_ESPECIALES_OBRAS_COMPLEMENTARIAS') and o.name = 'FK_PRIVATIV_REFERENCE_OBRAS_CO')
alter table PRIVATIVAS_INSTALACIONES_ESPECIALES_OBRAS_COMPLEMENTARIAS
   drop constraint FK_PRIVATIV_REFERENCE_OBRAS_CO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PROPIETARIOS') and o.name = 'FK_PROPIETA_REFERENCE_PERSONAS')
alter table PROPIETARIOS
   drop constraint FK_PROPIETA_REFERENCE_PERSONAS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PROPIETARIOS') and o.name = 'FK_PROPIETA_REFERENCE_INFORMAC')
alter table PROPIETARIOS
   drop constraint FK_PROPIETA_REFERENCE_INFORMAC
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('SOLICITANTES') and o.name = 'FK_SOLICITA_REFERENCE_PERSONAS')
alter table SOLICITANTES
   drop constraint FK_SOLICITA_REFERENCE_PERSONAS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('SUPERFICIES_DETALLE') and o.name = 'FK_SUPERFIC_REFERENCE_CARACTER')
alter table SUPERFICIES_DETALLE
   drop constraint FK_SUPERFIC_REFERENCE_CARACTER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('TERRENOS_DETALLE') and o.name = 'FK_TERRENOS_REFERENCE_ANALISIS')
alter table TERRENOS_DETALLE
   drop constraint FK_TERRENOS_REFERENCE_ANALISIS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('VALUADORES') and o.name = 'FK_VALUADOR_REFERENCE_PERSONAS')
alter table VALUADORES
   drop constraint FK_VALUADOR_REFERENCE_PERSONAS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('VENTA_INMUEBLES_SIMILARES_DETALLE') and o.name = 'FK_VENTA_IN_REFERENCE_INVESTIG2')
alter table VENTA_INMUEBLES_SIMILARES_DETALLE
   drop constraint FK_VENTA_IN_REFERENCE_INVESTIG2
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('VENTA_INMUEBLES_SIMILARES_HOMOLACION_DETALLE') and o.name = 'FK_VENTA_IN_REFERENCE_INVESTIG')
alter table VENTA_INMUEBLES_SIMILARES_HOMOLACION_DETALLE
   drop constraint FK_VENTA_IN_REFERENCE_INVESTIG
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('VENTA_TERRENOS_DETALLE') and o.name = 'FK_VENTA_TE_REFERENCE_INVESTIG2')
alter table VENTA_TERRENOS_DETALLE
   drop constraint FK_VENTA_TE_REFERENCE_INVESTIG2
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('VENTA_TERRENOS_HOMOLOGACION_DETALLE') and o.name = 'FK_VENTA_TE_REFERENCE_INVESTIG')
alter table VENTA_TERRENOS_HOMOLOGACION_DETALLE
   drop constraint FK_VENTA_TE_REFERENCE_INVESTIG
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('ACABADOS_DETALLES')
            and   name  = 'INDEX_2'
            and   indid > 0
            and   indid < 255)
   drop index ACABADOS_DETALLES.INDEX_2
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ACABADOS_DETALLES')
            and   type = 'U')
   drop table ACABADOS_DETALLES
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('ANALISIS_FISICO')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index ANALISIS_FISICO.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ANALISIS_FISICO')
            and   type = 'U')
   drop table ANALISIS_FISICO
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('AREAS_CONSIDERAR_ACABADOS')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index AREAS_CONSIDERAR_ACABADOS.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('AREAS_CONSIDERAR_ACABADOS')
            and   type = 'U')
   drop table AREAS_CONSIDERAR_ACABADOS
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('AVALUOS')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index AVALUOS.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('AVALUOS')
            and   type = 'U')
   drop table AVALUOS
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CALIDADES_PROYECTO')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index CALIDADES_PROYECTO.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CALIDADES_PROYECTO')
            and   type = 'U')
   drop table CALIDADES_PROYECTO
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CARACTERISTICAS_CONSTRUCCION_DETALLE')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index CARACTERISTICAS_CONSTRUCCION_DETALLE.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CARACTERISTICAS_CONSTRUCCION_DETALLE')
            and   type = 'U')
   drop table CARACTERISTICAS_CONSTRUCCION_DETALLE
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CARACTERISTICAS_INMUEBLE')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index CARACTERISTICAS_INMUEBLE.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CARACTERISTICAS_INMUEBLE')
            and   type = 'U')
   drop table CARACTERISTICAS_INMUEBLE
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CARACTERISTICAS_ZONA')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index CARACTERISTICAS_ZONA.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CARACTERISTICAS_ZONA')
            and   type = 'U')
   drop table CARACTERISTICAS_ZONA
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CARACTERISTICAS_ZONA_SERVICIOS_MUNICIPALES')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index CARACTERISTICAS_ZONA_SERVICIOS_MUNICIPALES.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CARACTERISTICAS_ZONA_SERVICIOS_MUNICIPALES')
            and   type = 'U')
   drop table CARACTERISTICAS_ZONA_SERVICIOS_MUNICIPALES
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CARACTERITICAS_ZONA_EQUIPAMIENTO_URBANO')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index CARACTERITICAS_ZONA_EQUIPAMIENTO_URBANO.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CARACTERITICAS_ZONA_EQUIPAMIENTO_URBANO')
            and   type = 'U')
   drop table CARACTERITICAS_ZONA_EQUIPAMIENTO_URBANO
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CLASES_GENERALES_INMUEBLES')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index CLASES_GENERALES_INMUEBLES.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CLASES_GENERALES_INMUEBLES')
            and   type = 'U')
   drop table CLASES_GENERALES_INMUEBLES
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CLASIFICACIONES_ZONA')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index CLASIFICACIONES_ZONA.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CLASIFICACIONES_ZONA')
            and   type = 'U')
   drop table CLASIFICACIONES_ZONA
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CLASIFICACION_CONSTRUCCIONES_DETALLE')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index CLASIFICACION_CONSTRUCCIONES_DETALLE.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CLASIFICACION_CONSTRUCCIONES_DETALLE')
            and   type = 'U')
   drop table CLASIFICACION_CONSTRUCCIONES_DETALLE
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('COLONIAS')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index COLONIAS.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('COLONIAS')
            and   type = 'U')
   drop table COLONIAS
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('COMUNES_INSTALACIONES_ESPECIALES_OBRAS_COMPLEMENTARIAS')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index COMUNES_INSTALACIONES_ESPECIALES_OBRAS_COMPLEMENTARIAS.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('COMUNES_INSTALACIONES_ESPECIALES_OBRAS_COMPLEMENTARIAS')
            and   type = 'U')
   drop table COMUNES_INSTALACIONES_ESPECIALES_OBRAS_COMPLEMENTARIAS
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CONCLUSIONES')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index CONCLUSIONES.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CONCLUSIONES')
            and   type = 'U')
   drop table CONCLUSIONES
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CONJUNTOS_HABITACIONALES')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index CONJUNTOS_HABITACIONALES.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CONJUNTOS_HABITACIONALES')
            and   type = 'U')
   drop table CONJUNTOS_HABITACIONALES
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('EQUIPAMIENTO_URBANO')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index EQUIPAMIENTO_URBANO.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('EQUIPAMIENTO_URBANO')
            and   type = 'U')
   drop table EQUIPAMIENTO_URBANO
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('ESTADOS')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index ESTADOS.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ESTADOS')
            and   type = 'U')
   drop table ESTADOS
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('ESTADOS_CONCERVACION')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index ESTADOS_CONCERVACION.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ESTADOS_CONCERVACION')
            and   type = 'U')
   drop table ESTADOS_CONCERVACION
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('FINALIDADES')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index FINALIDADES.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('FINALIDADES')
            and   type = 'U')
   drop table FINALIDADES
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('INFORMACION_GENENAL_INMUEBLE')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index INFORMACION_GENENAL_INMUEBLE.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('INFORMACION_GENENAL_INMUEBLE')
            and   type = 'U')
   drop table INFORMACION_GENENAL_INMUEBLE
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('INVESTIGACION_MERCADO')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index INVESTIGACION_MERCADO.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('INVESTIGACION_MERCADO')
            and   type = 'U')
   drop table INVESTIGACION_MERCADO
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('MEDIDAS_COLINDANCIAS_DETALLE')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index MEDIDAS_COLINDANCIAS_DETALLE.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('MEDIDAS_COLINDANCIAS_DETALLE')
            and   type = 'U')
   drop table MEDIDAS_COLINDANCIAS_DETALLE
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('MUNICIPIOS')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index MUNICIPIOS.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('MUNICIPIOS')
            and   type = 'U')
   drop table MUNICIPIOS
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('OBRAS_COMPLEMENTARIAS')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index OBRAS_COMPLEMENTARIAS.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('OBRAS_COMPLEMENTARIAS')
            and   type = 'U')
   drop table OBRAS_COMPLEMENTARIAS
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PERSONAS')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index PERSONAS.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('PERSONAS')
            and   type = 'U')
   drop table PERSONAS
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PRIVATIVAS_INSTALACIONES_ESPECIALES_OBRAS_COMPLEMENTARIAS')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index PRIVATIVAS_INSTALACIONES_ESPECIALES_OBRAS_COMPLEMENTARIAS.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('PRIVATIVAS_INSTALACIONES_ESPECIALES_OBRAS_COMPLEMENTARIAS')
            and   type = 'U')
   drop table PRIVATIVAS_INSTALACIONES_ESPECIALES_OBRAS_COMPLEMENTARIAS
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PROPIETARIOS')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index PROPIETARIOS.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('PROPIETARIOS')
            and   type = 'U')
   drop table PROPIETARIOS
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PROPOSITOS')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index PROPOSITOS.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('PROPOSITOS')
            and   type = 'U')
   drop table PROPOSITOS
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PROXIMIDADES_URBANAS')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index PROXIMIDADES_URBANAS.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('PROXIMIDADES_URBANAS')
            and   type = 'U')
   drop table PROXIMIDADES_URBANAS
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('REGIMENES_PROPIEDAD')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index REGIMENES_PROPIEDAD.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('REGIMENES_PROPIEDAD')
            and   type = 'U')
   drop table REGIMENES_PROPIEDAD
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('SERVICIOS_MUNICIPALES')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index SERVICIOS_MUNICIPALES.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('SERVICIOS_MUNICIPALES')
            and   type = 'U')
   drop table SERVICIOS_MUNICIPALES
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('SOLICITANTES')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index SOLICITANTES.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('SOLICITANTES')
            and   type = 'U')
   drop table SOLICITANTES
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('SUPERFICIES_DETALLE')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index SUPERFICIES_DETALLE.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('SUPERFICIES_DETALLE')
            and   type = 'U')
   drop table SUPERFICIES_DETALLE
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('TERRENOS_DETALLE')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index TERRENOS_DETALLE.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TERRENOS_DETALLE')
            and   type = 'U')
   drop table TERRENOS_DETALLE
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('TIPOS_ACABADOS')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index TIPOS_ACABADOS.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TIPOS_ACABADOS')
            and   type = 'U')
   drop table TIPOS_ACABADOS
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('TIPOS_INMUEBLES')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index TIPOS_INMUEBLES.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TIPOS_INMUEBLES')
            and   type = 'U')
   drop table TIPOS_INMUEBLES
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('USOS_SUELO')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index USOS_SUELO.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('USOS_SUELO')
            and   type = 'U')
   drop table USOS_SUELO
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('VALUADORES')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index VALUADORES.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('VALUADORES')
            and   type = 'U')
   drop table VALUADORES
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('VENTA_INMUEBLES_SIMILARES_DETALLE')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index VENTA_INMUEBLES_SIMILARES_DETALLE.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('VENTA_INMUEBLES_SIMILARES_DETALLE')
            and   type = 'U')
   drop table VENTA_INMUEBLES_SIMILARES_DETALLE
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('VENTA_INMUEBLES_SIMILARES_HOMOLACION_DETALLE')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index VENTA_INMUEBLES_SIMILARES_HOMOLACION_DETALLE.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('VENTA_INMUEBLES_SIMILARES_HOMOLACION_DETALLE')
            and   type = 'U')
   drop table VENTA_INMUEBLES_SIMILARES_HOMOLACION_DETALLE
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('VENTA_TERRENOS_DETALLE')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index VENTA_TERRENOS_DETALLE.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('VENTA_TERRENOS_DETALLE')
            and   type = 'U')
   drop table VENTA_TERRENOS_DETALLE
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('VENTA_TERRENOS_HOMOLOGACION_DETALLE')
            and   name  = 'INDEX_1'
            and   indid > 0
            and   indid < 255)
   drop index VENTA_TERRENOS_HOMOLOGACION_DETALLE.INDEX_1
go

if exists (select 1
            from  sysobjects
           where  id = object_id('VENTA_TERRENOS_HOMOLOGACION_DETALLE')
            and   type = 'U')
   drop table VENTA_TERRENOS_HOMOLOGACION_DETALLE
go

/*==============================================================*/
/* Table: ACABADOS_DETALLES                                     */
/*==============================================================*/
create table ACABADOS_DETALLES (
   ID_TIPO_ACABADO      int                  not null,
   ID_AREAS_CONSIDERAR  int                  not null,
   ID_CARACTERISTICA_INM int                  not null,
   DESCRIPCION          varchar(100)         null,
   FECHA_REGISTRO       datetime             null,
   ACTIVO               bit                  null,
   constraint PK_ACABADOS_DETALLES primary key (ID_TIPO_ACABADO, ID_AREAS_CONSIDERAR, ID_CARACTERISTICA_INM)
)
go

/*==============================================================*/
/* Index: INDEX_2                                               */
/*==============================================================*/
create index INDEX_2 on ACABADOS_DETALLES (
ID_TIPO_ACABADO ASC
)
go

/*==============================================================*/
/* Table: ANALISIS_FISICO                                       */
/*==============================================================*/
create table ANALISIS_FISICO (
   ID_ANALISIS_FISICO   int                  not null,
   VALOR_TERRENO        float                null,
   VALOR_CONSTRUCCION   float                null,
   VALOR_FISICO_TOTAL   float                null,
   FECHA_REGISTRO       datetime             null,
   ACTIVO               bit                  null,
   constraint PK_ANALISIS_FISICO primary key (ID_ANALISIS_FISICO)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on ANALISIS_FISICO (
ID_ANALISIS_FISICO ASC
)
go

/*==============================================================*/
/* Table: AREAS_CONSIDERAR_ACABADOS                             */
/*==============================================================*/
create table AREAS_CONSIDERAR_ACABADOS (
   ID_AREAS_CONSIDERAR  int                  not null,
   NOMBRE_CONSIDERACION varchar(50)          null,
   ACTIVO               bit                  null,
   constraint PK_AREAS_CONSIDERAR_ACABADOS primary key (ID_AREAS_CONSIDERAR)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on AREAS_CONSIDERAR_ACABADOS (
ID_AREAS_CONSIDERAR ASC
)
go

/*==============================================================*/
/* Table: AVALUOS                                               */
/*==============================================================*/
create table AVALUOS (
   ID_AVALUO            int                  not null,
   NUMERO_AVALUO        varchar(50)          null,
   ID_VALUADOR          int                  null,
   ID_PROPOSITO         int                  null,
   ID_FINALIDAD         int                  null,
   ID_INFORMACION_GEN   int                  null,
   ID_CARACTERISTICA_ZONA int                  null,
   ID_CARACTERISTICA_INM int                  null,
   ID_INVESTIGACION_MERCADO int                  null,
   ID_ANALISIS_FISICO   int                  null,
   ID_CONCLUSION        int                  null,
   IMPORTE_VALOR_COMERCIAL float                null,
   IMPORTE_VALOR_COMERCIAL_LETRAS varchar(100)         null,
   RUTA_PLANO           varchar(50)          null,
   FECHA_AVALUO         datetime             null,
   FECHA_REGISTRO       datetime             null,
   ACTIVO               bit                  null,
   constraint PK_AVALUOS primary key (ID_AVALUO)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on AVALUOS (
ID_AVALUO ASC
)
go

/*==============================================================*/
/* Table: CALIDADES_PROYECTO                                    */
/*==============================================================*/
create table CALIDADES_PROYECTO (
   ID_CALIDAD_PROYECTO  int                  not null,
   NOMBRE_CALIDAD       varchar(50)          null,
   ACTIVO               bit                  null,
   constraint PK_CALIDADES_PROYECTO primary key (ID_CALIDAD_PROYECTO)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on CALIDADES_PROYECTO (
ID_CALIDAD_PROYECTO ASC
)
go

/*==============================================================*/
/* Table: CARACTERISTICAS_CONSTRUCCION_DETALLE                  */
/*==============================================================*/
create table CARACTERISTICAS_CONSTRUCCION_DETALLE (
   ID_CARACTERISTICA_CONSTRUCCION int                  not null,
   ID_CARACTERISTICA_INM int                  not null,
   CIMENTACION          varchar(100)         null,
   ESTRUCTURAS          varchar(100)         null,
   MUROS                varchar(100)         null,
   ENTREPISOS           varchar(100)         null,
   TECHOS               varchar(100)         null,
   BARDAS               varchar(100)         null,
   FECHA_REGISTRO       datetime             null,
   ACTIVO               bit                  null,
   constraint PK_CARACTERISTICAS_CONSTRUCCIO primary key (ID_CARACTERISTICA_CONSTRUCCION, ID_CARACTERISTICA_INM)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on CARACTERISTICAS_CONSTRUCCION_DETALLE (
ID_CARACTERISTICA_CONSTRUCCION ASC
)
go

/*==============================================================*/
/* Table: CARACTERISTICAS_INMUEBLE                              */
/*==============================================================*/
create table CARACTERISTICAS_INMUEBLE (
   ID_CARACTERISTICA_INM int                  not null,
   RUTA_CROQUIS_LOCALIZACION varchar(50)          null,
   RUTA_FACHADA         varchar(50)          null,
   ID_USO_SUELO         int                  null,
   SERVIDUMBRE_RESTRICCIONES varchar(50)          null,
   NUMERO_NIVELES_UNIDAD int                  null,
   U_REN_ESTRUCTURA     int                  null,
   DESCRIPCION_GENERAL  varchar(200)         null,
   FECHA_REGISTRO       datetime             null,
   ACTIVO               bit                  null,
   constraint PK_CARACTERISTICAS_INMUEBLE primary key (ID_CARACTERISTICA_INM)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on CARACTERISTICAS_INMUEBLE (
ID_CARACTERISTICA_INM ASC
)
go

/*==============================================================*/
/* Table: CARACTERISTICAS_ZONA                                  */
/*==============================================================*/
create table CARACTERISTICAS_ZONA (
   ID_CARACTERISTICA_ZONA int                  not null,
   OTROS_SERVICIOS_MUNICIPALES varchar(200)         null,
   EN_RADIO_SE_UBICAN   varchar(200)         null,
   OTRO_EQUIPAMIENTO_URBANO varchar(200)         null,
   NIVEL_EQUIPAMIENTO   int                  null,
   ID_CLASIFICACION     int                  null,
   ID_PROXIMIDAD        int                  null,
   CONSTRUCCIONES_PREDOMINANTES varchar(100)         null,
   VIAS_ACCESO_IMPORTANCIA varchar(100)         null,
   FECHA_REGISTRO       datetime             null,
   ACTIVO               bit                  null,
   constraint PK_CARACTERISTICAS_ZONA primary key (ID_CARACTERISTICA_ZONA)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on CARACTERISTICAS_ZONA (
ID_CARACTERISTICA_ZONA ASC
)
go

/*==============================================================*/
/* Table: CARACTERISTICAS_ZONA_SERVICIOS_MUNICIPALES            */
/*==============================================================*/
create table CARACTERISTICAS_ZONA_SERVICIOS_MUNICIPALES (
   ID_CARACTERISTICA_ZONA int                  not null,
   ID_SERVICIO          int                  not null,
   FECHA_REGISTRO       datetime             null,
   ACTIVO               bit                  null,
   constraint PK_CARACTERISTICAS_ZONA_SERVIC primary key (ID_CARACTERISTICA_ZONA, ID_SERVICIO)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on CARACTERISTICAS_ZONA_SERVICIOS_MUNICIPALES (
ID_CARACTERISTICA_ZONA ASC,
ID_SERVICIO ASC
)
go

/*==============================================================*/
/* Table: CARACTERITICAS_ZONA_EQUIPAMIENTO_URBANO               */
/*==============================================================*/
create table CARACTERITICAS_ZONA_EQUIPAMIENTO_URBANO (
   ID_CARACTERISTICA_ZONA int                  not null,
   ID_EQUIPAMIENTO      int                  not null,
   FECHA_REGISTRO       datetime             null,
   ACTIVO               bit                  null,
   constraint PK_CARACTERITICAS_ZONA_EQUIPAM primary key (ID_CARACTERISTICA_ZONA, ID_EQUIPAMIENTO)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on CARACTERITICAS_ZONA_EQUIPAMIENTO_URBANO (
ID_CARACTERISTICA_ZONA ASC,
ID_EQUIPAMIENTO ASC
)
go

/*==============================================================*/
/* Table: CLASES_GENERALES_INMUEBLES                            */
/*==============================================================*/
create table CLASES_GENERALES_INMUEBLES (
   ID_CLASE_GENERAL_INM int                  not null,
   NOMBRE_CLASE_GENERAL varchar(50)          null,
   ACTIVO               bit                  null,
   constraint PK_CLASES_GENERALES_INMUEBLES primary key (ID_CLASE_GENERAL_INM)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on CLASES_GENERALES_INMUEBLES (
ID_CLASE_GENERAL_INM ASC
)
go

/*==============================================================*/
/* Table: CLASIFICACIONES_ZONA                                  */
/*==============================================================*/
create table CLASIFICACIONES_ZONA (
   ID_CLASIFICACION     int                  not null,
   NOMBRE_CLASIFICACION varchar(50)          null,
   ACTIVO               bit                  null,
   constraint PK_CLASIFICACIONES_ZONA primary key (ID_CLASIFICACION)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on CLASIFICACIONES_ZONA (
ID_CLASIFICACION ASC
)
go

/*==============================================================*/
/* Table: CLASIFICACION_CONSTRUCCIONES_DETALLE                  */
/*==============================================================*/
create table CLASIFICACION_CONSTRUCCIONES_DETALLE (
   ID_CLASIFICACION_CONSTRUCCION int                  not null,
   ID_ANALISIS_FISICO   int                  not null,
   ID_CLASE_GENERAL_INM int                  null,
   ID_TIPO_INM          int                  null,
   ID_ESTADO_CONSERVACION int                  null,
   ID_CALIDAD_PROYECTO  int                  null,
   EDAD_CONSTRUCCION_ANIOS int                  null,
   EDAD_UTIL_REMANENTE  int                  null,
   NUMERO_NIVELES       int                  null,
   NIVEL_EDIFICIO_CONDOMINIO int                  null,
   SUPERFICIE_M2        float                null,
   VR_NUEVO             float                null,
   FACTOR_EDAD          float                null,
   FACTOR_CONSERVACION  float                null,
   FACTOR_RESULTANTE    float                null,
   VR_NETO              float                null,
   VALOR_PARCIAL_CONSTRUCCION float                null,
   FECHA_REGISTRO       datetime             null,
   ACTIVO               bit                  null,
   constraint PK_CLASIFICACION_CONSTRUCCIONE primary key (ID_CLASIFICACION_CONSTRUCCION, ID_ANALISIS_FISICO)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on CLASIFICACION_CONSTRUCCIONES_DETALLE (
ID_CLASIFICACION_CONSTRUCCION ASC
)
go

/*==============================================================*/
/* Table: COLONIAS                                              */
/*==============================================================*/
create table COLONIAS (
   ID_COLONIA           int                  not null,
   ID_MUNICIPIO         int                  null,
   NOMBRE_COLONIA       varchar(100)         null,
   FECHA_REGISTRO       datetime             null,
   ACTIVO               bit                  null,
   constraint PK_COLONIAS primary key (ID_COLONIA)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on COLONIAS (
ID_COLONIA ASC,
ID_MUNICIPIO ASC
)
go

/*===============================================================*/
/* Table: COMUNES_INSTALACIONES_ESPECIALES_OBRAS_COMPLEMENTARIAS */
/*===============================================================*/
create table COMUNES_INSTALACIONES_ESPECIALES_OBRAS_COMPLEMENTARIAS (
   ID_ANALISIS_FISICO   int                  not null,
   ID_OBRA              int                  not null,
   UNIDAD               varchar(10)          null,
   CANTIDAD             int                  null,
   VR_NUEVO             float                null,
   VIDA_UTIL_REMANENTE  int                  null,
   EDAD_ANIOS           int                  null,
   FACTOR_EDAD          float                null,
   FACTOR_CONSERVACION  float                null,
   FACTOR_RESULTANTE    float                null,
   INDIVISO             float                null,
   VALOR_PARCIAL_AREAS_COMUNES float                null,
   FECHA_REGISTRO       datetime             null,
   ACTIVO               bit                  null,
   constraint PK_COMUNES_INSTALACIONES_ESPEC primary key (ID_ANALISIS_FISICO, ID_OBRA)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on COMUNES_INSTALACIONES_ESPECIALES_OBRAS_COMPLEMENTARIAS (
ID_ANALISIS_FISICO ASC,
ID_OBRA ASC
)
go

/*==============================================================*/
/* Table: CONCLUSIONES                                          */
/*==============================================================*/
create table CONCLUSIONES (
   ID_CONCLUSION        int                  not null,
   VALOR_COMPARATIVO_MERCADO float                null,
   VALOR_FISICO         float                null,
   FECHA_REGISTRO       datetime             null,
   ACTIVO               bit                  null,
   constraint PK_CONCLUSIONES primary key (ID_CONCLUSION)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on CONCLUSIONES (
ID_CONCLUSION ASC
)
go

/*==============================================================*/
/* Table: CONJUNTOS_HABITACIONALES                              */
/*==============================================================*/
create table CONJUNTOS_HABITACIONALES (
   ID_CONJUNTO          int                  not null,
   NOMBRE_CONJUNTO      varchar(100)         null,
   FECHA_REGISTRO       datetime             null,
   ACTIVO               bit                  null,
   constraint PK_CONJUNTOS_HABITACIONALES primary key (ID_CONJUNTO)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on CONJUNTOS_HABITACIONALES (
ID_CONJUNTO ASC
)
go

/*==============================================================*/
/* Table: EQUIPAMIENTO_URBANO                                   */
/*==============================================================*/
create table EQUIPAMIENTO_URBANO (
   ID_EQUIPAMIENTO      int                  not null,
   NOMBRE_EQUIPAMIENTO  varchar(50)          null,
   ACTIVO               bit                  null,
   constraint PK_EQUIPAMIENTO_URBANO primary key (ID_EQUIPAMIENTO)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on EQUIPAMIENTO_URBANO (
ID_EQUIPAMIENTO ASC
)
go

/*==============================================================*/
/* Table: ESTADOS                                               */
/*==============================================================*/
create table ESTADOS (
   ID_ESTADO            int                  not null,
   NOMBRE_ESTADO        varchar(50)          null,
   constraint PK_ESTADOS primary key (ID_ESTADO)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on ESTADOS (
ID_ESTADO ASC
)
go

/*==============================================================*/
/* Table: ESTADOS_CONCERVACION                                  */
/*==============================================================*/
create table ESTADOS_CONCERVACION (
   ID_ESTADO_CONSERVACION int                  not null,
   NOMBRE_ESTADO        varchar(50)          null,
   ACTIVO               bit                  null,
   constraint PK_ESTADOS_CONCERVACION primary key (ID_ESTADO_CONSERVACION)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on ESTADOS_CONCERVACION (
ID_ESTADO_CONSERVACION ASC
)
go

/*==============================================================*/
/* Table: FINALIDADES                                           */
/*==============================================================*/
create table FINALIDADES (
   ID_FINALIDAD         int                  not null,
   DESCRIPCION_FINALIDAD varchar(50)          null,
   ACTIVO               bit                  null,
   constraint PK_FINALIDADES primary key (ID_FINALIDAD)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on FINALIDADES (
ID_FINALIDAD ASC
)
go

/*==============================================================*/
/* Table: INFORMACION_GENENAL_INMUEBLE                          */
/*==============================================================*/
create table INFORMACION_GENENAL_INMUEBLE (
   ID_INFORMACION_GEN   int                  not null,
   ID_TIPO_INM          int                  null,
   ID_CONJUNTO          int                  null,
   ID_COLONIA           int                  null,
   CALLE                varchar(100)         null,
   NUMERO_O_MANZANA     varchar(50)          null,
   CP                   varchar(5)           null,
   LONGUITUD            varchar(10)          null,
   LATITUD              varchar(10)          null,
   ALTITUD_SNM_         varchar(10)          null,
   ID_REGIMEN           int                  null,
   CUENTA_PREDIAL       varchar(20)          null,
   CLAVE_CATASTRAL      varchar(20)          null,
   ID_SOLICITANTE       int                  null,
   FECHA_REGISTRO       datetime             null,
   ACTIVO               bit                  null,
   constraint PK_INFORMACION_GENENAL_INMUEBL primary key (ID_INFORMACION_GEN)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on INFORMACION_GENENAL_INMUEBLE (
ID_INFORMACION_GEN ASC
)
go

/*==============================================================*/
/* Table: INVESTIGACION_MERCADO                                 */
/*==============================================================*/
create table INVESTIGACION_MERCADO (
   ID_INVESTIGACION_MERCADO int                  not null,
   LOTE_TIPO_MODA       varchar(50)          null,
   VALOR_UNITARIO_PROMEDIO float                null,
   VALOR_APLICADO_M2    float                null,
   VALOR_PROMEDIO       float                null,
   SUPERFICIE_CONSTRUIDA_SUJETO float                null,
   VALOR_COMPARATIVO_MERCADO float                null,
   CONCLUSIONES_INVESTIGACION varchar(200)         null,
   FECHA_REGISTRO       datetime             null,
   ACTIVO               bit                  null,
   constraint PK_INVESTIGACION_MERCADO primary key (ID_INVESTIGACION_MERCADO)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on INVESTIGACION_MERCADO (
ID_INVESTIGACION_MERCADO ASC
)
go

/*==============================================================*/
/* Table: MEDIDAS_COLINDANCIAS_DETALLE                          */
/*==============================================================*/
create table MEDIDAS_COLINDANCIAS_DETALLE (
   ID_MEDIDAS_COL       int                  not null,
   ID_CARACTERISTICA_INM int                  not null,
   NORESTE1             varchar(100)         null,
   DESCRIPCION1         varchar(50)          null,
   NORESTE2             varchar(50)          null,
   DESCRIPCION2         varchar(50)          null,
   SURESTE1             varchar(50)          null,
   DESCRIPCION3         varchar(50)          null,
   SURESTE2             varchar(50)          null,
   DESCIRPCION4         varchar(50)          null,
   SUPERFICIE_LIBRE     float                null,
   DESCRIPCION5         varchar(50)          null,
   AREA_CONSTRUIDA      float                null,
   DESCRIPCION6         varchar(50)          null,
   AREA_TOTAL           float                null,
   DESCRIPCION7         varchar(50)          null,
   FECHA_REGISTRO       datetime             null,
   ACTIVO               bit                  null,
   constraint PK_MEDIDAS_COLINDANCIAS_DETALL primary key (ID_MEDIDAS_COL, ID_CARACTERISTICA_INM)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on MEDIDAS_COLINDANCIAS_DETALLE (
ID_MEDIDAS_COL ASC
)
go

/*==============================================================*/
/* Table: MUNICIPIOS                                            */
/*==============================================================*/
create table MUNICIPIOS (
   ID_MUNICIPIO         int                  not null,
   ID_ESTADO            int                  null,
   NOMBRE_MUNICIPIO     varchar(50)          null,
   ACTIVO               bit                  null,
   constraint PK_MUNICIPIOS primary key (ID_MUNICIPIO)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on MUNICIPIOS (
ID_MUNICIPIO ASC,
ID_ESTADO ASC
)
go

/*==============================================================*/
/* Table: OBRAS_COMPLEMENTARIAS                                 */
/*==============================================================*/
create table OBRAS_COMPLEMENTARIAS (
   ID_OBRA              int                  not null,
   NOMBRE_OBRA          varchar(50)          null,
   ACTIVO               bit                  null,
   constraint PK_OBRAS_COMPLEMENTARIAS primary key (ID_OBRA)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on OBRAS_COMPLEMENTARIAS (
ID_OBRA ASC
)
go

/*==============================================================*/
/* Table: PERSONAS                                              */
/*==============================================================*/
create table PERSONAS (
   ID_PERSONA           int                  not null,
   NOMBRE               varchar(50)          null,
   AP_PATERNO           varchar(50)          null,
   AP_MATERNO           varchar(50)          null,
   FECHA_NACIMIENTO     datetime             null,
   FECHA_REGISTRO       datetime             null,
   ACTIVO               bit                  null,
   constraint PK_PERSONAS primary key (ID_PERSONA)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on PERSONAS (
ID_PERSONA ASC
)
go

/*==================================================================*/
/* Table: PRIVATIVAS_INSTALACIONES_ESPECIALES_OBRAS_COMPLEMENTARIAS */
/*==================================================================*/
create table PRIVATIVAS_INSTALACIONES_ESPECIALES_OBRAS_COMPLEMENTARIAS (
   ID_ANALISIS_FISICO   int                  not null,
   ID_OBRA              int                  not null,
   UNIDAD               varchar(10)          null,
   CANTIDAD             int                  null,
   VR_NUEVO             float                null,
   VIDA_UTIL_REMANENTE  int                  null,
   EDAD_ANIOS           int                  null,
   FACTOR_EDAD          float                null,
   FACTOR_CONSERVACION  float                null,
   FACTOR_RESULTANTE    float                null,
   V_NETO_REP           float                null,
   VALOR_PARCIAL_ELEMENTOS_ADICIONALES float                null,
   FECHA_REGISTRO       datetime             null,
   ACTIVO               bit                  null,
   constraint PK_PRIVATIVAS_INSTALACIONES_ES primary key (ID_ANALISIS_FISICO, ID_OBRA)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on PRIVATIVAS_INSTALACIONES_ESPECIALES_OBRAS_COMPLEMENTARIAS (
ID_ANALISIS_FISICO ASC,
ID_OBRA ASC
)
go

/*==============================================================*/
/* Table: PROPIETARIOS                                          */
/*==============================================================*/
create table PROPIETARIOS (
   ID_PROPIETARIO       int                  not null,
   ID_INFORMACION_GEN   int                  not null,
   FECHA_REGISTRO       datetime             null,
   ACTIVO               bit                  null,
   constraint PK_PROPIETARIOS primary key (ID_PROPIETARIO, ID_INFORMACION_GEN)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on PROPIETARIOS (
ID_PROPIETARIO ASC,
ID_INFORMACION_GEN ASC
)
go

/*==============================================================*/
/* Table: PROPOSITOS                                            */
/*==============================================================*/
create table PROPOSITOS (
   ID_PROPOSITO         int                  not null,
   DESCRIPCION_PROPOSITO varchar(50)          null,
   ACTIVO               bit                  null,
   constraint PK_PROPOSITOS primary key (ID_PROPOSITO)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on PROPOSITOS (
ID_PROPOSITO ASC
)
go

/*==============================================================*/
/* Table: PROXIMIDADES_URBANAS                                  */
/*==============================================================*/
create table PROXIMIDADES_URBANAS (
   ID_PROXIMIDAD        int                  not null,
   NOMBRE_PROXIMIDAD    varchar(50)          null,
   ACTIVO               bit                  null,
   constraint PK_PROXIMIDADES_URBANAS primary key (ID_PROXIMIDAD)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on PROXIMIDADES_URBANAS (
ID_PROXIMIDAD ASC
)
go

/*==============================================================*/
/* Table: REGIMENES_PROPIEDAD                                   */
/*==============================================================*/
create table REGIMENES_PROPIEDAD (
   ID_REGIMEN           int                  not null,
   NOMBRE_REGIMEN       varchar(50)          null,
   ACTIVO               bit                  null,
   constraint PK_REGIMENES_PROPIEDAD primary key (ID_REGIMEN)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on REGIMENES_PROPIEDAD (
ID_REGIMEN ASC
)
go

/*==============================================================*/
/* Table: SERVICIOS_MUNICIPALES                                 */
/*==============================================================*/
create table SERVICIOS_MUNICIPALES (
   ID_SERVICIO          int                  not null,
   NOMBRE_SERVICIO      varchar(50)          null,
   ACTIVO               bit                  null,
   constraint PK_SERVICIOS_MUNICIPALES primary key (ID_SERVICIO)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on SERVICIOS_MUNICIPALES (
ID_SERVICIO ASC
)
go

/*==============================================================*/
/* Table: SOLICITANTES                                          */
/*==============================================================*/
create table SOLICITANTES (
   ID_SOLICITANTE       int                  not null,
   FECHA_REGISTRO       datetime             null,
   ACTIVO               bit                  null,
   constraint PK_SOLICITANTES primary key (ID_SOLICITANTE)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on SOLICITANTES (
ID_SOLICITANTE ASC
)
go

/*==============================================================*/
/* Table: SUPERFICIES_DETALLE                                   */
/*==============================================================*/
create table SUPERFICIES_DETALLE (
   ID_SUPERFICIE        int                  not null,
   ID_CARACTERISTICA_INM int                  not null,
   SUPERFICIE_TOTAL_TERRENO float                null,
   SUPERFICIE_TERRENO   float                null,
   SUPERFICIE_CONSTRUCCION float                null,
   SUPERFICIE_ACENTADA_ESCRITURA float                null,
   INDIVISO_TERRENO     float                null,
   INDIVISO_AREAS_COMUNES float                null,
   INDIVISO_ACCESORIA   float                null,
   SUPERFICIE_VENDIBLE  float                null,
   FECHA_REGISTRO       datetime             null,
   ACTIVO               bit                  null,
   constraint PK_SUPERFICIES_DETALLE primary key (ID_SUPERFICIE, ID_CARACTERISTICA_INM)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on SUPERFICIES_DETALLE (
ID_SUPERFICIE ASC,
ID_CARACTERISTICA_INM ASC
)
go

/*==============================================================*/
/* Table: TERRENOS_DETALLE                                      */
/*==============================================================*/
create table TERRENOS_DETALLE (
   ID_TERRENO_DETALLE   int                  not null,
   ID_ANALISIS_FISICO   int                  not null,
   SUPERFICIE_M2        float                null,
   IRRE                 float                null,
   "TOP"                float                null,
   FRENTE               float                null,
   FORMA                float                null,
   OTROS                float                null,
   FR                   float                null,
   VALOR_UNITARIO_NETO  float                null,
   INDIVISO             float                null,
   VALOR_PARCIAL        float                null,
   FECHA_REGISTRO       datetime             null,
   ACTIVO               bit                  null,
   constraint PK_TERRENOS_DETALLE primary key (ID_TERRENO_DETALLE, ID_ANALISIS_FISICO)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on TERRENOS_DETALLE (
ID_TERRENO_DETALLE ASC,
ID_ANALISIS_FISICO ASC
)
go

/*==============================================================*/
/* Table: TIPOS_ACABADOS                                        */
/*==============================================================*/
create table TIPOS_ACABADOS (
   ID_TIPO_ACABADO      int                  not null,
   NOMBRE_TIPO          varchar(50)          null,
   ACTIVO               bit                  null,
   constraint PK_TIPOS_ACABADOS primary key (ID_TIPO_ACABADO)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on TIPOS_ACABADOS (
ID_TIPO_ACABADO ASC
)
go

/*==============================================================*/
/* Table: TIPOS_INMUEBLES                                       */
/*==============================================================*/
create table TIPOS_INMUEBLES (
   ID_TIPO_INM          int                  not null,
   NOMBRE_TIPO_INM      varchar(50)          null,
   ACTIVO               bit                  null,
   constraint PK_TIPOS_INMUEBLES primary key (ID_TIPO_INM)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on TIPOS_INMUEBLES (
ID_TIPO_INM ASC
)
go

/*==============================================================*/
/* Table: USOS_SUELO                                            */
/*==============================================================*/
create table USOS_SUELO (
   ID_USO_SUELO         int                  not null,
   NOMBRE_USO           varchar(50)          null,
   ACTIVO               bit                  null,
   constraint PK_USOS_SUELO primary key (ID_USO_SUELO)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on USOS_SUELO (
ID_USO_SUELO ASC
)
go

/*==============================================================*/
/* Table: VALUADORES                                            */
/*==============================================================*/
create table VALUADORES (
   ID_VALUADOR          int                  not null,
   RUTA_CONSTANCIA      varchar(50)          null,
   CEDULA_PROFESIONAL_DE_VALUADOR__ varchar(50)          null,
   REGISTRO_ESTATAL     varchar(50)          null,
   REGISTRO_COLEGIO     varchar(50)          null,
   FECHA_REGISTRO       datetime             null,
   ACTIVO               bit                  null,
   constraint PK_VALUADORES primary key (ID_VALUADOR)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on VALUADORES (
ID_VALUADOR ASC
)
go

/*==============================================================*/
/* Table: VENTA_INMUEBLES_SIMILARES_DETALLE                     */
/*==============================================================*/
create table VENTA_INMUEBLES_SIMILARES_DETALLE (
   ID_VENTA_INMUEBLES_SIMILARES int                  not null,
   ID_INVESTIGACION_MERCADO int                  not null,
   UBICACION_OFERTA_COMPARABLE varchar(100)         null,
   EDAD                 int                  null,
   TELEFONO             varchar(20)          null,
   FUENTE               varchar(50)          null,
   FECHA_REGISTRO       datetime             null,
   ACTIVO               bit                  null,
   constraint PK_VENTA_INMUEBLES_SIMILARES_D primary key (ID_VENTA_INMUEBLES_SIMILARES, ID_INVESTIGACION_MERCADO)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on VENTA_INMUEBLES_SIMILARES_DETALLE (
ID_VENTA_INMUEBLES_SIMILARES ASC
)
go

/*==============================================================*/
/* Table: VENTA_INMUEBLES_SIMILARES_HOMOLACION_DETALLE          */
/*==============================================================*/
create table VENTA_INMUEBLES_SIMILARES_HOMOLACION_DETALLE (
   ID_VENTA_INMUEBLES_SIMILARES_H int                  not null,
   ID_INVESTIGACION_MERCADO int                  not null,
   PRECIO_VENTA         float                null,
   SUPERFICIE_TERRENO   float                null,
   SUPERFICIE_CONSTRUCCION float                null,
   VALOR_UNITARIO_M2    float                null,
   ZONA                 float                null,
   UBIC                 float                null,
   SUP                  float                null,
   EDAD                 float                null,
   CONS                 float                null,
   NEG                  float                null,
   FR                   float                null,
   VALOR_UNITARIO_RESULTANTE float                null,
   FECHA_REGISTRO       datetime             null,
   ACTIVO               bit                  null,
   constraint PK_VENTA_INMUEBLES_SIMILARES_H primary key (ID_VENTA_INMUEBLES_SIMILARES_H, ID_INVESTIGACION_MERCADO)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on VENTA_INMUEBLES_SIMILARES_HOMOLACION_DETALLE (
ID_VENTA_INMUEBLES_SIMILARES_H ASC
)
go

/*==============================================================*/
/* Table: VENTA_TERRENOS_DETALLE                                */
/*==============================================================*/
create table VENTA_TERRENOS_DETALLE (
   ID_VENTA_TERRENO     int                  not null,
   ID_INVESTIGACION_MERCADO int                  not null,
   UBICACION_OFERTA_COMPARABLE varchar(100)         null,
   PRECIO_OFERTA        float                null,
   SUPERFICIE_TERRENO   float                null,
   SUPERFICIE_CONSTRUIDA float                null,
   P_U_M2               float                null,
   FUENTE_ANTECEDENTE_TELEFONO varchar(100)         null,
   FECHA_REGISTRO       datetime             null,
   ACTIVO               bit                  null,
   constraint PK_VENTA_TERRENOS_DETALLE primary key (ID_VENTA_TERRENO, ID_INVESTIGACION_MERCADO)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on VENTA_TERRENOS_DETALLE (
ID_VENTA_TERRENO ASC
)
go

/*==============================================================*/
/* Table: VENTA_TERRENOS_HOMOLOGACION_DETALLE                   */
/*==============================================================*/
create table VENTA_TERRENOS_HOMOLOGACION_DETALLE (
   ID_VENTA_TERRENO_H   int                  not null,
   ID_INVESTIGACION_MERCADO int                  not null,
   COMPARABLE           varchar(100)         null,
   SUPERFICIE           float                null,
   VALOR_UNITARIO       float                null,
   ZONA                 float                null,
   UBICACION            float                null,
   FRENTE               float                null,
   FORMA                float                null,
   SUPERFICIE2          float                null,
   NEGOCIACION          float                null,
   RESULTANTE           float                null,
   FECHA_REGISTRO       datetime             null,
   ACTIVO               bit                  null,
   constraint PK_VENTA_TERRENOS_HOMOLOGACION primary key (ID_VENTA_TERRENO_H, ID_INVESTIGACION_MERCADO)
)
go

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create index INDEX_1 on VENTA_TERRENOS_HOMOLOGACION_DETALLE (
ID_VENTA_TERRENO_H ASC
)
go

alter table ACABADOS_DETALLES
   add constraint FK_ACABADOS_REFERENCE_TIPOS_AC foreign key (ID_TIPO_ACABADO)
      references TIPOS_ACABADOS (ID_TIPO_ACABADO)
go

alter table ACABADOS_DETALLES
   add constraint FK_ACABADOS_REFERENCE_AREAS_CO foreign key (ID_AREAS_CONSIDERAR)
      references AREAS_CONSIDERAR_ACABADOS (ID_AREAS_CONSIDERAR)
go

alter table ACABADOS_DETALLES
   add constraint FK_ACABADOS_REFERENCE_CARACTER foreign key (ID_CARACTERISTICA_INM)
      references CARACTERISTICAS_INMUEBLE (ID_CARACTERISTICA_INM)
go

alter table AVALUOS
   add constraint FK_AVALUOS_REFERENCE_VALUADOR foreign key (ID_VALUADOR)
      references VALUADORES (ID_VALUADOR)
go

alter table AVALUOS
   add constraint FK_AVALUOS_REFERENCE_INFORMAC foreign key (ID_INFORMACION_GEN)
      references INFORMACION_GENENAL_INMUEBLE (ID_INFORMACION_GEN)
go

alter table AVALUOS
   add constraint FK_AVALUOS_REFERENCE_CARACTER2 foreign key (ID_CARACTERISTICA_ZONA)
      references CARACTERISTICAS_ZONA (ID_CARACTERISTICA_ZONA)
go

alter table AVALUOS
   add constraint FK_AVALUOS_REFERENCE_CARACTER foreign key (ID_CARACTERISTICA_INM)
      references CARACTERISTICAS_INMUEBLE (ID_CARACTERISTICA_INM)
go

alter table AVALUOS
   add constraint FK_AVALUOS_REFERENCE_INVESTIG foreign key (ID_INVESTIGACION_MERCADO)
      references INVESTIGACION_MERCADO (ID_INVESTIGACION_MERCADO)
go

alter table AVALUOS
   add constraint FK_AVALUOS_REFERENCE_ANALISIS foreign key (ID_ANALISIS_FISICO)
      references ANALISIS_FISICO (ID_ANALISIS_FISICO)
go

alter table AVALUOS
   add constraint FK_AVALUOS_REFERENCE_CONCLUSI foreign key (ID_CONCLUSION)
      references CONCLUSIONES (ID_CONCLUSION)
go

alter table AVALUOS
   add constraint FK_AVALUOS_REFERENCE_PROPOSIT foreign key (ID_PROPOSITO)
      references PROPOSITOS (ID_PROPOSITO)
go

alter table AVALUOS
   add constraint FK_AVALUOS_REFERENCE_FINALIDA foreign key (ID_FINALIDAD)
      references FINALIDADES (ID_FINALIDAD)
go

alter table CARACTERISTICAS_CONSTRUCCION_DETALLE
   add constraint FK_CARACTER_REFERENCE_CARACTER foreign key (ID_CARACTERISTICA_INM)
      references CARACTERISTICAS_INMUEBLE (ID_CARACTERISTICA_INM)
go

alter table CARACTERISTICAS_INMUEBLE
   add constraint FK_CARACTER_REFERENCE_USOS_SUE foreign key (ID_USO_SUELO)
      references USOS_SUELO (ID_USO_SUELO)
go

alter table CARACTERISTICAS_ZONA
   add constraint FK_CARACTER_REFERENCE_CLASIFIC foreign key (ID_CLASIFICACION)
      references CLASIFICACIONES_ZONA (ID_CLASIFICACION)
go

alter table CARACTERISTICAS_ZONA
   add constraint FK_CARACTER_REFERENCE_PROXIMID foreign key (ID_PROXIMIDAD)
      references PROXIMIDADES_URBANAS (ID_PROXIMIDAD)
go

alter table CARACTERISTICAS_ZONA_SERVICIOS_MUNICIPALES
   add constraint FK_CARACTER_REFERENCE_CARACTER3 foreign key (ID_CARACTERISTICA_ZONA)
      references CARACTERISTICAS_ZONA (ID_CARACTERISTICA_ZONA)
go

alter table CARACTERISTICAS_ZONA_SERVICIOS_MUNICIPALES
   add constraint FK_CARACTER_REFERENCE_SERVICIO foreign key (ID_SERVICIO)
      references SERVICIOS_MUNICIPALES (ID_SERVICIO)
go

alter table CARACTERITICAS_ZONA_EQUIPAMIENTO_URBANO
   add constraint FK_CARACTER_REFERENCE_CARACTER2 foreign key (ID_CARACTERISTICA_ZONA)
      references CARACTERISTICAS_ZONA (ID_CARACTERISTICA_ZONA)
go

alter table CARACTERITICAS_ZONA_EQUIPAMIENTO_URBANO
   add constraint FK_CARACTER_REFERENCE_EQUIPAMI foreign key (ID_EQUIPAMIENTO)
      references EQUIPAMIENTO_URBANO (ID_EQUIPAMIENTO)
go

alter table CLASIFICACION_CONSTRUCCIONES_DETALLE
   add constraint FK_CLASIFIC_REFERENCE_CLASES_G foreign key (ID_CLASE_GENERAL_INM)
      references CLASES_GENERALES_INMUEBLES (ID_CLASE_GENERAL_INM)
go

alter table CLASIFICACION_CONSTRUCCIONES_DETALLE
   add constraint FK_CLASIFIC_REFERENCE_TIPOS_IN foreign key (ID_TIPO_INM)
      references TIPOS_INMUEBLES (ID_TIPO_INM)
go

alter table CLASIFICACION_CONSTRUCCIONES_DETALLE
   add constraint FK_CLASIFIC_REFERENCE_ESTADOS_ foreign key (ID_ESTADO_CONSERVACION)
      references ESTADOS_CONCERVACION (ID_ESTADO_CONSERVACION)
go

alter table CLASIFICACION_CONSTRUCCIONES_DETALLE
   add constraint FK_CLASIFIC_REFERENCE_CALIDADE foreign key (ID_CALIDAD_PROYECTO)
      references CALIDADES_PROYECTO (ID_CALIDAD_PROYECTO)
go

alter table CLASIFICACION_CONSTRUCCIONES_DETALLE
   add constraint FK_CLASIFIC_REFERENCE_ANALISIS foreign key (ID_ANALISIS_FISICO)
      references ANALISIS_FISICO (ID_ANALISIS_FISICO)
go

alter table COLONIAS
   add constraint FK_COLONIAS_REFERENCE_MUNICIPI foreign key (ID_MUNICIPIO)
      references MUNICIPIOS (ID_MUNICIPIO)
go

alter table COMUNES_INSTALACIONES_ESPECIALES_OBRAS_COMPLEMENTARIAS
   add constraint FK_COMUNES__REFERENCE_ANALISIS foreign key (ID_ANALISIS_FISICO)
      references ANALISIS_FISICO (ID_ANALISIS_FISICO)
go

alter table COMUNES_INSTALACIONES_ESPECIALES_OBRAS_COMPLEMENTARIAS
   add constraint FK_COMUNES__REFERENCE_OBRAS_CO foreign key (ID_OBRA)
      references OBRAS_COMPLEMENTARIAS (ID_OBRA)
go

alter table INFORMACION_GENENAL_INMUEBLE
   add constraint FK_INFORMAC_REFERENCE_SOLICITA foreign key (ID_SOLICITANTE)
      references SOLICITANTES (ID_SOLICITANTE)
go

alter table INFORMACION_GENENAL_INMUEBLE
   add constraint FK_INFORMAC_REFERENCE_TIPOS_IN foreign key (ID_TIPO_INM)
      references TIPOS_INMUEBLES (ID_TIPO_INM)
go

alter table INFORMACION_GENENAL_INMUEBLE
   add constraint FK_INFORMAC_REFERENCE_CONJUNTO foreign key (ID_CONJUNTO)
      references CONJUNTOS_HABITACIONALES (ID_CONJUNTO)
go

alter table INFORMACION_GENENAL_INMUEBLE
   add constraint FK_INFORMAC_REFERENCE_COLONIAS foreign key (ID_COLONIA)
      references COLONIAS (ID_COLONIA)
go

alter table INFORMACION_GENENAL_INMUEBLE
   add constraint FK_INFORMAC_REFERENCE_REGIMENE foreign key (ID_REGIMEN)
      references REGIMENES_PROPIEDAD (ID_REGIMEN)
go

alter table MEDIDAS_COLINDANCIAS_DETALLE
   add constraint FK_MEDIDAS__REFERENCE_CARACTER foreign key (ID_CARACTERISTICA_INM)
      references CARACTERISTICAS_INMUEBLE (ID_CARACTERISTICA_INM)
go

alter table MUNICIPIOS
   add constraint FK_MUNICIPI_REFERENCE_ESTADOS foreign key (ID_ESTADO)
      references ESTADOS (ID_ESTADO)
go

alter table PRIVATIVAS_INSTALACIONES_ESPECIALES_OBRAS_COMPLEMENTARIAS
   add constraint FK_PRIVATIV_REFERENCE_ANALISIS foreign key (ID_ANALISIS_FISICO)
      references ANALISIS_FISICO (ID_ANALISIS_FISICO)
go

alter table PRIVATIVAS_INSTALACIONES_ESPECIALES_OBRAS_COMPLEMENTARIAS
   add constraint FK_PRIVATIV_REFERENCE_OBRAS_CO foreign key (ID_OBRA)
      references OBRAS_COMPLEMENTARIAS (ID_OBRA)
go

alter table PROPIETARIOS
   add constraint FK_PROPIETA_REFERENCE_PERSONAS foreign key (ID_PROPIETARIO)
      references PERSONAS (ID_PERSONA)
go

alter table PROPIETARIOS
   add constraint FK_PROPIETA_REFERENCE_INFORMAC foreign key (ID_INFORMACION_GEN)
      references INFORMACION_GENENAL_INMUEBLE (ID_INFORMACION_GEN)
go

alter table SOLICITANTES
   add constraint FK_SOLICITA_REFERENCE_PERSONAS foreign key (ID_SOLICITANTE)
      references PERSONAS (ID_PERSONA)
go

alter table SUPERFICIES_DETALLE
   add constraint FK_SUPERFIC_REFERENCE_CARACTER foreign key (ID_CARACTERISTICA_INM)
      references CARACTERISTICAS_INMUEBLE (ID_CARACTERISTICA_INM)
go

alter table TERRENOS_DETALLE
   add constraint FK_TERRENOS_REFERENCE_ANALISIS foreign key (ID_ANALISIS_FISICO)
      references ANALISIS_FISICO (ID_ANALISIS_FISICO)
go

alter table VALUADORES
   add constraint FK_VALUADOR_REFERENCE_PERSONAS foreign key (ID_VALUADOR)
      references PERSONAS (ID_PERSONA)
go

alter table VENTA_INMUEBLES_SIMILARES_DETALLE
   add constraint FK_VENTA_IN_REFERENCE_INVESTIG2 foreign key (ID_INVESTIGACION_MERCADO)
      references INVESTIGACION_MERCADO (ID_INVESTIGACION_MERCADO)
go

alter table VENTA_INMUEBLES_SIMILARES_HOMOLACION_DETALLE
   add constraint FK_VENTA_IN_REFERENCE_INVESTIG foreign key (ID_INVESTIGACION_MERCADO)
      references INVESTIGACION_MERCADO (ID_INVESTIGACION_MERCADO)
go

alter table VENTA_TERRENOS_DETALLE
   add constraint FK_VENTA_TE_REFERENCE_INVESTIG2 foreign key (ID_INVESTIGACION_MERCADO)
      references INVESTIGACION_MERCADO (ID_INVESTIGACION_MERCADO)
go

alter table VENTA_TERRENOS_HOMOLOGACION_DETALLE
   add constraint FK_VENTA_TE_REFERENCE_INVESTIG foreign key (ID_INVESTIGACION_MERCADO)
      references INVESTIGACION_MERCADO (ID_INVESTIGACION_MERCADO)
go

