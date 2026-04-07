
public class Bovinos extends Animais {

    public Bovinos(String id, float altura, float comprimento, float largura, float peso, String status) {
        // Envia os dados para a classe pai (Animais) gerenciar
        super(id, altura, comprimento, largura, peso, status);
    }

    @Override
    public String getTipo() {
        return "Bovino";
    }
}