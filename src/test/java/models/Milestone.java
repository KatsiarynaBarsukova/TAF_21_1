package models;

import lombok.*;

@Getter
@Setter
@ToString(exclude = "id")
@EqualsAndHashCode(exclude = "id")
@NoArgsConstructor
@AllArgsConstructor
//@Data
public class Milestone {
    private String name;
    private String references;
    private String description;
    private boolean completed;

    public void setId(int i) {
    }
}
