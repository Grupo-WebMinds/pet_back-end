package webminds.group.pet_backend.api.list;
import webminds.group.pet_backend.services.scheduling.dto.SchedulingDto;
import webminds.group.pet_backend.utils.ListaObj;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.List;

public class ListScheduling {

    private ListaObj<SchedulingDto> listObj;

    public void TamanhoArq(int tam) {
        listObj = new ListaObj<>(tam);
    }

    public void adicionar(List<SchedulingDto> schedulingDto) {
        for (SchedulingDto s : schedulingDto) {
            this.listObj.adiciona(s);
        }
    }

    public void bubbleSort() {

        for (int i = 0; i < listObj.getTamanho() - 1; i++) {
            for (int j = 1; j < listObj.getTamanho() - i; j++) {

                LocalDateTime dateSchedulingAnt = listObj.getElemento(j - 1).getDateScheduling();
                String observationAnt = listObj.getElemento(j - 1).getObservation();
                String namePetAnt = listObj.getElemento(j - 1).getPetDto().getName();
                String nameServiceAnt = listObj.getElemento(j - 1).getAssignmentServiceEmployeeSchedulingDto().getServicePetDto().getName();

                LocalDateTime dateSchedulingNew = listObj.getElemento(j).getDateScheduling();
                String observationNew = listObj.getElemento(j).getObservation();
                String namePetNew = listObj.getElemento(j).getPetDto().getName();
                String nameServiceNew = listObj.getElemento(j).getAssignmentServiceEmployeeSchedulingDto().getServicePetDto().getName();

                if (dateSchedulingAnt.isAfter(dateSchedulingNew)) {
                    listObj.getElemento(j).setDateScheduling(dateSchedulingAnt);
                    listObj.getElemento(j).setObservation(observationAnt);
                    listObj.getElemento(j).getPetDto().setName(namePetAnt);
                    listObj.getElemento(j).getAssignmentServiceEmployeeSchedulingDto().getServicePetDto().setName(nameServiceAnt);

                    listObj.getElemento(j - 1).setDateScheduling(dateSchedulingNew);
                    listObj.getElemento(j - 1).setObservation(observationNew);
                    listObj.getElemento(j - 1).getPetDto().setName(namePetNew);
                    listObj.getElemento(j - 1).getAssignmentServiceEmployeeSchedulingDto().getServicePetDto().setName(nameServiceNew);
                }
            }
        }
    }


    public void GravaArquivoCsv() {
        FileWriter arq = null; // arq representa o arquivo de escrito
        Formatter saida = null; // Será usado para escrever no arquivo
        Boolean deuRuim = false;

        String nomeArq = "agendamento.csv"; // Está acrescentando a extensão .csv ao nome do arquivo

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
                SchedulingDto agendamento = listObj.getElemento(i);
                // Grava os dados do agendamento no arquivo csv
                // separando cada valor com um ; e finalizando com um \n
                saida.format("%s;%s;%s;%s\n", agendamento.getPetDto().getName(), agendamento.getAssignmentServiceEmployeeSchedulingDto().getServicePetDto().getName(),
                        agendamento.getObservation(), agendamento.getDateScheduling());
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
