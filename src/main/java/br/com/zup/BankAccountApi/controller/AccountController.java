package br.com.zup.BankAccountApi.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.zup.BankAccountApi.model.Account;
import br.com.zup.BankAccountApi.repository.AccountRepository;
import br.com.zup.BankAccountApi.utils.BindingResultUtils;

/**
 * Controller com os end-points relacionados ao CRUD da entidade Conta.
 * 
 * @author Mateus A
 */
@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
	
	@Autowired
	private AccountRepository accountRepository; 
	
	/**
	 * End-point de URL /api/v1/account - Recebe um objeto JSON no corpo da
	 * requisição, que representa uma conta a ser cadastrada, valida
	 * e tenta persistir, se o processo ocorrer com sucesso retorna o status 202.
	 * 
	 * @param account conta a ser cadastrada.
	 * @param brAccount objeto populado com os possíveis erros de validação.
	 * @return ResponseEntity representando o status HTTP 202, 422 ou 500.
	 */
	@PostMapping
	public ResponseEntity<Object> registerAccount (@Valid @RequestBody Account account, BindingResult brAccount){
		try {
			// 202 - OK / NO CONTENT
			if(!brAccount.hasErrors()) {
				accountRepository.save(account);
				return ResponseEntity.noContent().build();
			}
			else
				// 422 - UNPROCESSABLE ENTITY
				return ResponseEntity.unprocessableEntity().body(BindingResultUtils.fieldErrorstoHashMap(brAccount));
		} catch (Exception e) {
			// 500 - INTERNAL SERVER ERROR
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

}
