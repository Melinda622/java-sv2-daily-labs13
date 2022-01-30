package day05;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class TransferAggregator {

    private List<String> file1;
    private Map<String,TransferPerClient> transfersMap=new TreeMap<>();

    public List<String> readTransfers(Path path){
        List<String> lines=new ArrayList<>();
        try {
            lines=Files.readAllLines(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        file1=lines;
        return lines;
    }

   public Map<String,TransferPerClient> splitTransfers(){
        String[] temp;

       List<TransferPerClient> temporary=new ArrayList<>();


        for (int i = 0; i <file1.size() ; i++) {
            temp=file1.get(i).split(",");

            String sourceClientId=temp[0];
            String targetClientId=temp[1];
            int amount=Integer.parseInt(temp[2]);

            TransferPerClient transferPerClient=new TransferPerClient(sourceClientId,0,0);
            transferPerClient.decrease(amount);


            if(transfersMap.containsKey(transferPerClient.getClientId())){
                double totalSum=transfersMap.get(transferPerClient.getClientId()).getSum()+ transferPerClient.getSum();
                int totalNumberOfTransactions=transfersMap.get(transferPerClient.getClientId()).getNumberOfTransactions()+transferPerClient.getNumberOfTransactions();
                transfersMap.put(transferPerClient.getClientId(),new TransferPerClient(transferPerClient.getClientId(),totalSum,totalNumberOfTransactions));
            }else{
                transfersMap.put(transferPerClient.getClientId(),transferPerClient);
            }


            TransferPerClient transferPerClient2=new TransferPerClient(targetClientId,0,0);
            transferPerClient2.increase(amount);

            if(transfersMap.containsKey(transferPerClient2.getClientId())){
                double totalSum=transfersMap.get(transferPerClient2.getClientId()).getSum()+ transferPerClient2.getSum();
                int totalNumberOfTransactions=transfersMap.get(transferPerClient2.getClientId()).getNumberOfTransactions()+transferPerClient2.getNumberOfTransactions();
                transfersMap.put(transferPerClient2.getClientId(),new TransferPerClient(transferPerClient2.getClientId(),totalSum,totalNumberOfTransactions));
            }else{
                transfersMap.put(transferPerClient2.getClientId(),transferPerClient2);
            }

        }
            return transfersMap;

    }
}
