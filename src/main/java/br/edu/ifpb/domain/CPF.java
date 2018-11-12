package br.edu.ifpb.domain;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 12/11/2018, 09:41:10
 */
public class CPF {

    private String numero;

    public CPF() {
        this("");
    }

    public CPF(String numero) {
        this.numero = numero;
    }

    public String numero() {
        // * numero: 12345678901
        return this.numero;
    }

    public String formatado() {
        // * numero Formatado: 123.456.789-01
        return this.numero.substring(0, 3) + "."
                + this.numero.substring(3, 6) + "."
                + this.numero.substring(6, 9) + "-"
                + this.numero.substring(9, 11);
    }

    public boolean ehValido() {
        return this.numero.trim().length() == 11;
    }

}
