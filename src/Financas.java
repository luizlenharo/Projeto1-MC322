public class Financas {
    private float gastos;
    private float faturamento;
    private float caixa;

    public Financas() {
        this.gastos = 0;
        this.faturamento = 0;
        this.caixa = 1000;
    }

    public float getGastos() {
        return gastos;
    }

    public void setGastos(float gastos) {
        this.gastos = gastos;
    }

    public float getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(float faturamento) {
        this.faturamento = faturamento;
    }

    public float getCaixa() {
        return caixa;
    }

    public void setCaixa(float caixa) {
        this.caixa = caixa;
    }

    public float lucro() {
        return faturamento - gastos;
    }

    public void reset() {
        setFaturamento(0);
        setGastos(0);
    }
}
