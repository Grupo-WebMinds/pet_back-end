package webminds.group.pet_backend.services.pet.listPet;
import webminds.group.pet_backend.services.pet.PetService;
import webminds.group.pet_backend.services.pet.dto.PetDTO;
import webminds.group.pet_backend.utils.ListaObj;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.List;

public class ListaPet {

    private ListaObj<PetDTO> listObj;
    public void TamanhoArq(int tam){
         listObj = new ListaObj<>(tam);
    }

    public void adicionar(List<PetDTO> petDTOS){
        for (PetDTO p: petDTOS){
            this.listObj.adiciona(p);
        }
    }


    public void GravaArquivoCsv(String nomeArq) {
        FileWriter arq = null; // arq representa o arquivo de escrito
        Formatter saida = null; // Será usado para escrever no arquivo
        Boolean deuRuim = false;

        nomeArq += ".csv"; // Está acrescentando a extensão .csv ao nome do arquivo

        // Bloco try-catch para abrir o arquivo
        try {
            arq = new FileWriter(nomeArq); // Abre o arquivo para escrita
            saida = new Formatter(arq); // Associa o objeto saída ao arquivo
        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo!");
            System.exit(1);
        }

        // Bloco try-catch para gravar o arquivo
        try {
            for (int i = 0; i < listObj.getTamanho(); i++) {
                PetDTO pet = listObj.getElemento(i);
                // Grava os dados do pet no arquivo csv
                // separando cada valor com um ; e finalizando com um \n
                saida.format("%d;%s;%s;%s;%s\n", pet.getId(), pet.getName(), pet.getBirthDate(), pet.getGender(), pet.getSize());
            }
        } catch (FormatterClosedException e) {
            System.out.println("Erro ao gravar o arquivo");
            e.printStackTrace();
            deuRuim = true;
        } finally {
            saida.close();
            try {
                arq.close();
            } catch (IOException e) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }

            if (deuRuim) {
                System.exit(1);
            }
        }
    }

}
