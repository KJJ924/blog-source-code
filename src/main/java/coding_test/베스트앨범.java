package coding_test;

import java.util.*;
import java.util.stream.Collectors;


public class 베스트앨범 {
    static class Solution {
        public int[] solution(String[] genres, int[] plays) {

            Map<String,Integer> totalPlays = new HashMap<>();
            Map<String, Map<Integer,Integer>> albumCategory = new HashMap<>();

            for (int i = 0; i < genres.length; i++) {
                if(albumCategory.get(genres[i])==null){
                    Map<Integer,Integer> count = new HashMap<>();
                    count.put(i,plays[i]);
                    albumCategory.put(genres[i],count); //여기까지 앨범 카테고리 나누기
                    totalPlays.put(genres[i],plays[i]); //장르별 총 플레이 타임
                }else {
                    Map<Integer, Integer> count = albumCategory.get(genres[i]);
                    count.put(i,plays[i]);
                    albumCategory.put(genres[i],count);//여기까지 앨범 카테고리 나누기
                    totalPlays.merge(genres[i],plays[i], Integer::sum);//장르별 총 플레이 타임

                }
            }
            List<Map.Entry<String, Integer>> totalPlaySort = totalPlays.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .collect(Collectors.toList()); // 장르 시청시간 높은 순으로 정렬

            List<Integer> result =new ArrayList<>(); // 결과값 담을 그릇

            for (Map.Entry<String, Integer> category : totalPlaySort) {
                Map<Integer, Integer> TopAlbum = albumCategory.get(category.getKey()); // 플레이타임이 높은 앨범 카테고리 반환

                List<Map.Entry<Integer, Integer>> Top2Album = TopAlbum.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .limit(2)
                        .collect(Collectors.toList());// 앨범중에서 제일 플레이 시간이 높은 2개 가져오기

                for (Map.Entry<Integer, Integer> integerIntegerEntry : Top2Album) {
                    result.add(integerIntegerEntry.getKey()); //결과에 담기.
                }
            }
            return result.stream().mapToInt(i->i).toArray();
        }
    }

    public static void main(String[] args) {
        베스트앨범 a = new 베스트앨범();
        Solution solution = new Solution();
        String[] genres = new String[]{"classic","pop","classic","classic","pop","K"};
        int[] plays = new int[]{10, 501, 500, 100, 500,1502};

        System.out.println(Arrays.toString(solution.solution(genres, plays)));
    }
}
