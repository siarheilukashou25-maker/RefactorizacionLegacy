package facturacion;
/**
 * Clase Legacy del sistema de facturación.
 * ADVERTENCIA: Código con alta deuda técnica. No modificar la firma del método.
 */
public class FacturacionLegacy {

    // Método a refactorizar
    public double cT(double m, int tC, boolean dV) {
        if (m > 0) {
            if (tC == 1) {
                if (dV == true)
                    return m - (m * 0.25);
                else
                    return m - (m * 0.15);
            } else {
                if (tC == 2) {
                    return m - (m * 0.05);
                } else {
                    return m;
                }
            }
        } else {
            return 0;
        }
    }
}