package br.com.zup.BankAccountApi.service;

/**
 *  Interface que deve ser implementada em uma nova classe service para cada modelo
 *  que utilizar a anotação br.com.zup.BankAccountApi.validation.constraints.Unique.
 * 
 * @author Mateus A
 *
 */
public interface FieldValueExists {
	
	/**
	 *   Método utilizado na validação de unicidade dos parâmetros que receberem a anotação Unique.
	 * Valida se o campo passado já tem registrado na base de dados o valor passado.
	 *  
	 * @param fieldName nome do campo a ser validado.
	 * @param value valor do campo a ser validado.
	 * @return true se o campo tem registrado o valor passado, false se não.
	 * @throws UnsupportedOperationException
	 */
    boolean fieldValueExists(String fieldName, Object value) throws UnsupportedOperationException;
}
