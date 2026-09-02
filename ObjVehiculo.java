public class ObjVehiculo {
    private String Placa;
    private String Tipo_vehiculo;
    private String Propietario;
    private double Horas;   
    private double Valor_pagado;

    public ObjVehiculo(String placa, String tipo_vehiculo, String propietario, double horas, double valor_pagado) {
        Placa = placa;
        Tipo_vehiculo = tipo_vehiculo;
        Propietario = propietario;
        Horas = horas;
        Valor_pagado = valor_pagado;
    }

    public ObjVehiculo() {
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String placa) {
        Placa = placa;
    }

    public String getTipo_vehiculo() {
        return Tipo_vehiculo;
    }

    public void setTipo_vehiculo(String tipo_vehiculo) {
        Tipo_vehiculo = tipo_vehiculo;
    }

    public String getPropietario() {
        return Propietario;
    }

    public void setPropietario(String propietario) {
        Propietario = propietario;
    }

    public double getHoras() {
        return Horas;
    }

    public void setHoras(double horas) {
        Horas = horas;
    }

    public double getValor_pagado() {
        return Valor_pagado;
    }

    public void setValor_pagado(double valor_pagado) {
        Valor_pagado = valor_pagado;
    }
    
}
