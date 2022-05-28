package com.pfe.elios.Controller;


import com.pfe.elios.services.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ResponseController {
    @Autowired
    ResponseService responseService;

    @GetMapping("/getResponse")
    public ResponseEntity<?> getResponse(int id) {
        return responseService.getResponsetById(id);
    }

    @PutMapping("/updateResponse")
    public ResponseEntity<?> updateResponse(@RequestParam int id,@RequestParam String desc) {
        return responseService.updateResponse(id, desc);
    }

    @DeleteMapping("/DeleteResponse")
    public ResponseEntity<?> deleteResponse(int id) {
        return responseService.deleteById(id);
    }
}
