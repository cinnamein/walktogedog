package pupket.togedogserver.domain.user.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FindMateResponse {

    private long uuid;
    private long mateId;
    private String nickname;
    private String gender;
    private int age;
    private String birth;
    PreferredDetailsResponse preferred;
    private String profileImage;
    private int accommodatableDogsCount;
    private String career;
}
