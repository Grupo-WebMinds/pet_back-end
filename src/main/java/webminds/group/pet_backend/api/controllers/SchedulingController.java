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
import webminds.group.pet_backend.utils.list.FilaObj;
import webminds.group.pet_backend.utils.list.PilhaObj;

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

    @GetMapping("/fila")
    private ResponseEntity<FilaObj> getFila() {
        List<Scheduling> all = schedulingService.get();

        if (all.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<SchedulingDto> list = all.stream().map(SchedulingMapper::of).toList();

        FilaObj filaObj = new FilaObj(list.size());

        filaObj.insert(list);

        return  ResponseEntity.ok(filaObj);
    }

    @GetMapping("/pilha")
    private ResponseEntity<PilhaObj> getPilha() {
        List<Scheduling> all = schedulingService.get();

        if (all.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<SchedulingDto> list = all.stream().map(SchedulingMapper::of).toList();

        PilhaObj pilhaObj = new PilhaObj(list.size());

        pilhaObj.push(list);

        return  ResponseEntity.ok(pilhaObj);
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

        String nomeArq = "comprovante.txt";

        String corpo = "Comprovonate";
        corpo += String.format("%-40.40s", "\nNome Client: " + dto.getPetDto().getAuthUserDto().getName());
        corpo += String.format("%-40.40s", "\nCpf: " + dto.getPetDto().getAuthUserDto().getCpf());
        corpo += String.format("%-40.40s", "\nNome Pet: "+ dto.getPetDto().getName());
        corpo += String.format("%-40.40s", "\nPetShop: " + dto.getAssignmentServiceEmployeeSchedulingDto().getServicePetDto().getPetShopDto().getNome());
        corpo += String.format("%-40.40s", "\nCnpj: " + dto.getAssignmentServiceEmployeeSchedulingDto().getServicePetDto().getPetShopDto().getCnpj());
        corpo += String.format("%-40.40s", "\nData/Hora: " + dto.getDateScheduling());
        corpo += String.format("%-40.40s", "\nNome Funcionario: " + dto.getAssignmentServiceEmployeeSchedulingDto().getEmployeeDto().getAuthUserDto().getName());
        corpo += String.format("%-40.40s", "\nPreço: R$" + dto.getAssignmentServiceEmployeeSchedulingDto().getServicePetDto().getPrice());

        gravaRegistro(corpo, nomeArq);

    }

}
