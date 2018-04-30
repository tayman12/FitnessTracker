package org.learning.spring.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(indexes = {@Index(columnList = "username", name = "user_name_index"),
        @Index(columnList = "username,authority", name = "user_name_authority_index", unique = true)})
public class Authorities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    @NotNull
    private String authority;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
