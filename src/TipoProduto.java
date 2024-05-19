public enum TipoProduto {
    MECANICA("Mecanica"),
    ESTETICA("Estetica");

    private final String tipo;

    TipoProduto(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return this.tipo;
    }
}
