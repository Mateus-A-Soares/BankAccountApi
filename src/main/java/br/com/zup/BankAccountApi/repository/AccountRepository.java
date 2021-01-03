package br.com.zup.BankAccountApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

	/**
	 * Método DAO que busca a quantidade de registros da entidade Conta por email. 
	 *  
	 * @param email email para consulta
	 * @return quantidade de registros com o email igual ao passado de parâmetro
	 */
    @Query("SELECT COUNT (*) FROM Account a where a.email= :email")
	long existsHowManyByEmail(@Param("email") String email);
    
    /**
	 * Método DAO que busca a quantidade de registros da entidade Conta por cpf. 
	 *  
	 * @param cpf cpf para consulta
	 * @return quantidade de registros com o cpf igual ao passado de parâmetro
	 */
    @Query("SELECT COUNT (*) FROM Account a where a.cpf= :cpf")
    long existsHowManyByCPF(@Param("cpf") String cpf);
}
