package com.jalalshokouh.testspring.modules.users.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.jalalshokouh.testspring.modules.post.entity.Post;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
public class Users implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String email;
    private String name;
    private String password;
    @Column(nullable = true)
    private String cover;

    private boolean enabled = true;

    @ManyToMany
    @JoinTable(
            name = "authorities",
            joinColumns = @JoinColumn(name = "email",referencedColumnName = "email"),
            inverseJoinColumns = @JoinColumn(name = "roles" , referencedColumnName = "role")
    )
    private List<Roles> roles;

    @Transient
    @JsonIgnore
    private MultipartFile userPic;

    @CreationTimestamp()
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp()
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "users")
    private List <Post> posts ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public MultipartFile getUserPic() {
        return userPic;
    }

    public void setUserPic(MultipartFile userPic) {
        this.userPic = userPic;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", cover='" + cover + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", posts=" + posts +
                '}';
    }
}
