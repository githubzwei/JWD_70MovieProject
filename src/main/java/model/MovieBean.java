package model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieBean {

	private int id;
	private String title;
	private String description;
	private LocalDate releaseYear;
	private String duration;
	private int categoryId;
}
