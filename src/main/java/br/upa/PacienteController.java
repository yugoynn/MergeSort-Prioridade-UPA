package br.upa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PacienteController {

    // pacientes em ordem de chegada (guardados so na memoria)
    private final List<Paciente> chegada = new ArrayList<>();

    public PacienteController() {
        chegada.add(new Paciente("Joao", 30, "Verde"));
        chegada.add(new Paciente("Maria", 72, "Amarelo"));
        chegada.add(new Paciente("Pedro", 45, "Vermelho"));
        chegada.add(new Paciente("Ana", 25, "Amarelo"));
        chegada.add(new Paciente("Carlos", 80, "Azul"));
        chegada.add(new Paciente("Lucia", 60, "Laranja"));
        chegada.add(new Paciente("Jose", 90, "Verde"));
    }

    @GetMapping("/chegada")
    public List<Paciente> listarChegada() {
        return chegada;
    }

    @GetMapping("/fila")
    public List<Paciente> listarFila() {
        return MergeSort.ordenar(chegada);
    }

    @PostMapping("/pacientes")
    public ResponseEntity<String> cadastrar(@RequestBody Paciente paciente) {
        if (!PrioridadeDasCores.corValida(paciente.getCor())) {
            return ResponseEntity.badRequest().body("Cor invalida");
        }
        chegada.add(paciente);
        return ResponseEntity.ok("Paciente cadastrado");
    }

    // chama o primeiro da fila ordenada e remove ele da lista
    @PostMapping("/chamar")
    public ResponseEntity<Paciente> chamarProximo() {
        if (chegada.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        Paciente proximo = MergeSort.ordenar(chegada).get(0);
        chegada.remove(proximo);
        return ResponseEntity.ok(proximo);
    }
}
