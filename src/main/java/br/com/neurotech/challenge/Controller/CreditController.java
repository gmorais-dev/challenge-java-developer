package br.com.neurotech.challenge.Controller;
import br.com.neurotech.challenge.entity.VehicleModel;
import br.com.neurotech.challenge.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credit")
public class CreditController {
    @Autowired
    private CreditService creditService;
    @GetMapping("/check")
    public ResponseEntity<Boolean> checkCredit(@RequestParam String clientId, @RequestParam VehicleModel model) {
        boolean isEligible = creditService.checkCredit(clientId, model);
        return ResponseEntity.ok(isEligible);
    }
}
