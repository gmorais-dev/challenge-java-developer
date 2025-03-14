package br.com.neurotech.challenge.Controller;

import br.com.neurotech.challenge.dto.EligibleClientDto;
import br.com.neurotech.challenge.entity.NeurotechClient;
import br.com.neurotech.challenge.repository.NeurotechClientRepository;
import br.com.neurotech.challenge.service.ClientService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private NeurotechClientRepository neurotechClientRepository;
    @PostMapping
    public ResponseEntity<String> saveClient(@RequestBody NeurotechClient client, HttpServletRequest request, HttpServletResponse response) throws BadRequestException {
        String idClient = this.clientService.save(client);
        String header = request.getHeader("Location");
        response.setHeader("Location", header + "/" + idClient);
        return ResponseEntity.status(HttpStatus.CREATED).body("Registered successfully");
    }
    @GetMapping("/{id}")
    public ResponseEntity<NeurotechClient> getClient(@PathVariable String id) {
        NeurotechClient neurotechClient = clientService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(neurotechClient);
    }
    @GetMapping("/eligible-hatch")
    public List<EligibleClientDto> getEligibleClientsForHatch() {
        return clientService.getEligibleHatchClients();
    }
}












