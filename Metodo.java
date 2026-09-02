import java.util.Scanner;


public class Metodo {

    private double Precio = -1;

    public Boolean PrecioConfigurado(){
        return Precio != -1;
    }

    public double PedirValor(Scanner sc){
        double valor = -1;
        while(valor <= 0){
            System.out.println("Ingrese el valor del precio por Hora:"); 
            valor = sc.nextDouble();
            sc.nextLine();
            if(valor <= 0){
                System.out.println("El valor debe ser mayor que 0.");                
            }                       
        }  
        return valor;         
    }

    
    public void ConfigurarPrecio(Scanner sc){
        System.out.println("\n========= CONFIGURACION DE PRECIO POR HORA========="); 
        Precio = PedirValor(sc);
        System.out.println("\nPrecio configurados correctamente."); 
        System.out.println("\nPresione enter para continuar.");                                 
    }


    public ObjVehiculo[][] LlenarMatriz(ObjVehiculo[][] matriz, Scanner sc){
        if(!PrecioConfigurado()){
            System.out.println("\nAun no se ha ingresado el precio por hora.");
            System.out.println("Debe ingresarlo para poder registrar los vehiculos.");
            ConfigurarPrecio(sc);
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                sc.nextLine();              
                System.out.println("\n--- Registro del vehiculo de la posición ["+i+"]["+j+"]---\n");
                ObjVehiculo m = new ObjVehiculo();
                System.out.println("Ingrese la placa del vehiculo: ");
                m.setPlaca(sc.nextLine());
                System.out.println("Ingrese el tipo del vehiculo (Carro/Moto): ");
                m.setTipo_vehiculo(sc.nextLine());
                System.out.println("Ingrese su nombre completo: ");
                m.setPropietario(sc.nextLine());
                System.out.println("Ingrese las horas de estacionamiento: ");
                m.setHoras(sc.nextDouble());
                m.setValor_pagado(m.getHoras()*Precio);
                matriz[i][j] = m;                                              
            }
        }
        return matriz;
    }

    public void MostrarMatriz(ObjVehiculo[][] matriz){
        boolean hayRegistos = false;
        System.out.println("\n=====Vehiculos Registrados=====");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if(matriz[i][j] != null){
                    hayRegistos = true;
                    System.out.println("Placa: "+matriz[i][j].getPlaca());
                    System.out.println("Tipo Vehiculo: "+matriz[i][j].getTipo_vehiculo());
                    System.out.println("Propietario: "+matriz[i][j].getPropietario());
                    System.out.println("Horas: "+matriz[i][j].getHoras());
                    System.out.println("Valor pagado: "+matriz[i][j].getValor_pagado());
                }                
            }
        }
        if(!hayRegistos){
            System.out.println("Aun no hay vehiculos registrados.");                                            
        }
    }

     public void ReporteAdministracion(ObjVehiculo[][] matriz){
        ObjVehiculo Mayorpago = null;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if(matriz[i][j] != null){
                    if(Mayorpago == null || matriz[i][j].getValor_pagado() > Mayorpago.getValor_pagado()){
                        Mayorpago = matriz[i][j];
                    }
                }
            }
        }
        if(Mayorpago != null){
            System.out.println("Informe de vehiculo que genero el mayor pago.");
            System.out.println("Placa: "+Mayorpago.getPlaca());
            System.out.println("Tipo Vehiculo: "+Mayorpago.getTipo_vehiculo());
            System.out.println("Propietario: "+Mayorpago.getPropietario());
            System.out.println("Horas: "+Mayorpago.getHoras());
            System.out.println("Valor pagado: "+Mayorpago.getValor_pagado());            
        }        
     }
}