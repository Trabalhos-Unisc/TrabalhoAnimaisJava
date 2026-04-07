

import java.util.Arrays;

public abstract class Animais {
    private String id;
    private float altura;
    private float comprimento;
    private float largura;
    private float peso;
    private String status;
    private float precoVenda;

    public Animais(String id, float altura, float comprimento, float largura, float peso, String status) {
        this.setId(id);
        this.setAltura(altura);
        this.setComprimento(comprimento);
        this.setLargura(largura);
        this.setPeso(peso);
        this.setStatus(status);
        this.precoVenda = 0.0f; // Inicializa com 0
    }

    // Método que as filhas deverão implementar
    public abstract String getTipo();

    // SETTERS COM SUAS VALIDAÇÕES
    public void setId(String id) {
        this.id = id; 
    }
    public void setAltura(float altura) {
        if (altura > 0) this.altura = altura;
    }
    public void setComprimento(float comprimento) {
        if (comprimento > 0) this.comprimento = comprimento;
    }
    public void setLargura(float largura) {
        if (largura > 0) this.largura = largura;
    }
    public void setPeso(float peso) {
        if (peso > 0) this.peso = peso;
    }
    public void setStatus(String status) {
        String[] opcoes = {"Ativo", "Vendido", "Perdido"};
        if (Arrays.asList(opcoes).contains(status)) {
            this.status = status;
        }
    }
    public void setPrecoVenda(float precoVenda) {
        if (precoVenda > 0) this.precoVenda = precoVenda;
    }

    // GETTERS
    public String getId() { return this.id; }
    public float getAltura() { return this.altura; }
    public float getComprimento() { return this.comprimento; }
    public float getLargura() { return this.largura; }
    public float getPeso() { return this.peso; }
    public String getStatus() { return this.status; }
    public float getPrecoVenda() { return this.precoVenda; }
}
