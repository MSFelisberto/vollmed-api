package med.vol.api.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.vol.api.endereco.Endereco;
import med.vol.api.medico.DadosCadastroMedicos;
import med.vol.api.medico.DadosListagemMedico;
import med.vol.api.medico.Medico;
import med.vol.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedicos dados) {
        medicoRepository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listarMedicos(@PageableDefault(size = 10, sort = { "nome" }) Pageable paginacao) {
        return medicoRepository.findAll(paginacao).map(DadosListagemMedico::new);
    }

}
