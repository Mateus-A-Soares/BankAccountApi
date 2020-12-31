package br.com.zup.BankAccountApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.zup.BankAccountApi.model.Account;

/**
 * 
 *	Extende a interface org.springframework.data.jpa.repository.JpaRepository.
 *	Essa implementa as operações padrões de CRUD para a classe modelo br.com.zup.BankAccountApi.model.Account.
 * 
 * @author Mateus A
 *
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
