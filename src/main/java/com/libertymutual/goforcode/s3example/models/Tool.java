package com.libertymutual.goforcode.s3example.models;

import java.net.URL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
	import com.fasterxml.jackson.annotation.ObjectIdGenerators;


	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@Entity
	@Table(name="oneshed_tool")

	public class Tool {
		@Id
		@GeneratedValue(generator = "ToolIdSeq", strategy = GenerationType.AUTO)
		@SequenceGenerator(name = "ToolIdSeq", sequenceName = "ToolIdSeq")
		private Long id;
		
		@Column(nullable = false, length = 30)
		private String toolName;

		@Column(nullable = false, length = 80)
		private String toolDescription;
		
		@Column(nullable = true)
		private URL image;


		public Tool() {}

		public Tool(String toolName, String toolDescription, URL image) {
			
			this.toolName = toolName;
			this.toolDescription = toolDescription;
			this.image = image;

		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getToolName() {
			return toolName;
		}

		public void setToolName(String toolName) {
			this.toolName = toolName;
		}

		public URL getImage() {
			return image;
		}

		public void setImage(URL image) {
			this.image = image;
		}

		public String getToolDescription() {
			return toolDescription;
		}

		public void setToolDescription(String toolDescription) {
			this.toolDescription = toolDescription;
		}

	}

