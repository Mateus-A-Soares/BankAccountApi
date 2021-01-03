package br.com.zup.BankAccountApi.validation.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.zup.BankAccountApi.service.FieldValueExists;

/**
 *  Anotação utilizada nas classes que representam entidades, nos parâmetros em que deve ocorrer verificação de unicidade
 * antes da tentativa de persistência no banco de dados; 
 *  
 * @author Mateus A
 *
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueValidator.class)
public @interface Unique {
    String message() default "{unique.value.violation}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    Class<? extends FieldValueExists> service();
    String serviceQualifier() default "";
    String fieldName();
}
