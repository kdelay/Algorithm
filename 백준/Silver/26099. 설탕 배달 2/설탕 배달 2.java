import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    BigInteger N = new BigInteger(br.readLine());
    BigInteger five = new BigInteger("5");
    BigInteger value = N.remainder(BigInteger.valueOf(5));

    if (N.intValue() == 4 || N.intValue() == 7) {
      System.out.println(-1);
    } else if (value.equals(BigInteger.ZERO)) {
      System.out.println(N.divide(five));
    } else if (value.equals(BigInteger.ONE) || value.equals(BigInteger.valueOf(3))) {
      System.out.println(N.divide(five).add(BigInteger.valueOf(1)));
    } else if (value.equals(BigInteger.TWO) || value.equals(BigInteger.valueOf(4))) {
      System.out.println(N.divide(five).add(BigInteger.valueOf(2)));
    }
  }
}