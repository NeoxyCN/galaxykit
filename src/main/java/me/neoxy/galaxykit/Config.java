package me.neoxy.galaxykit;

import org.yaml.snakeyaml.Yaml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class Config {
    public void loadConfig(){
        try{
            BufferedReader i= new BufferedReader(new FileReader("./plugins/galaxykit/config.yml"));
            //Array
            String content=i.readLine();
        }
        catch(Exception e){

        }
    }
}
