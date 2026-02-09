@Getter
@Setter
@Table(name = "task")
public class TaskEntity {

    Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private boolean completed;
}
