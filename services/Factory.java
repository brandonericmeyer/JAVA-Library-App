/*
Student:  Brandon Meyer
AssignName:  BookClass
Assignment:  Week 5
School:  Regis University
Date:  17, November 2015
Description:  A factory design pattern for instantiating Service layer services.
 */
package library.services;
import java.io.*;
import java.util.*;

public class Factory
{
        public Factory() {}

        public IService getService(String serviceName) throws Exception 
        {
                    Class c = Class.forName(getImplName(serviceName));
                    
                    return (IService) c.newInstance();
        }

        private String getImplName(String serviceName) throws Exception 
        {
                    FileInputStream fis = new FileInputStream("config/properties.txt");
                    
                    Properties props = new Properties();
                    
                    props.load(fis);
                    
                    fis.close();
                    
                    return props.getProperty(serviceName);      
        }
}
