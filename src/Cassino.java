import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cassino {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      int N = scanner.nextInt();
      int k = scanner.nextInt();
      int m = scanner.nextInt();

      if (N == 0 && k == 0 && m == 0) {
        break;
      }

      Circulo circulo = new Circulo(N);
      List<String> resultados = new ArrayList<>();

      int posicaoHorario = 0;
      int posicaoAntiHorario = N - 1;

      while (circulo.tamanho() > 0) {
        Apostador removidoHorario = circulo.removerHorario(k, posicaoHorario);
        Apostador removidoAntiHorario = null;

        if (circulo.tamanho() > 1) {
          removidoAntiHorario = circulo.removerAntiHorario(m, posicaoAntiHorario);

          if (removidoHorario.getNumero() == removidoAntiHorario.getNumero()) {
            resultados.add(String.valueOf(removidoHorario.getNumero()));
          } else {
            resultados.add(removidoHorario.getNumero() + " " + removidoAntiHorario.getNumero());
          }

          // Marcar os apostadores como removidos
          removidoHorario.setRemovido(true);
          removidoAntiHorario.setRemovido(true);

          // Ajustar as posições para a próxima rodada
          posicaoHorario = (circulo.getApostadores().indexOf(removidoHorario) + 1) % N;
          posicaoAntiHorario = (circulo.getApostadores().indexOf(removidoAntiHorario) - 1 + N) % N;

          while (circulo.tamanho() > 0 && circulo.getApostadores().get(posicaoHorario).isRemovido()) {
            posicaoHorario = (posicaoHorario + 1) % N;
          }

          while (circulo.tamanho() > 0 && circulo.getApostadores().get(posicaoAntiHorario).isRemovido()) {
            posicaoAntiHorario = (posicaoAntiHorario - 1 + N) % N;
          }
        } else {
          resultados.add(String.valueOf(removidoHorario.getNumero()));
          removidoHorario.setRemovido(true);
          break;
        }
      }

      System.out.println(String.join(", ", resultados));
    }
    scanner.close();
  }
}