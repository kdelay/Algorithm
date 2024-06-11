import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

class Solution {

    /**
     * @param genres 고유번호가 i인 노래의 장르
     * @param plays 고유번호가 i인 노래가 재생된 횟수
     * @return 베스트 앨범에 들어갈 노래의 고유 번호 (각 장르별 2개씩. 1개일 경우 1개만 선택)
     */
    public static int[] solution(String[] genres, int[] plays) {

        Map<String, List<int[]>> genreMap = new HashMap<>(); //재생 횟수 별, 2차 정렬
        Map<String, Integer> playMap = new HashMap<>(); //장르 별, 1차 정렬

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i]; //장르
            int play = plays[i]; //재생 횟수

            //map에 장르가 없는 경우, 초기 세팅
            if (!genreMap.containsKey(genre)) {
                genreMap.put(genre, new ArrayList<>());
                playMap.put(genre, 0);
            }
            //값 세팅
            genreMap.get(genre).add(new int[]{i, play});
            playMap.put(genre, playMap.get(genre) + play);
        }

        //장르 별, 1차 정렬
        //총 재생 횟수가 많은 순으로 내림차순 정렬
        Stream<Map.Entry<String, Integer>> sortedByGenre = playMap.entrySet().stream()
                .sorted(((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue())));

        List<Integer> answer = new ArrayList<>();

        //재생 횟수 별, 2차 정렬
        //장르 내 재생 횟수가 많은 순으로 내림차순 정렬
        sortedByGenre.forEach(entry -> {
            //내림차순으로 정렬한 장르별로 genreMap 내부 순환
            Stream<int[]> sortedByPlay = genreMap.get(entry.getKey()).stream()
                    .sorted((o1, o2) -> Integer.compare(o2[1], o1[1])) //재생 횟수 내림차순 정렬
                    .limit(2); //최대 2개까지 제한
            //인덱스 값 반환
            sortedByPlay.forEach(song -> answer.add(song[0]));
        });
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}