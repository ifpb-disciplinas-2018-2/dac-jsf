package br.edu.ifpb.domain;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ricardo Job
 */
public class CPFTest {

    private final CPF instance = new CPF("12345678909");

    @Test
    public void testNumero() {
        System.out.println("numero");
        String expResult = "12345678909";
        String result = instance.numero();
        assertEquals(expResult, result);
    }

    @Test
    public void testFormatado() {
        System.out.println("formatado");
        String expResult = "123.456.789-09";
        String result = instance.formatado();
        assertEquals(expResult, result);
    }
    @Test
    public void testFormatacaoIncorreta() {
        System.out.println("formatado");
        String expResult = "123.456.789-00";
        String result = instance.formatado();
        assertNotEquals(expResult, result);
    }

}
