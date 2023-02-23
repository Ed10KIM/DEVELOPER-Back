<<<<<<<< HEAD:back/src/main/java/com/developer/favaritesstudyroom/entity/FavoritesStudyroom.java
package com.developer.favaritesstudyroom.entity;
========
package com.developer.favoritestudyroom.entity;
>>>>>>>> 66a38bee89c745bed6d4f523e8d9f08473494b51:back/src/main/java/com/developer/favoritestudyroom/entity/FavoritesStudyroom.java

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.developer.studyroom.entity.Studyroom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "Favorites_Studyroom")
@SequenceGenerator(
name =
"FAV_SEQ_GENERATOR", // 사용할 sequence 이름
sequenceName =
"fav_seq", // 실제 데이터베이스 sequence 이름
initialValue = 1, allocationSize = 1)
public class FavoritesStudyroom {
	@Id
	@Column(name="fav_seq")
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator =
			"FAV_SEQ_GENERATOR") 
	private Long favSeq;
	
	@Column(name="user_Id")
	private String userId;

	@Column(name="cnt")
	private Integer cnt;
	
	//sr_seq 지워야함(동수님꺼랑 합치면서 확인해보기)
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name="sr_seq")
	private Studyroom studyroom; 
}

