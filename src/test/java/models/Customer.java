package models;

import lombok.Builder;
import lombok.Data;

public class Customer {

    @Builder
    @Data
    public class Customer {
        private String id;
        private String firstname;
        private String lastName;
        private String email;
        private ing age;
    }
}
