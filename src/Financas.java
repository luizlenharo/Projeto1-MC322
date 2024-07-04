public class    Financas {
    private float gastos;
    private float faturamento;
    private float caixa;
    private float caixaEmProdutos;

    public Financas() {
        this.gastos = 0;
        this.faturamento = 0;
        this.caixa = 1000;
        this.caixaEmProdutos = 0;
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

    public float getCaixaEmProdutos() {
        return caixaEmProdutos;
    }

    public void setCaixaEmProdutos(float caixaEmProdutos) {
        this.caixaEmProdutos = caixaEmProdutos;
    }

    public float lucro() {
        return faturamento - gastos;
    }

    public void reset() {
        faturamento = 0;
        gastos = 0;
    }
}
