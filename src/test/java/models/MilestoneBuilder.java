package models;

import lombok.*;

@Builder
@ToString
@EqualsAndHashCode(exclude = "id")
public class MilestoneBuilder {
    private String name;
    private String references;
    private String description;
    private boolean completed;

    public static MilestoneBuilder build() {
    }

    public void setId(int i) {
    }
}
