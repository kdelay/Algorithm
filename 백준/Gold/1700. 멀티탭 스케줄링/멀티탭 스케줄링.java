import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] 전기용품순서 = new int[k];
		Map<Integer, Integer> 콘센트 = new HashMap<>();
		int 빼는카운트 = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			전기용품순서[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < k; i++) {
			int 전기용품 = 전기용품순서[i];

			if (콘센트.containsKey(전기용품)) {
				continue;
			}
			if (콘센트.size() < n) {
				넣기(전기용품, 콘센트);
				continue;
			}
			int 뺄거 = 가장나중에쓰는거찾는함수(콘센트, 전기용품순서, i);

			콘센트.remove(뺄거);
			빼는카운트++;

			넣기(전기용품, 콘센트);
		}

		System.out.println(빼는카운트);
	}

	private static void 넣기(int i, Map<Integer, Integer> 콘센트) {
		콘센트.put(i, 0);
	}

	private static int 가장나중에쓰는거찾는함수(Map<Integer, Integer> 콘센트, int[] 전기용품순서, int 현재위치) {
		int 뺄거 = 0;
		int 가장먼미래 = -1;

		for (int 꽂힌거 : 콘센트.keySet()) {
			int 다음사용위치 = Integer.MAX_VALUE;

			for (int j = 현재위치 + 1; j < 전기용품순서.length; j++) {
				if (전기용품순서[j] == 꽂힌거) {
					다음사용위치 = j;
					break;
				}
			}
			if (다음사용위치 > 가장먼미래) {
				가장먼미래 = 다음사용위치;
				뺄거 = 꽂힌거;
			}
		}
		return 뺄거;
	}
}