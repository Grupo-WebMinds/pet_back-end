package webminds.group.pet_backend.api.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import webminds.group.pet_backend.utils.list.ListScheduling;
import webminds.group.pet_backend.domain.scheduling.Scheduling;
import webminds.group.pet_backend.services.scheduling.SchedulingService;
import webminds.group.pet_backend.services.scheduling.dto.SchedulingDto;
import webminds.group.pet_backend.services.scheduling.dto.mapper.SchedulingMapper;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/arquivos")
public class ArquivoController {

    private Path diretorioBase = Path.of(System.getProperty("user.dir")); // projeto

    private final SchedulingService schedulingService;

//    @PostMapping("/upload")
//    public ResponseEntity<Arquivo> upload(@RequestParam("arquivo") MultipartFile file) {
//
//        if (file.isEmpty()) {
//            return ResponseEntity.status(400).build();
//        }
//
//        if (!this.diretorioBase.toFile().exists()) {
//            this.diretorioBase.toFile().mkdir();
//        }
//
//
//        String nomeArquivoFormatado = formatarNomeArquivo(file.getOriginalFilename());
//
//        String filePath = this.diretorioBase + "/" + nomeArquivoFormatado;
//        File dest = new File(filePath);
//        try {
//            file.transferTo(dest);
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new ResponseStatusException(422, "Não foi possível salvar o arquivo", null);
//        }
//
//        Arquivo arquivo = new Arquivo();
//        arquivo.setDataUpload(LocalDate.now());
//        arquivo.setNomeArquivoOriginal(file.getOriginalFilename());
//        arquivo.setNomeArquivoSalvo(nomeArquivoFormatado);
//        Arquivo arquivoBanco = arquivoRepository.save(arquivo);
//
//        return ResponseEntity.status(200).body(arquivoBanco);
//    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable Long id) {

        List<Scheduling> schedulings = schedulingService.getByAuthUser(id);

        if (schedulings.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<SchedulingDto> dtos = schedulings.stream().map(SchedulingMapper::of).toList();

        ListScheduling listScheduling = new ListScheduling();

        listScheduling.TamanhoArq(dtos.size());

        listScheduling.adicionar(dtos);

        listScheduling.bubbleSort();

        listScheduling.GravaArquivoCsv();

        File file = this.diretorioBase.resolve("agendamento.csv").toFile();
        try {
            InputStream fileInputStream = new FileInputStream(file);

            return ResponseEntity.status(200)
                    .header("Content-Disposition",
                            "attachment; filename=agendamento.csv")
                    .body(fileInputStream.readAllBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new ResponseStatusException(422, "Diretório não encontrado", null);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ResponseStatusException(422, "Não foi possível converter para byte[]", null);
        }
    }

    @GetMapping("/download-txt")
    public ResponseEntity<byte[]> downloadTxt() {

        File file = this.diretorioBase.resolve("comprovante.txt").toFile();
        try {
            InputStream fileInputStream = new FileInputStream(file);

            return ResponseEntity.status(200)
                    .header("Content-Disposition",
                            "attachment; filename=comprovante.txt")
                    .body(fileInputStream.readAllBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new ResponseStatusException(422, "Diretório não encontrado", null);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ResponseStatusException(422, "Não foi possível converter para byte[]", null);
        }
    }

//    private String formatarNomeArquivo(String nomeOriginal) {
//        return String.format("%s_%s", UUID.randomUUID(), nomeOriginal);
//    }
}
