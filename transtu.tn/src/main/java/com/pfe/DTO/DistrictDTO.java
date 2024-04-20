package com.pfe.DTO;

public class DistrictDTO {
	  private Long id;
	    private String label;
	    private String address;
	
		public String getLabel() {
			return label;
		}
		public void setLabel(String label) {
			this.label = label;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		
		public DistrictDTO(Long id, String label, String address) {
			super();
			this.id = id;
			this.label = label;
			this.address = address;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public DistrictDTO() {
		
		}
	    
}
