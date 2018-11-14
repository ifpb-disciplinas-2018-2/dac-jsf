package br.edu.ifpb.web.jsf.validator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 12/11/2018, 10:36:53
 */
@FacesValidator(value = "validator.Endereco")
public class ValidatorEndereco implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {
        System.out.println("Passei aqui:" + value);
    }

}
