import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    List<Integer> list = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();

    for (int i=0; i<N; i++) {
      int num = Integer.parseInt(br.readLine());
      list.add(num); // 초기 값 세팅
      // 최빈값을 위한 map 값 세팅
      int value = map.getOrDefault(num, 0) + 1; // map에 key가 이미 있으면 그 값에 +1를 하고, 없으면 1값 넣기
      map.put(num, value);
    }
    Collections.sort(list); // 배열 정렬

    // 1) 산술평균 구하기
    double sum = list.stream()
        .mapToInt(Integer::intValue)
        .sum();
    System.out.println(Math.round(sum / N));

    // 2) 중앙값 구하기
    int index = N / 2;
    System.out.println(list.get(index));

    // 3) 최빈값 구하기
    int maxFrequency = Collections.max(map.values());
    List<Integer> frequencies = new ArrayList<>();
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == maxFrequency) { // 최빈값이랑 entry의 value와 동일하다면
        // 새로운 map에 최빈값과 동일한 key, value들 저장
        frequencies.add(entry.getKey());
      }
    }
    // 새로운 map 정렬
    Collections.sort(frequencies);
    if (frequencies.size() == 1) { // 최빈값이 하나일 경우는 그대로 출력
      System.out.println(frequencies.get(0));
    } else { // 최빈값이 여러개일 경우는 두 번재로 작은 값 출력
      System.out.println(frequencies.get(1));
    }
    
    // 4) 범위 구하기
    System.out.println(list.get(list.size() - 1) - list.get(0)); // 맨 뒤 - 맨 앞
  }
}
