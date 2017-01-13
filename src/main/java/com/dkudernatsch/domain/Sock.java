package com.dkudernatsch.domain;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.awt.*;

/**
 * Created by daniel on 1/13/17.
 */
@Entity
public class Sock {
    @Id
    private int sockId;

    @Convert(converter = ColorIntConverter.class)
    private Color color;

    protected Sock(){}

    public Sock(Color color){
        this.color = color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
