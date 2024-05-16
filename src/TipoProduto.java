public enum TipoProduto {
    MECANICA("mecânica"),
    ESTETICA("estética");

    private final String tipo;

    TipoProduto(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return this.tipo;
    }
}
