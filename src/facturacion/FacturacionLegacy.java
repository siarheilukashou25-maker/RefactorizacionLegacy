package facturacion;
/**
 * @author Carmen Alhaja García y Siarhei Lukashou
 * Clase Legacy del sistema de facturación.
 * ADVERTENCIA: Código con alta deuda técnica. No modificar la firma del método.
 */
public class FacturacionLegacy {
    /**
        * DESCUENTO_VIP es un 25% descuento para clientes del primer tipo y si son VIP 
        */
    public static final double DESCUENTO_VIP = 0.75;
    /**
        * DESCUENTO_ESTANDAR es un 15% descuento para clientes del primer tipo y sin VIP 
        */
    public static final double DESCUENTO_ESTANDAR = 0.85;
    /**
        * DESCUENTO_TERCER_TIPO es un 5% descuento para clientes del segundo tipo 
        */
    public static final double DESCUENTO_TERCER_TIPO = 0.95;
    
    /**
     * Devuelve importe total según tipo de cliente.
     * @param importeBase Importe base del que calculamos.
     * @param tipoCliente Tipo de cliente [1,2 o cualquier sea]
     * @param esSocioVip Si es socio VIP. Si es true tendrá un descuento.
     * @return Devuelve variable con el valor de importe total de tipo double.
     * Con rango de valores [0, Double.MAX_VALUE]
     * Devuelve 0 si importeBase < 0
     * @see java.lang.Double
     */
    public double calcularTotal(double importeBase, int tipoCliente, boolean esSocioVip) {
        //Entorno:
            double importeTotal;
        //Algoritmo:
            importeTotal = 0;
            
            if(importeBase > 0){
                switch(tipoCliente){
                    case 1:
                        importeTotal = esSocioVip ? importeBase * DESCUENTO_VIP : importeBase * DESCUENTO_ESTANDAR;
                        break;
                    case 2:
                        importeTotal = importeBase * DESCUENTO_TERCER_TIPO;
                        break;
                    default:
                        importeTotal = importeBase;
                        break;
                }//Fin Segun Sea
            }//Fin Si
   
            return importeTotal;
    }
}
