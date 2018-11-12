package br.edu.ifpb.web.jsf;

import br.edu.ifpb.domain.CPF;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 12/11/2018, 09:56:11
 */
@FacesConverter(value = "converter.CPF")
public class CPFConverter implements Converter {
    // String -> CPF
    // CPF -> String

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        if (value == null) {
            return null;
        }
        return new CPF(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object value) {
        if (value == null) {
            return null;
        }
        CPF cpf = (CPF) value;
        return cpf.numero();

    }

}
