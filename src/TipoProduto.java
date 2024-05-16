public enum TipoProduto {
    MECANICA("Mecânica"),
    ESTETICA("Estética");

    private final String tipo;

    TipoProduto(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return this.tipo;
    }
}
