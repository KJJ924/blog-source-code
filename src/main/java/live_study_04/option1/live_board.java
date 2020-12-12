package live_study_04.option1;

import org.kohsuke.github.*;

import java.util.*;


public class live_board {
    public static void main(String[] args) throws Exception {
        Map<String,Member> members =new HashMap<>();
        String repoPath = "whiteship/live-study";
        String token = "자신의 토큰값";

        GitHub github = new GitHubBuilder().withOAuthToken(token).build();
        GHRepository repository = github.getRepository(repoPath);

        //깃허브의 모든 이슈 가져오기
        List<GHIssue> issues = repository.getIssues(GHIssueState.ALL);
        for (GHIssue issue : issues) {
            String title = issue.getTitle();
            String[] s = title.split(" ");
            for (GHIssueComment comment : issue.getComments()) {
                String id = comment.getUser().getLogin();
                Member member = members.get(id);
                if(member == null){
                    member = new Member(id);
                    members.put(id,member);
                }
                member.getWeekJoinMap().put(s[0],true);
            }
        }
        for (Member member : members.values()) {
            member.percentProcess();
            System.out.printf("[ %s ]" ,member.getId());
            System.out.printf("[ 참여율:%.3f ]",member.getPercent()*100);
            System.out.printf(" 출석부:%s" ,member.getWeekJoinMap());
            System.out.println();
        }

    }

}
