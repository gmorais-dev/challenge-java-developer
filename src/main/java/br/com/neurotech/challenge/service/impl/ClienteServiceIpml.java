package br.com.neurotech.challenge.service.impl;
import br.com.neurotech.challenge.dto.EligibleClientDto;
import br.com.neurotech.challenge.entity.CreditType;
import br.com.neurotech.challenge.entity.NeurotechClient;
import br.com.neurotech.challenge.repository.NeurotechClientRepository;
import br.com.neurotech.challenge.service.ClientService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import static br.com.neurotech.challenge.Util.ClientUtil.validateClienteSave;

@Service
public class ClienteServiceIpml implements ClientService {
    @Autowired
    private NeurotechClientRepository neurotechClientRepository;
    @Override
    public String save(NeurotechClient client) throws BadRequestException {
        validateClienteSave(client);
        NeurotechClient savedClient = neurotechClientRepository.save(client);
        return savedClient.getId().toString();
    }
    @Override
    public NeurotechClient get(String id) {
        NeurotechClient neurotechClient = neurotechClientRepository.getById(Long.valueOf(id));
        return neurotechClient;
    }
    public List<EligibleClientDto> getEligibleHatchClients() {
        List<NeurotechClient> clients = neurotechClientRepository.findAll();
        return clients.stream()
                .filter(client-> client.getAge() >= 23 && client.getAge() <= 49)
                .filter(client -> isEligibleForHatch(client))
                .map(client -> new EligibleClientDto(client.getName(), client.getIncome()))
                .collect(Collectors.toList());
    }
    private boolean isEligibleForHatch(NeurotechClient client) {
        return client.getIncome() >= 5000 && client.getIncome() <= 15000;
    }
}

