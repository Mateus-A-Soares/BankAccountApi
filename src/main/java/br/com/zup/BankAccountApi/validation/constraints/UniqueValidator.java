package br.com.zup.BankAccountApi.validation.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import br.com.zup.BankAccountApi.service.FieldValueExists;

/**
 *  Classe que executa a operação de validação nos parâmetros anotados com
 * br.com.zup.BankAccountApi.validation.constraints.Unique.
 * 
 * @author Mateus A
 *
 */
public class UniqueValidator implements ConstraintValidator<Unique, Object> {

	@Autowired
    private ApplicationContext applicationContext;
	
    private FieldValueExists service;
    private String fieldName;

    /**
     *  Primeiro método invocado no processo de validação, pega os atributos passados na anotação e
     * verifica se foi passado algo no serviceQualifier para popular o objeto FieldValueExists que será utilizado
     * no método isValid().
     * 
     * @param unique objeto representativo da anotação
     */
    @Override
    public void initialize(Unique unique) {
        Class<? extends FieldValueExists> serviceClass = unique.service();
        this.fieldName = unique.fieldName();
        String serviceQualifier = unique.serviceQualifier();

        if (!serviceQualifier.equals("")) {
            this.service = (FieldValueExists) applicationContext.getBean(serviceQualifier, serviceClass);
        } else {
            this.service = (FieldValueExists) applicationContext.getBean(serviceClass);
        }
    }

    /**
     *  Método chamado em sequência no processo de validação, utiliza o método fieldValueExists
     * implementado no objeto service para verificar se o campo passado na anotação já tem o valor
     * igual ao populado no objeto anotado.  
     * 
     * @param value valor populado no objeto anotado.
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        return !this.service.fieldValueExists(this.fieldName, value);
    }
}