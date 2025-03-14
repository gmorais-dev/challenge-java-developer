package br.com.neurotech.challenge.service;

import br.com.neurotech.challenge.dto.EligibleClientDto;
import br.com.neurotech.challenge.entity.NeurotechClient;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {
	/**
	 * Salva um novo cliente
	 * 
	 * @return ID do cliente recém-salvo
	 */
	String save(NeurotechClient client) throws BadRequestException;

	/**
	 * Recupera um cliente baseado no seu ID
	 */
	NeurotechClient get(String id);
	List<EligibleClientDto> getEligibleHatchClients();

}
