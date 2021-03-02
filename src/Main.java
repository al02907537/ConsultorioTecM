import jdk.internal.access.JavaNetUriAccess;

import java.net.URI;
import java.util.Scanner;

public class Main {

    private static JavaNetUriAccess book;

    public static void main(String[] args) {
        Consultorio consultorio = new Consultorio();
        Scanner reader;
        String op;
        String usuario;
        String password;
        String usrlvl;
        String amed;
        String bmed;

        System.out.println("tipo de usuario?");
        System.out.println("a=Administrador     m=Medico       s=Secretaria");
        reader  = new Scanner(System.in);
        usrlvl = reader.nextLine();
        String cedula;
        switch(usrlvl){

            case "a":
                //acceso de administrador
                if(usuario==Administrador.admin)&&(password=Administrador.adminpass){
                    System.out.println("a=Alta medico   b=Baja medico   s=Alta de secretaria     d=Baja de secretaria   x=Salir");
                    reader = new Scanner(System.in);
                    op = reader.nextLine();
                    switch (op){
                    case "a":
                        System.out.println("Cedula: ");
                        reader = new Scanner(System.in);
                        cedula = reader.nextLine();
                        System.out.println("Nombre: ");
                        reader = new Scanner(System.in);
                        String nombreMedico = reader.nextLine();
                        System.out.println("Especialidad: ");
                        reader = new Scanner(System.in);
                        String especialidad = reader.nextLine();

                        System.out.println("la cedula profesional será asignada como contraseña...");
                        String password = cedula;
                        book.create(cedula, nombreMedico, especialidad, password)
                        break;
                    case "b":
                        System.out.println("Cedula: ");
                        reader = new Scanner(System.in);
                        cedula = reader.nextLine();
                        book.delete(cedula);
                        break;
                    case "s":
                        System.out.println("CURP: ");
                        reader = new Scanner(System.in);
                        String secreID = reader.nextLine();
                        System.out.println("Nombre: ");
                        reader = new Scanner(System.in);
                        String nomSecre = reader.nextLine();
                        System.out.println("Asignar contraseña: ");
                        reader = new Scanner(System.in);
                        String secrepass = reader.nextLine();
                        break;
                    case "d":
                        System.out.println("CURP: ");
                        reader = new Scanner(System.in);
                        secreID = reader.nextLine();
                        book.delete(secreID);
                        break;
                    case "x":
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Comando no reconocido");
                        break;
                }else
                {System.out.println("Usuario no autorizado");
                System.exit(0);
                }
            }
            case "m":
                //acceso de medico
                if(usuario==Medico.nombreMedico)&&(password=Medico.mpassword){
                System.out.println("BIENVENIDO DR "+Medico.nombremedico);
                System.out.println("Desea ver su agenda para el dia de hoy?   S/N");
                reader = new Scanner(System.in);
                String verAg = reader.nextLine();
                if(verAg="S"){

                    //mostrar agenda del dia

                }else{
                    System.out.println("Ingrese el nombre del paciente a atender: ");

                }




                break;
            case "s":
                //acceso de secretaria
                System.out.println("");
                System.out.println("");

                break;

        }


        }
    }
}