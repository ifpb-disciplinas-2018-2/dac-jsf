package br.edu.ifpb.web.jsf.convert;

import br.edu.ifpb.domain.Clientes;
import br.edu.ifpb.domain.Endereco;
import br.edu.ifpb.infra.ClientesEmMemoria;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 12/11/2018, 10:23:37
 */
@FacesConverter(value = "converter.Endereco")
public class EnderecoConverter implements Converter {

    private Clientes clientes = new ClientesEmMemoria();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) { // o valor da propriedade rua do Endereco
        if (value == null) {
            return null;
        }
        return clientes.localizarEnderecoComRua(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object value) {
        if (value == null) {
            return null;
        }
        Endereco endereco = (Endereco) value;
        return endereco.getRua();
    }

}
