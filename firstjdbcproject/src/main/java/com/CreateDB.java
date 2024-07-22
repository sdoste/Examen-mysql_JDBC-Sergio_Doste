package com;

import java.sql.*;
import java.util.Scanner;
public class CreateDB {
    public static void main(String[] args){
        
        try {
            //Conexión

            //Conectar con driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Conectar con DB específica. Crear objeto Connection
            Connection conexion1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/empleadojpa", "root", "admin");

            //Crear objeto Statement para consultas
            Statement stat1 = conexion1.createStatement();

            //Ejecutar instrucciones SQL (executeQuery y executeUpdate) y guardarlo en Resultset

            //ver todo
            ResultSet resultado1 = stat1.executeQuery("SELECT * FROM empleado");

            //Recorrer resultado
            while(resultado1.next()){
                System.out.println(resultado1.getString("nombre_empleado"));
            }
           
            conexion1.close();

        } catch(Exception e){
            //Mensaje de error
            System.out.println("**** Conexión1 fallida ****");
            e.printStackTrace();
        }

        // try{
        //     //Driver
        //     Class.forName("com.mysql.cj.jdbc.Driver");

        //     //DB
        //     Connection conexion2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/empleadojpa", "root", "admin");

        //     //Statement para consultas
        //     Statement stat2 = conexion2.createStatement();

        //     //Insertar Datos
        //     String insertar = "INSERT INTO empleado (id, edad, direccion, nombre_empleado, puesto) VALUES (51, 20, 'Cbotijo', 'Brienne', 'PM')";
        //     stat2.executeUpdate(insertar);
        //     System.out.println("¡Datos insertados!");

        //     //Actualizar 
        //     String actualizar = "UPDATE empleado SET nombre_empleado='Bobby' WHERE id=10";
        //     stat2.executeUpdate(actualizar);

        //     //Eliminar registros
        //     String borrar = "DELETE FROM empleado WHERE id=50";
        //     stat2.executeUpdate(borrar);

        // } catch(Exception e){
        //     //Mensaje de error
        //     System.out.println("**** Conexión2 fallida ****");
        //     e.printStackTrace();
        // }

        try{
            //Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //DB
            Connection conexion2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/empleadojpa", "root", "admin");

            //Statement para consultas
            Statement stat2 = conexion2.createStatement();

            //Insertar Datos
            // String insertar = "INSERT INTO empleado (id, edad, direccion, nombre_empleado, puesto) VALUES (51, 20, 'Cbotijo', 'Brienne', 'PM')";
            // stat2.executeUpdate(insertar);
            // System.out.println("¡Datos insertados!");

            Scanner sc = new Scanner(System.in);

            System.out.println("Introduce id");
            Integer idempleado = Integer.parseInt(sc.nextLine());
            System.out.println(idempleado);
            
            System.out.println("Introduce la edad");
            Integer edadempleado = Integer.parseInt(sc.nextLine());
            System.out.println(edadempleado);

            // System.out.println("Introduce el nombre");
            // String nombreempleado = sc.nextLine();
            
            // System.out.println("Introduce el puesto");
            // String puestoempleado = sc.nextLine();  
            
            sc.close();

            String actualizar = "UPDATE empleado SET edad = ? WHERE id = ?";

            PreparedStatement prep = conexion2.prepareStatement(actualizar);
            prep.setInt(1, edadempleado); 
            prep.setInt(2, idempleado);
            
            
            // String actualizarTitulo = "UPDATE empleado SET nombre_empleado = ? WHERE id = ?";


            // //Actualizar 
            // String actualizar = "UPDATE empleado SET nombre_empleado='Bobby' WHERE id=10";
            // stat2.executeUpdate(actualizar);

            // //Eliminar registros
            // String borrar = "DELETE FROM empleado WHERE id=50";
            // stat2.executeUpdate(borrar);

        } catch(Exception e){
            //Mensaje de error
            System.out.println("**** Conexión2 fallida ****");
            e.printStackTrace();
        }

        
    }
}
