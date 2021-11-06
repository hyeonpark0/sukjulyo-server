package com.archive.sukjulyo.hashtag.domain;

import com.archive.sukjulyo.news.domain.News;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter @Setter
@Builder
@Entity
public class Hashtag implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 64, nullable = false, unique = true)
    private String tag;

    @Column()
    @ColumnDefault("0")
    private Integer priority;

    @ManyToMany(mappedBy="hashtags")
    @JsonBackReference
    private List<News> news = new ArrayList<>();

}
