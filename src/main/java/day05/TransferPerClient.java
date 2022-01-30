package day05;

public class TransferPerClient {

    private String clientId;
    private double sum;
    private int numberOfTransactions;

    public TransferPerClient(String clientId, double sum, int numberOfTransactions) {
        this.clientId = clientId;
        this.sum = sum;
        this.numberOfTransactions = numberOfTransactions;
    }

    public TransferPerClient(String clientId) {
        this.clientId = clientId;
    }

    public void increase(double amount){
        sum=0;
        sum+=amount;
        numberOfTransactions+=1;
    }

    public void decrease(double amount){
        sum=0;
        sum-=amount;
        numberOfTransactions+=1;
    }


    public String getClientId() {
        return clientId;
    }

    public double getSum() {
        return sum;
    }

    public int getNumberOfTransactions() {
        return numberOfTransactions;
    }

    @Override
    public String toString() {
        return "TransferPerClient{" +
                "clientId='" + clientId + '\'' +
                ", sum=" + sum +
                ", numberOfTransactions=" + numberOfTransactions +
                '}';
    }
}
