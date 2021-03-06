package com.basis.grupoum.sgt.service.recurso;


import com.basis.grupoum.sgt.service.servico.ItemServico;
import com.basis.grupoum.sgt.service.servico.dto.ItemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/itens")
@RequiredArgsConstructor
public class ItemRecurso {
    private final ItemServico itemServico;

    @GetMapping
    public ResponseEntity<List<ItemDTO>> listar(){
        List<ItemDTO> itens = itemServico.listar();
        return new ResponseEntity<>(itens, HttpStatus.OK);
    }

    @GetMapping("/disponibilidade/{campo}")
    public ResponseEntity<List<ItemDTO>> listarItensDisponiveis(@PathVariable("campo") boolean campo ){
        List<ItemDTO> itens = itemServico.listarItensDisponiveis(campo);
        return new ResponseEntity<>(itens, HttpStatus.OK);
    }

    @GetMapping("/nome/{campo}")
    public ResponseEntity<List<ItemDTO>> listarItensPorNome(@PathVariable("campo") String campo ){
        List<ItemDTO> itens = itemServico.listarItensPorNome(campo);
        return new ResponseEntity<>(itens, HttpStatus.OK);
    }

    @GetMapping("/categoria/{campo}")
    public ResponseEntity<List<ItemDTO>> listarItensPorCategoria(@PathVariable("campo") Long campo ){
        List<ItemDTO> itens = itemServico.listarItensPorCategoria(campo);
        return new ResponseEntity<>(itens, HttpStatus.OK);
    }

    @GetMapping("/usuario/{campo}")
    public ResponseEntity<List<ItemDTO>> listarItensPorUsuario(@PathVariable("campo") Long campo ){
        List<ItemDTO> itens = itemServico.listarItensPorUsuario(campo);
        return new ResponseEntity<>(itens, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> obterPorId(@PathVariable("id") Long idItem){
        ItemDTO item = itemServico.obterPorId(idItem);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ItemDTO> salvar(@RequestBody ItemDTO itemDTO){
        ItemDTO item = itemServico.salvar(itemDTO);
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ItemDTO> atualizar(@RequestBody ItemDTO itemDTO){
        ItemDTO item = itemServico.salvar(itemDTO);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long idItem){
        itemServico.deletar(idItem);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
