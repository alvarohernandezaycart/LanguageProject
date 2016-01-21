package com.nemsolutions.aurabase.language;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.cli.Option;
import org.springframework.stereotype.Service;

import com.nemsolutions.auracore.commands.Command;

@Service
public class LanguageCommand implements Command{

	public static final String SHORT_CODE = "create_language";
	
	public void execute() {
		createFile("");
        createFile("_en");
        createFile("_es");
        createFile("_fr");
	}
	
	 public void createFile(String language){
     	
	    	String ruta="C:\\Users\\ahernandez\\Documents\\aura-base\\Archivo"+language+".properties";
	    	FileWriter archivoConfig = null;
	        FileInputStream fileConfig =null;
	        Properties propConfig =new Properties();
	        try {
	            //Se crea el archivo en disco
	            archivoConfig = new FileWriter(ruta);
	            //Se carga el archivo a un File para poder usar el método Load
	            fileConfig =new FileInputStream(ruta);
	            //Con el método load cargamos el objeto properties
	            propConfig.load(fileConfig);
	            //Ahora agregamos información al properties mediante un Hashmap
	            propConfig.putAll(getConfig(language));
	            propConfig.put("11", "Individual");
	            //Salvamos los datos en el properties y listo
	            propConfig.store(new FileOutputStream(ruta),"Config");
	            archivoConfig.close();
	        } catch (IOException ex) {
//	            Logger.getLogger(GestorArchivoPropiedades.class.getName()).log(Level.SEVERE, null, ex);
	        }

			}

	    public HashMap<String, String> getConfig(String language){

	        HashMap<String, String> map= new HashMap<String, String>();
	        
	        for (int i = 0; i < 10; i++) {
	        	map.put(Integer.toString(i+1),("entrada"+(i+1)));
			}
	        
	        return map;
	    }
	    
	    public static Option getOption() {
			Option opt = new Option(SHORT_CODE, false, "");
			return opt;
		}
}
