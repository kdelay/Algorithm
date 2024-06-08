import java.util.ArrayDeque;

class Solution {
    /**
     * @param bridge_length 다리에 올라갈 수 있는 최대 트럭 수, 다리 길이
     * @param weight 다리 최대 하중
     * @param truck_weights 트럭 무게
     * @return 모든 트럭이 다리를 건너기 위한 최소 소요 시간(초)
     */
    public static int solution(int bridge_length, int weight, int[] truck_weights) {

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        //트럭 총 하중, 소요 시간(초)
        int sum = 0, sec = 0;

        for (int truck : truck_weights) {

            while (true) {
                //큐에 아무것도 없는 경우
                if (queue.isEmpty()) {
                    queue.add(truck);
                    sum += truck;
                    sec++;
                    break;
                } else if (queue.size() == bridge_length) { //최대 개수만큼 트럭이 다 찬 경우
                    sum -= queue.poll();
                } else { //큐에 트럭이 있고, 최대 개수가 아닌 경우
                    //최대 하중이 안 넘으면 추가
                    if ((sum + truck) <= weight) {
                        queue.add(truck);
                        sum += truck;
                        sec++;
                        break;
                    } else { //최대 하중이 넘으면 0을 넣고 트럭이 다리를 건너게 한다.
                        queue.add(0);
                        sec++;
                    }
                }
            }
        }
        //마지막 트럭도 다리를 건너야 하므로 다리 길이만큼 추가 시간 소요됨
        return sec + bridge_length;
    }
}