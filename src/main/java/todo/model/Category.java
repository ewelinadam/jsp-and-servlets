package todo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Category {
    RELAX,
    WORK,
    HOBBY,
    HOME,
    EDUCATION,
    FAMILY,
    HEALTH;
}
