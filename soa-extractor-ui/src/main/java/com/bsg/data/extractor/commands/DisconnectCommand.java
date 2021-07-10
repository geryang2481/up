package com.bsg.data.extractor.commands;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;


@SuppressWarnings("deprecation")
public class DisconnectCommand {

	@NotEmpty
    @Size(min = 2, max = 50)
    private String id1;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String id2;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String location1;
    private String location2;

	@NotEmpty
    @Size(min = 2, max = 50)
    private String central;

    @NotEmpty
    @Size(min = 2, max = 2)
    private String centralCode;

    @NotEmpty
    @Size(min = 5, max = 10)
    private String compressCode;

    public String getId1() {
        return id1;
    }

    public void setId1(String id1) {
        this.id1 = id1;
    }

    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }

	public String getLocation1() {
		return location1;
	}

	public void setLocation1(String location1) {
		this.location1 = location1;
	}

	public String getLocation2() {
		return location2;
	}

	public void setLocation2(String location2) {
		this.location2 = location2;
	}

	public String getCentral() {
		return central;
	}

	public void setCentral(String central) {
		this.central = central;
	}

	public String getCentralCode() {
		return centralCode;
	}

	public void setCentralCode(String centralCode) {
		this.centralCode = centralCode;
	}

	public String getCompressCode() {
		return compressCode;
	}

	public void setCompressCode(String compressCode) {
		this.compressCode = compressCode;
	}

   
}
