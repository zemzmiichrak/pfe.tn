package com.pfe.DTO;

public class LigneDTO {
	   private Long id;
	   private String code;
	   private String label;
	   
		public LigneDTO(Long id, String code, String label) {
			super();
			this.id = id;
			this.code = code;
			this.label = label;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getLabel() {
			return label;
		}
		public void setLabel(String label) {
			this.label = label;
		}
		public LigneDTO() {
			
		}
		
	    
}
