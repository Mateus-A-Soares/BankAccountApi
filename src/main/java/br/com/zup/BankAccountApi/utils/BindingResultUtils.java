package br.com.zup.BankAccountApi.utils;

import java.util.HashMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * 	Classe com métodos auxiliares para utilização do BindingResult.  
 * 
 * @author Mateus A
 */
public class BindingResultUtils {
	
	/**
	 * Método que transforma os erros de campos do BindingResult em um HashMap de células no formato parâmetro-erro.
	 * 
	 * @param br BindingResult usado na transformacao.
	 * @return HashMap contendo os erros dos campos do BindingResult passado.
	 */
	public static HashMap<String, String> fieldErrorstoHashMap(BindingResult bindingResult){
		HashMap<String, String> hashMap = new HashMap<>();
		for(FieldError fieldError : bindingResult.getFieldErrors()) {
			hashMap.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return hashMap;
	}
}
