public class Main {
  public static void main(String[] args) {
    boolean[] arr = new boolean[10001];
    for (int i=1; i<=10000; i++) {
      int n = d(i);
      if (n <= 10000) { // 10000보다 작은 수일 경우만 true로 변경한다.
        arr[n] = true;
      }
    }
    for (int i=1; i<=10000; i++) {
      if (!arr[i]) {
        System.out.println(i);
      }
    }
  }
  static int d(int i) {
    int sum = i;
    while (i != 0) {
      sum += i % 10;
      i /= 10;
    }
    return sum;
  }
}