package com.teamseven.MusicVillain.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "member_table")
public class Member {
    @Id
    @Column(name = "member_id")
    public String memberId; // PK, uuid.toString()
    @Column(name = "user_id")
    public String userId;
    @Column(name = "user_info")
    public String userInfo;
    @Column(name = "name")
    public String name;
    @Column(name ="email")
    public String email;
    @Column(name = "role")
    public String role;
    @Column(name = "created_at")
    public LocalDateTime createdAt;
    @Column(name = "updated_at")
    public LocalDateTime updatedAt;
    @Column(name = "last_login_at")
    public LocalDateTime lastLoginAt;
    @Column(name = "provider_type")
    public String providerType;
    @Builder
    public Member(String memberId, String userId, String userInfo, String name, String email,
                  String role, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime lastLoginAt, String providerType) {
        this.memberId = memberId;
        this.userId = userId;
        this.userInfo = userInfo;
        this.name = name;
        this.email = email;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.lastLoginAt = lastLoginAt;
        this.providerType = providerType;
    }

    @JsonIgnore
    public List<String> getRoleList(){

        if(this.role.length() > 0){
            // role이 null이 아니면 콤마를 기준으로 분리하여 리스트에 담아 리턴
            return Arrays.asList(this.role.split(","));
        }
        // role이 null이면 빈 리스트를 리턴
        return new ArrayList<>();
    }
}
