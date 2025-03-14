package br.com.neurotech.challenge.service.impl;

import br.com.neurotech.challenge.Exceptions.ResourceNotFoundException;
import br.com.neurotech.challenge.dto.CreditTypeDto;
import br.com.neurotech.challenge.entity.CreditType;
import br.com.neurotech.challenge.entity.NeurotechClient;
import br.com.neurotech.challenge.entity.VehicleModel;
import br.com.neurotech.challenge.service.ClientService;
import br.com.neurotech.challenge.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CreditServiceImpl implements CreditService {
    @Autowired
    ClientService clientService;
    @Override
    public boolean checkCredit(String clientId, VehicleModel model) {
        NeurotechClient client = clientService.get(clientId);
        CreditTypeDto creditTypeDto = new CreditTypeDto();
        if (client == null) {
            throw new ResourceNotFoundException("Client not found");
        }
        CreditType creditType = this.personalcredit(client);
        if (creditType == CreditType.REJECTED){
            return false;
        }
        creditTypeDto.setCreditType(creditType);
        creditTypeDto.setIdClient(client.getId());
        switch (model) {
            case HATCH:
                    return client.getIncome() >= 5000 && client.getIncome() <= 15000;
            case SUV:
                    return client.getIncome() > 8000 && client.getAge() > 20;
            default:
                return false;
        }
    }
    public CreditType personalcredit (NeurotechClient neurotechClient){
        if((neurotechClient.getAge() >= 21 && neurotechClient.getAge() <= 65) && (neurotechClient.getIncome() >= 5000.0 && neurotechClient.getIncome() <= 15000.0) ){
           return CreditType.VARIABLE;
        } else if (neurotechClient.getAge() >= 18 && neurotechClient.getAge() <= 25) {
           return CreditType.FIXED;
        } else if (neurotechClient.getAge() > 65) {
            return CreditType.CONSIGNED;
        } else {
            return CreditType.REJECTED;
        }
    }
}









