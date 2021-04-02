package com.max.project.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder(access = AccessLevel.PUBLIC)
@Entity
@Table(name = "app_user")
@SecondaryTable(name = "user_personal_data", pkJoinColumns =
@PrimaryKeyJoinColumn(name = "fk_user_id", referencedColumnName = "user_id"))
@Getter
@Setter
@ToString()
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "login", length = 25, unique = true)
    @NotNull
    private String login;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "role_id")
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private UserRoleEnum roleId;

    @Column(name = "firstname", table = "user_personal_data", length = 25)
    @NotNull
    private String firstname;

    @Column(name = "lastname", table = "user_personal_data", length = 25)
    @NotNull
    private String lastname;

    @Column(name = "email", table = "user_personal_data", unique = true, length = 30)
    @NotNull
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Note> noteList;

}
