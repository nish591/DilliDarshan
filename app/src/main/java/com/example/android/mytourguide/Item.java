package com.example.android.mytourguide;

import java.io.Serializable;

public class Item implements Serializable {
	private static final long serialVersionUID = -6099312954099962806L;
	private String title;
	private String body;
	private int ImageResourceId;
	private String address;
	private String phoneNo="-1";
	private String Timing="-1";

	public Item(int ImageResourceId,String title, String body,String address,String phoneNo,String Timing) {
		this.title = title;
		this.body = body;
		this.ImageResourceId=ImageResourceId;
		this.phoneNo=phoneNo;
		this.address=address;
		this.Timing=Timing;
	}

    public String getTiming() {
        return Timing;
    }

    public String getAddress() {
		return address;
	}

	public int getImageResourceId() {
		return ImageResourceId;
	}

	public String getTitle() {
		return title;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public String getBody() {
		return body;
	}

	@Override
	public String toString() {
		return getTitle();
	}

	public boolean hasPhone() {
		if(phoneNo.equals("-1"))
		    return false;
		else
			return true;
	}
    public boolean hasTiming() {
        if(Timing.equals("-1"))
            return false;
        else
            return true;
    }
}
