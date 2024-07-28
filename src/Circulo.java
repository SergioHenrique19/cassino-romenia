import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Circulo {
  private List<Apostador> apostadores;

  public Circulo(int n) {
    apostadores = IntStream.rangeClosed(1, n).mapToObj(Apostador::new).collect(Collectors.toList());
  }

  public List<Apostador> getApostadores() {
    return apostadores;
  }

  public int tamanho() {
    return (int) apostadores.stream().filter(a -> !a.isRemovido()).count();
  }

  public Apostador removerHorario(int k, int posicaoAtual) {
    int contador = 0;

    while (contador < k) {
      if (!apostadores.get(posicaoAtual).isRemovido()) {
        contador++;
      }

      if (contador < k) {
        posicaoAtual = (posicaoAtual + 1) % apostadores.size();
      }
    }

    return apostadores.get(posicaoAtual);
  }

  public Apostador removerAntiHorario(int m, int posicaoAtual) {
    int contador = 0;

    while (contador < m) {
      if (!apostadores.get(posicaoAtual).isRemovido()) {
        contador++;
      }
      if (contador < m) {
        posicaoAtual = (posicaoAtual - 1 + apostadores.size()) % apostadores.size();
      }
    }

    return apostadores.get(posicaoAtual);
  }

}
