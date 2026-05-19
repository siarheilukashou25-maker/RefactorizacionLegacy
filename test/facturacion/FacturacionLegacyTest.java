package facturacion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Batería de pruebas unitarias para asegurar la refactorización.
 * EL ALUMNADO NO DEBE MODIFICAR ESTE ARCHIVO.
 */
public class FacturacionLegacyTest {

    private FacturacionLegacy facturacion;

    @BeforeEach
    public void setUp() {
        facturacion = new FacturacionLegacy();
    }

    @Test
    public void testClienteVipConDescuentoExtra() {
        // tC = 1, dV = true -> 25% descuento. 100 - 25 = 75
        assertEquals(75.0, facturacion.calcularTotal(100.0, 1, true), 0.001,
                "Fallo: El cliente VIP con descuento extra debe pagar 75.0");
    }

    @Test
    public void testClienteVipSinDescuentoExtra() {
        // tC = 1, dV = false -> 15% descuento. 100 - 15 = 85
        assertEquals(85.0, facturacion.calcularTotal(100.0, 1, false), 0.001,
                "Fallo: El cliente VIP normal debe pagar 85.0");
    }

    @Test
    public void testClienteEstandar() {
        // tC = 2, dV = true o false -> 5% descuento. 100 - 5 = 95
        assertEquals(95.0, facturacion.calcularTotal(100.0, 2, false), 0.001,
                "Fallo: El cliente Estándar debe pagar 95.0");
        assertEquals(95.0, facturacion.calcularTotal(100.0, 2, true), 0.001,
                "Fallo: El cliente Estándar debe pagar 95.0 independientemente de dV");
    }

    @Test
    public void testClienteSinCategoria() {
        // tC = 3 -> 0% descuento. 100 - 0 = 100
        assertEquals(100.0, facturacion.calcularTotal(100.0, 3, false), 0.001,
                "Fallo: Un cliente sin categoría conocida no tiene descuento.");
    }

    @Test
    public void testImporteNegativoOCero() {
        // m <= 0 -> 0
        assertEquals(0.0, facturacion.calcularTotal(0.0, 1, true), 0.001,
                "Fallo: Importe 0 debe devolver 0");
        assertEquals(0.0, facturacion.calcularTotal(-50.0, 2, false), 0.001,
                "Fallo: Importes negativos deben devolver 0");
    }
}