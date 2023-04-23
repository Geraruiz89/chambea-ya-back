package com.example.helloworld;
/** /
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import mx.com.ultrasist.ci.generator.GenCode;
import mx.com.ultrasist.ci.generator.model.Entidad;
/**/
public class CodeGeneratorTest {
    /** /
    private static Log logger = LogFactory.getLog(CodeGeneratorTest.class);

    private static void doit(GenCode codeGenerator) {
        logger.info("**************************************************************");
        logger.info(codeGenerator.generate2("velocity/Template.java.vm", "model"));
        logger.info("**************************************************************");
        logger.info(codeGenerator.generate2("velocity/TemplateController.java.vm", "controller"));
        logger.info("**************************************************************");
        logger.info(codeGenerator.generate2("velocity/TemplateMapper.java.vm", "mapper"));
        logger.info("**************************************************************");
        logger.info(codeGenerator.generate2("velocity/TemplateService.java.vm", "service"));
        logger.info("**************************************************************");
        logger.info(codeGenerator.generate2("velocity/TemplateServiceImpl.java.vm", "service"));
        logger.info("**************************************************************");
    }

    public static void main1(String... args) {
        GenCode codeGenerator = new GenCode("Cliente.json");
        doit(codeGenerator);
    }

    /**
     * Test for Generator lib.
     * 
     * @param args No necesita parámetros de entrada
     *
    public static void main(String... args) throws IOException {
        logger.info("Calculando la lista total de Entidades a procesar...");
        long start = System.currentTimeMillis();
        List<Entidad> lista =  GenCode.pop(
                "jdbc:mariadb://localhost:3307/publisher",//"jdbc:mysql://100.24.41.125:3306/cinepolis?zeroDateTimeBehavior=convertToNull",
                "root", 
                "garellano", 
                "org.mariadb.jdbc.Driver");
        long end = System.currentTimeMillis();
        long total = (end - start) / 1000;
        logger.info("Lista total de Entidades procesada. Tiempo: " + total);

        logger.info("Mostrando la lista total de tablas a procesar");
        for (Entidad entity : lista) {
            //String jsonString = mapper.writeValueAsString(entity);
            logger.info(entity.getTableCat());
            //logger.info(jsonString);
        }
        
        logger.info("Creando mapper para json conversion");
        ObjectMapper mapper = new ObjectMapper();
        
        String all = mapper.writeValueAsString(lista);
        logger.info(all);
        List<Entidad> obj = mapper.readValue(all, new TypeReference<List<Entidad>>(){});

        logger.info("Seleccionando algunas de las tablas de la DB");
        String[] tablas = {"producto","imagen_producto","caracteristica_producto"}; 
        List<Entidad> seleccion = GenCode.filter(obj, tablas);
        
        logger.info("Procesando sólo las tablas seleccionadas");
        for (Entidad entity : seleccion) {
            GenCode gc = new GenCode(entity);
            doit(gc);
            logger.info("---------------");
        }

        logger.info("Imprimiendo la seleccion en modo económico");
        logger.info(lista);
    }

    public static void main7(String... args) throws IOException {
        Properties prop = getProperties("gen.job");
        String wksp = prop.getProperty("gen.TEMPLATES_DIR");
        String preProcJsonFile = "definitions/cinepolis-db.json";
        String all = new String(Files.readAllBytes(Paths.get(wksp + preProcJsonFile)));

        ObjectMapper mapper = new ObjectMapper();
        List<Entidad> obj = mapper.readValue(all, new TypeReference<List<Entidad>>(){});

        logger.info("Seleccionando algunas de las tablas de la DB");
        String[] tablas = {"RESERVA", "CAT_CIUDAD"}; 
        List<Entidad> seleccion = GenCode.filter(obj, tablas);

        logger.info("Procesando sólo las tablas seleccionadas");
        for (Entidad entity : seleccion) {
            GenCode gc = new GenCode(entity);
            doit(gc);
            logger.info("---------------");
        }

        logger.info("Imprimiendo la seleccion en modo económico");
        logger.info(seleccion);
    }

    private static Properties getProperties(String propertiesFile) {
        Properties prop = new Properties();
        InputStream is = ClassLoader.getSystemResourceAsStream(propertiesFile);
        try {
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
    /**/
}


/*
    String:1
    int:4
    short:5
    double:6
    float:7
    double:8

java.math.BigDecimal:2
java.math.BigDecimal:3
*/
