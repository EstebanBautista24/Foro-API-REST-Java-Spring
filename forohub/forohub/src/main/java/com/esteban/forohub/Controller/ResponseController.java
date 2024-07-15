package com.esteban.forohub.Controller;

import com.esteban.forohub.model.DTO.RegisterResponse;
import com.esteban.forohub.model.DTO.ResponseDetails;
import com.esteban.forohub.model.Response;
import com.esteban.forohub.service.ResponseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/response")
public class ResponseController {
    @Autowired
    private ResponseService responseService;

    @PostMapping
    public ResponseEntity<ResponseDetails> registerResponse(@RequestBody @Valid RegisterResponse registerResponse) {
       Response response  = responseService.saveResponse(registerResponse);
       HttpHeaders headers = new HttpHeaders();
       return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(new ResponseDetails(response));
    }

}
