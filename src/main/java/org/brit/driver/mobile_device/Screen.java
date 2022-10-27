
package org.brit.driver.mobile_device;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Screen {

    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("height")
    @Expose
    private Integer height;

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Screen withWidth(Integer width) {
        this.width = width;
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Screen withHeight(Integer height) {
        this.height = height;
        return this;
    }

}
