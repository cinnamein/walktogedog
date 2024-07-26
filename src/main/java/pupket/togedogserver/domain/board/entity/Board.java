package pupket.togedogserver.domain.board.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import pupket.togedogserver.domain.chat.entity.ChatRoom;
import pupket.togedogserver.domain.dog.entity.Dog;
import pupket.togedogserver.domain.match.constant.MatchStatus;
import pupket.togedogserver.domain.user.entity.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@ToString
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE board SET deleted = true WHERE board_id = ?")
@Where(clause = "deleted = false")
public class Board {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long boardId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime editedAt;

    @Column(nullable = false)
    private LocalTime startTime;

    @Column(nullable = false)
    private LocalTime endTime;

    @Column(nullable = false)
    private LocalDate pickUpDay;
    /**
     * 도로명 주소
     */
    private String pickupLocation1;
    /**
     * 세부 주소
     */
    private String pickupLocation2;

    private Double mapX;

    private Double mapY;

    @Enumerated(EnumType.STRING)
    private FeeType feeType;

    @Column(nullable = false)
    private Long fee;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("'UNMATCHED'")
    @Column(nullable = false)
    @Builder.Default
    private MatchStatus matched = MatchStatus.UNMATCHED;

    @Column(nullable = false)
    @ColumnDefault("false")
    @Builder.Default
    private boolean deleted = Boolean.FALSE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_uuid")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dog_id")
    private Dog dog;

    @OneToMany(mappedBy = "board")
    private List<ChatRoom> chatRoom;

    @OneToMany(mappedBy = "board")
    private Set<WalkingPlaceTag> walkingPlaceTag;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.editedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.editedAt = LocalDateTime.now();
    }

}
