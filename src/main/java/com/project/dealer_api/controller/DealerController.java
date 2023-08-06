package com.project.dealer_api.controller;

import com.project.dealer_api.domain.dealer.*;
import com.project.dealer_api.service.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@CrossOrigin(origins = {"http://localhost:3000","http://localhost:3001" })
@RestController
@RequestMapping(value ="/dealer")
public class DealerController {
    @Autowired
    private DealerService dealerService;

    public DealerController(DealerService dealerService){
        this.dealerService = dealerService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DealerDetailDTO> dealer(@PathVariable Integer id){
        var dealer = dealerService.findById(id);
        return ResponseEntity.ok(new DealerDetailDTO(dealer));
    }

    @GetMapping
    public ResponseEntity<Page<DealerListDTO>> list(Pageable pageable){
        var list = dealerService.findAll(pageable).map(DealerListDTO::new);
        return ResponseEntity.ok(list);
    }

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid DealerCreateDTO dealerCreateDTO, UriComponentsBuilder uriComponentsBuilder){
        var dealer = new Dealer(dealerCreateDTO);
        dealerService.create(dealer);

        var uri = uriComponentsBuilder.path("/dealer/{id}").buildAndExpand(dealer.getId()).toUri();
        return ResponseEntity.created(uri).body(new DealerDetailDTO(dealer));
    }

    @DeleteMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Integer id){
        dealerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DealerDetailDTO> update(@RequestBody @Valid DealerUpdateDTO dealerUpdateDTO){
        var dealer = dealerService.findById(dealerUpdateDTO.id());
        dealer.update(dealerUpdateDTO);

        return ResponseEntity.ok(new DealerDetailDTO(dealer));
    }
}
