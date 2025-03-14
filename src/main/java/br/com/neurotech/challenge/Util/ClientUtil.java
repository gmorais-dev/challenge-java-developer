package br.com.neurotech.challenge.Util;
import br.com.neurotech.challenge.entity.NeurotechClient;
import org.apache.coyote.BadRequestException;
public class ClientUtil {
    public static void validateClienteSave(NeurotechClient neurotechClient) throws BadRequestException {
        if (neurotechClient.getName() == null || neurotechClient.getName().isBlank()) {
            throw new BadRequestException("Error saving client, empty name");
        }
        if (neurotechClient.getAge() == null) {
            throw new BadRequestException("Error saving client, empty age");
        }
        if (neurotechClient.getIncome() == null) {
            throw new BadRequestException("Error saving client, empty income");
        }
    }
}





