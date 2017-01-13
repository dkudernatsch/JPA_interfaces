package com.dkudernatsch.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.awt.*;

/**
 * Created by daniel on 1/13/17.
 */
@Converter
public class ColorIntConverter implements AttributeConverter<Color, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Color color) {
        int colorInt = color.getRGB();
        if (color.getAlpha() != 0){
            return colorInt ^ color.getAlpha();
        }
        return color. getRGB();
    }

    @Override
    public Color convertToEntityAttribute(Integer integer) {
        return new Color(integer);
    }
}
