package com.example.demo.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "journal")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Journal {
	
	/*
	 * id
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	/*
	 * date
	 */
	@Column(name = "date", nullable = false)
	private LocalDate date;
	
	/*
	 * title
	 */
	@Column(name = "title", nullable = false)
    private String title;
    
    /*
     * content
     */
	@Column(name = "content", nullable = false)
	@Lob
    private String content;
}
