package com;

import java.sql.*;
import java.util.Scanner;
public class CreateDB {
    public static void main(String[] args){
        
        //6- JDBC: usa tu propia plantilla JDBC o la que te pase el profesor. Realiza una consulta para ver todos
            //los titulos y los autores de todos los libros desde un statement normal directo.
            
        try {
            //Conexión

            //Conectar con driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Conectar con DB específica. Crear objeto Connection
            Connection conexion1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen", "root", "admin");

            //Crear objeto Statement para consultas
            Statement stat1 = conexion1.createStatement();

            //Ejecutar instrucciones SQL (executeQuery y executeUpdate) y guardarlo en Resultset

            //ver todo
            ResultSet resultado1 = stat1.executeQuery("SELECT titulo, autor FROM libros");

            //Recorrer resultado
            while(resultado1.next()){
                System.out.println("Título: " + resultado1.getString("titulo") );
                System.out.println("Autor: " + resultado1.getString("autor")+ "\n");
            }
           
            conexion1.close();

            
        } catch(Exception e){
            //Mensaje de error
            System.out.println("**** Conexión1 fallida ****");
            e.printStackTrace();
        }

        // 7- JDBC. Sobre esa misma plantilla, realiza un insert con un PreparedStatement para registrar una
        //     nueva fila la en en la tabla Clientes. Verifica que aparece el nuevo libro en la base de datos.
        //"nuevo libro"?? Imagino que es un error, añado cliente"
        
        try{
            //Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //DB
            Connection conexion2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen", "root", "admin");

            //Statement para consultas
            Statement stat2 = conexion2.createStatement();

            String insertar = "INSERT INTO `clientes` (`nombre`, `e-mail`) VALUES (?,?)";
            
            //Pedimos datos por el Scanner
            Scanner sc = new Scanner(System.in);

            //ID AUTOINCREMENTAL, SE AÑADE SOLO ASÍ QUE NO HACE FALTA PEDIRLO
            // System.out.println("Introduce el id del cliente");
            // Integer idcliente = Integer.parseInt(sc.nextLine());
            // System.out.println(idcliente);

            System.out.println("Introduce el nombre del cliente");
            String nombrecliente = sc.nextLine();
            System.out.println(nombrecliente);
            
            System.out.println("Introduce el e-mail del cliente");
            String emailcliente = sc.nextLine();
            System.out.println(emailcliente);

            PreparedStatement prep = conexion2.prepareStatement(insertar);
            // prep.setInt(1, idcliente); 
            prep.setString(1, nombrecliente); 
            prep.setString(2, emailcliente);
        

            prep.executeUpdate();
            System.out.println("¡Datos insertados!");
    

            sc.close();

        } catch(Exception e){
            //Mensaje de error
            System.out.println("**** Conexión2 fallida ****");
            e.printStackTrace();
        }

        
    }
}
