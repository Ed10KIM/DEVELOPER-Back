package com.developer.lesson.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.developer.appliedlesson.entity.AppliedLesson;
import com.developer.favoriteslesson.entity.FavoritesLesson;
import com.developer.tutor.entity.Tutor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="LESSON")
@DynamicInsert @DynamicUpdate
@Setter @Getter @NoArgsConstructor
@SequenceGenerator(
		name ="lessonSeq", 
		sequenceName ="lesson_seq", 
		initialValue = 1, allocationSize = 1 
		)
public class Lesson {
	@Id
	@Column(name="lesson_seq")
	@GeneratedValue( 
			strategy = GenerationType.SEQUENCE, 
			generator ="lessonSeq"  
		)
	private Long lessonSeq;

	@NotNull
	@Column(name="lesson_name")
	private String lessonName;
	
	@NotNull
	@Column(name="category")
	private Integer category; //0:프로그래밍언어, 1:웹개발, 2:앱개발, 3:보안/네트워크, 4:데이터
	
	@NotNull
	@Column(name="content")
	private String content;
	
	@NotNull
	@Column(name="people")
	private Integer people;
	
	@NotNull
	@Column(name="img_path")
	private String imgPath;
	
	@NotNull
	@Column(name="start_cdate")
	private LocalDate startCdate;
	
	@NotNull
	@Column(name="end_cdate")
	private LocalDate endCdate;
	
	@NotNull
	@Column(name="price")
	private Integer price;
	
	@NotNull
	@Column(name="start_date")
	private LocalDate startDate;
	
	@NotNull
	@Column(name="end_date")
	private LocalDate endDate;
	
	@ColumnDefault(value = "2")
	@Column(name="pay_lesson")
	private Integer payLesson; //0무료 1유료 2결제대기
	
	@NotNull
	@Column(name="location")
	private String location;
	
	
	
	
	@ManyToOne
	@JoinColumn(name="tutor_id")
	private Tutor tutor;

	@OneToMany(mappedBy = "lesson", 
							cascade = CascadeType.REMOVE)
	private List<FavoritesLesson> flList;
	
	@OneToMany(mappedBy = "lesson")	
	private List<AppliedLesson> alList;
}


