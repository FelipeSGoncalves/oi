package br.ifpr.crud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import br.ifpr.crud.exception.ApiException;
import br.ifpr.crud.exception.NegocioException;
import br.ifpr.crud.model.Veiculo;
import br.ifpr.crud.repository.VeiculoRepository;

@Component
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	public ResponseEntity<Veiculo> inserir(Veiculo veiculo) {
		try {
			//Validar o email duplicado
			Optional<Veiculo> optVeiculo = 			
					veiculoRepository.findById(1);
			
			if(optVeiculo.isPresent())
				throw new NegocioException(
						"Erro ao inserir o Veiculo. E-mail duplicado!");
			
			//Salvar
			veiculo = veiculoRepository.save(veiculo);
			return new ResponseEntity<Veiculo>(veiculo, HttpStatus.CREATED); 
		} catch (Exception e) {
			throw new ApiException("Erro ao inserir o veiculo.");
		}
	}
	
}


