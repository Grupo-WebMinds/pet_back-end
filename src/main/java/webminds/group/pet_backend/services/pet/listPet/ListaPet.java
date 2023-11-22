//package webminds.group.pet_backend.services.pet.listPet;
//import webminds.group.pet_backend.services.pet.dto.PetDto;
//import webminds.group.pet_backend.utils.ListaObj;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.time.LocalDate;
//import java.util.Formatter;
//import java.util.FormatterClosedException;
//import java.util.List;
//
//public class ListaPet {
//
//    private ListaObj<PetDto> listObj;
//
//    public void TamanhoArq(int tam) {
//        listObj = new ListaObj<>(tam);
//    }
//
//    public void adicionar(List<PetDto> petDTOS) {
//        for (PetDto p : petDTOS) {
//            this.listObj.adiciona(p);
//        }
//    }
//
//    public void bubbleSort() {
//
//        for (int i = 0; i < listObj.getTamanho() - 1; i++) {
//            for (int j = 1; j < listObj.getTamanho() - i; j++) {
//                Long idAnt = listObj.getElemento(j - 1).getId();
//                String nameAnt = listObj.getElemento(j - 1).getName();
//                LocalDate birthDateAnt = listObj.getElemento(j - 1).getBirthDate();
//                String genderAnt = listObj.getElemento(j - 1).getGender();
//                String sizeAnt = listObj.getElemento(j - 1).getSize();
//
//                Long idNew = listObj.getElemento(j).getId();
//                String nameNew = listObj.getElemento(j).getName();
//                LocalDate birthDateNew = listObj.getElemento(j).getBirthDate();
//                String genderNew = listObj.getElemento(j).getGender();
//                String sizeNew = listObj.getElemento(j).getSize();
//
//                if (nameAnt.length() > nameNew.length()) {
//                    listObj.getElemento(j).setId(idAnt);
//                    listObj.getElemento(j).setName(nameAnt);
//                    listObj.getElemento(j).setBirthDate(birthDateAnt);
//                    listObj.getElemento(j).setGender(genderAnt);
//                    listObj.getElemento(j).setSize(sizeAnt);
//
//                    listObj.getElemento(j - 1).setId(idNew);
//                    listObj.getElemento(j - 1).setName(nameNew);
//                    listObj.getElemento(j - 1).setBirthDate(birthDateNew);
//                    listObj.getElemento(j - 1).setGender(genderNew);
//                    listObj.getElemento(j - 1).setSize(sizeNew);
//                }
//            }
//        }
//    }
//
//
//    public void GravaArquivoCsv(String nomeArq) {
//        FileWriter arq = null; // arq representa o arquivo de escrito
//        Formatter saida = null; // Será usado para escrever no arquivo
//        Boolean deuRuim = false;
//
//        nomeArq += ".csv"; // Está acrescentando a extensão .csv ao nome do arquivo
//
//        // Bloco try-catch para abrir o arquivo
//        try {
//            arq = new FileWriter(nomeArq); // Abre o arquivo para escrita
//            saida = new Formatter(arq); // Associa o objeto saída ao arquivo
//        } catch (IOException e) {
//            System.out.println("Erro ao abrir o arquivo!");
//            System.exit(1);
//        }
//
//        // Bloco try-catch para gravar o arquivo
//        try {
//            for (int i = 0; i < listObj.getTamanho(); i++) {
//                PetDto pet = listObj.getElemento(i);
//                // Grava os dados do pet no arquivo csv
//                // separando cada valor com um ; e finalizando com um \n
//                saida.format("%d;%s;%s;%s;%s\n", pet.getId(), pet.getName(), pet.getBirthDate(), pet.getGender(), pet.getSize());
//            }
//        } catch (FormatterClosedException e) {
//            System.out.println("Erro ao gravar o arquivo");
//            e.printStackTrace();
//            deuRuim = true;
//        } finally {
//            saida.close();
//            try {
//                arq.close();
//            } catch (IOException e) {
//                System.out.println("Erro ao fechar o arquivo");
//                deuRuim = true;
//            }
//
//            if (deuRuim) {
//                System.exit(1);
//            }
//        }
//    }
//
//}
