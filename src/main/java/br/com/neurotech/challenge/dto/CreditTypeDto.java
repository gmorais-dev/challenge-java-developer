package br.com.neurotech.challenge.dto;

import br.com.neurotech.challenge.entity.CreditType;
import br.com.neurotech.challenge.entity.VehicleModel;
import lombok.Data;

@Data
public class CreditTypeDto {

    private CreditType creditType;
    private VehicleModel vehicleModel;
    private Long idClient;
    private boolean aprovado;

}
