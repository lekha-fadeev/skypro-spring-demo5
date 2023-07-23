package pro.sky.skyprospringdemo5.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class EmployeeStorageIsFullException extends HttpStatusCodeException {

    public EmployeeStorageIsFullException(String massage){
        super(HttpStatus.BAD_REQUEST, massage);
    }
}
