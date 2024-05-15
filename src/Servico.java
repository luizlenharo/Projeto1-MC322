public class Servico extends Item{
    private String descricao;

    public Servico(float preco, float custo, String nome, String descricao){
        super(preco, custo, nome);
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String toString(){
        String out = " ";
        return out;
    }
}
