package br.com.zup.BankAccountApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.BankAccountApi.repository.AccountRepository;

/**
 *  Classe service que define o método utilizado pela anotação
 *  br.com.zup.BankAccountApi.validation.constraints.Unique, no processo de validação.
 *
 * @author Mateus A
 *
 */
@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
    private AccountRepository accountRepository;

	/**
	 *  Implementação do método utilizado no processo de validação de unicidade dos campos email e cpf para a entidade Conta.
	 */
    @Override
    public boolean fieldValueExists(String fieldName, Object value) throws UnsupportedOperationException {
    	switch (fieldName) {
		case "email":
			return this.accountRepository.existsHowManyByEmail(value.toString()) > 0;
		case "cpf":
			return this.accountRepository.existsHowManyByCPF(value.toString()) > 0;
		default:
			return false;
		}
    }
}
