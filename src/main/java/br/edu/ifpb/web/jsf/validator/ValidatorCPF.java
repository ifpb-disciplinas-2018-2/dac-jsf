package br.edu.ifpb.web.jsf.validator;

import br.edu.ifpb.domain.CPF;
import javax.faces.application.FacesMessage;
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
@FacesValidator(value = "validator.CPF")
public class ValidatorCPF implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {
        CPF cpf = (CPF) value;

        if (!cpf.ehValido()) {
//            context.addMessage("cpf", new FacesMessage("CPF Inválido"));
            throw new ValidatorException(
                    new FacesMessage("CPF Inválido")
            );
        }
    }

}
