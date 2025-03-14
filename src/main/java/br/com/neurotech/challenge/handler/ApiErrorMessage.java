package br.com.neurotech.challenge.handler;
import lombok.Data;
import java.time.Instant;
@Data
public class ApiErrorMessage {
    private Integer status;
    private Instant timestamp;
    private String error;
    private String messagem;
    private String path;
}




