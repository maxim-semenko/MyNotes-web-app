package com.max.project.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Builder(access = AccessLevel.PUBLIC)
@Entity
@Table(name = "notes")
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Note extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id")
    private Long id;

    @Column(name = "name", length = 25)
    private String name;

    @Column(name = "decryption")
    private String decryption;

    @Column(name = "created_time", length = 30)
    private String createdTime;

    @Column(name = "fk_note_status_id")
    @Enumerated(EnumType.ORDINAL)
    private NoteStatusEnum noteStatus;

    //    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //    @JoinColumn(name = "fk_user_id")
    @ManyToOne
    private User user;

}
