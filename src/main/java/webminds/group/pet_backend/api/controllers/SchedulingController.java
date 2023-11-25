package webminds.group.pet_backend.api.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webminds.group.pet_backend.domain.pet.Pet;
import webminds.group.pet_backend.domain.scheduling.Scheduling;
import webminds.group.pet_backend.domain.service.AssignmentServiceEmployee;
import webminds.group.pet_backend.services.pet.PetService;
import webminds.group.pet_backend.services.scheduling.SchedulingService;
import webminds.group.pet_backend.services.scheduling.dto.SchedulingCreationDto;
import webminds.group.pet_backend.services.scheduling.dto.SchedulingDto;
import webminds.group.pet_backend.services.scheduling.dto.mapper.SchedulingMapper;
import webminds.group.pet_backend.services.service.AssignmentServiceEmployeeService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/agendamentos")
public class SchedulingController {

    private final PetService petService;
    private final AssignmentServiceEmployeeService assignmentServiceEmployeeService;
    private final SchedulingService schedulingService;

    @GetMapping
    private ResponseEntity<List<SchedulingDto>> get() {
        List<Scheduling> all = schedulingService.get();

        if (all.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(all.stream().map(SchedulingMapper::of).toList());
    }

    @GetMapping("/{id}")
    private ResponseEntity<SchedulingDto> getById(@PathVariable Long id) {
        Optional<Scheduling> item = schedulingService.getById(id);

        if (item.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(SchedulingMapper.of(item.get()));
    }

    @GetMapping("/client/{idClient}")
    private ResponseEntity<List<SchedulingDto>> getByAuthUser(@PathVariable Long idClient) {
        List<Scheduling> schedulings = schedulingService.getByAuthUser(idClient);

        if (schedulings.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(schedulings.stream().map(SchedulingMapper::of).toList());
    }

    @PostMapping
    private ResponseEntity<Void> create(@RequestBody @Valid SchedulingCreationDto schedulingCreationDto) {

        Optional<Pet> pet = petService.getById(schedulingCreationDto.getIdPet());

        if (pet.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        Optional<AssignmentServiceEmployee> assignmentServiceEmployee = assignmentServiceEmployeeService.getById(schedulingCreationDto.getIdAssignment());

        if (assignmentServiceEmployee.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        Scheduling scheduling = schedulingService.create(SchedulingMapper.ofCreation(schedulingCreationDto, pet.get(), assignmentServiceEmployee.get()));

        gravaArquivoTxt(scheduling.getId());

        return ResponseEntity.created(null).build();
    }

    @PutMapping("/{id}")
    private ResponseEntity<Void> update(@RequestBody @Valid SchedulingCreationDto schedulingCreationDto, @PathVariable Long id) {
        Optional<Pet> pet = petService.getById(schedulingCreationDto.getIdPet());

        if (pet.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        Optional<AssignmentServiceEmployee> assignmentServiceEmployee = assignmentServiceEmployeeService.getById(schedulingCreationDto.getIdAssignment());

        if (assignmentServiceEmployee.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        schedulingService.update(SchedulingMapper.ofCreation(schedulingCreationDto, pet.get(), assignmentServiceEmployee.get()), id);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> delete(@PathVariable Long id) {
        schedulingService.delete(id);
        return ResponseEntity.noContent().build();
    }

    public void gravaRegistro(String registro, String nomeArq) {
        BufferedWriter saida = null;

        // Abre o arquivo
        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        } catch (IOException erro) {
            System.out.println("Erro na abertura do arquivo");
        }

        // Grava o registro e fecha o arquivo
        try {
            saida.append(registro + "\n");
            saida.close();
        } catch (IOException erro) {
            System.out.println("Erro ao gravar o arquivo");
            erro.printStackTrace();
        }
    }

    public void gravaArquivoTxt(Long id) {
        SchedulingDto dto = SchedulingMapper.of(this.schedulingService.getById(id).get());
        int contaRegDados = 0;

        // Monta o registro de header
        String header = "00NOTA20232";
        header += LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        header += "01";

        String nomeArq = "comprovante.txt";

        // Grava o registro de header
        gravaRegistro(header, nomeArq);

        // Grava os registros de dados (ou registros de corpo)

        String corpo = "02";
        corpo += String.format("%-10.10s", dto.getAssignmentServiceEmployeeSchedulingDto().getServicePetDto().getPetShopDto().getNome());
        corpo += String.format("%-8.8s", dto.getDateScheduling());
        corpo += String.format("%-50.50s", dto.getAssignmentServiceEmployeeSchedulingDto().getEmployeeDto().getAuthUserDto().getName());
        corpo += String.format("%-40.40s", dto.getAssignmentServiceEmployeeSchedulingDto().getServicePetDto().getPrice());
        // Grava o registro de corpo
        gravaRegistro(corpo, nomeArq);
        // Incrementa o contador de registros de dados gravados
        contaRegDados++;


        // Monta e grava o registro de trailer
        String trailer = "01";
        trailer += String.format("%010d", contaRegDados);

        gravaRegistro(trailer, nomeArq);
    }

}
