package br.com.zup.BankAccountApi.service;

/**
 *  Interface que extende a interface br.com.zup.BankAccountApi.service.FieldValueExists
 *  para que sua implementação (br.com.zup.BankAccountApi.service.AccountServiceImpl)
 *  possa ser utilizada como parâmetro na utilização da anotação
 *  br.com.zup.BankAccountApi.validation.constraints.Unique.
 * 
 * @author Mateus A
 *
 */
public interface AccountService extends FieldValueExists {
}
