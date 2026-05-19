package facturacion;
/**
 * Clase Legacy del sistema de facturación.
 * ADVERTENCIA: Código con alta deuda técnica. No modificar la firma del método.
 */
public class FacturacionLegacy {
    public static final double DESCUENTO_VIP = 0.75;
    public static final double DESCUENTO_ESTANDAR = 0.85;
    public static final double DESCUENTO_TERCER_TIPO = 0.95;
    
    // Método a refactorizar
    public double calcularTotal(double importeBase, int tipoCliente, boolean esSocioVip) {
        //Entorno:
            double importeTotal;
        //Algoritmo:
            importeTotal = 0;
            
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
            }
                
            return importeTotal;
    }
}