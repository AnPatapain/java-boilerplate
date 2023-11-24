package tds.td3_fileIO;

public class ExceptionUtilise extends RuntimeException {
    private int numeroEmp;
    public ExceptionUtilise(int numeroEmp) {
        super("numero employee utilise" + numeroEmp);
        this.numeroEmp = numeroEmp;
    }
}
