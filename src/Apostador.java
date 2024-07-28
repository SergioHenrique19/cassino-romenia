public class Apostador {
  private int numero;
  private boolean removido;

  public Apostador(int numero) {
    this.numero = numero;
    this.removido = false;
  }

  public int getNumero() {
    return numero;
  }

  public boolean isRemovido() {
    return removido;
  }

  public void setRemovido(boolean removido) {
    this.removido = removido;
  }
}
